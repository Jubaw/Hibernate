package com.hb02.embeddable;

import com.hb01.annotations.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {


        //1.Öğrenci:
        Student02 student1 = new Student02();
        student1.setId(1001);
        student1.setName("Ayşe Hanım");
        student1.setGrade(80);

        Adress adress1 = new Adress();
        adress1.setStreet("Apple Street");
        adress1.setCity("İstanbul");
        adress1.setCountry("Turkey");
        adress1.setZipCode("34000");


        student1.setAdress(adress1);

        //2.Ogrenci:
        Student02 student2 = new Student02();

        student2.setId(1002);
        student2.setName("Abdullah");
        student2.setGrade(80);

        Adress adress2 = new Adress();
        adress2.setStreet("Orange");
        adress2.setCountry("Turkey");
        adress2.setCity("Ankara");
        adress2.setZipCode("06000");

        student2.setAdress(adress2);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);




        tx.commit();
        session.close();
        sf.close();



    }
}
