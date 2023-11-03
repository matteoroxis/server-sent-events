package it.matteoroxis.sse.manager.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotifyEventTest {

    private NotifyEvent notifyEvent;

    @BeforeEach
    public void setUp() {
        notifyEvent = new NotifyEvent(
                "1",
                "2-1",
                "John Doe",
                "Away Team",
                "Home Team"
        );
    }

    @Test
    public void testGetId() {
        assertEquals("1", notifyEvent.getId());
    }

    @Test
    public void testSetId() {
        notifyEvent.setId("2");
        assertEquals("2", notifyEvent.getId());
    }

    @Test
    public void testGetScore() {
        assertEquals("2-1", notifyEvent.getScore());
    }

    @Test
    public void testSetScore() {
        notifyEvent.setScore("3-0");
        assertEquals("3-0", notifyEvent.getScore());
    }

    @Test
    public void testGetHomeTeam() {
        assertEquals("Home Team", notifyEvent.getHomeTeam());
    }

    @Test
    public void testSetHomeTeam() {
        notifyEvent.setHomeTeam("New Home Team");
        assertEquals("New Home Team", notifyEvent.getHomeTeam());
    }

    @Test
    public void testGetAwayTeam() {
        assertEquals("Away Team", notifyEvent.getAwayTeam());
    }

    @Test
    public void testSetAwayTeam() {
        notifyEvent.setAwayTeam("New Away Team");
        assertEquals("New Away Team", notifyEvent.getAwayTeam());
    }

    @Test
    public void testGetScorer() {
        assertEquals("John Doe", notifyEvent.getScorer());
    }

    @Test
    public void testSetScorer() {
        notifyEvent.setScorer("Jane Smith");
        assertEquals("Jane Smith", notifyEvent.getScorer());
    }
}

