package it.matteoroxis.sse.manager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.matteoroxis.sse.manager.model.NotifyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/scores")
public class ScoreController {

    @Autowired
    private ReactiveRedisOperations<String, NotifyEvent> eventRedisOperations;
    @Autowired
    private ObjectMapper objectMapper;

    private static final String SCORE_EVENT_TYPE = "GOAL";
    private static final String SCORE_CHANNEL_PREFIX = "scores:";


    @GetMapping(path = "/events/{idMatch}")
    Flux<ServerSentEvent<NotifyEvent>> getScoreEvents(@PathVariable String idMatch) {
        return Mono.just(ServerSentEvent.<NotifyEvent>builder().comment("connected").build())
                .mergeWith(Flux.interval(Duration.ofSeconds(30L))
                        .map(i -> ServerSentEvent.<NotifyEvent>builder().comment("keepalive").build()))
                .mergeWith(this.eventRedisOperations
                        .listenToChannel(
                                composeChannelName(idMatch))
                        .map(ReactiveSubscription.Message::getMessage)
                        .map(event -> ServerSentEvent.builder(event)
                                .id(UUID.randomUUID().toString())
                                .event(SCORE_EVENT_TYPE)
                                .data(objectMapper.convertValue(event,NotifyEvent.class))
                                .build()));
    }

    private String composeChannelName(String idMatch){
        return SCORE_CHANNEL_PREFIX + idMatch;
    }

}
