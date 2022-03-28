package com.vadim.dto;

import javax.validation.constraints.NotNull;

public class ParallelogramDto {

    @NotNull
    private Long id;

    @NotNull
    private Double width;

    @NotNull
    private Double height;

    public ParallelogramDto() {

    }

    public ParallelogramDto(Long id, Double width, Double height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPerimeter() {
        return 2 * (width + height);
    }

    public Double getSquare() {
        return width * height;
    }
}
