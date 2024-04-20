package com.hb11.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        System.out.println("*********** İlk Get işlemi --> 1 ID'li student için");
        Student11 student1 = session.get(Student11.class,1);


       session.clear(); //First level cache temizlendi.
       //Eğer bunu atmasaydık,
        // 2.Query'i run etmeye gerek görmeyecekti çünkü ilk işlemde
        // fist level cache yapıldı.Çünkü aynı session içerisindeyiz.


        System.out.println("*********** 2. Get işlemi --> 1 ID'li student için");
        Student11 student2 = session.get(Student11.class,1);



        tx.commit();
        session.close(); //first level cache temizlendi.

        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();


        tx2.commit();
        System.out.println("*********** Session1 close sonrası Get işlemi --> 1 ID'li student için");
        Student11 student3 = session2.get(Student11.class,1);
        session2.close();
        sf.close();


    }


}
