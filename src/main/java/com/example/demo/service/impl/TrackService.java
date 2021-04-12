package com.example.demo.service.impl;

import com.example.demo.domain.Track;
import com.example.demo.repository.TrackRepository;
import com.example.demo.service.IService;
import com.example.demo.service.IMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService implements IMetadataService, IService<Track> {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void create(Track track) {

    }

    @Override
    public void update(Track track) {

    }

    @Override
    public void delete(Long id) {

    }
}
