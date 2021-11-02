package edu.usfca.numberguessgame.model;

import org.springframework.data.annotation.Id;

public class Session {

	
	@Id
    private String id;
    private int target;
    private int lowerBound;
    private int upperBound;

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public Session(int target, int lowerBound, int upperBound) {
        super();
        this.target = target;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Session() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
