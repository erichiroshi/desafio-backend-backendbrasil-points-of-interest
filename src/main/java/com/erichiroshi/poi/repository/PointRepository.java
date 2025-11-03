package com.erichiroshi.poi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erichiroshi.poi.entity.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

    @Query("""
            SELECT p FROM Point p
            WHERE (p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax)
            """)
    List<Point> findNearMe(@Param("xMin") long xMin,
                            @Param("xMax") long xMax,
                            @Param("yMin") long yMin,
                            @Param("yMax") long yMax);

}