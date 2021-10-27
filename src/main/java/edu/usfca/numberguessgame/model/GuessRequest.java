package edu.usfca.numberguessgame.model;

public class GuessRequest {
    String currId;
    String number;


    public GuessRequest(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCurrId() {
        return currId;
    }

    public void setCurrId(String currId) {
        this.currId = currId;
    }

    @Override
    public String toString() {
        return "GuessRequest [currId=" + currId + ", number=" + number + "]";
    }
}
