package com.hb06.unionetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        Student06 student1 = session.get(Student06.class, 1001);
        System.out.println(student1);

        //!!! TASK: HQL ile id'si 101 olan kitabı getirelim.

        String hqlQuery1 = "FROM Book06 b WHERE b.id = 101";
        Book06 book1 = session.createQuery(hqlQuery1,Book06.class).uniqueResult();
        System.out.println(book1);


        //!!! Yukarıdaki sorguyu get ile yazarsak nasıl olur.
        Book06 book2 = session.get(Book06.class,101);
        System.out.println(book2);

        //TASK: 1001 idli öğrencinin kitaplarını getirme

        String hqlQuery2 = "SELECT b.id,b.name FROM Student06 s INNER JOIN s.book06List b WHERE s.id = 1001";
        List<Object[]> resultList1 = session.createQuery(hqlQuery2).getResultList();
        resultList1.forEach(t-> System.out.println(Arrays.toString(t)));

        //!!! Aynı sorguyu get methodu ile yazın.

        Student06 student2 = session.get(Student06.class,1001);
        student2.getBook06List().forEach(System.out::println);

        tx.commit();
        sf.close();
        sf.close();
    }
}
