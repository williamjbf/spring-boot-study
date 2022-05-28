package com.github.williamjbf.springbootproject.repository;

import com.github.williamjbf.springbootproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = "select u from Users u where upper(trim(u.name)) like %?1%")
    List<Users> findByName(String name);
}
