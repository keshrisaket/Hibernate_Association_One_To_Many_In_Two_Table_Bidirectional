package beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "Employee_Name",nullable = false,length = 50)
    private String name;

    @Column(name = "Employee_Addr",nullable = false,length = 50)
    private String addr;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee",orphanRemoval = true)
    private List<PhoneNumber> phoneNumber;


    // orphanRemoval = true makes sure that any PhoneNumber removed from the list will also be deleted from the database.


    //In other words, mappedBy tells Hibernate that the foreign key is managed by the other side of the relationship. The entity that does not use the mappedBy is the owning side, and it is responsible for managing the database relationship (like setting the foreign key).


   public String toString(){
        return  name+" "+addr+" ";
    }

}
