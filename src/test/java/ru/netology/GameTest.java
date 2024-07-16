package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    private Game game;
    Player player1 = new Player(1, "Ivan", 20);
    Player player2 = new Player(2, "Stepan", 10);
    Player player3 = new Player(3, "Bos", 30);
    Player player4 = new Player(4, "Slava", 15);
    Player player5 = new Player(5, "Niko", 25);
    Player player6 = new Player(6, "Jack", 17);
    Player player7 = new Player(7, "Zaak", 20);

    @BeforeEach
    public void setUp() {
        game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player7);
    }

    @Test
    public void searchForARegisteredPlayer() {
        Assertions.assertTrue(game.isRegisteredPlayer(player2));
        Assertions.assertFalse(game.isRegisteredPlayer(player5));
    }

    @Test
    public void reRegistrationOfTheParticipant() {
        game.register(player1);
        Assertions.assertEquals(5, game.registeredPlayer.size());
    }

    @Test
    public void competitionWithAnUnregisteredPlayer() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Jack");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Niko", "Bos");
        });

    }

    @Test
    public void duelBetweenRegisteredUsers() {
        Assertions.assertEquals(1, game.round("Ivan", "Stepan"));
        Assertions.assertEquals(2, game.round("Slava", "Bos"));
        Assertions.assertEquals(0, game.round("Ivan", "Zaak"));
    }


}
