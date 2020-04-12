package com.deepwav.fattony.model.payload;

public class PlayerResponse {

    long playerid;
    String name;
    String role;
    boolean dead;
    String roomkey;
    long roomid;
        boolean sight;
    String gesture;
    long vote;



    

    public long getPlayerid() {
        return playerid;
    }

    public void setPlayerid(long playerid) {
        this.playerid = playerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getRoomkey() {
        return roomkey;
    }

    public void setRoomkey(String roomkey) {
        this.roomkey = roomkey;
    }

    public long getRoomid() {
        return roomid;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    public boolean isSight() {
        return sight;
    }

    public void setSight(boolean sight) {
        this.sight = sight;
    }

    public String getGesture() {
        return gesture;
    }

    public void setGesture(String gesture) {
        this.gesture = gesture;
    }

    public long getVote() {
        return vote;
    }

    public void setVote(long vote) {
        this.vote = vote;
    }

    

}