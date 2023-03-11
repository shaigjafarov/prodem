package com.example.prodem.service;

import com.example.prodem.entity.AccountEn;
import com.example.prodem.entity.Teacher;
import com.example.prodem.repository.TeacherJpaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TeacherService {

    TeacherJpaRepository teacherJpaRepository = new TeacherJpaRepository();

    public void createTeacherWithStudents(Teacher teacher) {
  teacherJpaRepository.saveTeacher(teacher);
//        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
//        CriteriaQuery<Teacher> criteriaQuery = criteriaBuilder.createQuery(Teacher.class);
//        Root<AccountEn> studentRoot = criteriaQuery.from(AccountEn.class);
//        criteriaQuery.select(studentRoot);
//        TypedQuery<AccountEn> typedQuery = entitymanager.createQuery(criteriaQuery);
//        List<AccountEn> studentList = typedQuery.getResultList();




    }
}
