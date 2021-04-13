package com.gpx.exchange.repository;

import com.gpx.exchange.domain.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaypointRepository extends JpaRepository<Waypoint, Long> {
}
