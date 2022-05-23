package dev.rumblefish.namely.service.command;

import dev.rumblefish.namely.facade.PersonRepository;
import dev.rumblefish.namely.jpa.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCommandService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonCommandService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addName(String name) {
        Person person = Person.builder()
                .name(name)
                .build();
        personRepository.save(person);
    }
}
