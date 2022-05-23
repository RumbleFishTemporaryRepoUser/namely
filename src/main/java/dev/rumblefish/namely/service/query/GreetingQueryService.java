package dev.rumblefish.namely.service.query;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingQueryService {

    @Value("${value.greeting.without.name}")
    public String greetingNoName = "Hello!";
    @Value("${value.greeting.with.name.begin}")
    private String greetingNameBegin = "Hello ";
    @Value("${value.greeting.with.name.end}")
    private String greetingNameEnd = "!";

    public String createGreeting() {
        return greetingNoName;
    }

    public String createGreeting(String name) {
        return greetingNameBegin + name + greetingNameEnd;
    }
}
