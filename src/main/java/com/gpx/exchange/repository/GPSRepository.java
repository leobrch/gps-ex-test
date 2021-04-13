package com.gpx.exchange.repository;

import com.gpx.exchange.domain.GPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPSRepository extends JpaRepository<GPS, Long> {
}
