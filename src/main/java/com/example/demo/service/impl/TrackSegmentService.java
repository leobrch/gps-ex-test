package com.example.demo.service.impl;

import com.example.demo.domain.TrackSegment;
import com.example.demo.repository.TrackSegmentRepository;
import com.example.demo.service.ITrackSegmentService;
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
    public void update(TrackSegment trackSegment) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<TrackSegment> bulkCreate(List<TrackSegment> trackSegments) {
        return trackSegmentRepository.save(trackSegments);
    }
}
