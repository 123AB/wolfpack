package wolfpackdemo.wolfpackdemo.model;

//import javax.persistence.*;

import javax.persistence.*;

@Entity
public class WolfPack{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer groupId;

     @OneToOne
     private Wolf wolf;

     @OneToOne
     private Pack pack;

    private String groupName;

    public WolfPack(){}

    public WolfPack(Integer id, Integer groupId){
        this.id  = id;
        this.groupId = groupId;
    }

    public WolfPack(Wolf wolf, Pack pack){
          this.wolf  = wolf;
          this.pack = pack;
    }

    public Integer getId() {
        return id;
    }

    public Wolf getWolf() {
        return wolf;
    }

    public void setWolf(Wolf wolf) {
        this.wolf = wolf;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public String toString(){
        String wolfPackResult = wolf.getId() + wolf.getFirstName() + wolf.getLastName() + wolf.getGender() + pack.getId();
        return wolfPackResult;
    }



}
