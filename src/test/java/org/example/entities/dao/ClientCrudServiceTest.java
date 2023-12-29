package org.example.entities.dao;

import org.example.dao.ClientCrudService;
import org.example.entities.Client;
import org.example.postgresdb.PostgresDBInitService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientCrudServiceTest {
    static ClientCrudService clientDAO;
    @BeforeAll
    static void beforeAll() {
        new PostgresDBInitService();
        clientDAO = new ClientCrudService();
    }

    @Test
    void testCreateDeleteClient() {
        Client newClient = new Client();
        newClient.setName("new Client");
        Long id = clientDAO.createClient(newClient);
        assertTrue(id > 0);
        clientDAO.deleteClientById(id);
        assertEquals(null, clientDAO.getClientById(id));
    }


    @Test
    void testGetClientById() {
        assertEquals("Bruce Wayne", clientDAO.getClientById(1L).getName());
        assertEquals(1L, clientDAO.getClientById(1L).getId());
    }

    @Test
    void testGetAllClients() {
        assertEquals(10, clientDAO.getAllClients().size());
    }

    @Test
    void testUpdateClient() {
        Client newClient = new Client();
        newClient.setId(1L);
        newClient.setName("Batman");
        assertEquals("Batman", clientDAO.updateClient(newClient).getName());

        newClient.setName("Bruce Wayne");
        clientDAO.updateClient(newClient);
    }

    @Test
    void deleteClient() {
        Client newClient = new Client();
        newClient.setName("new Client");
        Long id = clientDAO.createClient(newClient);
        clientDAO.deleteClient(newClient);
        assertEquals(null, clientDAO.getClientById(id));
    }
}