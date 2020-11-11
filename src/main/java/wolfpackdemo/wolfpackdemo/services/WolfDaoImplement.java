package wolfpackdemo.wolfpackdemo.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import wolfpackdemo.wolfpackdemo.model.Pack;
import wolfpackdemo.wolfpackdemo.model.Wolf;
import wolfpackdemo.wolfpackdemo.model.WolfPack;

@Transactional
@Repository
@Component
public class WolfDaoImplement implements WolfDao {


    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Return all the wolf stored in the database.
     */
    @Override
    public List<Wolf> getAll() {
        String query="SELECT w FROM Wolf w";
        return entityManager.createQuery(query).getResultList();

    }

    /*
    @Override
    public List<Pack> getAllPack() {
        String query="SELECT p FROM Pack p";
        return entityManager.createQuery(query).getResultList();

    }

     */

    @Override
    public List<Pack> getAllWolfFPack() {
        String query="SELECT Wolf, Pack FROM WolfPack";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public WolfPack getWolfFPackbyID(Integer id) {
        return entityManager.find(WolfPack.class, id);
    }

    @Override
    public Wolf getWolfById(Integer id) {
        return entityManager.find(Wolf.class, id);
    }

    /**
     * Save the Wolf in the database.
     */
    @Override
    public Wolf create(Wolf wolf) {
        entityManager.persist(wolf);
        int id = wolf.getId();
        return entityManager.find(Wolf.class, id);
    }

    /**
     * delete the employee in the database.
     */
    @Override
    public boolean delete(Wolf wolf) {
        if (entityManager.contains(wolf)) {
            entityManager.remove(wolf);
        }
        else {
            entityManager.remove(entityManager.merge(wolf));
        }
        return true;
    }


    @Override
    public WolfPack addWolfPack(Pack pack, Wolf wolf){
        WolfPack wolfpack = new WolfPack();
        wolfpack.setPack(pack);
        wolfpack.setWolf(wolf);
        entityManager.persist(wolfpack);
        int id = wolfpack.getId();
        return entityManager.find(WolfPack.class, id);
    }

    /*
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

*/

}
