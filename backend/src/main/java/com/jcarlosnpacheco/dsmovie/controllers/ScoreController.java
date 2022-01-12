package com.jcarlosnpacheco.dsmovie.controllers;

import com.jcarlosnpacheco.dsmovie.dto.MovieDTO;
import com.jcarlosnpacheco.dsmovie.dto.ScoreDTO;
import com.jcarlosnpacheco.dsmovie.services.ScoreServices;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
    @Autowired
    private ScoreServices services;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        return services.saveScore(dto);
    }

}
