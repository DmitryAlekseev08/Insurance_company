package com.agent.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "insurance_agents"
@Table(name = "insurance_agents")
public class Insurance_agent {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="insurance_agents_seq")
    @SequenceGenerator(name="insurance_agents_seq", sequenceName="insurance_agents_id_seq", allocationSize=10)
    private BigInteger agentId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "insurance_percent")
    private Float percent;

    // Методы класса
    public BigInteger getAgentId() {
        return agentId;
    }
    public void setAgentId(BigInteger agentId) {
        this.agentId = agentId;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Float getPercent() { return percent; }
    public void setPercent(Float percent) { this.percent = percent; }

    // Конструктор класса
    public Insurance_agent(String lastName, String firstName, String middleName, String phone, String email, Float percent) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.percent = percent;
    }

    public Insurance_agent() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "Insurance agent{" +
                "IdAgent =" + agentId +
                ", LastName ='" + lastName + '\'' +
                ", Firstname ='" + firstName + '\'' +
                ", MiddleName ='" + middleName + '\'' +
                ", Phone ='" + phone + '\'' +
                ", Email ='" + email + '\'' +
                ", InsurancePercent ='" + percent + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insurance_agent)) return false;
        Insurance_agent agent = (Insurance_agent) o;
        return Objects.equals(getAgentId(), agent.getAgentId());
    }

    @Override
    public int hashCode() {
        int result = agentId.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + percent.hashCode();
        return result;
    }
}