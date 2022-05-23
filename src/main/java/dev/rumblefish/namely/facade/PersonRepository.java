package dev.rumblefish.namely.facade;

import dev.rumblefish.namely.jpa.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

    Optional<Person> findTopByOrderByIdDesc();
}
