package com.policy.dao;

import com.policy.model.Insuranсе_policy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

// Прослойка между базой данных и приложением
@Repository
public class PolicyDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(com.policy.dao.PolicyDao.class));

    @SuppressWarnings("unchecked")
    public List<Insuranсе_policy> listPolicy() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Insuranсе_policy> policyList = session.createQuery("SELECT p FROM Insuranсе_policy p").list();
        for(Insuranсе_policy p: policyList){
            logger.info(p.toString());
        }
        return policyList;
    }

    public void addPolicy(Insuranсе_policy policy) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(policy);
        logger.info("Policy successfully saved. Policy details: " + policy);
    }

    public void updatePolicy(Insuranсе_policy policy) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(policy);
        logger.info("Policy successfully update. Policy details: " + policy);
    }

    public void removePolicy(BigInteger id) {
        Session session = this.sessionFactory.getCurrentSession();
        Insuranсе_policy policy = (Insuranсе_policy) session.load(Insuranсе_policy.class, new BigInteger(String.valueOf(id)));
        session.delete(policy);
        logger.info("Policy successfully removed. Policy details: " + policy);
    }

    public Insuranсе_policy getPolicyId(BigInteger id) {
        Session session =this.sessionFactory.getCurrentSession();
        Insuranсе_policy policy = (Insuranсе_policy) session.load(Insuranсе_policy.class, new BigInteger(String.valueOf(id)));
        logger.info("Policy successfully loaded. Policy details: " + policy);

        return policy;
    }
}

