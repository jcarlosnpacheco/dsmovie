package com.jcarlosnpacheco.dsmovie.repositories;

import com.jcarlosnpacheco.dsmovie.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
