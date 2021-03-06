package com.insurant.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "insurants"
@Table(name = "insurants")
public class Insurant {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="insurants_seq")
    @SequenceGenerator(name="insurants_seq", sequenceName="insurants_id_seq", allocationSize=10)
    private BigInteger insurantId;
    @Column(name = "last_name", unique = true, nullable = false)
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
    public BigInteger getInsurantId() {
        return insurantId;
    }
    public void setInsurantId(BigInteger insurantId) { this.insurantId = insurantId; }

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
    public Insurant(String LastName, String FirstName, String MiddleName, String Phone, String Email) {
        this.lastName = LastName;
        this.firstName = FirstName;
        this.middleName = MiddleName;
        this.phone = Phone;
        this.email = Email;
    }
    public Insurant() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "Insurant{" +
                "IdInsurant =" + insurantId +
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
        if (!(o instanceof Insurant)) return false;
        Insurant insurant = (Insurant) o;
        return Objects.equals(getInsurantId(), insurant.getInsurantId());
    }

    @Override
    public int hashCode() {
        int result = insurantId .hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}