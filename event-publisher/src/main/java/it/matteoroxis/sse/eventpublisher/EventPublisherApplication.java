package it.matteoroxis.sse.eventpublisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.matteoroxis.sse.eventpublisher.model.NotifyEvent;
import it.matteoroxis.sse.eventpublisher.service.EventPublisherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventPublisherApplication.class, args);
    }

    @Bean
    public RedisTemplate<String, NotifyEvent> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, NotifyEvent> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(NotifyEvent.class)); // todo change with custom event
        return template;
    }
}
