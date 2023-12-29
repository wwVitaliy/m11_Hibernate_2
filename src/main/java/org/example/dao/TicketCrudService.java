package org.example.dao;


import org.example.entities.Client;
import org.example.entities.Ticket;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Ticket DAO (data access object)
 */
public class TicketCrudService {
    private static final String GET_ALL_TICKETS_QUERY = "from Ticket";

    /**
     * Creates new ticket in DB
     */
    public Long createTicket(Ticket ticket) {

        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(ticket);
                transaction.commit();
                return ticket.getId();
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Cannot create ticket. Reason: " + e.getMessage());
                return null;
            }
        }
    }

    /**
     * Creates new ticket in DB
     */
    public Long createTicket(Long clientId, String fromPlanet, String toPlanet) {
        //Create new ticket
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        Ticket ticket = new Ticket();
        ticket.setCreatedAt(new Date());
        ticket.setClient(clientCrudService.getClientById(clientId));
        ticket.setFromPlanet(planetCrudService.getPlanetById(fromPlanet));
        ticket.setToPlanet(planetCrudService.getPlanetById(toPlanet));

        return createTicket(ticket);
    }



    /**
     * Gets ticket with defined id from DB
     */
    public Ticket getTicketById(Long id) {
        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    /**
     * Gets all tickets from DB
     */
    public List<Ticket> getAllTickets() {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_TICKETS_QUERY, Ticket.class).list();
        }
    }

    /**
     * Updates ticket in DB
     */
    public Ticket updateTicket(Ticket ticket) {
        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(ticket);
                transaction.commit();
                return ticket;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Cannot update ticket. Reason: " + e.getMessage());
                return null;
            }
        }
    }

    /**
     * Deletes ticket with defined id from DB
     */
    public boolean deleteTicketById(Long id) {
        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Ticket ticket = session.get(Ticket.class, id);
                session.remove(ticket);
                transaction.commit();
                return true;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Cannot delete ticket. Reason: " + e.getMessage());
                return false;
            }
        }
    }

    /**
     * Deletes ticket from DB
     */
    public boolean deleteTicket(Ticket ticket) {
        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.remove(ticket);
                transaction.commit();
                return true;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Cannot delete ticket. Reason: " + e.getMessage());
                return false;
            }
        }
    }
}





