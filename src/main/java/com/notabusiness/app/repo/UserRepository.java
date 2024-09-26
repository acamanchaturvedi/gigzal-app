package com.notabusiness.app.repo;

import com.notabusiness.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
