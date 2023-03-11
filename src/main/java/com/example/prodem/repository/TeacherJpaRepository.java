package com.example.prodem.repository;

import com.example.prodem.entity.Teacher;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TeacherJpaRepository {


    public void saveTeacher(Teacher teacher) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MyPersistence");

        EntityManager entityManager = emfactory.createEntityManager();

//        Query query = em.createNativeQuery("INSERT INTO myschema.teacher ( name, surname, groupname) VALUES (:name , :surname, :groupname);");
//        em.getTransaction().begin();
//        query.setParameter("name", teacher.getAd());
//        query.setParameter("surname", teacher.getSoyad());
//        query.setParameter("groupname", teacher.getGroupName());
//        query.executeUpdate();
//        em.getTransaction().commit();

//        teacher.getStudents().forEach(student -> student.setTeacher(teacher));
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
