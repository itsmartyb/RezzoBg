package com.rezzobg.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
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
    @Size(max = 20, min = 3, message = "{user.name.invalid}")
    @NotBlank(message = "Last name is not long enough")
    private String lastName;
    @NotBlank(message = "Telephone is not long enough")
    private String telephone;
    @NotBlank(message = "Street is not long enough")
    private String street;
    @NotBlank(message = "Area is not long enough")
    private String area;
    @NotBlank(message = "City is not long enough")
    private String city;
    @NotBlank(message = "Country is not long enough")
    private String country;
    @NotNull(message = "")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate dateOfBirth;
}
