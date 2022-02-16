package com.vadim.model;

public class Parallelogram {

    private Long id;
    private Double width;
    private Double height;

    public Parallelogram() {

    }
    public Parallelogram(Long id, Double width, Double height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

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

    public Double getSquare() {
        return width * height;
    }

    public Double getPerimeter() {
        return 2 * (width + height);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
