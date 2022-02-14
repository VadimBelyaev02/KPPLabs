package com.vadim.unit;

import com.vadim.dto.ParallelogramDto;
import com.vadim.service.ParallelogramService;
import com.vadim.service.impl.ParallelogramServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParallelogramUnitTest {

    @InjectMocks
    private ParallelogramServiceImpl service;

    @Test
    public void Given_WidthAndHeight_When_CalculateSquareAndPerimeter_Then_ParallelogramIsReturned() {
        Double width = 4D;
        Double height = 3D;
        ParallelogramDto parallelogramDto = new ParallelogramDto(width, height);

        //when(parallelogramService.getParallelogram(width, height)).thenReturn(parallelogramDto);

        assertEquals(service.getParallelogram(width, height).getSquare(), parallelogramDto.getSquare());
        assertEquals(service.getParallelogram(width, height).getPerimeter(), parallelogramDto.getPerimeter());
    }

}
