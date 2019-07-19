import com.rezzobg.dto.AddressDTO;
import com.rezzobg.models.Address;
import com.rezzobg.models.City;
import com.rezzobg.repositories.AddressRepository;
import com.rezzobg.repositories.CityRepository;
import com.rezzobg.services.AddressService;
import com.rezzobg.services.CityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class AddressAndCityServicesTests {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @InjectMocks
    private AddressService addressService;

    private City city;
    private Address address;

    @Before
    public void setUp() {
        this.city = new City(5L, "NewCity");
        this.address = new Address(5L, "Street", "Area", this.city, "Bulgaria");
    }

    @Test
    public void addNewCityTest() {
        Mockito.when(cityRepository.findByName(city.getName())).thenReturn(this.city);
        Assert.assertEquals(this.city.getName(), cityService.getAndSaveCity("NewCity").getName());
    }

    @Test
    public void tryingToAddAnExistingCity() {
        Mockito.when(cityRepository.findByName(city.getName())).thenReturn(null);
        City c = new City(null, "some city");
        cityService.getAndSaveCity(c.getName());
        Mockito.verify(cityRepository).save(Mockito.any(City.class));
    }

    @Test
    public void saveAddressShouldSaveCity() {
        AddressDTO addressDTO = new AddressDTO("Street", "Area", "City", "Country");
        City c = new City(null, addressDTO.getCity());
        Mockito.when(addressService.getCityService().getAndSaveCity(addressDTO.getCity()))
                .thenReturn(c);
        addressService.getAndSaveAddress(addressDTO);
        Mockito.verify(addressRepository).save(Mockito.any(Address.class));
    }
}
