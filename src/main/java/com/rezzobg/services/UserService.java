package com.rezzobg.services;

import com.rezzobg.dto.AddressDTO;
import com.rezzobg.dto.LoginDTO;
import com.rezzobg.dto.SignUpDTO;
import com.rezzobg.exceptions.BadRequestException;
import com.rezzobg.exceptions.InvalidPasswordException;
import com.rezzobg.exceptions.UserNotExistsException;
import com.rezzobg.exceptions.UsernameExistsException;
import com.rezzobg.models.Address;
import com.rezzobg.models.User;
import com.rezzobg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CityService cityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(rollbackOn = Exception.class)
    public boolean signUp(SignUpDTO signUpDTO) throws UsernameExistsException {
        User user = userRepository.findByUsername(signUpDTO.getUsername());
        if(user != null) {
            throw new UsernameExistsException("User with such username already exists!");
        }
        Address address = manageAddress(signUpDTO);
        User newUser = manageUser(address, signUpDTO);
        this.userRepository.save(newUser);
        return true;
    }

    private Address manageAddress(SignUpDTO signUpDTO) {
        return addressService.getAndSaveAddress(new AddressDTO(signUpDTO.getStreet(), signUpDTO.getArea(),
                signUpDTO.getCity(), signUpDTO.getCountry()));

    }

    private User manageUser(Address address, SignUpDTO signUpDTO) {
        return new User(signUpDTO.getUsername(), this.passwordEncoder.encode(signUpDTO.getPassword()), signUpDTO.getFirstName(),
                signUpDTO.getLastName(), signUpDTO.getTelephone(),
                address, signUpDTO.getDateOfBirth());
    }

    private void checkForValidUser(LoginDTO loginDTO, User user) throws UserNotExistsException  {
        if(user == null) {
            throw new UserNotExistsException("User with such username does not exist!");
        }
        if(!this.passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new UserNotExistsException("Wrong password, please enter valid username and password!");
        }
    }

    public User login(LoginDTO loginDTO) throws UserNotExistsException {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        checkForValidUser(loginDTO, user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }
}
