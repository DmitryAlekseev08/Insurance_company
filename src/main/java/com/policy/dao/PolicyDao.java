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

    public List AgentInformation() {
        Session session = this.sessionFactory.getCurrentSession();
        List agentInfo = session.createQuery("SELECT new list(pol.agent, age.lastName, age.firstName, age.middleName) " +
                "FROM Insuranсе_policy pol, Insurance_agent age WHERE pol.agent = age.agentId").list();
        return agentInfo;
    }

    public List InsurantInformation() {
        Session session = this.sessionFactory.getCurrentSession();
        List insurantInfo = session.createQuery("SELECT new list(pol.insurant, ins.lastName, ins.firstName, ins.middleName) " +
                "FROM Insuranсе_policy pol, Insurant ins WHERE pol.insurant = ins.insurantId").list();
        return insurantInfo;
    }

    public List BeneficiaryInformation() {
        Session session = this.sessionFactory.getCurrentSession();
        List beneficiaryInfo = session.createQuery("SELECT new list(pol.beneficiary, ben.lastName, ben.firstName, ben.middleName) " +
                "FROM Insuranсе_policy pol, Beneficiary ben WHERE pol.beneficiary = ben.beneficiaryId").list();
        return beneficiaryInfo;
    }

    public List<Integer> listAgentId() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Integer> agentIdList = session.createQuery("SELECT agentId FROM Insurance_agent").list();
        return agentIdList;
    }

    public List<Integer> listInsurantId() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Integer> insurantIdList = session.createQuery("SELECT insurantId FROM Insurant").list();
        return insurantIdList;
    }

    public List<Integer> listBeneficiaryId() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Integer> beneficiaryIdList = session.createQuery("SELECT beneficiaryId FROM Beneficiary").list();
        return beneficiaryIdList;
    }
}

