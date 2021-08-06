package dev.makeall.mafiaapi.model.payload;

public class RoomCreateRequest {

    String name;

    String gametype;

    int numplayers;

    String rules;

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

    public RoomCreateRequest(String name, String gametype, int numplayers, String rules) {
        this.name = name;
        this.gametype = gametype;
        this.numplayers = numplayers;
        this.rules = rules;
    }

    public RoomCreateRequest() {
    }

    

}