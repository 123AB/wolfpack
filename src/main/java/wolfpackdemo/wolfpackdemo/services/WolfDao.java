package wolfpackdemo.wolfpackdemo.services;

import wolfpackdemo.wolfpackdemo.model.Pack;
import wolfpackdemo.wolfpackdemo.model.Wolf;
import wolfpackdemo.wolfpackdemo.model.WolfPack;

import java.util.List;

public interface WolfDao{

    List<Wolf> getAll();

    Wolf getWolfById(Integer  id);

    WolfPack getWolfFPackbyID(Integer id);

    /**
     * Save the Wolf in the database.
     */
    Wolf create(Wolf wolf);



    /**
     * delete the employee in the database.
     */
    boolean delete(Wolf wolf);

    WolfPack addWolfPack(Pack pack, Wolf wolfd);

    List<Pack> getAllWolfFPack();




}
