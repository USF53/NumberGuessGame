package edu.usfca.numberguessgame.request;

public class SetBoundRequest {
    String lowerBound;
    String upperBound;
    String userId;

    public SetBoundRequest(String lowerBound, String upperBound, String userId) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.userId = userId;
    }

    public String getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(String lowerBound) {
        this.lowerBound = lowerBound;
    }

    public String getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(String upperBound) {
        this.upperBound = upperBound;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
