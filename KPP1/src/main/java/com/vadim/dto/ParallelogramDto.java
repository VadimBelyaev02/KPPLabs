package com.vadim.dto;

import java.util.Objects;

public class ParallelogramDto {

    private Double width;
    private Double height;

    public ParallelogramDto(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    public Double getSquare() {
        return width * height;
    }

    public Double getPerimeter() { return 2 * (width + height); }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParallelogramDto that = (ParallelogramDto) o;
        return Objects.equals(width, that.width) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
