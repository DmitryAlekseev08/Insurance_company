import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "СтраховойАгент"
@Table(name = "СтраховойАгент")
public class Insurance_agent {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "КодСтраховогоАгента")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger AgentID;
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
    @Column(name = "СтраховойПроцент")
    private Float Percent;

    // Методы класса
    public BigInteger getAgentID() {
        return AgentID;
    }
    public void setAgentID(BigInteger AgentID) {
        this.AgentID = AgentID;
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

    public Float getPercent() { return Percent; }
    public void setPercent(Float percent) { this.Percent = percent; }

    // Конструктор класса
    public Insurance_agent(String LastName, String FirstName, String MiddleName, String Phone, String Mail, Float Percent) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.Phone = Phone;
        this.Mail = Mail;
        this.Percent = Percent;
    }

    public Insurance_agent() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "Страховой агент{" +
                "КодСтраховогоАгента =" + AgentID +
                ", Фамилия ='" + LastName + '\'' +
                ", Имя ='" + FirstName + '\'' +
                ", Отчество ='" + MiddleName + '\'' +
                ", Телефон ='" + Phone + '\'' +
                ", Почта ='" + Mail + '\'' +
                ", СтраховойПроцент ='" + Percent + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insurance_agent)) return false;
        Insurance_agent agent = (Insurance_agent) o;
        return Objects.equals(getAgentID(), agent.getAgentID());
    }

    @Override
    public int hashCode() {
        int result = AgentID.hashCode();
        result = 31 * result + LastName.hashCode();
        result = 31 * result + FirstName.hashCode();
        result = 31 * result + MiddleName.hashCode();
        result = 31 * result + Phone.hashCode();
        result = 31 * result + Mail.hashCode();
        result = 31 * result + Percent.hashCode();
        return result;
    }
}