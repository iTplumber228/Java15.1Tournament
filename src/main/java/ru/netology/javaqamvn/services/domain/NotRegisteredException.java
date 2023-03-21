package ru.netology.javaqamvn.services.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Player name: " + playerName + " not found");
    }
}