package com.example.test.counter.service;

import com.example.test.counter.entity.Counter;
import com.example.test.counter.repository.CounterRepository;
import org.springframework.stereotype.Service;

@Service
public record CounterService(CounterRepository counterRepository) {

    public Counter initializeCounter() {
        Counter counter = new Counter();
        counter.setCounter(0);
        return counterRepository.save(counter);
    }

    public Counter updateCounter(int newCounter, long id) {
        Counter updatedCounter = counterRepository.findById(id).orElse(new Counter());
        updatedCounter.setCounter(newCounter);
        return counterRepository.save(updatedCounter);
    }
}