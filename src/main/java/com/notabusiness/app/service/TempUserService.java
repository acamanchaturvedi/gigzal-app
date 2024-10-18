package com.notabusiness.app.service;

import com.notabusiness.app.entity.TempUser;
import com.notabusiness.app.repo.TempUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TempUserService {

    @Autowired
    private TempUsersRepository tempUsersRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);

    public TempUser register(TempUser tempUser) {
        tempUser.setPassword(bCryptPasswordEncoder.encode(tempUser.getPassword()));
        return tempUsersRepository.save(tempUser);
    }

    public String verify(TempUser tempUser) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tempUser.getUsername(), tempUser.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(tempUser.getUsername());
        return "Failure";
    }
}
