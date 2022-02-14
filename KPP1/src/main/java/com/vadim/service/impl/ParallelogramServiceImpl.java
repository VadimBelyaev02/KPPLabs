package com.vadim.service.impl;

import com.vadim.service.ParallelogramService;
import org.springframework.stereotype.Service;

@Service
public class ParallelogramServiceImpl implements ParallelogramService {

    @Override
    public Double calculateSquare(Double width, Double height) {
        return width * height;
    }

    @Override
    public Double calculatePerimeter(Double width, Double height) {
        return 2 * (width + height);
    }
}
