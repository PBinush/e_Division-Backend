package edu.e_g.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
