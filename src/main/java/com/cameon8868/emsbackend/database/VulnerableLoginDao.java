package com.cameon8868.emsbackend.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VulnerableLoginDao {
    private final EntityManager em;

    public VulnerableLoginDao(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings ("unchecked")
    public List<User> findByLoginAndPassword(String login, String password) {
        String sql = "SELECT login, password FROM users WHERE login = '" + login + "' AND password = '" + password + "'";
        System.out.println("Executing SQL: " + sql); // For debugging purposes
        Query query = em.createNativeQuery(sql);
        return query.getResultList();
    }

}
