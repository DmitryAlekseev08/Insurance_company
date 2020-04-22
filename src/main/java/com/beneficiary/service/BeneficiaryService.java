package com.beneficiary.service;

import com.beneficiary.dao.BeneficiaryDao;
import com.beneficiary.model.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

// Реализация бизнес-логики
@Service
public class BeneficiaryService {
    @Autowired
    private BeneficiaryDao beneficiaryDAO;

    public void setBeneficiaryDAO(BeneficiaryDao beneficiaryDAO) {
        this.beneficiaryDAO = beneficiaryDAO;
    }

    @Transactional
    public List<Beneficiary> listBeneficiary() { return this.beneficiaryDAO.listBeneficiary(); }

    @Transactional
    public void addBeneficiary(Beneficiary beneficiary) {
        this.beneficiaryDAO.addBeneficiary(beneficiary);
    }

    @Transactional
    public void updateBeneficiary(Beneficiary beneficiary) {
        this.beneficiaryDAO.updateBeneficiary(beneficiary);
    }

    @Transactional
    public void removeBeneficiary(BigInteger id) {
        this.beneficiaryDAO.removeBeneficiary(id);
    }

    @Transactional
    public Beneficiary getBeneficiaryId(BigInteger id) {
        return this.beneficiaryDAO.getBeneficiaryId(id);
    }
}
