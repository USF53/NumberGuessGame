package edu.usfca.numberguessgame.models;


import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDriver {

    public static void main(String[] args) {
        final String uri = "mongodb+srv://admin:usfca@cluster0.prst9.mongodb.net/NumberGuessGame?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Session");
            MongoCollection<Document> collection = database.getCollection("test");
        }
    }
}