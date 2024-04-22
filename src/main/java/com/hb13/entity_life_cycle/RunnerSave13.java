package com.hb13.entity_life_cycle;

import com.hb12.getload.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {


        Student13 student1 = new Student13(); //!!! Transient State

        student1.setName("Aslı Hanım");
        student1.setMathGrade(75);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1); //Persistent State

        student1.setName("Aslıhan Hanım");
        session.evict(student1); //detached state - SQL Rollback

        session.update(student1); // !!! detached --> persisted
        session.merge(student1); // !!! detached --> persisted

        tx.commit(); //Detach ediyor.
        session.close();
        sf.close();


    }
}
