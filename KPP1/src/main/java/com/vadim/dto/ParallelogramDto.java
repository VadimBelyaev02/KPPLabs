package com.vadim.dto;

public class ParallelogramDto {

    private Double width;
    private Double height;

    public ParallelogramDto() {

    }

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
}
