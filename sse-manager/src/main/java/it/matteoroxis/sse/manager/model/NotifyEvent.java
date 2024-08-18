package it.matteoroxis.sse.manager.model;

public record NotifyEvent(String id, String score, String homeTeam, String awayTeam, String scorer) {
}