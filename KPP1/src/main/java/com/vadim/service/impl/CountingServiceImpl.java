package com.vadim.service.impl;

import com.vadim.service.CountingService;
import org.springframework.stereotype.Service;

@Service
public class CountingServiceImpl implements CountingService {

    private long numberOfRequests;

    //
    //
    //

    public void increment() {
        this.numberOfRequests++;
    }

    public Long getNumberOfRequests() {
        return this.numberOfRequests;
    }
}
