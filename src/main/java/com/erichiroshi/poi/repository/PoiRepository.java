package com.erichiroshi.poi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erichiroshi.poi.entity.Point;

public interface PoiRepository extends JpaRepository<Point, Long> {

}
