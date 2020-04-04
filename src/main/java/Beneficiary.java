import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "Выгодоприобретатель"
@Table(name = "Выгодоприобретатель")
public class Beneficiary {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "КодВыгодоприобретателя")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger BeneficiaryID;
    @Column(name = "Фамилия")
    private String LastName;
    @Column(name = "Имя")
    private String FirstName;
    @Column(name = "Отчество")
    private String MiddleName;
    @Column(name = "Телефон")
    private String Phone;
    @Column(name = "Почта")
    private String Mail;

    // Методы класса
    public BigInteger getBeneficiaryID() {
        return BeneficiaryID;
    }
    public void setBeneficiaryID(BigInteger BeneficiaryID) {
        this.BeneficiaryID = BeneficiaryID;
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

    public String getMail() { return Mail; }
    public void setMail(String mail) { this.Mail = mail; }

    // Конструктор класса
    public Beneficiary(String LastName, String FirstName, String MiddleName, String Phone, String Mail) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.Phone = Phone;
        this.Mail = Mail;
    }
    public Beneficiary() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "Выгодоприобретатель{" +
                "КодВыгодоприобретателя =" + BeneficiaryID +
                ", Фамилия ='" + LastName + '\'' +
                ", Имя ='" + FirstName + '\'' +
                ", Отчество ='" + MiddleName + '\'' +
                ", Телефон ='" + Phone + '\'' +
                ", Почта ='" + Mail + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beneficiary)) return false;
        Beneficiary beneficiary = (Beneficiary) o;
        return Objects.equals(getBeneficiaryID(), beneficiary.getBeneficiaryID());
    }

    @Override
    public int hashCode() {
        int result = BeneficiaryID.hashCode();
        result = 31 * result + LastName.hashCode();
        result = 31 * result + FirstName.hashCode();
        result = 31 * result + MiddleName.hashCode();
        result = 31 * result + Phone.hashCode();
        result = 31 * result + Mail.hashCode();
        return result;
    }
}
