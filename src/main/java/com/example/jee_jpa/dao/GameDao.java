package com.example.jee_jpa.dao;

import com.example.jee_jpa.PersistenceManager;
import com.example.jee_jpa.model.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameDao implements Dao<Game>{

//    @PersistenceContext(unitName = "myPU")
//    private EntityManager entityManager;


    //va permettre de nous connecter à la BDD
    private EntityManager em = PersistenceManager.getEntityManager();


//    @Override
//    public Optional<Game> get(Long id) {
//        //On veut récupérer l'élement en fonction de son id et non de sa position (car id=1 à la position 0 par exemple)
//        return games.stream().filter(g-> g.getId() == id).findFirst();
//    }

    @Override
    public Optional<Game> findById(Long id) {
        //   EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Game recette = em.createQuery("SELECT g FROM Game g WHERE g.id = :idParam", Game.class)
                    .setParameter("idParam", id)
                    .getSingleResult();
            et.commit();
            return Optional.of(recette);
        }catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return Optional.empty();
    }



    @Override
    public List<Game> getAll() {
        List<Game> gameList = new ArrayList<>();

        EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            TypedQuery<Game> queryGetAll = em.createQuery("SELECT g FROM Game g", Game.class);
            gameList = queryGetAll.getResultList();
            et.commit();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

        return gameList;
    }

    @Override
    public void save(Game game) {

        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(game);
            et.commit();
        }catch (Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
    }

    //TODO
    @Override
    public Game update(Game gameParam) {
        Game gameUpdated = null;
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            gameUpdated = em.merge(gameParam);
            et.commit();
        }catch(Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return gameUpdated;
    }

    //TODO
    @Override
    public Boolean delete(Long id) {
       EntityManager entityManager = PersistenceManager.getEntityManager();
        EntityTransaction et = entityManager.getTransaction();
        try{
            et.begin();
            Game game = entityManager.find(Game.class, id);
            entityManager.remove(game);
            et.commit();
        }catch(Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            entityManager.close();
        }
        return true;
    }
}
