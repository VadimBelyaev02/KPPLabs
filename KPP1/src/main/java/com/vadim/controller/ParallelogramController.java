package com.vadim.controller;

import com.vadim.service.ParallelogramService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parallelogram")
public class ParallelogramController {

    private final ParallelogramService parallelogramService;

    public ParallelogramController(ParallelogramService parallelogramService) {
        this.parallelogramService = parallelogramService;
    }

    @GetMapping("/square")
    @ResponseStatus(HttpStatus.OK)
    public Double getSquare(@RequestParam(value = "width") Double width,
                            @RequestParam(value = "height") Double height) {
        return parallelogramService.calculateSquare(width, height);
    }

    @GetMapping("/perimeter")
    @ResponseStatus(HttpStatus.OK)
    public Double getPerimeter(@RequestParam(value = "width") Double width,
                               @RequestParam(value = "height") Double height) {
        return parallelogramService.calculatePerimeter(width, height);
    }
}
