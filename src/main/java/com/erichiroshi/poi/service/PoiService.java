package com.erichiroshi.poi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erichiroshi.poi.entity.Point;
import com.erichiroshi.poi.entity.dto.PointDTO;
import com.erichiroshi.poi.repository.PoiRepository;

@Service
public class PoiService {

    private final PoiRepository poiRepository;

    public PoiService(PoiRepository poiRepository) {
        this.poiRepository = poiRepository;
    }

    public List<PointDTO> findAll() {
        List<Point> list = poiRepository.findAll();
        return list.stream().map(PointDTO::toPointDTO).toList();
    }

}