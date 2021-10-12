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

import model.CourseDetails;

/**
 * @author AnthonT
 *
 */
public class CourseDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CourseDatabase");

	public void insertNewCourseDetails(CourseDetails e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	public List<CourseDetails> getListName() {
		EntityManager em = emfactory.createEntityManager();
		List<CourseDetails> allDetails = em.createQuery("SELECT e FROM CourseDetails e").getResultList();
		return allDetails;
	}

	public void deleteList(CourseDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CourseDetails> typedQuery = em.createQuery("select detail from CourseDetails detail where detail.id = :selectedId", CourseDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		CourseDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	public CourseDetails searchForCourseDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CourseDetails found = em.find(CourseDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateList(CourseDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
