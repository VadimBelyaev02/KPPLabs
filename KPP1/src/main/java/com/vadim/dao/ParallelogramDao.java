package com.vadim.dao;

import com.vadim.model.Parallelogram;

import java.util.Objects;
import java.util.Optional;

public interface ParallelogramDao {

    Parallelogram save(Parallelogram parallelogram);

    Optional<Parallelogram> findById(Long id);

    boolean existsById(Long id);
}
