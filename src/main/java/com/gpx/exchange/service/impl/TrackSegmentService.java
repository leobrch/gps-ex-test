package com.gpx.exchange.service.impl;

import com.gpx.exchange.domain.TrackSegment;
import com.gpx.exchange.repository.TrackSegmentRepository;
import com.gpx.exchange.service.ITrackSegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrackSegmentService implements ITrackSegmentService {

    @Autowired
    private TrackSegmentRepository trackSegmentRepository;

    @Transactional
    @Override
    public TrackSegment create(TrackSegment trackSegment) {
        return trackSegmentRepository.save(trackSegment);
    }

    @Override
    public List<TrackSegment> bulkCreate(List<TrackSegment> trackSegments) {
        return trackSegmentRepository.save(trackSegments);
    }
}
