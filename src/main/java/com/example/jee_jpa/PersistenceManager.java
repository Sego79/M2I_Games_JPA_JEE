package com.example.jee_jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {


    private static EntityManagerFactory emf;

    private static EntityManager em;

    private final static String PERSISTANCE_NAME = "myPU"; //NOM DE L'UNITE DE PERSISTANCE CIBLEE

    //CREATION DE NOTRE CONSTRUCTEUR EN PRIVATE
    private PersistenceManager() {
    }


    //CONNEXION A LA BASE DE DONNEES
    public static EntityManager getEntityManager() {
        //CREATION DE L'ENTITY MANAGER FACTORY
        emf = Persistence.createEntityManagerFactory(PERSISTANCE_NAME);
        //CREATION DE L'ENTITY MANAGER
        em = emf.createEntityManager();
        return em;
    }



    //DECONNEXION DE LA BASE DE DONNEES
    public static void closeConnection() {
        if(emf!=null && emf.isOpen()){
            emf.close();
        }
    }

}
