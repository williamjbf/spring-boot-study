package com.github.williamjbf.springbootproject.repository;

import com.github.williamjbf.springbootproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
