package com.vadim.service.impl;

import com.vadim.dto.ParallelogramDto;
import com.vadim.service.ParallelogramService;
import org.springframework.stereotype.Service;

@Service
public class ParallelogramServiceImpl implements ParallelogramService {

    @Override
    public ParallelogramDto getParallelogram(Double width, Double height) {
        return new ParallelogramDto(width, height);
    }

}
