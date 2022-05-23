package dev.rumblefish.namely.service.query;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonGreetingQueryServiceTest {

    @Mock
    private PersonQueryService personQueryService;
    @Mock
    private GreetingQueryService greetingQueryService;
    @InjectMocks
    private PersonGreetingQueryService personGreetingQueryService;

    @Test
    void findGreetingForLatestPersonLatestNameNotFound() {
        when(personQueryService.findLatestName())
                .thenReturn(Optional.empty());
        String greeting = UUID.randomUUID().toString();
        when(greetingQueryService.createGreeting())
                .thenReturn(greeting);
        assertThat(personGreetingQueryService.findGreetingForLatestPerson())
                .isEqualTo(greeting);
        verify(greetingQueryService, never()).createGreeting(any(String.class));
    }

    @Test
    void findGreetingForLatestPerson() {
        String name = UUID.randomUUID().toString();
        when(personQueryService.findLatestName())
                .thenReturn(Optional.of(name));
        String greeting = UUID.randomUUID().toString();
        when(greetingQueryService.createGreeting(name))
                .thenReturn(greeting);
        assertThat(personGreetingQueryService.findGreetingForLatestPerson())
                .isEqualTo(greeting);
        verify(greetingQueryService, never()).createGreeting();

    }
}