package com.policy.dao;

import com.agent.model.Insurance_agent;
import com.beneficiary.model.Beneficiary;
import com.insurant.model.Insurant;
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

    public List BeneficiaryInformation() {
        Session session = this.sessionFactory.getCurrentSession();
        List beneficiaryInfo = session.createQuery("SELECT new list(pol.beneficiary.beneficiaryId, ben.lastName, ben.firstName, ben.middleName) " +
                "FROM Insuranсе_policy pol, Beneficiary ben WHERE pol.beneficiary.beneficiaryId = ben.beneficiaryId").list();
        return beneficiaryInfo;
    }

    public List<Insurance_agent> listAgent() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Insurance_agent> agentList = session.createQuery("SELECT agent FROM Insurance_agent agent").list();
        return agentList;
    }

    public List<Insurant> listInsurant() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Insurant> insurantList = session.createQuery("SELECT insurant FROM Insurant insurant").list();
        return insurantList;
    }

    public List<Beneficiary> listBeneficiary() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Beneficiary> beneficiaryList = session.createQuery("SELECT beneficiary FROM Beneficiary beneficiary").list();
        return beneficiaryList;
    }
}

