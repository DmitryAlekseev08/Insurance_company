package com.insurant;

import com.insurant.model.Insurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

public class CRUD {

    @Test
    public void crud() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        read(session);
        create(session);
        read(session);
        /*readID(session, BigInteger.valueOf(2));
        update(session, BigInteger.valueOf(1), "Носик", "Владимир", "Алексеевич", "+7 (908) 876-91-82", "NosikVA@yandex.ru");
        read(session);
        delete(session, BigInteger.valueOf(22));
        read(session);*/
        session.close();
    }

    // Метод чтения записей из таблицы
    private void read(Session session) {
        List<Insurant> insurantList = session.createQuery("SELECT s FROM Insurant s").list();
        System.out.println("");
        for (Insurant s : insurantList) {
            System.out.println("List:" + s);
        }
        System.out.println("");
    }

    // Метод создания новой записи в таблице
    private void create(Session session) {
        Insurant insurant = new Insurant();
        insurant.setLastName("Усманов");
        insurant.setFirstName("Олег");
        insurant.setMiddleName("Владимирович");
        insurant.setPhone("+7 (910) 108-46-67");
        insurant.setEmail("UsmanovOV@yandex.ru");
        System.out.println("Create:" + insurant);
        System.out.println("");
        session.beginTransaction();
        session.save(insurant);
        session.getTransaction().commit();
    }

    // Метод чтения записи из таблицы по id
    private void readID(Session session, BigInteger id) {
        Insurant insurant = (Insurant) session.load(Insurant.class, id);
        System.out.println("Read:" + insurant);
        System.out.println("");
    }

    // Метод удаления записи из таблицы
    private void delete(Session session, BigInteger id)
    {
        Insurant insurant = (Insurant) session.load(Insurant.class, id);
                System.out.println("Delete:" + insurant);
                System.out.println("");
                session.beginTransaction();
                session.delete(insurant);
                session.getTransaction().commit();
    }

    // Метод редактирования записи в таблице
    private void update(Session session, BigInteger id, String LastName, String FirstName, String MiddleName, String Phone, String Mail)
    {
        Insurant insurant = (Insurant) session.load(Insurant.class, id);
        System.out.println("Update:" + insurant);
        System.out.println("");
        insurant.setFirstName(FirstName);
        insurant.setMiddleName(MiddleName);
        insurant.setLastName(LastName);
        insurant.setPhone(Phone);
        insurant.setEmail(Mail);
        session.beginTransaction();
        session.update(insurant);
        session.getTransaction().commit();
    }
}