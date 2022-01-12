package com.jcarlosnpacheco.dsmovie.repositories;

import com.jcarlosnpacheco.dsmovie.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
