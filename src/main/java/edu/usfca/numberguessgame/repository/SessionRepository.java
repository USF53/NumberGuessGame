package edu.usfca.numberguessgame.repository;

import edu.usfca.numberguessgame.model.Session;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session, String> {

}