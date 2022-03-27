package com.vadim.dto.converter;

import com.vadim.dto.ParallelogramDto;
import com.vadim.model.Parallelogram;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class ParallelogramConverter {


    public Parallelogram convertToModel(ParallelogramDto parallelogramDto) {
        final Long id = parallelogramDto.getId();
        final Double width = parallelogramDto.getWidth();
        final Double height = parallelogramDto.getHeight();
        Parallelogram parallelogram = new Parallelogram();
        parallelogram.setWidth(width);
        parallelogram.setHeight(height);
        parallelogram.setId(id);
        return parallelogram;
    }

    public ParallelogramDto convertToDto(Parallelogram parallelogram) {
        final Long id = parallelogram.getId();
        final Double width = parallelogram.getWidth();
        final Double height = parallelogram.getHeight();
        ParallelogramDto parallelogramDto = new ParallelogramDto();
        parallelogramDto.setWidth(width);
        parallelogramDto.setHeight(height);
        parallelogramDto.setId(id);
        return parallelogramDto;
    }
}
