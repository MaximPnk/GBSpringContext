package ru.pankov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.pankov.entity.Cart;

@Configuration
@ComponentScan("ru.pankov")
public class AppConfig {

    @Bean
    @Scope(value = "prototype")
    Cart cart() {
        return new Cart();
    }
}