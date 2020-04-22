package com.beneficiary.dao;

import com.beneficiary.model.Beneficiary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

// Прослойка между базой данных и приложением
@Repository
public class BeneficiaryDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(BeneficiaryDao.class));

    @SuppressWarnings("unchecked")
    public List<Beneficiary> listBeneficiary() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Beneficiary> beneficiaryList = session.createQuery("SELECT p FROM Beneficiary p").list();
        for(Beneficiary p: beneficiaryList){
            logger.info(p.toString());
        }
        return beneficiaryList;
    }

    public void addBeneficiary(Beneficiary beneficiary) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(beneficiary);
        logger.info("Beneficiary successfully saved. Beneficiary details: " + beneficiary);
    }

    public void updateBeneficiary(Beneficiary beneficiary) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(beneficiary);
        logger.info("Beneficiary successfully update. Beneficiary details: " + beneficiary);
    }

    public void removeBeneficiary(BigInteger id) {
        Session session = this.sessionFactory.getCurrentSession();
        Beneficiary beneficiary = (Beneficiary) session.load(Beneficiary.class, new BigInteger(String.valueOf(id)));
        session.delete(beneficiary);
        logger.info("Beneficiary successfully removed. Beneficiary details: " + beneficiary);
    }

    public Beneficiary getBeneficiaryId(BigInteger id) {
        Session session =this.sessionFactory.getCurrentSession();
        Beneficiary beneficiary = (Beneficiary) session.load(Beneficiary.class, new BigInteger(String.valueOf(id)));
        logger.info("Beneficiary successfully loaded. Beneficiary details: " + beneficiary);

        return beneficiary;
    }
}
