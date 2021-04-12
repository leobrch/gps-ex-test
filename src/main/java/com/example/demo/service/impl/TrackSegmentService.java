package com.example.demo.service.impl;

import com.example.demo.domain.TrackSegment;
import com.example.demo.repository.TrackSegmentRepository;
import com.example.demo.service.IService;
import com.example.demo.service.IMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackSegmentService implements IMetadataService, IService<TrackSegment> {

    @Autowired
    private TrackSegmentRepository trackSegmentRepository;

    @Override
    public void create(TrackSegment trackSegment) {

    }

    @Override
    public void update(TrackSegment trackSegment) {

    }

    @Override
    public void delete(Long id) {

    }
}
