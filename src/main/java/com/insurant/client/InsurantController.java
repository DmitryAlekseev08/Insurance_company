package com.insurant.client;

import com.insurant.model.Insurant;
import com.insurant.service.InsurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;

// Класс-контроллер для обработки запросов
@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller
public class InsurantController {

    private InsurantService insurantService;

    @Autowired()
    @Qualifier(value = "insurantService")
    public void setInsurantService(InsurantService ps) {
        this.insurantService = ps;
    }

    @RequestMapping(value ={"/insurants"}, method = RequestMethod.GET)
    public String listInsurant(Model model) {
        model.addAttribute("insurant", new Insurant());
        model.addAttribute("listInsurants", this.insurantService.listInsurant());
        return "/insurants";
    }

    @RequestMapping(value ="/insurants/add", method = RequestMethod.POST)
    public String addInsurant(@ModelAttribute("insurant") Insurant insurant) {
        if (insurant.getInsurantId() == null){
        this.insurantService.addInsurant(insurant);}
        else {
            this.insurantService.updateInsurant(insurant);
        }
        return "redirect:/insurants";
    }

    @RequestMapping(value ="/insurants/edit/{id}")
    public String editInsurant(@PathVariable("id") BigInteger id, Model model) {
        model.addAttribute("insurant", this.insurantService.getInsurantId(id));
        model.addAttribute("listInsurants", this.insurantService.listInsurant());
        return "/insurants";
    }

    @RequestMapping(value ="/insurants/remove/{id}")
    public String removeInsurant(@PathVariable("id") BigInteger id) {
        this.insurantService.removeInsurant(id);
        return "redirect:/insurants";
    }
}