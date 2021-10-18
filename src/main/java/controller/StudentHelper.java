/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Oct 11, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Student;

/**
 * @author AnthonT
 *
 */
public class StudentHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CourseDatabase");
	
	public void insertEntry(Student e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	// creates a query to show all the entries in our database to our console program
	public List<Student>showAllEntries() {
		EntityManager em = emfactory.createEntityManager();
		List<Student>allEntries = em.createQuery("SELECT e FROM Student e").getResultList();
		return allEntries;
	}
	
	// takes the Student passed into it and searches for it by looking for the list entry by the student name that's passed on
	public void deleteEntry(Student toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student>typedQuery = em.createQuery("select e from Student e where e.studentName = :selectedStudentName", Student.class);
		
		// substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedStudentName", toDelete.getStudentName());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get the result and save it into a new list item
		Student result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Student searchForEntryById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Student found = em.find(Student.class, idToEdit);
		em.close();
		return found;
	}

	public void updateEntry(Student toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Student> searchForEntryByStudentName(String StudentName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("select e from Student e where e.studentName = :selectedStudentName", Student.class);
		typedQuery.setParameter("selectedStudentName", StudentName);
		List<Student> foundEntries = typedQuery.getResultList();
		em.close();
		return foundEntries;
	}
	
	// Added findStudent
	public Student findStudent(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("select sh from Student sh where sh.studentName = :selectedName", Student.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Student foundStudent;
		
		try {
			foundStudent = typedQuery.getSingleResult();
		} 
		catch (NoResultException ex) {
			foundStudent = new Student(nameToLookUp);
		}
		
		em.close();
		return foundStudent;
		}
	
	public void cleanUp(){
		emfactory.close();
		}
}
