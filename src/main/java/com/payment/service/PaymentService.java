package com.payment.service;

import com.payment.dao.PaymentDao;
import com.payment.model.Insurance_payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

// Реализация бизнес-логики
@Service
public class PaymentService {
    @Autowired
    private PaymentDao paymentDAO;

    public void setPaymentDAO(PaymentDao paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Transactional
    public List<Insurance_payment> listPayment() { return this.paymentDAO.listPayment(); }

    @Transactional
    public void addPayment(Insurance_payment payment) {
        this.paymentDAO.addPayment(payment);
    }

    @Transactional
    public void updatePayment(Insurance_payment payment) {
        this.paymentDAO.updatePayment(payment);
    }

    @Transactional
    public void removePayment(BigInteger id) {
        this.paymentDAO.removePayment(id);
    }

    @Transactional
    public Insurance_payment getPaymentId(BigInteger id) { return this.paymentDAO.getPaymentId(id); }

    @Transactional
    public List<Integer> listPolicyId() { return this.paymentDAO.listPolicyId(); }
}
