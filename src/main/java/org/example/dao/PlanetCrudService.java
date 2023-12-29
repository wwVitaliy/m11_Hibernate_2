package org.example.dao;


import org.example.entities.Planet;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Planet DAO (data access object)
 */
public class PlanetCrudService {
    private static final String GET_ALL_PLANET_QUERY = "from Planet";

    /**
     * Creates new planet in DB
     */
    public String createPlanet(Planet planet) {

        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(planet);
                transaction.commit();
                return planet.getId();
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Cannot create planet. Reason: " + e.getMessage());
                return null;
            }
        }
    }

    /**
     * Gets planet with defined id from DB
     */
    public Planet getPlanetById(String id) {
        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    /**
     * Gets all planets from DB
     */
    public List<Planet> getAllPlanets() {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_PLANET_QUERY, Planet.class).list();
        }
    }

    /**
     * Updates planet in DB
     */
    public Planet updatePlanet(Planet planet) {
        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(planet);
                transaction.commit();
                return planet;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Cannot update planet. Reason: " + e.getMessage());
                return null;
            }
        }
    }

    /**
     * Deletes planet with defined id from DB
     */
    public boolean deletePlanetById(String id) {
        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Planet planet = session.get(Planet.class, id);
                session.remove(planet);
                transaction.commit();
                return true;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Cannot delete planet. Reason: " + e.getMessage());
                return false;
            }
        }

    }

    /**
     * Deletes planet from DB
     */
    public boolean deletePlanet(Planet planet) {
        try (Session session
                     = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.remove(planet);
                transaction.commit();
                return true;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Cannot delete planet. Reason: " + e.getMessage());
                return false;
            }
        }
    }
}




