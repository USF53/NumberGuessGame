package edu.usfca.numberguessgame.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {
    @Id
    public String id;

    public String userId;
    public int target;
    public int lowerBound;
    public int upperBound;

    public User(String userId, int target, int lowerBound, int upperBound) {
        this.userId = userId;
        this.target = target;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getTarget() {
        return this.target;
    }
}
