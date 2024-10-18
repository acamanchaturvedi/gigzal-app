package com.notabusiness.app.service;

import com.notabusiness.app.entity.TempUser;
import com.notabusiness.app.model.UserPrincipal;
import com.notabusiness.app.repo.TempUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private TempUsersRepository tempUsersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TempUser tempUser = tempUsersRepository.findByUsername(username);
        if(tempUser==null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(tempUser);
    }
}
