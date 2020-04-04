package com.insurant.service;

import com.insurant.dao.InsurantDao;
import com.insurant.model.Insurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
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
    public List<Insurant> filter()
    {
        List<Insurant> insurantList = this.insurantDAO.listInsurant();
        // Фильтр отсеивает записи, которые начинаются с гласной буквы
        Iterator<Insurant> insurantIterator = insurantList.iterator(); // Создаю итератор
        while(insurantIterator.hasNext()) { // До тех пор, пока в списке есть элементы

            Insurant nextInsurant = insurantIterator.next();
            if (nextInsurant.getLastName().matches("^(?i:[aeiouy]).*")) {
                insurantIterator.remove();
            }
        }
        return insurantList;
    };

    @Transactional
    public List<Insurant> listInsurant() { return this.insurantDAO.listInsurant(); }
}