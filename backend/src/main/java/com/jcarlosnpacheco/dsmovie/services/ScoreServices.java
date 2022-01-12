package com.jcarlosnpacheco.dsmovie.services;

import com.jcarlosnpacheco.dsmovie.dto.MovieDTO;
import com.jcarlosnpacheco.dsmovie.dto.ScoreDTO;
import com.jcarlosnpacheco.dsmovie.entities.Movie;
import com.jcarlosnpacheco.dsmovie.entities.Score;
import com.jcarlosnpacheco.dsmovie.entities.User;
import com.jcarlosnpacheco.dsmovie.repositories.MovieRepository;
import com.jcarlosnpacheco.dsmovie.repositories.ScoreRepository;
import com.jcarlosnpacheco.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreServices {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());

        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user); // garantia do obj salvo no banco imediatamente
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();

        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        // pega a soma de avaliações/notas
        double sumScores = 0.0;

        for (Score s : movie.getScores()) {
            sumScores = sumScores + s.getValue();
        }

        double avg = sumScores / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        return new MovieDTO(movieRepository.save(movie));

    }

}
