package it.matteoroxis.sse.eventpublisher.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotifyEvent {

    private String id;
    private String score;
    private String homeTeam;
    private String awayTeam;
    private String scorer;

    public NotifyEvent(String id,
                       String score,
                       String homeTeam,
                       String awayTeam,
                       String scorer) {
        this.id = id;
        this.score = score;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.scorer = scorer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getScorer() {
        return scorer;
    }

    public void setScorer(String scorer) {
        this.scorer = scorer;
    }

    @Override
    public String toString() {
        return "NotifyEvent{" +
                "id='" + id + '\'' +
                ", score='" + score + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", scorer='" + scorer + '\'' +
                '}';
    }
}
