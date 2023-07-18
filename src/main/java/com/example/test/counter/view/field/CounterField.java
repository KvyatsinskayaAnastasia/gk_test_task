package com.example.test.counter.view.field;

import com.example.test.counter.TestCounter;
import com.vaadin.flow.component.textfield.IntegerField;

public class CounterField extends IntegerField {

    public CounterField(TestCounter testCounter, String label) {
        super(label);
        initializeCounterField(testCounter);
    }

    private void initializeCounterField(TestCounter testCounter) {
        this.setLabel("Counter");
        this.setValue(testCounter.getCounterValue());
        this.setMax(Integer.MAX_VALUE);
        this.setMin(Integer.MIN_VALUE);
        this.setHelperText("Please, choose value from -2147483648 to 2147483647");
    }
}