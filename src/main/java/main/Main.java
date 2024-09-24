package main;

import beans.Employee;
import beans.PhoneNumber;
import hibernateutils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(session);

        try {

            Employee employee=new Employee();
            employee.setName("saket kumar keshri");

            PhoneNumber phoneNumber=new PhoneNumber( );
            phoneNumber.setPhNo("6789098789");
            phoneNumber.setEmployee(employee);

            PhoneNumber phoneNumber1=new PhoneNumber();
            phoneNumber1.setPhNo("123456");
            phoneNumber1.setEmployee(employee);

            List<PhoneNumber> phoneNumbers=new ArrayList<>();
            phoneNumbers.add(phoneNumber1);
            phoneNumbers.add(phoneNumber);

            employee.setPhoneNumber(phoneNumbers);

            employee.setAddr("Patna anand bazar dana");

            //session.persist(employee);
           // session.persist(employee2);



            // Fetching data from database
           Employee employee1= (Employee) session.get(Employee.class,Integer.parseInt("1"));

            System.out.println(employee1.getPhoneNumber());
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }


    }
}
