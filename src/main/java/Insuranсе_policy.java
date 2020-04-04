import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "СтраховойПолис"
@Table(name = "СтраховойПолис")
public class Insuranсе_policy {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "КодСтраховогоПолиса")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger PolicyID;
    @Column(name = "СерияНомер")
    private String SeriesNumber;
    @Column(name = "ОбъектСтрахования")
    private String ObjectInsurance;
    @Column(name = "СтраховаяСумма")
    private Integer InsuranceAmount;
    @Column(name = "СтраховаяПремия")
    private Integer InsurancePremium;
    @Column(name = "ДатаЗаключенияДоговора")
    private Date DateIn;
    @Column(name = "ДатаОкончанияДействияДоговора")
    private Date DateOut;
    @Column(name = "КодСтраховогоАгента")
    private Integer Agent;
    @Column(name = "КодСтрахователя")
    private Integer Insurant;
    @Column(name = "КодВыгодоприобретателя")
    private Integer Beneficiary;

    // Методы класса
    public BigInteger getPolicyID() {
        return PolicyID;
    }
    public void setPolicyID(BigInteger PolicyID) {
        this.PolicyID = PolicyID;
    }

    public String getSeriesNumber() {
        return SeriesNumber;
    }
    public void setSeriesNumber(String SeriesNumber) {
        this.SeriesNumber = SeriesNumber;
    }

    public String getObjectInsurance() {
        return ObjectInsurance;
    }
    public void setObjectInsurance(String ObjectInsurance) {
        this.ObjectInsurance = ObjectInsurance;
    }

    public Integer getInsuranceAmount() {
        return InsuranceAmount;
    }
    public void setInsuranceAmount(Integer InsuranceAmount) {
        this.InsuranceAmount = InsuranceAmount;
    }

    public Integer getInsurancePremium() {
        return InsurancePremium;
    }
    public void setInsurancePremium(Integer InsurancePremium) { this.InsurancePremium = InsurancePremium; }

    public Date getDateIn() { return DateIn; }
    public void setDateIn(Date DateIn) { this.DateIn = DateIn; }

    public Date getDateOut() { return DateOut; }
    public void setDateOut(Date DateOut) { this.DateOut = DateOut; }

    public Integer getAgent() { return Agent; }
    public void setAgent(Integer Agent) { this.Agent = Agent; }

    public Integer getInsurant() { return Insurant; }
    public void setInsurant(Integer Insurant) { this.Insurant = Insurant; }

    public Integer getBeneficiary() { return Beneficiary; }
    public void setBeneficiary(Integer Beneficiary) { this.Beneficiary = Beneficiary; }

    // Конструктор класса
    public Insuranсе_policy(String SeriesNumber, String ObjectInsurance, Integer InsuranceAmount, Integer InsurancePremium, Date DateIn, Date DateOut, Integer Agent, Integer Insurant, Integer Beneficiary) {
        this.SeriesNumber = SeriesNumber;
        this.ObjectInsurance = ObjectInsurance;
        this.InsuranceAmount = InsuranceAmount;
        this.InsurancePremium = InsurancePremium;
        this.DateIn = DateIn;
        this.DateOut = DateOut;
        this.Agent = Agent;
        this.Insurant = Insurant;
        this.Beneficiary = Beneficiary;
    }

    public Insuranсе_policy() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "СтраховойПолис{" +
                "КодСтраховогоПолиса=" + PolicyID +
                ", СерияНомер ='" + SeriesNumber + '\'' +
                ", ОбъектСтрахования ='" + ObjectInsurance + '\'' +
                ", СтраховаяСумма ='" + InsuranceAmount + '\'' +
                ", СтраховаяПремия ='" + InsurancePremium + '\'' +
                ", ДатаЗаключенияДоговора ='" + DateIn + '\'' +
                ", ДатаОкончанияДействияДоговора ='" + DateOut + '\'' +
                ", КодСтраховогоАгента ='" + Agent + '\'' +
                ", КодСтрахователя ='" + Insurant + '\'' +
                ", КодВыгодоприобретателя ='" + Beneficiary + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insuranсе_policy)) return false;
        Insuranсе_policy policy = (Insuranсе_policy) o;
        return Objects.equals(getPolicyID(), policy.getPolicyID());
    }

    @Override
    public int hashCode() {
        int result = PolicyID.hashCode();
        result = 31 * result + SeriesNumber.hashCode();
        result = 31 * result + ObjectInsurance.hashCode();
        result = 31 * result + InsuranceAmount.hashCode();
        result = 31 * result + InsurancePremium.hashCode();
        result = 31 * result + DateIn.hashCode();
        result = 31 * result + DateOut.hashCode();
        result = 31 * result + Agent.hashCode();
        result = 31 * result + Insurant.hashCode();
        result = 31 * result + Beneficiary.hashCode();
        return result;
    }
}
