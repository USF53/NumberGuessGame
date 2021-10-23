package edu.usfca.numberguessgame.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry web){
        web.addViewController("main").setViewName("main");
        web.addViewController("guess").setViewName("guess");
        web.addViewController("congrats").setViewName("congrats");
    }
}
