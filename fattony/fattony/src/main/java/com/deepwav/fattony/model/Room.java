package com.deepwav.fattony.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "ROOM")
public class Room {

    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    @SequenceGenerator(name = "room_seq", allocationSize = 1)
    private Long id;

    @Column(name = "ROOM_KEY")
    String roomkey;

    @Column(name = "ROOM_NAME")
    String name;

    @Column(name = "ROOM_GAME_TYPE")
    String gametype;

    @Column(name = "ROOM_PLAYER_NUM")
    int numplayers;

    @Column(name = "ROOM_RULES")
    String rules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    


}