package dev.rumblefish.namely.resource.command;


import dev.rumblefish.namely.request.PersonCreationRequest;
import dev.rumblefish.namely.service.command.PersonCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonCommandController {

    private final PersonCommandService personCommandService;

    @Autowired
    public PersonCommandController(PersonCommandService personCommandService) {
        this.personCommandService = personCommandService;
    }

    @PostMapping("/")
    public void addName(@RequestBody @Valid PersonCreationRequest request) {
        personCommandService.addName(request.getName());
    }

}