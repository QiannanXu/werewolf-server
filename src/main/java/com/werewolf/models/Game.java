package com.werewolf.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

public class Game {

    private Map<String, Player> players;
    private String gameId;
    private LinkedList<RoleType> playerQueue = new LinkedList<>();
    private Judge judge;

    public Game(GameConfiguration gameConfiguration, String sessionId) {
        char[] digitals = "0123456789".toCharArray();
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(digitals[random.nextInt(digitals.length)]);
        }
        this.gameId = builder.toString();
        this.players = new HashMap<>();

        initPlayerQueue(gameConfiguration);

        judge = new Judge(getSnapshot(), sessionId);
    }

    private void initPlayerQueue(GameConfiguration gameConfiguration) {
        IntStream.range(0, gameConfiguration.getWolf()).forEach(i -> playerQueue.add(RoleType.WEREWOLF));
        IntStream.range(0, gameConfiguration.getVillager()).forEach(i -> playerQueue.add(RoleType.VILLAGER));
        IntStream.range(0, gameConfiguration.getHunter()).forEach(i -> playerQueue.add(RoleType.HUNTER));
        IntStream.range(0, gameConfiguration.getProphet()).forEach(i -> playerQueue.add(RoleType.PROPHET));
        IntStream.range(0, gameConfiguration.getWitch()).forEach(i -> playerQueue.add(RoleType.WITCH));

        Collections.shuffle(playerQueue);
    }

    public Optional<Player> getPlayerById(String sessionId) {
        if(players.containsKey(sessionId)) {
            return Optional.of(players.get(sessionId));
        }
        return Optional.empty();
    }

    public String getGameId() {
        return gameId;
    }

    public LinkedList<RoleType> getPlayerQueue() {
        return playerQueue;
    }

    public void addPlayer(String sessionId, Player player) {
        players.put(sessionId, player);
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public GameState checkState() {
        GameSnapshot snapshot = getSnapshot();

        return judge.next(snapshot);
    }

    private GameSnapshot getSnapshot() {
        ArrayList<PlayerSnapshot> playerSnapshots = new ArrayList<>();
        players.keySet().stream().map(key -> new PlayerSnapshot(players.get(key))).forEach(playerSnapshots::add);
        return new GameSnapshot(playerSnapshots, playerQueue.size());
    }

    public String getJudge() {
        return judge.getSessionId();
    }

    public GameState getCurrentState() {
        return judge.getCurrentState();
    }
}
