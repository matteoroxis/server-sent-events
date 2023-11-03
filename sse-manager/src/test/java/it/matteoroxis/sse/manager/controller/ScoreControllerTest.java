package it.matteoroxis.sse.manager.controller;

import it.matteoroxis.sse.manager.ManagerApplication;
import it.matteoroxis.sse.manager.config.RedisServerConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(classes = RedisServerConfiguration.class)
public class ScoreControllerTest {

    private WebTestClient client = WebTestClient.bindToServer()
            .baseUrl("http://localhost:8080/api/v1/scores")
            .build();

    @Test
    public void whenFluxEndpointIsCalled_thenEventStreamingBegins() {

        Executable sseStreamingCall = () -> client.get()
                .uri("/events/1")
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader()
                .contentTypeCompatibleWith(MediaType.TEXT_EVENT_STREAM)
                .expectBody(String.class);

    }

}

