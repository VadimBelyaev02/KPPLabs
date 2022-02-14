package com.vadim.controller;

import com.vadim.dto.ParallelogramDto;
import com.vadim.service.ParallelogramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/parallelogram")
@Validated
public class ParallelogramController {

    private final ParallelogramService service;

    public ParallelogramController(ParallelogramService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ParallelogramDto getParallelogram(@RequestParam("width") @Min(1) Double width,
                                             @RequestParam("height") @Min(1) Double height) {
        return service.getParallelogram(width, height);
    }

    @GetMapping("/x")
    public ParallelogramDto parallelogramDto() {
        return new ParallelogramDto();
    }
}
