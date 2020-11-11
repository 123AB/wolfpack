package wolfpackdemo.wolfpackdemo.model;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//this is the wolf model class
public class Wolf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    private String gender;

    public Wolf(){}

    public Wolf(Integer id){ this.id  = id; }

    public Wolf(String firstName, String lastName, String gender){this.firstName = firstName; this.lastName = lastName; this.gender = gender;}

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public Boolean delete(Integer id){return true; }


}
