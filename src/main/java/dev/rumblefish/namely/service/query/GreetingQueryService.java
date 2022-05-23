package dev.rumblefish.namely.service.query;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingQueryService {

    private final String greetingNoName;
    private final String greetingNameBegin;
    private final String greetingNameEnd;

    public GreetingQueryService(@Value("${value.greeting.without.name}") String greetingNoName, @Value("${value.greeting.with.name.begin}") String greetingNameBegin, @Value("${value.greeting.with.name.end}") String greetingNameEnd) {
        this.greetingNoName = greetingNoName;
        this.greetingNameBegin = greetingNameBegin;
        this.greetingNameEnd = greetingNameEnd;
    }

    public String createGreeting() {
        return greetingNoName;
    }

    public String createGreeting(String name) {
        return greetingNameBegin + name + greetingNameEnd;
    }
}
