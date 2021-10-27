package edu.usfca.numberguessgame;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class NumberGuessGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumberGuessGameApplication.class, args);
    }
}
