package com.agent.client;

import com.agent.model.Insurance_agent;
import com.agent.service.AgentService;
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
public class AgentController {
    private AgentService agentService;

    @Autowired()
    @Qualifier(value = "agentService")
    public void setAgentService(AgentService ps) {
        this.agentService = ps;
    }

    // Получение списка страховых агентов
    @RequestMapping(value ={"/agents"}, method = RequestMethod.GET)
    public String listAgent(Model model) {
        try {
            model.addAttribute("agent", new Insurance_agent());
            model.addAttribute("listAgents", this.agentService.listAgent());
        }
        catch (Exception error){
            return "/error";
        }
        return "/agents";
    }

    // Добавление записи о новом страховом агенте
    @RequestMapping(value ="/agents/add", method = RequestMethod.POST)
    public String addAgent(@ModelAttribute("agent") Insurance_agent agent) {
        if(agent.getAgentId() == null) {
            this.agentService.addAgent(agent);
        } else {
            this.agentService.updateAgent(agent);
        }
        return "redirect:/agents";
    }

    // Обновление информации о страховом агенте
    @RequestMapping(value ="/agents/edit/{id}")
    public String editAgent(@PathVariable("id") BigInteger id, Model model) {
        model.addAttribute("agent", this.agentService.getAgentId(id));
        model.addAttribute("listAgents", this.agentService.listAgent());
        return "/agents";
    }

    // Удаление сведений о страховом агенте
    @RequestMapping(value ="/agents/remove/{id}")
    public String removeAgent(@PathVariable("id") BigInteger id) {
        this.agentService.removeAgent(id);
        return "redirect:/agents";
    }
}