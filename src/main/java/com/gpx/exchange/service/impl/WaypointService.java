package com.gpx.exchange.service.impl;

import com.gpx.exchange.domain.Waypoint;
import com.gpx.exchange.repository.WaypointRepository;
import com.gpx.exchange.service.IWaypointService;
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

    @Transactional
    @Override
    public List<Waypoint> bulkCreate(List<Waypoint> waypoints) {
        return waypointRepository.save(waypoints);
    }
}
