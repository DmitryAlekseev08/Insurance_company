package com.insurant.client;

import com.insurant.model.Insurant;
import com.insurant.service.InsurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Класс-контроллер для обработки запросов
@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@RestController
public class InsurantController {
    private InsurantService insurantService;

    @Autowired()
    @Qualifier(value = "insurantService")
    public void setInsurantService(InsurantService ps) {
        this.insurantService = ps;
    }

    @RequestMapping(value = "/insurants", method = RequestMethod.GET)
    public List<Insurant> listInsurants() {
        List<Insurant> insurantList = this.insurantService.listInsurant();
        for (Insurant s : insurantList)
            System.out.println(s);
        return insurantList;
    }

    @RequestMapping(value = "/filter")
    public List<Insurant> filter() {
        List<Insurant> insurantList = this.insurantService.filter();
        for (Insurant s : insurantList)
            System.out.println("Filter:" + s);
        return insurantList;
    }
}