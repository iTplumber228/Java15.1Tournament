package ru.netology.javaqamvn.services.manager;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqamvn.services.domain.Game;
import ru.netology.javaqamvn.services.domain.NotRegisteredException;
import ru.netology.javaqamvn.services.domain.Player;

import java.nio.file.Path;

public class GameTest {
    @Test
    public void testWhen1PlayerWin(){
        Game game = new Game();
        Player john = new Player(1, "John", 20);
        Player james = new Player(2, "James", 25);

        game.register(john);
        game.register(james);
        int actual = game.round("James", "John");
        int expected = 1;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void testWhenPlayersNotExist() {
        Game game = new Game();
        Player john = new Player(1, "John", 20);
        Player james = new Player(2, "James", 25);
        game.register(john);
        game.register(james);

        Assertions.assertThrows(NotRegisteredException.class,
                ()-> game.round("Michael", "Alex"));
    }
    @Test
    public void testWhenNoPlayersWin(){
        Game game = new Game();
        Player john = new Player(1, "John", 25);
        Player james = new Player(2, "James", 25);

        game.register(john);
        game.register(james);
        int actual = game.round("James", "John");
        int expected = 0;
        Assertions.assertEquals(actual, expected);
    }
}
