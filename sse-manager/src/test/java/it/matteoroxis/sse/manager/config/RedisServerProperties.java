package it.matteoroxis.sse.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class RedisServerProperties {

        private final int redisPort;
        private final String redisHost;

        public RedisServerProperties(
                @Value("${spring.redis.port}") int redisPort,
                @Value("${spring.redis.host}") String redisHost) {
            this.redisPort = redisPort;
            this.redisHost = redisHost;
        }

    public int getRedisPort() {
        return redisPort;
    }

    public String getRedisHost() {
        return redisHost;
    }
}
