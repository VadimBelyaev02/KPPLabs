package com.vadim.dao.impl;

import com.vadim.dao.ParallelogramDao;
import com.vadim.model.Parallelogram;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ParallelogramDaoImpl implements ParallelogramDao {

    private Map<Long, Parallelogram> parallelograms;

    public Parallelogram save(Parallelogram parallelogram) {
        return parallelograms.put(parallelogram.getId(), parallelogram);
    }

    public Optional<Parallelogram> findById(Long id) {
        Parallelogram parallelogram = parallelograms.get(id);
        if (Objects.isNull(parallelogram)) {
            return Optional.empty();
        }
        return Optional.of(parallelogram);
    }

    public boolean existsById(Long id) {
        return parallelograms.containsKey(id);
    }
}
