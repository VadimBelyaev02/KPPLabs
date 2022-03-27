package com.vadim.unit;

import com.vadim.dto.ParallelogramDto;
import com.vadim.exception.CalculatingException;
import com.vadim.service.impl.ParallelogramServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ParallelogramServiceUnitTest {

    @InjectMocks
    private ParallelogramServiceImpl service;

    @Test
    public void Given_WidthAndHeight_When_CalculateSquareAndPerimeter_Then_ParallelogramIsReturned() {
        Double width = 2D;
        Double height = 3D;
        ParallelogramDto parallelogramDto = new ParallelogramDto(width, height);

        assertEquals(service.getParallelogram(width, height), parallelogramDto);
    }

    @Test
    public void Given_WidthAndHeight_When_BadValues_Then_ThrowsCalculatingException() {
        Double width = 40000D;
        Double height = 300000D;

        assertThrows(CalculatingException.class, () -> service.getParallelogram(width, height));
    }

}
