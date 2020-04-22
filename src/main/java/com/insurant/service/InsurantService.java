package com.insurant.service;

import com.insurant.dao.InsurantDao;
import com.insurant.model.Insurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

// Реализация бизнес-логики
@Service
public class InsurantService {
    @Autowired
    private InsurantDao insurantDAO;

    public void setInsurantDAO(InsurantDao insurantDAO) {
        this.insurantDAO = insurantDAO;
    }

    @Transactional
    public List<Insurant> listInsurant() { return this.insurantDAO.listInsurant(); }

    @Transactional
    public void addInsurant(Insurant insurant) {
        this.insurantDAO.addInsurant(insurant);
    }

    @Transactional
    public void updateInsurant(Insurant insurant) { this.insurantDAO.updateInsurant(insurant); }

    @Transactional
    public void removeInsurant(BigInteger id) {
        this.insurantDAO.removeInsurant(id);
    }

    @Transactional
    public Insurant getInsurantId(BigInteger id) { return this.insurantDAO.getInsurantId(id); }
}