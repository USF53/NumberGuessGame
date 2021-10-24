package edu.usfca.numberguessgame.repository;

import edu.usfca.numberguessgame.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}