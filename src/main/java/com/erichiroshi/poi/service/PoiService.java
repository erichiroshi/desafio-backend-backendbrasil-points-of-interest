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
        List<PointDTO> listDto = list.stream()
                .filter(point -> Math.hypot(deltaX(x, point.x()), deltaY(y, point.y())) <= dMax).toList();
        return listDto.stream().map(PointNomeDTO::toPointNomeDTO).toList();
    }

    private Long deltaX(Long x1, Long x2) {
        return x1 - x2 >= 0 ? x1 - x2 : x2 - x1;
    }

    private Long deltaY(Long y1, Long y2) {
        return y1 - y2 >= 0 ? y1 - y2 : y2 - y1;
    }

}