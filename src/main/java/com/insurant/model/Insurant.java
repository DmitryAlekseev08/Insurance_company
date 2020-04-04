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
    @Column(name = "insurant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger IdInsurant;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "first_name")
    private String FirstName;
    @Column(name = "middle_name")
    private String MiddleName;
    @Column(name = "phone")
    private String Phone;
    @Column(name = "email")
    private String Email;

    // Методы класса
    public BigInteger getInsurantID() {
        return IdInsurant;
    }
    public void setInsurantID(BigInteger insurantID) {
        this.IdInsurant = insurantID;
    }

    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }
    public void setMiddleName(String middleName) {
        this.MiddleName = middleName;
    }

    public String getPhone() { return Phone; }
    public void setPhone(String phone) { this.Phone = phone; }

    public String getEmail() { return Email; }
    public void setEmail(String email) { this.Email = email; }

    // Конструктор класса
    public Insurant(String LastName, String FirstName, String MiddleName, String Phone, String Email) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.Phone = Phone;
        this.Email = Email;
    }
    public Insurant() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "Insurant{" +
                "IdInsurant =" + IdInsurant +
                ", LastName ='" + LastName + '\'' +
                ", FirstName ='" + FirstName + '\'' +
                ", MiddleName ='" + MiddleName + '\'' +
                ", Phone ='" + Phone + '\'' +
                ", Email ='" + Email + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insurant)) return false;
        Insurant insurant = (Insurant) o;
        return Objects.equals(getInsurantID(), insurant.getInsurantID());
    }

    @Override
    public int hashCode() {
        int result = IdInsurant .hashCode();
        result = 31 * result + LastName.hashCode();
        result = 31 * result + FirstName.hashCode();
        result = 31 * result + MiddleName.hashCode();
        result = 31 * result + Phone.hashCode();
        result = 31 * result + Email.hashCode();
        return result;
    }
}