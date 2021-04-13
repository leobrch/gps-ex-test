package com.gpx.exchange.repository;

import com.gpx.exchange.domain.TrackSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackSegmentRepository extends JpaRepository<TrackSegment, Long> {
}
