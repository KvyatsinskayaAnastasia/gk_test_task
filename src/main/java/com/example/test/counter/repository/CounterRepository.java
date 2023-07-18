package com.example.test.counter.repository;

import com.example.test.counter.entity.Counter;
import org.springframework.data.repository.CrudRepository;

public interface CounterRepository extends CrudRepository<Counter, Long> {
}
