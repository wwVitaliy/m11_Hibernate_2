package org.example.entities.dao;

import org.example.entities.Planet;
import org.example.postgresdb.PostgresDBInitService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetCrudServiceTest {
    static PlanetCrudService planetDAO;
    @BeforeAll
    static void beforeAll() {
        new PostgresDBInitService();
        planetDAO = new PlanetCrudService();
    }

    @Test
    void testCreateDeletePlanet() {
        Planet newPlanet = new Planet();
        String newName = "new Planet";
        String newId = "NP";
        newPlanet.setName(newName);
        newPlanet.setId(newId);
        planetDAO.createPlanet(newPlanet);
        planetDAO.deletePlanetById(newId);
        assertEquals(null, planetDAO.getPlanetById(newId));
    }


    @Test
    void testGetPlanetById() {
        assertEquals("Earth", planetDAO.getPlanetById("EAR").getName());
        assertEquals("EAR", planetDAO.getPlanetById("EAR").getId());
    }

    @Test
    void testGetAllPlanets() {
        assertEquals(5, planetDAO.getAllPlanets().size());
    }

    @Test
    void testUpdatePlanet() {
        Planet newPlanet = new Planet();
        newPlanet.setId("EAR");
        newPlanet.setName("EARTH3000");
        assertEquals("EARTH3000", planetDAO.updatePlanet(newPlanet).getName());

        newPlanet.setName("Earth");
        planetDAO.updatePlanet(newPlanet);
    }

    @Test
    void deletePlanet() {
        Planet newPlanet = new Planet();
        String newName = "new Planet";
        String newId = "NP";
        newPlanet.setName(newName);
        newPlanet.setId(newId);
        planetDAO.createPlanet(newPlanet);
        planetDAO.deletePlanet(newPlanet);
        assertEquals(null, planetDAO.getPlanetById(newId));
    }
}