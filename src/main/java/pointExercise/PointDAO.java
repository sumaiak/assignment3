package pointExercise;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lyngby.dk.UniCorn.HibernateConfig;

import java.util.List;

public class PointDAO {

        public static int store1000Points() {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
            EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                for (int i = 0; i < 1000; i++) {
                    Point p = new Point(i, i);
                    em.persist(p);
                }
                em.getTransaction().commit();
                return 1;
            }



    public static int numberOfPointObjects() {
        try (EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig()) {
            try (EntityManager em = emf.createEntityManager()) {
                Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
                long count = (long) q1.getSingleResult();
                return (int) count;
            }
        }
    }

    public static double findTheAverageX(int x) {
        try (EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig()) {
            try (EntityManager em = emf.createEntityManager()) {
                Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
                return (double) q2.getSingleResult();
            }
        }
    }

    public static List<Point> retrieveAllThePointObjects() {
        try (EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig()) {
            try (EntityManager em = emf.createEntityManager()) {
                TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
                List<Point> results = query.getResultList();
                return results;
            }
        }
    }
}