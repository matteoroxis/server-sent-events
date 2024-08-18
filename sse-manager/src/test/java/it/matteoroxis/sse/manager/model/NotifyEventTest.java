package it.matteoroxis.sse.manager.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NotifyEventTest {

    @Test
    void testNotifyEventCreation() {
        // Arrange
        String id = "1";
        String score = "2-1";
        String homeTeam = "Team A";
        String awayTeam = "Team B";
        String scorer = "John Doe";

        // Act
        NotifyEvent event = new NotifyEvent(id, score, homeTeam, awayTeam, scorer);

        // Assert
        assertEquals(id, event.id());
        assertEquals(score, event.score());
        assertEquals(homeTeam, event.homeTeam());
        assertEquals(awayTeam, event.awayTeam());
        assertEquals(scorer, event.scorer());
    }

    @Test
    void testNotifyEventEquality() {
        // Arrange
        NotifyEvent event1 = new NotifyEvent("1", "2-1", "Team A", "Team B", "John Doe");
        NotifyEvent event2 = new NotifyEvent("1", "2-1", "Team A", "Team B", "John Doe");

        // Act & Assert
        assertEquals(event1, event2);
    }

    @Test
    void testNotifyEventToString() {
        // Arrange
        NotifyEvent event = new NotifyEvent("1", "2-1", "Team A", "Team B", "John Doe");

        // Act
        String expectedToString = "NotifyEvent[id=1, score=2-1, homeTeam=Team A, awayTeam=Team B, scorer=John Doe]";

        // Assert
        assertEquals(expectedToString, event.toString());
    }

    @Test
    void testNotifyEventHashCode() {
        // Arrange
        NotifyEvent event1 = new NotifyEvent("1", "2-1", "Team A", "Team B", "John Doe");
        NotifyEvent event2 = new NotifyEvent("1", "2-1", "Team A", "Team B", "John Doe");

        // Act & Assert
        assertEquals(event1.hashCode(), event2.hashCode());
    }
}

