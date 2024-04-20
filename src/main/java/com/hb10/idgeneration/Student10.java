package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
public class Student10 {

    /*
   GenerationType.Sequence ---> Oracle DB - PostgreSQL kullanir, Sequence ( kontrolü
            developera bırakır, Id üretilirken başlangıç değeri veya kaç tane id cachelenecek
            gibi bilgileri developer setliyebilir)

   GenerationType.IDENTITY ---> MySQL - Microsoft SQL  kullanir, IDENTITY ( kontrol DB de ,
            kendi yapısına göre ıd oluşturur, içlerindeki en basitidir)

   GenerationType.AUTO ---> Hibernate otomatik olarak kullanilan DB ye gore stratejiyi belirler

   GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id üretmek için
            ekstra tablo oluşturuyor
 */

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",
            sequenceName = "student_seq", //sequence name that will be created in DB
            initialValue = 1000, // id starts from 1000
            allocationSize = 10 //Cache 10 ID  in DB,default is 50.
    )
    private int id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;

    public int getId() {
        return id;
    }

//    public void setId(int id) { //strategy = GenerationType.IDENTITY olduğu için
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
