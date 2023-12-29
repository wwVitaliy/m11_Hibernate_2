package org.example.dao;

import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.example.postgresdb.PostgresDBInitService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketCrudServiceTest {
    static TicketCrudService ticketDAO;

    @BeforeAll
    static void beforeAll() {
        new PostgresDBInitService();
        ticketDAO = new TicketCrudService();

    }

    @Test
    void testCreateDeleteTicket() {
        Long ticketId = ticketDAO.createTicket(1l, "EAR", "EAR");
        assertTrue(ticketId > 0);
        ticketDAO.deleteTicketById(ticketId);
        assertNull(ticketDAO.getTicketById(ticketId));
    }

    @Test
    void testCreateNullClientTicket(){
        assertNull(ticketDAO.createTicket(null, "EAR", "EAR"));
    }

    @Test
    void testCreateNullPlanetTicket() {
        assertNull(ticketDAO.createTicket(1L, "EAR", null));

    }

    @Test
    void testCreateNotRegisteredClientTicket(){
       assertNull(ticketDAO.createTicket(0L, "EAR", "EAR"));
    }

    @Test
    void testCreateNotRegisteredPlanetTicket() {
        assertNull(ticketDAO.createTicket(1L, "EAR", "000"));

    }

    @Test
    void testGetAllTickets() {
        assertEquals(10, ticketDAO.getAllTickets().size());
    }

    @Test
    void testUpdateTicket() {
        Ticket ticket = ticketDAO.getTicketById(1L);
        Planet planetTo = ticket.getToPlanet();
        Planet planetFrom = ticket.getFromPlanet();
        ticket.setToPlanet(planetFrom);
        ticket.setFromPlanet(planetTo);

        assertEquals(planetTo, ticketDAO.updateTicket(ticket).getFromPlanet());

        ticket.setToPlanet(planetTo);
        ticket.setFromPlanet(planetFrom);
        ticketDAO.updateTicket(ticket).getFromPlanet();
    }

    @Test
    void deleteTicket() {
        Long ticketId = ticketDAO.createTicket(1l, "EAR", "EAR");
        Ticket ticket = ticketDAO.getTicketById(ticketId);
        ticketDAO.deleteTicket(ticket);
        assertNull(ticketDAO.getTicketById(ticketId));

    }
}