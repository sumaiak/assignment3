package pointExercise;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lyngby.dk.UniCorn.HibernateConfig;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PointDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    @BeforeAll
    public static void setUp() {
        emf = HibernateConfig.getEntityManagerFactoryConfig();
        em = emf.createEntityManager();
    }

    @AfterAll
    public static void tearDown() {
            em.close();
        }



    @Test
    public void testStore1000Points() {
        int result = PointDAO.store1000Points();
        assertEquals(1, result);
    }

    @Test
    public void testNumberOfPointObjects() {
        int count = PointDAO.numberOfPointObjects();
        assertEquals(1000, count);
    }

    @Test
    public void testFindTheAverageX() {
        double averageX = PointDAO.findTheAverageX(8);
        assertEquals(499.5, averageX);
    }

    @Test
    public void testRetrieveAllThePointObjects() {
        List<Point> points = PointDAO.retrieveAllThePointObjects();
        assertEquals(1000, points.size());
    }
}