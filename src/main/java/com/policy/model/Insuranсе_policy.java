package com.policy.model;

import com.agent.model.Insurance_agent;
import com.beneficiary.model.Beneficiary;
import com.insurant.model.Insurant;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "insuranсe_policies"
@Table(name = "insuranсe_policies")
public class Insuranсе_policy {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="insuranсe_policies_seq")
    @SequenceGenerator(name="insuranсe_policies_seq", sequenceName="insuranсe_policies_id_seq", allocationSize=10)
    private BigInteger policyId;
    @Column(name = "series_and_number")
    private String seriesNumber;
    @Column(name = "object_insurance")
    private String objectInsurance;
    @Column(name = "insurance_amount")
    private Integer insuranceAmount;
    @Column(name = "insurance_premium")
    private Integer insurancePremium;
    @Column(name = "date_in")
    private String dateIn;
    @Column(name = "date_out")
    private String dateOut;

    @ManyToOne
    @JoinColumn(name = "id_agent")
    private Insurance_agent agent;

    @ManyToOne
    @JoinColumn(name = "id_insurant")
    private Insurant insurant;

    @ManyToOne
    @JoinColumn(name = "id_beneficiary")
    private Beneficiary beneficiary;

    // Методы класса
    public BigInteger getPolicyId() {
        return policyId;
    }
    public void setPolicyId(BigInteger policyId) {
        this.policyId = policyId;
    }

    public String getSeriesNumber() {
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
    public void setDateOut(String dateOut) { this.dateOut = dateOut; }

    public Insurance_agent getAgent() { return agent; }
    public void setAgent(Insurance_agent agent) { this.agent = agent; }

    public Insurant getInsurant() { return insurant; }
    public void setInsurant(Insurant insurant) { this.insurant = insurant; }

    public Beneficiary getBeneficiary() { return beneficiary; }
    public void setBeneficiary(Beneficiary beneficiary) { this.beneficiary = beneficiary; }

    // Конструктор класса
    public Insuranсе_policy(String seriesNumber, String objectInsurance, Integer insuranceAmount, Integer insurancePremium, String dateIn, String dateOut, Insurance_agent agent, Insurant insurant, Beneficiary beneficiary) {
        this.seriesNumber = seriesNumber;
        this.objectInsurance = objectInsurance;
        this.insuranceAmount = insuranceAmount;
        this.insurancePremium = insurancePremium;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.agent = agent;
        this.insurant = insurant;
        this.beneficiary = beneficiary;
    }

    public Insuranсе_policy() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "Insurance policy{" +
                "Id =" + policyId +
                ", seriesNumber ='" + seriesNumber + '\'' +
                ", objectInsurance ='" + objectInsurance + '\'' +
                ", insuranceAmount ='" + insuranceAmount + '\'' +
                ", insurancePremium ='" + insurancePremium + '\'' +
                ", dateIn ='" + dateIn + '\'' +
                ", dateOut ='" + dateOut + '\'' +
                ", IdAgent ='" + agent + '\'' +
                ", IdInsurant ='" + insurant + '\'' +
                ", IdBeneficiary ='" + beneficiary + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insuranсе_policy)) return false;
        Insuranсе_policy policy = (Insuranсе_policy) o;
        return Objects.equals(getPolicyId(), policy.getPolicyId());
    }

    @Override
    public int hashCode() {
        int result = policyId.hashCode();
        result = 31 * result + seriesNumber.hashCode();
        result = 31 * result + objectInsurance.hashCode();
        result = 31 * result + insuranceAmount.hashCode();
        result = 31 * result + insurancePremium.hashCode();
        result = 31 * result + dateIn.hashCode();
        result = 31 * result + dateOut.hashCode();
        result = 31 * result + agent.hashCode();
        result = 31 * result + insurant.hashCode();
        result = 31 * result + beneficiary.hashCode();
        return result;
    }
}
