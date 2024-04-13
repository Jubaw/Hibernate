package com.hb02.embeddable;


import javax.persistence.*;
@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id //Primary Key
    private int id;

    @Column(name = "student_name",length = 100,nullable = false,unique = false)
    private String name;

    private int grade;

    @Embedded //opsiyonel, kod okunurluğu için.
    private Adress adress; //getAdress

    //NOT: Getter - Setter *************************


    public int id() {
        return id;
    }

    public Student02 setId(int id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public Student02 setName(String name) {
        this.name = name;
        return this;
    }

    public int grade() {
        return grade;
    }

    public Student02 setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public Adress getAdress() {
        return adress;
    }

    public Student02 setAdress(Adress adress) {
        this.adress = adress;
        return this;
    }


    //NOT: toString methodu ************************

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }





}
