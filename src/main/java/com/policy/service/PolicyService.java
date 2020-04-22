package com.policy.service;

import com.policy.dao.PolicyDao;
import com.policy.model.Insuranсе_policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

// Реализация бизнес-логики
@Service
public class PolicyService {
    @Autowired
    private PolicyDao policyDAO;

    public void setPolicyDAO(PolicyDao policyDAO) {
        this.policyDAO = policyDAO;
    }

    @Transactional
    public List<Insuranсе_policy> listPolicy() { return this.policyDAO.listPolicy(); }

    @Transactional
    public void addPolicy(Insuranсе_policy policy) {
        this.policyDAO.addPolicy(policy);
    }

    @Transactional
    public void updatePolicy(Insuranсе_policy policy) {
        this.policyDAO.updatePolicy(policy);
    }

    @Transactional
    public void removePolicy(BigInteger id) {
        this.policyDAO.removePolicy(id);
    }

    @Transactional
    public Insuranсе_policy getPolicyId(BigInteger id) {
        return this.policyDAO.getPolicyId(id);
    }
}
