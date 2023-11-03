package it.matteoroxis.sse.manager.config;

import org.springframework.boot.test.context.TestConfiguration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
