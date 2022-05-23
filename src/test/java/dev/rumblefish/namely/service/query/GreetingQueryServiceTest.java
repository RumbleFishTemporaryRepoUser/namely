package dev.rumblefish.namely.service.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


class GreetingQueryServiceTest {
    private String greetingNoName;
    private String greetingNameBegin;
    private String greetingNameEnd;

    private GreetingQueryService greetingQueryService;

    @BeforeEach
    void setUp() {
        greetingNoName = UUID.randomUUID().toString();
        greetingNameBegin = UUID.randomUUID().toString();
        greetingNameEnd = UUID.randomUUID().toString();
        greetingQueryService = new GreetingQueryService(
                greetingNoName,
                greetingNameBegin,
                greetingNameEnd);
    }

    @Test
    void createGreeting() {
        assertThat(greetingQueryService.createGreeting()).isEqualTo(greetingNoName);
    }

    @Test
    void testCreateGreeting() {
        String name = UUID.randomUUID().toString();
        assertThat(greetingQueryService.createGreeting(name)).isEqualTo(greetingNameBegin + name + greetingNameEnd);
    }
}