package com.banks.playerjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class PlayerJdbcApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    PlayerDao dao;

    public static void main(String[] args) {

        SpringApplication.run(PlayerJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All Players Data: {}", dao.getAllPlayers());
        logger.info("Inserting Player 4: {}", dao.insertPlayer(
                new Player (4, "Thiem", "Austria",
                        new Date(System.currentTimeMillis()),
                        17 )));
        logger.info("All Players Data: {}", dao.getAllPlayers());
        logger.info("Updating Player with Id 4: {}",  dao.updatePlayer(
                new Player(4, "Thiem", "Austria",
                        Date.valueOf("1993-09-03"), 17)));
        logger.info("Player with id 4: {}", dao.getPlayerById(4));
        logger.info("Deleting Player with Id 2: {}", dao.deletePlayerById(2));
        logger.info("All Players Data: {}", dao.getAllPlayers());
    }

    public PlayerDao getDao() {
        return dao;
    }

    @Autowired
    public void setDao(PlayerDao dao) {
        this.dao = dao;
    }
}
