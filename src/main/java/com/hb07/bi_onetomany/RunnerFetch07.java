package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerFetch07 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        /*Student07 student07 = session.get(Student07.class,1001);
        student07.getBookList().forEach(System.out::println);*/

/*        String hqlQuery1 = " SELECT s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id = b.student.id";
        List<Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
        resultList1.forEach(t-> System.out.println(Arrays.toString(t)));*/

        //Delete process HQL
/*
        String hqlQuery2 = "DELETE FROM Book07";
        int numOfRecord = session.createQuery(hqlQuery2).executeUpdate();
        System.out.println("Effected row count: "+numOfRecord);
*/

/*        String hqlQuery3 = "DELETE FROM Student07";
        int numOfRecord2 = session.createQuery(hqlQuery3).executeUpdate();
        System.out.println("Effected row count: " + numOfRecord2);*/

//        TASK 1001 ID'li öğrenciiy sil.
//        String hqlQuery4 = "DELETE FROM Student07 s WHERE s.id = 1001";
//        int numOfRecord = session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println("Deleted rows: " + numOfRecord);

        //Not : Kitabı olan öğrenciyi silmeye çalışırsam hata alacağım,
        // bunu çözmek için :
        // 1.YOL: Öğrenciye ait bütün kitapları silip sonra öğrenciyi silebiliriz.
        // 2.YOL: Student entity clasına orphanRemoval veya cascade eklenmeli
//        Student07 student2 = session.get(Student07.class,1001);
//        session.delete(student2);

        Student07 student3 = session.get(Student07.class,1002);
        student3.getBookList().set(0,null); //Triggers orphan removal






        tx.commit();
        session.close();
        sf.close();
    }
}
