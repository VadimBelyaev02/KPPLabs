package com.vadim.dao;

import com.vadim.model.Parallelogram;

import java.util.List;
import java.util.Optional;

public interface ParallelogramDao {

    Parallelogram save(Parallelogram parallelogram);

    Optional<Parallelogram> findById(Long id);

    boolean existsById(Long id);

    List<Parallelogram> findAll();

    void deleteById(Long id);
}
