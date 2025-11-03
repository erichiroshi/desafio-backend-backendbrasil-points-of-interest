package com.erichiroshi.poi.entity.dto;

import com.erichiroshi.poi.entity.Point;

public record PointDTO(
        String nome,
        Long x,
        Long y) {

    public static PointDTO toPointDTO(Point point) {
        return new PointDTO(point.getNome(), point.getX(), point.getY());
    }

    public Point toPoint() {
        return new Point(nome, x, y);
    }
}