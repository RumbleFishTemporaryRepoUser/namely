package dev.rumblefish.namely;

import dev.rumblefish.namely.request.PersonCreationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    void getHello() {
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("{\"greeting\":\"Hello!\"}");
    }

    @Test
    void postHello() {
        String name = UUID.randomUUID().toString();
        PersonCreationRequest request = PersonCreationRequest.builder()
                .name(name)
                .build();
        template.postForEntity("/", request, Void.class);
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("{\"greeting\":\"Hello " + name + "!\"}");
    }
}