package com.notabusiness.app.service;

import com.notabusiness.app.entity.Users;
import com.notabusiness.app.exception.ApplicationException;
import com.notabusiness.app.gigzal.generated.model.LoginResponse;
import com.notabusiness.app.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UsersRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);

    private static final String RESPONSE_BAD_REQUEST = "user already exists";

    public Users register(Users user) {
        log.info("call register() " + user);
        Users oldUser = userRepository.findByUsernameOrEmailOrPhone(user.getUsername(), user.getEmail(), user.getPhone());
        if (oldUser != null) {
            log.error(RESPONSE_BAD_REQUEST);
            throw new ApplicationException(RESPONSE_BAD_REQUEST);
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

    public LoginResponse verify(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtService.generateToken(username);
    }
}
