package it.matteoroxis.sse.manager.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisServer;


@TestConfiguration
public class RedisServerConfiguration {

    private final RedisServer redisServer;

    public RedisServerConfiguration(RedisServerProperties redisServerProperties) {
        this.redisServer = new RedisServer(redisServerProperties.getRedisPort());
    }

    @PostConstruct
    public void postConstruct() {
        redisServer.start();
    }

    @PreDestroy
    public void preDestroy() {
        redisServer.stop();
    }
}
