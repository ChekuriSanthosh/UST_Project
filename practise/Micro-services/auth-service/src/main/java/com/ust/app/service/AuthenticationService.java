package com.ust.app.service;


import com.ust.app.dto.JwtToken;
import com.ust.app.dto.UserCredentials;
import com.ust.app.model.UserModel;
import com.ust.app.respository.UserRepository;
import com.ust.app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public JwtToken loginUser(UserCredentials userCredentials){
        UserModel userModel=userRepository.findByUsername(userCredentials.username()).orElseThrow(()->new UsernameNotFoundException("User with name "+userCredentials.username()+"Not Found"));

        if(!passwordEncoder.matches(userCredentials.password(),userModel.getPassword())){
            throw  new RuntimeException("Invalid Credentials");
        }

        String jwt=jwtUtil.generateToken(userCredentials.username());
        return new JwtToken(jwt);

    }
}
