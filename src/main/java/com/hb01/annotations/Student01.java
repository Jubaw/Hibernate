package com.hb01.annotations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity //Entity koyduğumuz sınıf, veritabanında bir tabloya karşılık gelecek.
@Table(name = "t_student01")//!!! Eğer oluşacak tablo ismini değiştirmek istenirse name attribute ile
// bir tablo ismi verilir.
//!!!@Table ile isim değiştirilmese idi, DB'de (küçük harfle) student01 isminde tablo oluşturacaktı.
public class Student01 { //student01

    @Id //!!! @Id ---> primary key oluşturmayı sağlıyor.Primary key relation oluşturmaya yarar.
    @Column(name = "std_id")
    private int id;

    @Column(name = "student_name",length = 100,nullable = false,unique = false)
    private String name; //255 karakter

    //@Transient //!!! @Transient --> veritabanı tablosunda "grade" adında bir kolon oluşturulmaz. kod içinde
    // kullanılmak için bir değişken oluştururuz ama bu sınıf DB ye kaydedileceği
    // zaman ilgili tabloya kolon olarak eklenmez
    private int grade;








}
