package edu.usfca.numberguessgame.model;

public class SetBoundRequest {
    String lowerBound;
    String upperBound;

    public SetBoundRequest(String lowerBound, String upperBound, String userId) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
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
}
