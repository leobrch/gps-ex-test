package com.example.demo.service.impl;

import com.example.demo.domain.Waypoint;
import com.example.demo.repository.WaypointRepository;
import com.example.demo.service.IWaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WaypointService implements IWaypointService {

    @Autowired
    private WaypointRepository waypointRepository;

    @Transactional
    @Override
    public Waypoint create(Waypoint waypoint) {
        return waypointRepository.save(waypoint);
    }

    @Override
    public void update(Waypoint waypoint) {

    }

    @Override
    public void delete(Long id) {

    }

    @Transactional
    @Override
    public List<Waypoint> bulkCreate(List<Waypoint> waypoints) {
        return waypointRepository.save(waypoints);
    }
}
