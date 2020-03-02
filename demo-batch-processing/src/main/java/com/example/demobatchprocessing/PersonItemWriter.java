package com.example.demobatchprocessing;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonItemWriter implements ItemWriter {
    @Autowired
    PersonRepository personRepository;
    @Override
    public void write(List persons) throws Exception {
        personRepository.saveAll(persons);
    }
}
