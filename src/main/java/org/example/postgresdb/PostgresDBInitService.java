package org.example.postgresdb;

import org.flywaydb.core.Flyway;

/**
 * Initializes DB
 */
public class PostgresDBInitService {
    public PostgresDBInitService() {
        PostgresDBInitService.applyFlywayMigrations(
                PropertyReader.getDBURL(),
                PropertyReader.getDBUser(),
                PropertyReader.getDBPassword()
        );
    }

    /**
     * Applies Flyway migrations for DB
     */
    private static void applyFlywayMigrations(String url, String user, String password) {
        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
        flyway.migrate();
    }

}
