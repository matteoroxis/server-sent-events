package it.matteoroxis.sse.manager.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotifyEvent {

    private String id;
    private String score;
    private String homeTeam;
    private String awayTeam;
    private String scorer;

    public  NotifyEvent(){}
    public NotifyEvent(String id, String score, String scorer, String awayTeam, String homeTeam) {
        this.id= id;
        this.score= score;
        this.scorer=scorer;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
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
}
