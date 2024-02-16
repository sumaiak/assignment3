package DAO;

public interface Student {

        void create(Student student);

        Student read(int id);

        void update(Student student);

        void delete(int id);
    }
