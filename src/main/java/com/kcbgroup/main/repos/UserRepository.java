package com.kcbgroup.main.repos;

import com.kcbgroup.main.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
