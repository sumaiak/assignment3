package part2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lyngby.dk.UniCorn.HibernateConfig;
import lyngby.dk.UniCorn.Unicorn;

import java.util.List;

public class Main {
    public static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();


    public static void main(String[] args) {
        Student s =new Student("sumaia","kalash","skdk12945@gmail.com",28);
        createStudent(s);
        findStudentByid(1);
        updateStudent(s);





    }
    public static void createStudent(Student student){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        System.out.println(student);


    }
    public static Student findStudentByid(int id){

        EntityManager em = emf.createEntityManager();
        Student foundStudent = em.find(Student.class, id);
        em.close();
        return foundStudent;






    }
    public static Student updateStudent(Student student)    {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student updatedStudent = em.merge(student);
        em.getTransaction().commit();
        em.close();
        return updatedStudent;
    }
    public static void deleteStudent(int id){

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = findStudentByid(id);
        if (student != null)
        {
            em.remove(student);
        }
        em.getTransaction().commit();
        em.close();



    }
    public static List<Student> readAllStudents(){
            EntityManager em = emf.createEntityManager();
                var query = em.createQuery("select s FROM Student s", Student.class);
                return query.getResultList(); // Objects are detached after method returns
            }


    }
