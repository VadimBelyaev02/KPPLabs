package com.vadim.dao.impl;

import com.vadim.dao.ParallelogramDao;
import com.vadim.model.Parallelogram;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ParallelogramDaoImpl implements ParallelogramDao {

    private final Map<Long, Parallelogram> parallelograms;

    public ParallelogramDaoImpl() {
         this.parallelograms = new HashMap<>();
    }

    @Override
    public Parallelogram save(Parallelogram parallelogram) {
        parallelograms.put(parallelogram.getId(), parallelogram);
        return parallelogram;
    }

    @Override
    public Optional<Parallelogram> findById(Long id) {
        Parallelogram parallelogram = parallelograms.get(id);
        if (Objects.isNull(parallelogram)) {
            return Optional.empty();
        }
        return Optional.of(parallelogram);
    }

    @Override
    public boolean existsById(Long id) {
        return parallelograms.containsKey(id);
    }

    @Override
    public List<Parallelogram> findAll() {
        return new ArrayList<>(parallelograms.values());
    }

    @Override
    public void deleteById(Long id) {
        parallelograms.remove(id);
    }
}
