package com.erichiroshi.poi.entity.dto;

import com.erichiroshi.poi.entity.Point;

public record PointNomeDTO(
        String nome) {

    public static PointNomeDTO toPointNomeDTO(Point point) {
        return new PointNomeDTO(point.getNome());
    }

}
