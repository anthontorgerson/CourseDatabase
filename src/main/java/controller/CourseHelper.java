/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Oct 11, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Course;

/**
 * @author AnthonT
 *
 */
public class CourseHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CourseDatabase");
	
	public void insertEntry(Course e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	// creates a query to show all the entries in our database to our console program
	public List<Course>showAllEntries() {
		EntityManager em = emfactory.createEntityManager();
		List<Course>allEntries = em.createQuery("SELECT e FROM Course e").getResultList();
		return allEntries;
	}
	
	// takes the Course passed into it and searches for it by looking for the list entry by the course name and teacher name that's passed on
	public void deleteEntry(Course toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Course>typedQuery = em.createQuery("select e from Course e where e.courseName = :selectedCourseName and e.courseTeacher = :selectedCourseTeacher", Course.class);
		
		// substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCourseName", toDelete.getCourseName());
		typedQuery.setParameter("selectedCourseTeacher", toDelete.getCourseTeacher());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get the result and save it into a new list item
		Course result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Course searchForEntryById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Course found = em.find(Course.class, idToEdit);
		em.close();
		return found;
	}

	public void updateEntry(Course toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Course> searchForEntryByCourseName(String CourseName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Course> typedQuery = em.createQuery("select e from Course e where e.courseName = :selectedCourseName", Course.class);
		typedQuery.setParameter("selectedCourseName", CourseName);
		List<Course> foundEntries = typedQuery.getResultList();
		em.close();
		return foundEntries;
	}

	public List<Course> searchForEntryByCourseTeacher(String CourseTeacher) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Course> typedQuery = em.createQuery("select e from Course e where e.courseTeacher = :selectedCourseTeacher", Course.class);
		typedQuery.setParameter("selectedCourseTeacher", CourseTeacher);
		List<Course> foundEntries = typedQuery.getResultList();
		em.close();
		return foundEntries;
	}
	
	public void cleanUp(){
		emfactory.close();
		}
}
