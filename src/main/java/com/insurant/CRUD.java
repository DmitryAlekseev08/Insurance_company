package com.insurant;

import com.agent.model.Insurance_agent;
import com.beneficiary.model.Beneficiary;
import com.insurant.model.Insurant;
import com.policy.model.Insuranсе_policy;
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
        List<Insurant> list = read1(session);
        List<Insurance_agent> listAgent = read2(session);
        List<Beneficiary> listBen = read3(session);
        create(session, list, listAgent, listBen);
        //read(session);
        /*readID(session, BigInteger.valueOf(2));
        update(session, BigInteger.valueOf(1), "Носик", "Владимир", "Алексеевич", "+7 (908) 876-91-82", "NosikVA@yandex.ru");
        read(session);
        delete(session, BigInteger.valueOf(22));
        read(session);*/
        session.close();
    }

    // Метод чтения записей из таблицы
    private List<Insurant> read1(Session session) {
        List<Insurant> insurantList = session.createQuery("SELECT s FROM Insurant s").list();
        return insurantList;
    }

    private List<Insurance_agent> read2(Session session) {
        List<Insurance_agent> agentList = session.createQuery("SELECT s FROM Insurance_agent s").list();
        return agentList;
    }
    private List<Beneficiary> read3(Session session) {
        List<Beneficiary> benList = session.createQuery("SELECT s FROM Beneficiary s").list();
        return benList;
    }

    // Метод создания новой записи в таблице
    private void create(Session session, List<Insurant> list, List<Insurance_agent> list2,List<Beneficiary> list3) {
        Insuranсе_policy policy = new Insuranсе_policy();
        policy.setSeriesNumber("1234567810");
        policy.setObjectInsurance("Flat");
        policy.setInsuranceAmount(10000);
        policy.setInsurancePremium(1000);
        policy.setDateIn("2011-11-11");
        policy.setDateOut("2012-11-11");
        policy.setAgent(list2.get(1));
        policy.setInsurant(list.get(1));
        policy.setBeneficiary(list3.get(1));
        //list.get(1).setPolicies((List<Insuranсе_policy>) policy);
        System.out.println("Create:" + policy);
        System.out.println("");
        session.beginTransaction();
        session.save(policy);
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