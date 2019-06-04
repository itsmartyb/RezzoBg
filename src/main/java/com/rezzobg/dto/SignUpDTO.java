package com.rezzobg.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {
    @NotBlank(message = "Username is not long enough")
    private String username;
    @NotBlank(message = "Password is not long enough")
    private String password;
    @NotBlank(message = "First name is not long enough")
    private String firstName;
    @NotBlank(message = "Last name is not long enough")
    private String lastname;
    @Pattern(regexp = "^\\+[0-9]{1,3}\\.[0-9]{4,14}(?:x.+)?$", message = "Telephone isn't standard for EU")
    @NotBlank(message = "Telephone is not long enough")
    private String telephone;
    @NotBlank(message = "Street is not long enough")
    private String street;
    @NotBlank(message = "City is not long enough")
    private String city;
    @NotBlank(message = "Country is not long enough")
    private String country;
    @NotBlank(message = "Date of birth is not long enough")
    @Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")
    private LocalDate dateOfBirth;
}
