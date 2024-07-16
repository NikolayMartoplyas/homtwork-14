package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> registeredPlayer = new ArrayList<>();

    public void register(Player player) {
        if (!registeredPlayer.contains(player)) {
            registeredPlayer.add(player);
        }
    }

    public Player findByName(String name) {
        for (Player player : registeredPlayer) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public boolean isRegisteredPlayer(Player name) {
        return registeredPlayer.contains(name);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок: " + playerName1 + " не зарегестрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок: " + playerName2 + " не зарегестрирован");
        }
        if (findByName(playerName1).getStrenght() > findByName(playerName2).getStrenght()) {
            return 1;
        }
        if (findByName(playerName1).getStrenght() < findByName(playerName2).getStrenght()) {
            return 2;
        } else {
            return 0;
        }

    }
}
