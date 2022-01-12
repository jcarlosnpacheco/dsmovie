package com.jcarlosnpacheco.dsmovie.repositories;

import com.jcarlosnpacheco.dsmovie.entities.Score;
import com.jcarlosnpacheco.dsmovie.entities.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
