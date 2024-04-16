package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student04 student1 = session.get(Student04.class, 1001);
        Diary04 diary1 = session.get(Diary04.class, 101);
        System.out.println(student1);
        System.out.println("*********************");
        System.out.println(student1.getDiary());
        System.out.println("*********************");
        System.out.println(diary1);
        System.out.println("*********************");
        System.out.println(diary1.getStudent());

/*        //Task: Diary'si olan öğrencilerin iismlerini ve günlüklerinin isimlerini getiriniz.

        String hqlQuery = "SELECT s.name,d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id=d.student";
        //Select s.std_name, d.name FROM Student04 s INNER JOIN Diary04 d ON s.id = d.std_id
        List<Object[]> resultList1 = session.createQuery(hqlQuery).getResultList();
        for (Object[] objects : resultList1){
            System.out.println(Arrays.toString(objects));
        }
        resultList1.forEach(t->{
            System.out.println(Arrays.toString(t));
        });*/

        //!!! Task: Bütün öğrenciler ve varsa bu öğrencilerin kitaplarını da getirelim.



        tx.commit();
        session.close();
        sf.close();
    }

}
