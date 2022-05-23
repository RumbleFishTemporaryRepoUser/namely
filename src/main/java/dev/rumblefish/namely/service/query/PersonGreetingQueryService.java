package dev.rumblefish.namely.service.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonGreetingQueryService {

    private final PersonQueryService personQueryService;
    private final GreetingQueryService greetingQueryService;

    @Autowired
    public PersonGreetingQueryService(PersonQueryService personQueryService, GreetingQueryService greetingQueryService) {
        this.personQueryService = personQueryService;
        this.greetingQueryService = greetingQueryService;
    }

    public String findGreetingForLatestPerson() {
        return personQueryService.findLatestName()
                .map(greetingQueryService::createGreeting)
                .orElseGet(greetingQueryService::createGreeting);
    }
}
