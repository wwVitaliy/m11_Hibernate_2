package org.example;

import org.example.postgresdb.PostgresDBInitService;

public class Main {
    public static void main(String[] args) {
        //Init postgresql DB
        new PostgresDBInitService();

    }

}
