package wolfpackdemo.wolfpackdemo.services;

import wolfpackdemo.wolfpackdemo.model.Pack;
import wolfpackdemo.wolfpackdemo.model.Wolf;
import wolfpackdemo.wolfpackdemo.model.WolfPack;

import java.util.List;

public interface PackDao{

    Pack createPack(Pack pack);

    Pack findOne(Integer groupId);

    List<Pack> getAllPack();


}
