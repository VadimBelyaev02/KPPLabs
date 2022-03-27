package com.vadim.unit;

import com.vadim.dao.impl.ParallelogramDaoImpl;
import com.vadim.dto.ParallelogramDto;
import com.vadim.dto.converter.ParallelogramConverter;
import com.vadim.exception.AlreadyExistsException;
import com.vadim.exception.NotFoundException;
import com.vadim.model.Parallelogram;
import com.vadim.service.impl.ParallelogramServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ParallelogramUnitTest {

    @InjectMocks
    private ParallelogramServiceImpl service;

    @Mock
    private ParallelogramDaoImpl dao;

    @Mock
    private ParallelogramConverter converter;

    @Test
    public void Given_Id_When_GettingParallelogram_Then_ParallelogramIsReturned() {
        Long id = 1L;
        ParallelogramDto parallelogramDto = new ParallelogramDto();
        Parallelogram parallelogram = new Parallelogram();
        parallelogram.setId(id);

        when(dao.findById(id)).thenReturn(Optional.of(parallelogram));
        when(converter.convertToDto(parallelogram)).thenReturn(parallelogramDto);

        assertEquals(service.getParallelogram(id), parallelogramDto);

        verify(dao, only()).findById(id);
        verify(converter, only()).convertToDto(parallelogram);
    }

    @Test
    public void Given_Id_When_GettingParallelogram_Then_ThrowNotFoundException() {
        Long id = 1L;
        ParallelogramDto parallelogramDto = new ParallelogramDto();
        Parallelogram parallelogram = new Parallelogram();

        when(dao.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.getParallelogram(id));

        verify(dao, only()).findById(id);
        verify(converter, never()).convertToDto(parallelogram);
    }

    @Test
    public void Given_ParallelogramDto_When_SavingIt_Then_SavedParallelogramIsReturned() {
        Long id = 1L;
        Parallelogram parallelogram = new Parallelogram();
        ParallelogramDto parallelogramDto = new ParallelogramDto();
        parallelogramDto.setId(id);

        when(dao.existsById(id)).thenReturn(false);
        when(converter.convertToDto(parallelogram)).thenReturn(parallelogramDto);
        when(converter.convertToModel(parallelogramDto)).thenReturn(parallelogram);
        when(dao.save(parallelogram)).thenReturn(parallelogram);

        assertEquals(service.save(parallelogramDto), parallelogramDto);

        verify(dao, times(1)).save(parallelogram);
        verify(converter, times(1)).convertToDto(parallelogram);
        verify(converter, times(1)).convertToModel(parallelogramDto);
        verify(dao, times(1)).existsById(id);
    }

    @Test
    public void Given_ParallelogramDto_When_SavingIt_Then_ThrowAlreadyExistsException() {
        Long id = 1L;
        Parallelogram parallelogram = new Parallelogram();
        ParallelogramDto parallelogramDto = new ParallelogramDto();
        parallelogramDto.setId(id);

        when(dao.existsById(id)).thenReturn(true);

        assertThrows(AlreadyExistsException.class, () -> service.save(parallelogramDto));

        verify(dao, only()).existsById(id);
        verify(dao, never()).save(parallelogram);
        verify(converter, never()).convertToDto(parallelogram);
        verify(converter, never()).convertToModel(parallelogramDto);
    }

    @Test
    public void Given_Nothing_When_GettingAllParallelograms_Then_ReturnList() {
        List<ParallelogramDto> parallelogramDtos = new ArrayList<>();
        List<Parallelogram> parallelograms = new ArrayList<>();
        ParallelogramDto parallelogramDto = new ParallelogramDto();
        Parallelogram parallelogram = new Parallelogram();
        parallelograms.add(parallelogram);
        parallelograms.add(parallelogram);
        parallelograms.add(parallelogram);
        parallelogramDtos.add(parallelogramDto);
        parallelogramDtos.add(parallelogramDto);
        parallelogramDtos.add(parallelogramDto);

        when(dao.findAll()).thenReturn(parallelograms);
        when(converter.convertToDto(parallelogram)).thenReturn(parallelogramDto);

        assertEquals(service.getAll(), parallelogramDtos);

        verify(dao, only()).findAll();
        verify(converter, times(3)).convertToDto(parallelogram);
        verify(converter, never()).convertToModel(parallelogramDto);
    }

    @Test
    public void Given_ParallelogramDto_When_UpdatingExisted_Then_ReturnUpdated() {
        Long id = 1L;
        ParallelogramDto parallelogramDto = new ParallelogramDto();
        Parallelogram parallelogram = new Parallelogram();
        parallelogramDto.setId(id);

        when(dao.existsById(id)).thenReturn(true);
        when((converter.convertToDto(parallelogram))).thenReturn(parallelogramDto);
        when(converter.convertToModel(parallelogramDto)).thenReturn(parallelogram);
        when(dao.save(parallelogram)).thenReturn(parallelogram);

        assertEquals(service.update(parallelogramDto), parallelogramDto);

        verify(dao, times(1)).existsById(id);
        verify(dao, times(1)).save(parallelogram);
        verify(converter, times(1)).convertToModel(parallelogramDto);
        verify(converter, times(1)).convertToDto(parallelogram);
    }

    @Test
    public void Given_ParallelogramDto_When_UpdatingExisted_Then_ThrowNotFoundException() {
        Long id = 1L;
        ParallelogramDto parallelogramDto = new ParallelogramDto();
        Parallelogram parallelogram = new Parallelogram();
        parallelogramDto.setId(id);

        when(dao.existsById(id)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> service.update(parallelogramDto));

        verify(dao, only()).existsById(id);
        verify(dao, never()).save(parallelogram);
        verify(converter, never()).convertToModel(parallelogramDto);
        verify(converter, never()).convertToDto(parallelogram);
    }
}
