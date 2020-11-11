package wolfpackdemo.wolfpackdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Pack(){}

    public Pack(Integer id){ this.id  = id;}

    public Integer getId() {
        return id;
    }



}
