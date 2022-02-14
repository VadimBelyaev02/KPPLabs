package com.vadim.service.impl;

import com.vadim.dto.ParallelogramDto;
import com.vadim.exception.CalculatingException;
import com.vadim.service.ParallelogramService;
import org.springframework.stereotype.Service;

@Service
public class ParallelogramServiceImpl implements ParallelogramService {

    @Override
    public ParallelogramDto getParallelogram(Double width, Double height) {
        if (width * height > 100000D) {
            throw new CalculatingException("This is an exception just to show that it works");
        }
        return new ParallelogramDto(width, height);
    }

}
