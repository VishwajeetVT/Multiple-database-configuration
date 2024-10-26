package com.data.multi.db.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.data.multi.db.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
