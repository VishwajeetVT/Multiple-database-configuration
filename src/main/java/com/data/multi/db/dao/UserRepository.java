package com.data.multi.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.data.multi.db.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
