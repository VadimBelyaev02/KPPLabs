package com.vadim.service.impl;

import com.vadim.dao.impl.ParallelogramDaoImpl;
import com.vadim.dto.ParallelogramDto;
import com.vadim.dto.converter.ParallelogramConverter;
import com.vadim.exception.AlreadyExistsException;
import com.vadim.exception.NotFoundException;
import com.vadim.model.Parallelogram;
import com.vadim.service.ParallelogramService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParallelogramServiceImpl implements ParallelogramService {

    private final ParallelogramDaoImpl parallelogramDao;
    private final ParallelogramConverter converter;

    public ParallelogramServiceImpl(ParallelogramDaoImpl parallelogramDao, ParallelogramConverter converter) {
        this.parallelogramDao = parallelogramDao;
        this.converter = converter;
    }

    @Override
    public ParallelogramDto getParallelogram(Long id) {
        Parallelogram parallelogram = parallelogramDao.findById(id).orElseThrow(() ->
            new NotFoundException("Parallelogram with id = " + id + " is not found")
        );
        return converter.convertToDto(parallelogram);
    }

    @Override
    public ParallelogramDto save(ParallelogramDto parallelogramDto) {
        if (parallelogramDao.existsById(parallelogramDto.getId())) {
            throw new AlreadyExistsException("Parallelogram with id = " + parallelogramDto.getId() + " already exists");
        }
        Parallelogram parallelogram = parallelogramDao.save(converter.convertToModel(parallelogramDto));
        return converter.convertToDto(parallelogram);
    }

    @Override
    public List<ParallelogramDto> getAll() {
        return parallelogramDao.findAll().stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParallelogramDto update(ParallelogramDto parallelogramDto) {
        if (!parallelogramDao.existsById(parallelogramDto.getId())) {
            throw new NotFoundException("Parallelogram with id = " + parallelogramDto.getId() + " is not found");
        }
        Parallelogram parallelogram = parallelogramDao.save(converter.convertToModel(parallelogramDto));
        return converter.convertToDto(parallelogram);
    }

    @Override
    public void deleteById(Long id) {
        if (!parallelogramDao.existsById(id)) {
            throw new NotFoundException("Parallelogram with id = " + id + " is not found");
        }
        parallelogramDao.deleteById(id);
    }

}
