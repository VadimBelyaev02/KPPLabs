package com.vadim.controller;

import com.vadim.dto.ParallelogramDto;
import com.vadim.service.ParallelogramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/parallelogram")
@Validated
public class ParallelogramController {

    @Autowired
    private ParallelogramService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ParallelogramDto getParallelogram(@RequestParam("width") Double width,
                                             @RequestParam("height") Double height) {
        return service.getParallelogram(width, height);
    }
}
