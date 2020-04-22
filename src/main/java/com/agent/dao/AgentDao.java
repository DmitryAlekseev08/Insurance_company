package com.agent.dao;

import com.agent.model.Insurance_agent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

// Прослойка между базой данных и приложением
@Repository
public class AgentDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(AgentDao.class));

    @SuppressWarnings("unchecked")
    public List<Insurance_agent> listAgent() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Insurance_agent> agentList = session.createQuery("SELECT p FROM Insurance_agent p").list();
        for(Insurance_agent p: agentList){
            logger.info(p.toString());
        }
        return agentList;
    }

    public void addAgent(Insurance_agent agent) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(agent);
        logger.info("Agent successfully saved. Agent details: " + agent);
    }

    public void updateAgent(Insurance_agent agent) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(agent);
        logger.info("Agent successfully update. Agent details: " + agent);
    }

    public void removeAgent(BigInteger id) {
        Session session = this.sessionFactory.getCurrentSession();
        Insurance_agent agent = (Insurance_agent) session.load(Insurance_agent.class, new BigInteger(String.valueOf(id)));
        session.delete(agent);
        logger.info("Agent successfully removed. Agent details: " + agent);
    }

    public Insurance_agent getAgentId(BigInteger id) {
        Session session =this.sessionFactory.getCurrentSession();
        Insurance_agent agent = (Insurance_agent) session.load(Insurance_agent.class, new BigInteger(String.valueOf(id)));
        logger.info("Agent successfully loaded. Agent details: " + agent);

        return agent;
    }
}
