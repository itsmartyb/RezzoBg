package com.rezzobg.services;

import com.rezzobg.dto.SignUpDTO;
import com.rezzobg.exceptions.UsernameExistsException;
import com.rezzobg.models.Address;
import com.rezzobg.models.User;
import com.rezzobg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder hashedPassword;

    public boolean signUp(SignUpDTO signUpDTO) throws UsernameExistsException {
        User user = userRepository.findByUsername(signUpDTO.getUsername());
        if(user != null) {
            throw new UsernameExistsException(
                    "There is an account with that username:" + signUpDTO.getUsername());
        }
        User newUser = new User(1l, signUpDTO.getUsername(), this.hashedPassword.encode(signUpDTO.getPassword()), signUpDTO.getFirstName(),
                    signUpDTO.getLastname(), signUpDTO.getTelephone(),
                new Address(1l, signUpDTO.getCity(), signUpDTO.getStreet(), signUpDTO.getCountry()), signUpDTO.getDateOfBirth(), false);

        userRepository.save(newUser);
        return true;
    }

}
