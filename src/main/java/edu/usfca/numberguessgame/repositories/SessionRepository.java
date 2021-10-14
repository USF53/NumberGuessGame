package edu.usfca.numberguessgame.repositories;

import edu.usfca.numberguessgame.models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends MongoRepository<Session, String>{

}
