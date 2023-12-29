package org.example.postgresdb;

import org.flywaydb.core.Flyway;
/**
 * Applies Flyway migrations for DB
 */
public class FlywayMigration {

    public FlywayMigration(String url, String user, String password) {
        applyFlywayMigrations(url, user, password);
    }

    /**
     * Applies Flyway migrations for DB
     */
    private void applyFlywayMigrations(String url, String user, String password) {
        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
        flyway.migrate();
    }

}
