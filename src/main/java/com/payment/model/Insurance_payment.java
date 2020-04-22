package com.payment.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "insurance_payments"
@Table(name = "insurance_payments")
public class Insurance_payment {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="insurance_payments_seq")
    //@SequenceGenerator(name="insurance_payments_seq", sequenceName="insurance_payments_id_seq", allocationSize=10)
    private BigInteger paymentId;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "date")
    private String datePayment;
    @Column(name = "terms_and_reasons")
    private String conditionsReasons;
    @Column(name = "id_policy")
    private Integer policy;

    // Методы класса
    public BigInteger getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(BigInteger paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDatePayment() {
        return datePayment;
    }
    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public String getConditionsReasons() {
        return conditionsReasons;
    }
    public void setConditionsReasons(String conditionsReasons) {
        this.conditionsReasons = conditionsReasons;
    }

    public Integer getPolicy() {
        return policy;
    }
    public void setPolicy(Integer policy) {
        this.policy = policy;
    }

    // Конструктор класса
    public Insurance_payment(Integer amount, String datePayment, String conditionsReasons, Integer policy) {
        this.amount = amount;
        this.datePayment = datePayment;
        this.conditionsReasons = conditionsReasons;
        this.policy = policy;
    }

    public Insurance_payment() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "Insurance payment{" +
                "Id =" + paymentId +
                ", Amount ='" + amount + '\'' +
                ", Date ='" + datePayment + '\'' +
                ", TermsAndReasons ='" + conditionsReasons + '\'' +
                ", IdPolicy='" + policy + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insurance_payment)) return false;
        Insurance_payment payment = (Insurance_payment) o;
        return Objects.equals(getPaymentId(), payment.getPaymentId());
    }

    @Override
    public int hashCode() {
        int result = paymentId.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + datePayment.hashCode();
        result = 31 * result + conditionsReasons.hashCode();
        result = 31 * result + policy.hashCode();
        return result;
    }
}
