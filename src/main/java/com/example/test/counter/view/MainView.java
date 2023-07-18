package com.example.test.counter.view;

import com.example.test.counter.TestCounter;
import com.example.test.counter.entity.Counter;
import com.example.test.counter.view.field.CounterField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("main")
public class MainView extends VerticalLayout {
    private final TestCounter testCounter;

    public MainView(TestCounter testCounter) {
        this.testCounter = testCounter;

        initializeMainView(testCounter);
    }

    private void initializeMainView(TestCounter testCounter) {
        final Button counterButton = new Button("Increment Counter");
        final CounterField counterField = new CounterField(testCounter, "Counter");
        final Binder<Counter> counterBinder = new Binder<>(Counter.class);
        counterBinder.forField(counterField).bind(Counter::getCounter, Counter::setCounter);

        addCounterChangeFieldListener(testCounter, counterButton, counterField);
        addClickIncrementListener(testCounter, counterBinder, counterButton);

        add(new H1("Test Counter"), counterField, counterButton);
    }

    private void addCounterChangeFieldListener(TestCounter testCounter, Button counterButton, CounterField counterField) {
        counterField.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                int counterValue = event.getValue();
                testCounter.updateCounter(counterValue);
                counterButton.setEnabled(testCounter.getCounterValue() != Integer.MAX_VALUE);
            }
            counterField.setValue(testCounter.getCounterValue());
        });
    }

    private void addClickIncrementListener(TestCounter testCounter, Binder<Counter> counterBinder, Button counterButton) {
        counterButton.addClickListener(event -> {
            int incrementedCounter = testCounter.getCounterValue() + 1;
            testCounter.updateCounter(incrementedCounter);
            counterBinder.readBean(testCounter.getTestCounter());
            counterButton.setEnabled(testCounter.getCounterValue() != Integer.MAX_VALUE);
        });
    }
}