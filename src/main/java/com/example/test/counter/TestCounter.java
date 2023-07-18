package com.example.test.counter;

import com.example.test.counter.entity.Counter;
import com.example.test.counter.service.CounterService;
import org.springframework.stereotype.Component;

@Component
public class TestCounter {
    private final CounterService counterService;
    private Counter counter;

    public TestCounter(CounterService counterService) {
        this.counterService = counterService;
        this.counter = counterService.initializeCounter();
    }

    public Counter getTestCounter() {
        return counter;
    }

    public int getCounterValue() {
        return counter.getCounter();
    }

    public void updateCounter(int counterValue) {
        counter = counterService.updateCounter(counterValue, counter.getId());
    }
}
