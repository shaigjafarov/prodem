package com.example.prodem.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "myschema", name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "name")
    String ad;


    @Column(name = "surname")
    String soyad;


    @Column(name = "birhtdate")
    LocalDate dogumTarixi;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    public Student(String ad, String soyad, LocalDate dogumTarixi, Teacher teacher ) {
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarixi = dogumTarixi;
        this.teacher =teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public LocalDate getDogumTarixi() {
        return dogumTarixi;
    }

    public void setDogumTarixi(LocalDate dogumTarixi) {
        this.dogumTarixi = dogumTarixi;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
