package com.michael;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta= new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory= meta.getSessionFactoryBuilder().build();
    	Session session=factory.openSession();
    	Transaction t1= session.beginTransaction();
    	Student student= new Student("Messi","Chaib", "ComputerScience");
    	Address address=new Address("11126 Highfield Ct","BethtelPark","USA");
    	session.save(student);
    	student.setAddress(address);
    	address.setStudent(student);
    	session.save(student);
    	t1.commit();
    	@SuppressWarnings("unchecked")
    	List<Student> students= (List<Student>)session.createQuery("from Student").list();
    	
    	for(Student s:students)
    		System.out.println("Details: "+s);
    	session.close();
    	factory.close();
    }
}
