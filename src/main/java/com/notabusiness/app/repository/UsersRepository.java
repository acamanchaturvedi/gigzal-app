package com.notabusiness.app.repository;

import com.notabusiness.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);

    Users findByUsernameOrEmailOrPhone(String username, String email, String phone);
}
