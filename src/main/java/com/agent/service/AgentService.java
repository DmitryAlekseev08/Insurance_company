package com.agent.service;

import com.agent.dao.AgentDao;
import com.agent.model.Insurance_agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

// Реализация бизнес-логики
@Service
public class AgentService {
    @Autowired
    private AgentDao agentDAO;

    public void setAgentDAO(AgentDao agentDAO) {
        this.agentDAO = agentDAO;
    }

    @Transactional
    public List<Insurance_agent> listAgent() { return this.agentDAO.listAgent(); }

    @Transactional
    public void addAgent(Insurance_agent agent) {
        this.agentDAO.addAgent(agent);
    }

    @Transactional
    public void updateAgent(Insurance_agent agent) {
        this.agentDAO.updateAgent(agent);
    }

    @Transactional
    public void removeAgent(BigInteger id) {
        this.agentDAO.removeAgent(id);
    }

    @Transactional
    public Insurance_agent getAgentId(BigInteger id) {
        return this.agentDAO.getAgentId(id);
    }
}
