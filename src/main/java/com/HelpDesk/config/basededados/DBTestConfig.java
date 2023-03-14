package com.HelpDesk.config.basededados;

import com.HelpDesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class DBTestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instaciaDB(){
        this.dbService.povoaDB();
    }
}
