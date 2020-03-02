package com.example.demobatchprocessing;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class PersonItemProcessor implements ItemProcessor<Person,Person> {
    @Override
    public Person process(Person person) throws Exception {
        person.setLastName(person.getLastName().toUpperCase());
        return person;
    }
}
