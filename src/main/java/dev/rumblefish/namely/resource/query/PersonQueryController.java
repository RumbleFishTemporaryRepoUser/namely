package dev.rumblefish.namely.resource.query;


import dev.rumblefish.namely.response.GreetingResponse;
import dev.rumblefish.namely.service.query.PersonGreetingQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonQueryController {

    private final PersonGreetingQueryService personGreetingQueryService;

    @Autowired
    public PersonQueryController(PersonGreetingQueryService personGreetingQueryService) {
        this.personGreetingQueryService = personGreetingQueryService;
    }

    @GetMapping("/")
    public GreetingResponse findLatestName() {
        String greetingForLatestPerson = personGreetingQueryService.findGreetingForLatestPerson();
        return GreetingResponse.builder()
                .greeting(greetingForLatestPerson)
                .build();
    }
}