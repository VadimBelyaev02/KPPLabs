package com.vadim.service.impl;

import com.vadim.dto.ParallelogramDto;
import com.vadim.exception.CalculatingException;
import com.vadim.service.ParallelogramService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ParallelogramServiceImpl implements ParallelogramService {

    private static final Logger logger = LogManager.getLogger(ParallelogramServiceImpl.class);

    @Override
    public ParallelogramDto getParallelogram(Double width, Double height) {
        logger.error("Class: ParallelogramServiceImpl; Method: getParallelogram; Params: (width=" + width + ", height=" + height + ")");
        if (width * height > 100000D) {
            logger.error("Calculating exception");
            throw new CalculatingException("This is an exception just to show that it works");
        }
        logger.info("Everything is okay");
        return new ParallelogramDto(width, height);
    }

}
