package edu.usfca.numberguessgame.model;

import org.springframework.data.mongodb.core.mapping.Document;

// TODO @Document(collation = "session")
public class Session {

    // TODO  change to id
    // add @Id annotation
    //
    private String _id;
    public int target;
    public int lowerBound;
    public int upperBound;

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

    // camel case
    public String get_id() {
        return _id;
    }

    // camel case
    public void set_id(String _id) {
        this._id = _id;
    }
}
