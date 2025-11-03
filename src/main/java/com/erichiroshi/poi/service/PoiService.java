package com.erichiroshi.poi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erichiroshi.poi.entity.Point;
import com.erichiroshi.poi.entity.dto.PointDTO;
import com.erichiroshi.poi.entity.dto.PointNomeDTO;
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

    public PointDTO insert(PointDTO dto) {
        Point pointSave = poiRepository.save(dto.toPoint());
        return PointDTO.toPointDTO(pointSave);
    }

    public List<PointNomeDTO> listarProximos(Long x, Long y, Long dMax) {
        List<PointDTO> list = findAll();
        List<PointDTO> listDto = list
                .stream()
                .filter(point -> distanciaEntreDoisPontos(x, y, point) <= dMax)
                .toList();
        
        return listDto.stream().map(PointNomeDTO::toPointNomeDTO).toList();
    }

    private double distanciaEntreDoisPontos(Long x, Long y, PointDTO dto) {

        return Math.hypot((double) x - dto.x(), (double) y - dto.y());
    }
}