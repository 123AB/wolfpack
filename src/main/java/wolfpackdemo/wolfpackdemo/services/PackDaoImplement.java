package wolfpackdemo.wolfpackdemo.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import wolfpackdemo.wolfpackdemo.model.Pack;


@Transactional
@Repository
@Component
public class PackDaoImplement implements PackDao {


    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Return all the pack stored in the database.
     */


    @Override
    public List<Pack> getAllPack() {
        String query="SELECT p FROM Pack p";
        return entityManager.createQuery(query).getResultList();

    }



    @Override
    public Pack findOne(Integer groupId) {
        return entityManager.find(Pack.class, groupId);
    }



    @Override
    public Pack createPack(Pack pack) {
        entityManager.persist(pack);
        int id = pack.getId();
        return entityManager.find(Pack.class, id);
    }



}
