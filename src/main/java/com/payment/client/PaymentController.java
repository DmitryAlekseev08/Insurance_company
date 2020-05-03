package com.payment.client;

import com.payment.model.Insurance_payment;
import com.payment.service.PaymentService;
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
public class PaymentController {
    private PaymentService paymentService;

    @Autowired()
    @Qualifier(value = "paymentService")
    public void setPaymentService(PaymentService ps) {
        this.paymentService = ps;
    }

    @RequestMapping(value ={"/payments"}, method = RequestMethod.GET)
    public String listPayment(Model model) {
        model.addAttribute("payment", new Insurance_payment());
        model.addAttribute("listPayments", this.paymentService.listPayment());
        model.addAttribute("listPolicyId", this.paymentService.listPolicyId());
        return "/payments";
    }

    @RequestMapping(value ="/payments/add", method = RequestMethod.POST)
    public String addPayment(@ModelAttribute("payment") Insurance_payment payment) {
            if (payment.getPaymentId() == null) {
                this.paymentService.addPayment(payment);
            } else {
                this.paymentService.updatePayment(payment);
            }
        return "redirect:/payments";
    }

    @RequestMapping(value ="/payments/edit/{id}")
    public String editPayment(@PathVariable("id") BigInteger id, Model model) {
        model.addAttribute("payment", this.paymentService.getPaymentId(id));
        model.addAttribute("listPayments", this.paymentService.listPayment());
        model.addAttribute("listPolicyId", this.paymentService.listPolicyId());
        return "/payments";
    }

    @RequestMapping(value ="payments/remove/{id}")
    public String removePayment(@PathVariable("id") BigInteger id) {
        this.paymentService.removePayment(id);
        return "redirect:/payments";
    }
}