package com.erichiroshi.poi.entity.dto;

import com.erichiroshi.poi.entity.Point;

public record PointDTO(
        Long id,
        String nome,
        Long x,
        Long y) {

    public static PointDTO toPointDTO(Point point) {
        return new PointDTO(point.getId(), point.getNome(), point.getX(), point.getY());
    }

    public Point toPoint() {
        return new Point(nome, x, y);
    }
}