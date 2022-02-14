package com.vadim.dto;

public class ParallelogramDto {

    private Double width;
    private Double height;
    private Double square;
    private Double perimeter;

    public ParallelogramDto() {

    }

    public ParallelogramDto(Double width, Double height) {
        this.width = width;
        this.height = height;
        this.square = width * height;
        this.perimeter = 2 * (width + height);
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }
}
