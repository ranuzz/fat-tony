package dev.makeall.mafiaapi.model.payload;

public class RoomCreateResponse {

    long roomid;

    String roomkey;

    String name;

    String gametype;

    int numplayers;

    String rules;

    public RoomCreateResponse() {
    }



    public String getRoomkey() {
        return roomkey;
    }

    public void setRoomkey(String roomkey) {
        this.roomkey = roomkey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype;
    }

    public int getNumplayers() {
        return numplayers;
    }

    public void setNumplayers(int numplayers) {
        this.numplayers = numplayers;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public long getRoomid() {
        return roomid;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }



}