package com.example.prodem.repository;

import com.example.prodem.entity.AccountEn;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountJpaRepository {


     public List<AccountEn> getAllAccount(){

         EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "MyPersistence" );

         EntityManager entitymanager = emfactory.createEntityManager( );

         CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
         CriteriaQuery<AccountEn> criteriaQuery = criteriaBuilder.createQuery(AccountEn.class);
         Root<AccountEn> studentRoot = criteriaQuery.from(AccountEn.class);
         criteriaQuery.select(studentRoot);
         TypedQuery<AccountEn> typedQuery = entitymanager.createQuery(criteriaQuery);
         List<AccountEn> studentList = typedQuery.getResultList();
         return studentList;


     }


    public AccountEn getAccountEnById(long id) {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "MyPersistence" );

        EntityManager entitymanager = emfactory.createEntityManager( );

        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
        CriteriaQuery<AccountEn> criteriaQuery = criteriaBuilder.createQuery(AccountEn.class);
        Root<AccountEn> accountRoot = criteriaQuery.from(AccountEn.class);
        criteriaQuery.select(accountRoot).where(criteriaBuilder.equal(accountRoot.get("id"), id));
        TypedQuery<AccountEn> typedQuery = entitymanager.createQuery(criteriaQuery);
        AccountEn accountEn = typedQuery.getSingleResult();
        return accountEn;
    }

    public List<AccountEn> getAccountsByParams(AccountEn accountEn) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "MyPersistence" );

        EntityManager entitymanager = emfactory.createEntityManager( );

        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
        CriteriaQuery<AccountEn> criteriaQuery = criteriaBuilder.createQuery(AccountEn.class);
        Root<AccountEn> accountRoot = criteriaQuery.from(AccountEn.class);
        criteriaQuery.select(accountRoot);

        List<Predicate> predicates = new ArrayList<>();

        if (accountEn.getId() != null ) {
            Predicate idPredicate = criteriaBuilder.equal(accountRoot.get("id"), accountEn.getId());
            predicates.add(idPredicate);
        }

        if (accountEn.getName() != null&& !accountEn.getName().isEmpty()) {
            Predicate pricePredicate = criteriaBuilder.equal(accountRoot.get("name"), accountEn.getName());
            predicates.add(pricePredicate);
        }

        if (accountEn.getBalance() != null ) {
            Predicate categoryPredicate = criteriaBuilder.greaterThan(accountRoot.get("balance"), accountEn.getBalance());
            predicates.add(categoryPredicate);
        }

        Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        criteriaQuery.where(finalPredicate);

        TypedQuery<AccountEn> typedQuery = entitymanager.createQuery(criteriaQuery);
        List<AccountEn> accountEnList = typedQuery.getResultList();
        return accountEnList;

    }
}
