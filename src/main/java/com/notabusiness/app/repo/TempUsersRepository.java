package com.notabusiness.app.repo;

import com.notabusiness.app.entity.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempUsersRepository extends JpaRepository<TempUser, Integer> {

    TempUser findByUsername(String username);

}
