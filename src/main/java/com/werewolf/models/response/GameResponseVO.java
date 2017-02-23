package com.werewolf.models.response;

public class GameResponseVO {
    private String roomNum;
    private String role;
    private String message;
    private Boolean voice;
    private Boolean daylight;
    private Boolean alive;

    public GameResponseVO() {
        roomNum = "";
        role = "";
        message = "";
        voice = false;
        daylight = false;
        alive = true;
    }

    public String getRole() {
        return role;
    }

    public GameResponseVO setRole(String role) {
        this.role = role;
        return this;
    }

    public Boolean getVoice() {
        return voice;
    }

    public GameResponseVO setVoice(Boolean voice) {
        this.voice = voice;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public GameResponseVO setMessage(String message) {
        this.message = message;
        return this;
    }

    public Boolean getDaylight() {
        return daylight;
    }

    public GameResponseVO setDaylight(Boolean daylight) {
        this.daylight = daylight;
        return this;
    }

    public Boolean getAlive() {
        return alive;
    }

    public GameResponseVO setAlive(Boolean alive) {
        this.alive = alive;
        return this;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public GameResponseVO setRoomNum(String roomNum) {
        this.roomNum = roomNum;
        return this;
    }
}