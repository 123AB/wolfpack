package wolfpackdemo.wolfpackdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wolfpackdemo.wolfpackdemo.model.Pack;
import wolfpackdemo.wolfpackdemo.model.Wolf;
import wolfpackdemo.wolfpackdemo.model.WolfPack;
import wolfpackdemo.wolfpackdemo.services.PackDao;
import wolfpackdemo.wolfpackdemo.services.WolfDao;


@RestController
public class WolfDemoController {

    @Autowired
    private WolfDao wolfDao;

    @Autowired
    private PackDao packdao;


    @PostMapping("/add")
    public String addWolf(@RequestParam String first, @RequestParam String last, @RequestParam String gender)  {
        Wolf wolf = new Wolf();
        wolf.setFirstName(first);
        wolf.setLastName(last);
        if(gender != null) {
            wolf.setGender(gender);
        }
        wolfDao.create(wolf);
        return "Added new wolf to repo!";
    }

    @PostMapping("/addPack")
    public String addPack(Integer groupId){
        Pack pack = new Pack();
        if(pack != null) {

        }
        packdao.createPack(pack);
        return "Added new pack to repo!";
    }

    @GetMapping("/list")
    public Iterable<Wolf> getWolfs() {
        return wolfDao.getAll();
    }

    @GetMapping("/findWolfById")
    public Wolf getWolfById(@RequestParam Integer wolfId) {
        return wolfDao.getWolfById(wolfId);
    }

    @PostMapping("/delete")
    public String deleteWolfById(@RequestParam Integer id){
        Boolean isDeleted = false;
        try{
            Wolf wolf = new Wolf(id);
            isDeleted = wolfDao.delete(wolf);
        }
        catch(Exception ex){

            System.out.println("Wolf not found to delete" + ex.getMessage());
            return "Error deleting the Wolf: " + ex.toString();

        }

        if(isDeleted){

            return "Wolf succesfully deleted!";

        }

        else{

            return "Error! Wolf deleted error!";

        }

    }


    @PostMapping("/group")
    public String groupWolfs(@RequestParam Integer wolfId, Integer groupId)  {

        if(wolfId != null & groupId != null){
            Pack pack = packdao.findOne(groupId);
            Wolf wolf = getWolfById(wolfId);
                wolfDao.addWolfPack(pack, wolf);

        }
        return "Added new wolf to repo!";
    }

    @GetMapping("/listGroupById")
    public WolfPack getPacksforGroup(@RequestParam Integer WolfPackId) {
        return wolfDao.getWolfFPackbyID(WolfPackId);
    }

    @GetMapping("/listPack")
    public Iterable<Pack> getPacks() {
        return packdao.getAllPack();
    }

}
