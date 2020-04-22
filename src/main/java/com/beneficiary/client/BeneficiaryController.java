package com.beneficiary.client;

import com.beneficiary.model.Beneficiary;
import com.beneficiary.service.BeneficiaryService;
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
public class BeneficiaryController {
    private BeneficiaryService beneficiaryService;

    @Autowired()
    @Qualifier(value = "beneficiaryService")
    public void setInsurantService(BeneficiaryService ps) {
        this.beneficiaryService = ps;
    }

    @RequestMapping(value ={"/beneficiaries"}, method = RequestMethod.GET)
    public String listBeneficiary(Model model) {
        model.addAttribute("beneficiary", new Beneficiary());
        model.addAttribute("listBeneficiaries", this.beneficiaryService.listBeneficiary());
        return "/beneficiaries";
    }

    @RequestMapping(value ="/beneficiaries/add", method = RequestMethod.POST)
    public String addBeneficiary(@ModelAttribute("beneficiary") Beneficiary beneficiary) {
        if(beneficiary.getBeneficiaryId() == null) {
            this.beneficiaryService.addBeneficiary(beneficiary);
        } else {
            this.beneficiaryService.updateBeneficiary(beneficiary);
        }
        return "redirect:/beneficiaries";
    }

    @RequestMapping(value ="/beneficiaries/edit/{id}")
    public String editBeneficiary(@PathVariable("id") BigInteger id, Model model) {
        model.addAttribute("beneficiary", this.beneficiaryService.getBeneficiaryId(id));
        model.addAttribute("listBeneficiaries", this.beneficiaryService.listBeneficiary());
        return "/beneficiaries";
    }

    @RequestMapping(value ="/beneficiaries/remove/{id}")
    public String removeBeneficiary(@PathVariable("id") BigInteger id) {
        this.beneficiaryService.removeBeneficiary(id);
        return "redirect:/beneficiaries";
    }
}
