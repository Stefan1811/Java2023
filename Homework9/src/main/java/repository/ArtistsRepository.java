package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static main.EntityManagerFactoryS.getEm;
import models.Artists;


public class ArtistsRepository extends AbstractRepository<Artists>{
    EntityManager  entityManager;

    public ArtistsRepository() {
        super(Artists.class);
        entityManager=getEm();
    }

    public List<Artists> findByName(String name) {
        entityManager.getTransaction().begin();
        TypedQuery<Artists> query = entityManager.createNamedQuery("Artists.findByTitle", Artists.class);
        query.setParameter("name", name);
        List<Artists> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }
}
