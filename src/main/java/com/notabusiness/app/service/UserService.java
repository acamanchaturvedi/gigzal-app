package com.notabusiness.app.service;

import com.notabusiness.app.entity.Users;
import com.notabusiness.app.gigzal.generated.model.LoginResponse;
import com.notabusiness.app.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);

    public Users register(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public LoginResponse verify(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        if(authentication.isAuthenticated())
        return jwtService.generateToken(username);
//        return "Failure";
    }
}
