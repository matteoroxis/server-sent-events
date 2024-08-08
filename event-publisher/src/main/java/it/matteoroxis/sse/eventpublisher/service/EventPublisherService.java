package it.matteoroxis.sse.eventpublisher.service;

import it.matteoroxis.sse.eventpublisher.model.NotifyEvent;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class EventPublisherService {

    @Autowired
    private RedisTemplate<String, NotifyEvent> redisTemplate;// todo change with custom event
    private final Random random = new Random();
    private static final String SCORE_EVENT_TYPE = "GOAL";
    private static final String SCORE_CHANNEL_PREFIX = "scores:";
    private final String[] channels = {"1", "2", "3"};
    private Map<String,NotifyEvent> matches = new HashMap();

    private Logger logger = LoggerFactory.getLogger(EventPublisherService.class);

    @PostConstruct
    public void init(){
        matches.put("1",new NotifyEvent("1","1-1","Roma","Lazio","Lorenzo Pellegrini"));
        matches.put("2",new NotifyEvent("2","1-1","Inter","Milan","Lautaro Martinez"));
        matches.put("3",new NotifyEvent("3","1-1","Juventus","Torino","Federico Chiesa"));
    }


     @Scheduled(fixedRate = 500)
    public void startEventPublishing() {
        logger.info("Start Publishing");
        publishEvent();
    }

    private void publishEvent(){
        int channelIndex = random.nextInt(1,4);
        System.out.println("Channel Index " + channelIndex);
        String channel = SCORE_CHANNEL_PREFIX + channelIndex;
        NotifyEvent notifyEvent = generateRandomEvent(String.valueOf(channelIndex));
        logger.info("Notify Event: "+ notifyEvent + "on channel: "+channel);
        redisTemplate.convertAndSend(channel, notifyEvent);
    }


    private NotifyEvent generateRandomEvent(String channelIndex) {
        return matches.get(channelIndex);
    }

}
