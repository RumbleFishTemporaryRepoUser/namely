package dev.rumblefish.namely.service.command;

import dev.rumblefish.namely.facade.PersonRepository;
import dev.rumblefish.namely.jpa.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class PersonCommandServiceTest {

    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonCommandService personCommandService;
    @Captor
    private ArgumentCaptor<Person> personArgumentCaptor;

    @Test
    void addName() {
        String name = UUID.randomUUID().toString();
        personCommandService.addName(name);
        verify(personRepository).save(personArgumentCaptor.capture());
        assertThat(personArgumentCaptor.getValue().getName()).isNotBlank().isEqualTo(name);
    }
}