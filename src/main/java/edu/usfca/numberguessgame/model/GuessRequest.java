package edu.usfca.numberguessgame.model;

public class GuessRequest {
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

}
