package edu.usfca.numberguessgame.request;

public class GuessRequest {
    String number;
    String userId;


    public GuessRequest(String number, String userId) {
        this.number = number;
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}