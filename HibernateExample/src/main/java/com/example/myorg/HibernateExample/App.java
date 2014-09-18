package com.example.myorg.HibernateExample;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.myorg.example.entities.Address;
import com.myorg.example.entities.Author;
import com.myorg.example.entities.Company;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
 {
		System.out.println("Starting the Sample Hibernate App ..");
		System.out.println("Starting the Sample Hibernate App ..");
		System.out.println("Starting the Sample Hibernate App ..");
		System.out.println("Hurrey GIT is working ..");

		Configuration config = new Configuration().configure();
		Session session = config.buildSessionFactory().openSession();
		session.beginTransaction();
		Set<Address> addressSet =new HashSet<Address>();
		
		Address address = new Address();
		address.setCity("SLC");
		address.setState("UT");
		address.setStreet("Fort Union Blvd");
		address.setZip("84047");
		addressSet.add(address);
		
		Address address1 = new Address();
		address1.setCity("Washington");
		address1.setState("DC");
		address1.setStreet("Georgia Avenue");
		address1.setZip("20906");
		
		addressSet.add(address1);
		
		Author author = new Author();
		author.setFirstName("John");
		author.setLastName("Grisham");
		author.setAddressess(addressSet);
		
		Company myCompany = new Company();
		myCompany.setAddresses(addressSet);
		myCompany.setCompanyName("Overstock");
		myCompany.setRevenue(new Double(12000000));
		
		
		
		
		address1.setAuthor(author);
		//address1.setCompany(myCompany);
		
		//address.setAuthor(author);
		address.setCompany(myCompany);
		session.persist(myCompany);
		
		session.persist(author);
//		session.persist(address);
//		session.persist(address1);
		
		session.getTransaction().commit();
		
		System.out.println("Entity should be saved now ..get it from session :"
				+ session.createCriteria(Address.class)
						.add(Restrictions.like("city", "Washington")).list());
		session.close();

	}
}
