package com.policy.service;

import com.agent.model.Insurance_agent;
import com.beneficiary.model.Beneficiary;
import com.insurant.model.Insurant;
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
    public List listPolicy() { return this.policyDAO.listPolicy(); }

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

    @Transactional
    public List BeneficiaryInformation() { return this.policyDAO.BeneficiaryInformation(); }

    @Transactional
    public List<Insurance_agent> listAgent() { return this.policyDAO.listAgent(); }

    @Transactional
    public List<Insurant> listInsurant() { return this.policyDAO.listInsurant(); }

    @Transactional
    public List<Beneficiary> listBeneficiary() { return this.policyDAO.listBeneficiary(); }
}
