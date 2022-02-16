package com.vadim.service;

import com.vadim.dto.ParallelogramDto;

import java.util.List;

public interface ParallelogramService {

    ParallelogramDto getParallelogram(Long id);

    ParallelogramDto save(ParallelogramDto parallelogramDto);

    List<ParallelogramDto> getAll();

    ParallelogramDto update(ParallelogramDto parallelogramDto);

    void deleteById(Long id);
}