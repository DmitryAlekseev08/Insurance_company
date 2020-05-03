package com.policy.client;

import com.policy.model.Insuranсе_policy;
import com.policy.service.PolicyService;
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
public class PolicyController {
    private PolicyService policyService;

    @Autowired()
    @Qualifier(value = "policyService")
    public void setPolicyService(PolicyService ps) {
        this.policyService = ps;
    }

    @RequestMapping(value ={"/policies"}, method = RequestMethod.GET)
    public String listPolicy(Model model) {
        model.addAttribute("policy", new Insuranсе_policy());
        model.addAttribute("listPolicies", this.policyService.listPolicy());
        model.addAttribute("agentInfo", this.policyService.AgentInformation());
        model.addAttribute("insurantInfo", this.policyService.InsurantInformation());
        model.addAttribute("beneficiaryInfo", this.policyService.BeneficiaryInformation());
        model.addAttribute("listAgentId", this.policyService.listAgentId());
        model.addAttribute("listInsurantId", this.policyService.listInsurantId());
        model.addAttribute("listBeneficiaryId", this.policyService.listBeneficiaryId());
        return "/policies";
    }

    @RequestMapping(value ="/policies/add", method = RequestMethod.POST)
    public String addPolicy(@ModelAttribute("policy") Insuranсе_policy policy) {
            if (policy.getPolicyId() == null) {
                this.policyService.addPolicy(policy);
            } else {
                this.policyService.updatePolicy(policy);
            }
        return "redirect:/policies";
    }

    @RequestMapping(value ="/policies/edit/{id}")
    public String editPolicy(@PathVariable("id") BigInteger id, Model model) {
        model.addAttribute("policy", this.policyService.getPolicyId(id));
        model.addAttribute("listPolicies", this.policyService.listPolicy());
        model.addAttribute("agentInfo", this.policyService.AgentInformation());
        model.addAttribute("insurantInfo", this.policyService.InsurantInformation());
        model.addAttribute("beneficiaryInfo", this.policyService.BeneficiaryInformation());
        model.addAttribute("listAgentId", this.policyService.listAgentId());
        model.addAttribute("listInsurantId", this.policyService.listInsurantId());
        model.addAttribute("listBeneficiaryId", this.policyService.listBeneficiaryId());
        return "/policies";
    }

    @RequestMapping(value ="/policies/remove/{id}")
    public String removePolicy(@PathVariable("id") BigInteger id) {
        this.policyService.removePolicy(id);
        return "redirect:/policies";
    }
}
