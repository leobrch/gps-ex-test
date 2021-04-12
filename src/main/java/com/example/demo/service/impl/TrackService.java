package com.example.demo.service.impl;

import com.example.demo.domain.Track;
import com.example.demo.repository.TrackRepository;
import com.example.demo.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrackService implements ITrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Transactional
    @Override
    public Track create(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public void update(Track track) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Track> bulkCreate(List<Track> tracks) {
        return trackRepository.save(tracks);
    }
}
