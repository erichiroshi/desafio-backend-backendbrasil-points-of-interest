package com.erichiroshi.poi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.erichiroshi.poi.entity.Point;
import com.erichiroshi.poi.entity.dto.PointDTO;
import com.erichiroshi.poi.entity.dto.PointNomeDTO;
import com.erichiroshi.poi.repository.PointRepository;

@Service
public class PointService {

    private final PointRepository pointRepository;

    public PointService(PointRepository poiRepository) {
        this.pointRepository = poiRepository;
    }

    public Page<PointDTO> findAll(PageRequest pageRequest) {
        Page<Point> pageAll = pointRepository.findAll(pageRequest);
        return pageAll.map(PointDTO::toPointDTO);
    }

    public PointDTO insert(PointDTO dto) {
        Point pointSave = pointRepository.save(dto.toPoint());
        return PointDTO.toPointDTO(pointSave);
    }

    public List<PointNomeDTO> listarProximos(Long x, Long y, Long dMax) {

        var xMin = x - dMax;
        var xMax = x + dMax;
        var yMin = y - dMax;
        var yMax = y + dMax;

        List<Point> list = pointRepository.findNearMe(xMin, xMax, yMin, yMax)
                .stream()
                .filter(point -> distanciaEntreDoisPontos(x, y, point) <= dMax)
                .toList();

        return list.stream().map(PointNomeDTO::toPointNomeDTO).toList();
    }

    private double distanciaEntreDoisPontos(Long x, Long y, Point point) {
        return Math.hypot((double) x - point.getX(), (double) y - point.getY());
    }
}