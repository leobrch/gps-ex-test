package com.gpx.exchange.service.impl;

import com.gpx.exchange.domain.Track;
import com.gpx.exchange.repository.TrackRepository;
import com.gpx.exchange.service.ITrackService;
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
    public List<Track> bulkCreate(List<Track> tracks) {
        return trackRepository.save(tracks);
    }
}
