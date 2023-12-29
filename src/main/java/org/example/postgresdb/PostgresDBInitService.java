package org.example.postgresdb;

import org.flywaydb.core.Flyway;

/**
 * Initializes DB
 */
public class PostgresDBInitService {
    public PostgresDBInitService() {
       new FlywayMigration(
                PropertyReader.getDBURL(),
                PropertyReader.getDBUser(),
                PropertyReader.getDBPassword()
        );
    }
}
