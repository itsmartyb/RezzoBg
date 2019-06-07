package com.rezzobg.services;

import com.rezzobg.dto.LoginDTO;
import com.rezzobg.dto.SignUpDTO;
import com.rezzobg.exceptions.BadRequestException;
import com.rezzobg.exceptions.InvalidPasswordException;
import com.rezzobg.exceptions.UserNotExistsException;
import com.rezzobg.exceptions.UsernameExistsException;
import com.rezzobg.models.Address;
import com.rezzobg.models.User;
import com.rezzobg.repositories.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(rollbackOn = Exception.class)
    public boolean signUp(SignUpDTO signUpDTO) throws Exception, UsernameExistsException {
        User user = userRepository.findByUsername(signUpDTO.getUsername());
        if(user != null) {
            throw new UsernameExistsException("User with such username already exists!");
        }
        //govedo
        Address address = addressService.getAndSaveAddress(signUpDTO);
        User newUser = new User(signUpDTO.getUsername(), this.passwordEncoder.encode(signUpDTO.getPassword()), signUpDTO.getFirstName(),
                    signUpDTO.getLastName(), signUpDTO.getTelephone(),
               address, signUpDTO.getDateOfBirth());

        this.userRepository.save(newUser);
        return true;
    }

    private void checkForValidUser(LoginDTO loginDTO, User user) throws UserNotExistsException  {
        if(user == null) {
            throw new UserNotExistsException("User with such username does not exist!");
        }
        if(!this.passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new UserNotExistsException("Wrong password, please enter valid username and password!");
        }
    }

    public User login(LoginDTO loginDTO) throws BadRequestException, UserNotExistsException, InvalidPasswordException {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        checkForValidUser(loginDTO, user);
        return user;
    }
}
