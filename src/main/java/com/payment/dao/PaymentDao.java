package com.payment.dao;

import com.payment.model.Insurance_payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

// Прослойка между базой данных и приложением
@Repository
public class PaymentDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(PaymentDao.class));

    @SuppressWarnings("unchecked")
    public List<Insurance_payment> listPayment() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Insurance_payment> paymentList = session.createQuery("SELECT p FROM Insurance_payment p").list();
        for(Insurance_payment p: paymentList){
            logger.info(p.toString());
        }
        return paymentList;
    }

    public void addPayment(Insurance_payment payment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(payment);
        logger.info("Insurance payment successfully saved. Insurance payment details: " + payment);
    }

    public void updatePayment(Insurance_payment payment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(payment);
        logger.info("Insurance payment successfully update. Insurance payment details: " + payment);
    }

    public void removePayment(BigInteger id) {
        Session session = this.sessionFactory.getCurrentSession();
        Insurance_payment payment = (Insurance_payment) session.load(Insurance_payment.class, new BigInteger(String.valueOf(id)));
        session.delete(payment);
        logger.info("Insurance payment successfully removed. Insurance payment details: " + payment);
    }

    public Insurance_payment getPaymentId(BigInteger id) {
        Session session = this.sessionFactory.getCurrentSession();
        Insurance_payment payment = (Insurance_payment) session.load(Insurance_payment.class, new BigInteger(String.valueOf(id)));
        logger.info("Insurance payment successfully loaded. Insurance payment details: " + payment);

        return payment;
    }

        public List<Integer> listPolicyId() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Integer> policyIdList = session.createQuery("SELECT pol.policyId FROM Insuranсе_policy pol WHERE pol.policyId not in (SELECT pay.policy FROM Insurance_payment pay)").list();
            return policyIdList;
        }
}
