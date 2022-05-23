package dev.rumblefish.namely.service.query;

import dev.rumblefish.namely.facade.PersonRepository;
import dev.rumblefish.namely.jpa.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonQueryService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonQueryService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<String> findLatestName() {
        return personRepository.findTopByOrderByIdDesc().map(Person::getName);
    }
}
