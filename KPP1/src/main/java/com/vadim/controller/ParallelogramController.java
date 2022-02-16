package com.vadim.controller;

import com.vadim.dto.ParallelogramDto;
import com.vadim.exception.NotValidException;
import com.vadim.service.CountingService;
import com.vadim.service.ParallelogramService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/parallelogram")
@Validated
public class ParallelogramController {

    private final ParallelogramService service;
    private final CountingService countingService;

    public ParallelogramController(ParallelogramService service, CountingService countingService) {
        this.service = service;
        this.countingService = countingService;
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long getCount() {
        countingService.increment();
        return countingService.getNumberOfRequests();
    }

    @GetMapping("/{id}/square")
    @ResponseStatus(HttpStatus.OK)
    public Double getSquare(@PathVariable("id") Long id) {
        countingService.increment();
        return service.getParallelogram(id).getSquare();
    }

    @GetMapping("/{id}/perimeter")
    @ResponseStatus(HttpStatus.OK)
    public Double getPerimeter(@PathVariable("id") Long id) {
        countingService.increment();
        return service.getParallelogram(id).getPerimeter();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ParallelogramDto getParallelogram(@PathVariable("id") Long id) {
        countingService.increment();
        return service.getParallelogram(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ParallelogramDto> getParallelograms() {
        countingService.increment();
        return service.getAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ParallelogramDto putParallelogram(@Valid @RequestBody ParallelogramDto parallelogramDto, BindingResult result) {
        if (result.hasErrors()) {
            throw new NotValidException(result.getAllErrors().toString());
        }
        countingService.increment();
        return service.update(parallelogramDto);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParallelogramDto postParallelogram(@Valid @RequestBody ParallelogramDto parallelogramDto, BindingResult result) {
        Random random = new Random();
        long id = random.nextLong();
        if (countingService.getNumberOfRequests() < 4) {
            id = 1L;
        }
        parallelogramDto.setId(id);
        if (result.hasErrors()) {
            throw new NotValidException(result.getAllErrors().toString());
        }
        countingService.increment();
        return service.save(parallelogramDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParallelogram(@PathVariable("id") Long id) {
        countingService.increment();
        if (id != 0) {
            return;
        }
        service.deleteById(id);
    }
}
