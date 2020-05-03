package com.insurant.dao;

import com.insurant.model.Insurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

// Прослойка между базой данных и приложением
@Repository
public class InsurantDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    Logger logger = Logger.getLogger(String.valueOf(InsurantDao.class));

    @SuppressWarnings("unchecked")
    public List<Insurant> listInsurant() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Insurant> insurantList = session.createQuery("SELECT p FROM Insurant p").list();
        for(Insurant p: insurantList){
            logger.info(p.toString());
        }
        return insurantList;
    }

    public void addInsurant(Insurant insurant) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(insurant);
        logger.info("Insurant successfully saved. Insurant details: " + insurant);
    }

    public void updateInsurant(Insurant insurant) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(insurant);
        logger.info("Insurant successfully update. Insurant details: " + insurant);
    }

    public void removeInsurant(BigInteger id) {
        Session session = this.sessionFactory.getCurrentSession();
        Insurant insurant = (Insurant) session.load(Insurant.class, new BigInteger(String.valueOf(id)));
        session.delete(insurant);
        logger.info("Insurant successfully removed. Insurant details: " + insurant);
    }

    public Insurant getInsurantId(BigInteger id) {
        Session session =this.sessionFactory.getCurrentSession();
        Insurant insurant = (Insurant) session.load(Insurant.class, new BigInteger(String.valueOf(id)));
        logger.info("Insurant successfully loaded. Insurant details: " + insurant);

        return insurant;
    }
}