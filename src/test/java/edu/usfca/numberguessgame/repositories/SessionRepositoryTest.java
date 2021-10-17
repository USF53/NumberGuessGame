package edu.usfca.numberguessgame.repositories;

import edu.usfca.numberguessgame.models.Session;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class SessionRepositoryTest {
//    @Autowired
//    private MongoRepository sessionMongoRepository;

//    @Before
//    public void setUp() throws Exception{
//        Session session1 = new Session();
//        assertNull(session1.getId());
//        this.sessionMongoRepository.save(session1);
//    }
    @Test
    void contextLoads() {
    }

}
