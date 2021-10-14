package edu.usfca.numberguessgame.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "users")
public class Session {
    @Id
    private String id;
    private String upperBound;
    private String lowerBound;
    private int generatorValue;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUpperBound() {
        return upperBound;
    }
    public void setUpperBound(String upperBound) {
        this.upperBound = upperBound;
    }
    public String getLowerBound() {
        return lowerBound;
    }
    public void setLowerBound(String lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getGeneratorValue() {
        return generatorValue;
    }
    public void setGeneratorValue(int generatorValue) {
        this.generatorValue = generatorValue;
    }

}
//create get on controller for session data
