package com.example.demo.service.impl;

import com.example.demo.domain.Waypoint;
import com.example.demo.repository.WaypointRepository;
import com.example.demo.service.IService;
import com.example.demo.service.IMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaypointService implements IMetadataService, IService<Waypoint> {

    @Autowired
    private WaypointRepository waypointRepository;

    @Override
    public void create(Waypoint waypoint) {

    }

    @Override
    public void update(Waypoint waypoint) {

    }

    @Override
    public void delete(Long id) {

    }
}
