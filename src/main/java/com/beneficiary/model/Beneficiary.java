package com.beneficiary.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "beneficiaries"
@Table(name = "beneficiaries")
public class Beneficiary {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beneficiaries_seq")
    @SequenceGenerator(name = "beneficiaries_seq", sequenceName = "beneficiaries_id_seq", allocationSize = 10)
    private BigInteger beneficiaryId;
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

    // Методы класса
    public BigInteger getBeneficiaryId() {
        return beneficiaryId;
    }
    public void setBeneficiaryId(BigInteger beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
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

    // Конструктор класса
    public Beneficiary(String lastName, String firstName, String middleName, String phone, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
    }
    public Beneficiary() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "Beneficiary{" +
                "IdBeneficiary =" + beneficiaryId +
                ", LastName ='" + lastName + '\'' +
                ", FirstName ='" + firstName + '\'' +
                ", MiddleName ='" + middleName + '\'' +
                ", Phone ='" + phone + '\'' +
                ", Email ='" + email + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beneficiary)) return false;
        Beneficiary beneficiary = (Beneficiary) o;
        return Objects.equals(getBeneficiaryId(), beneficiary.getBeneficiaryId());
    }

    @Override
    public int hashCode() {
        int result = beneficiaryId.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
