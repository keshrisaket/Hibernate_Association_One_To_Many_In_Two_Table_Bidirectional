package beans;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhoneNumber")
public class PhoneNumber {

    public PhoneNumber(String phNo) {
        this.phNo=phNo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PhoneNumber_Id")
    private int id;


    @Column(name = "Phone_No",nullable = false,unique = true)
    private String phNo;



    @ManyToOne
    @JoinColumn(name = "Employee_Id",nullable = false)
    private Employee employee;



}
