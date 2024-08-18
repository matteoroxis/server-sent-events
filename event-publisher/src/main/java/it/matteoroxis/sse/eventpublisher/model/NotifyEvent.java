package it.matteoroxis.sse.eventpublisher.model;

public record NotifyEvent(String id, String score, String homeTeam, String awayTeam, String scorer) {
}