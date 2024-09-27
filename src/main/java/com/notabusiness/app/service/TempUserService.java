package com.notabusiness.app.service;

import com.notabusiness.app.entity.TempUser;
import com.notabusiness.app.repo.TempUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TempUserService {

    @Autowired
    private TempUsersRepository tempUsersRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);

    public TempUser register(TempUser tempUser) {
        tempUser.setPassword(bCryptPasswordEncoder.encode(tempUser.getPassword()));
        return tempUsersRepository.save(tempUser);
    }

}
