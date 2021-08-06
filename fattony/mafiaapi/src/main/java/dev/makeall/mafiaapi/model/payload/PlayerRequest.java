package dev.makeall.mafiaapi.model.payload;

public class PlayerRequest {

    long plpayerid;
    String name;
    String role;
    boolean dead;
    String roomkey;
    long roomid;
    boolean sight;
    String gesture;
    long vote;

    



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

    public long getPlpayerid() {
        return plpayerid;
    }

    public void setPlpayerid(long plpayerid) {
        this.plpayerid = plpayerid;
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