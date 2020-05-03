package com.complex;

import javax.persistence.Column;
import java.math.BigInteger;
public class QueryHard {
    @Column(table = "insuranсe_policies", name="id")
    private BigInteger policyId;
    /*private String seriesNumber;
    private String objectInsurance;
    private Integer insuranceAmount;
    private Integer insurancePremium;
    private String dateIn;
    private String dateOut;*/
    //private Integer agent;
    @Column(table = "insurance_agents", name="id")
    private String agentName;
    //private Integer insurant;
    @Column(table = "insurants", name="id")
    private String insurantName;
    //private Integer beneficiary;
    @Column(table = "beneficiaries", name="id")
    private String beneficiaryName;

    public BigInteger getPolicyId() {
        return policyId;
    }
    public void setPolicyId(BigInteger policyId) {
        this.policyId = policyId;
    }

    /*public String getSeriesNumber() {
        return seriesNumber;
    }
    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getObjectInsurance() {
        return objectInsurance;
    }
    public void setObjectInsurance(String objectInsurance) {
        this.objectInsurance = objectInsurance;
    }

    public Integer getInsuranceAmount() {
        return insuranceAmount;
    }
    public void setInsuranceAmount(Integer insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Integer getInsurancePremium() {
        return insurancePremium;
    }
    public void setInsurancePremium(Integer insurancePremium) { this.insurancePremium = insurancePremium; }

    public String getDateIn() { return dateIn; }
    public void setDateIn(String dateIn) { this.dateIn = dateIn; }

    public String getDateOut() { return dateOut; }
    public void setDateOut(String dateOut) { this.dateOut = dateOut; }*/

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }

    /*public Integer getAgent() { return agent; }
    public void setAgent(Integer agent) { this.agent = agent; }

    public Integer getInsurant() { return insurant; }
    public void setInsurant(Integer insurant) { this.insurant = insurant; }

    public Integer getBeneficiary() { return beneficiary; }
    public void setBeneficiary(Integer beneficiary) { this.beneficiary = beneficiary; }*/

    public String getInsurantName() { return insurantName; }
    public void setInsurantName(String insurantName) { this.insurantName = insurantName; }

    public String getBeneficiaryName() { return beneficiaryName; }
    public void setAgent(String beneficiaryName) { this.beneficiaryName = beneficiaryName; }
}
