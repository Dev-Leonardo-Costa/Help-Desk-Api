package com.HelpDesk.config.basededados;

import com.HelpDesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DBDevConfig {

    @Autowired
    private DBService dbService;

    @Value("spring.jpa.hibernate.ddl-auto")
    private String valueDDL;

    @Bean
    public boolean instaciaDB() {
        if (valueDDL.equals("create")) {
            this.dbService.povoaDB();
        }
        return false;
    }
}
