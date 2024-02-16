package lyngby.dk.UniCorn;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import lombok.ToString;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        EntityManager em = emf.createEntityManager();

        Unicorn uni = new Unicorn("sumaia", 23, 20);
        Unicorn uni2 = new Unicorn("micchel", 36, 40);
        UnicornDAO unicorn = new UnicornDAO();
        unicorn.save(uni2);
        uni.setName("fatma kalash");
        uni.setPowerStrength(30);
        unicorn.update(uni);
        Unicorn unicornById = unicorn.findById(2);
        unicorn.delete(1);
        System.out.println("------------------------------");
        System.out.println("these are the attributes of id 2 :" + unicornById.getName() +" ,"+ unicornById.getAge()+" ,"+ unicornById.getPowerStrength());







        em.getTransaction().begin();
        em.persist(uni);
        em.getTransaction().commit();
        em.close();
        System.out.println(uni.toString());

    }

}
