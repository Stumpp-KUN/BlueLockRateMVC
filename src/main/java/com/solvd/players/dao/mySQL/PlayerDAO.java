package com.solvd.players.dao.mySQL;

import com.solvd.players.dao.IPlayerDAO;
import com.solvd.players.models.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlayerDAO extends MySQLDAO implements IPlayerDAO {
//    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Player getEntityById(int id) {
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Player.class).buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Player player=session.get(Player.class,id);
        session.getTransaction().commit();
        sessionFactory.close();
        return player;
    }

    @Override
    public Player createEntity(Player player) {
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Player.class).buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(player);
        session.getTransaction().commit();
        sessionFactory.close();
        return player;
    }

    @Override
    public void updateEntity(Player player, int k) {

    }

    @Override
    public void deleteEntity(int id) {
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Player.class).buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from Player " +"where id="+id).executeUpdate();
        session.getTransaction().commit();
        sessionFactory.close();

    }

    @Override

    public List<Player> getAllPlayers() {
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Player.class).buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Player> allPlayers=session.createQuery("from Player ",Player.class).getResultList().stream().sorted(Comparator.comparing(Player::getRate)).collect(Collectors.toList());
        session.getTransaction().commit();
        sessionFactory.close();
        return allPlayers;
    }

}
