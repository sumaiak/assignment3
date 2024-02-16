package DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
public class StudentDao implements  Student {
    EntityManager entityManager;

    @Override
    public void create(Student student) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
    }

    @Override
    public Student read(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void update(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(student);
        transaction.commit();

    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Student1 student1 = entityManager.find(Student1.class, id);
        if (student1 != null) {
            entityManager.remove(student1);
        }
        transaction.commit();

    }


}