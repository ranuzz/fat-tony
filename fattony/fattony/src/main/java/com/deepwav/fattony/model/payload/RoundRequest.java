package com.deepwav.fattony.model.payload;

public class RoundRequest {

    long roundid;
    int roundnum;
    String votes;
    boolean done;
    long roomid;



    public int getRoundnum() {
        return roundnum;
    }

    public void setRoundnum(int roundnum) {
        this.roundnum = roundnum;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getRoomid() {
        return roomid;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    public long getRoundid() {
        return roundid;
    }

    public void setRoundid(long roundid) {
        this.roundid = roundid;
    }

    

}