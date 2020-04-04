import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
@Embeddable
// Таблица "СтраховаяВыплата"
@Table(name = "СтраховаяВыплата")
public class Insurance_payment {
    // Поля класса(столбцы таблицы)
    @Id
    @Column(name = "КодВыплаты")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger PaymentID;
    @Column(name = "СуммаВыплаты")
    private Integer Amount;
    @Column(name = "ДатаВыплаты")
    private Date DatePayment;
    @Column(name = "УсловияПричиныВыплаты")
    private String ConditionsReasons;
    @Column(name = "КодСтраховогоПолиса ")
    private Integer Policy;

    // Методы класса
    public BigInteger getPaymentID() {
        return PaymentID;
    }
    public void setPaymentID(BigInteger PaymentID) {
        this.PaymentID = PaymentID;
    }

    public Integer getAmount() {
        return Amount;
    }
    public void setAmount(Integer Amount) {
        this.Amount = Amount;
    }

    public Date getDatePayment() {
        return DatePayment;
    }
    public void setDatePayment(Date DatePayment) {
        this.DatePayment = DatePayment;
    }

    public String getConditionsReasons() {
        return ConditionsReasons;
    }
    public void setConditionsReasons(String ConditionsReasons) {
        this.ConditionsReasons = ConditionsReasons;
    }

    public Integer getPolicy() {
        return Policy;
    }
    public void setPolicy(Integer Policy) {
        this.Policy = Policy;
    }

    // Конструктор класса
    public Insurance_payment(Integer Amount, Date DatePayment, String ConditionsReasons, Integer Policy) {
        this.Amount = Amount;
        this.DatePayment = DatePayment;
        this.ConditionsReasons = ConditionsReasons;
        this.Policy = Policy;
    }

    public Insurance_payment() {
    }

    // Метод, возвращающий запись из таблицы
    @Override
    public String toString() {
        return "СтраховаяВыплата{" +
                "КодВыплата =" + PaymentID +
                ", СуммаВыплаты ='" + Amount + '\'' +
                ", ДатаВыплаты ='" + DatePayment + '\'' +
                ", УсловияПричиныВыплаты ='" + ConditionsReasons + '\'' +
                ", КодСтраховогоПолиса='" + Policy + '\'' +
                '}';
    }

    // Метод, выполняющий сравнение записей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insurance_payment)) return false;
        Insurance_payment payment = (Insurance_payment) o;
        return Objects.equals(getPaymentID(), payment.getPaymentID());
    }

    @Override
    public int hashCode() {
        int result = PaymentID.hashCode();
        result = 31 * result + Amount.hashCode();
        result = 31 * result + DatePayment.hashCode();
        result = 31 * result + ConditionsReasons.hashCode();
        result = 31 * result + Policy.hashCode();
        return result;
    }
}
