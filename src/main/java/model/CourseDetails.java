/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Oct 11, 2021
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author AnthonT
 *
 */
@Entity
public class CourseDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate startDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Student student;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Course> listOfCourses;

	public CourseDetails() {
		super();
	}

	public CourseDetails(int id, String listName, LocalDate startDate, Student student, List<Course> listOfCourses) {
		super();
		this.id = id;
		this.listName = listName;
		this.startDate = startDate;
		this.student = student;
		this.listOfCourses = listOfCourses;
	}

	public CourseDetails(String listName, LocalDate startDate, Student student, List<Course> listOfCourses) {
		super();
		this.listName = listName;
		this.startDate = startDate;
		this.student = student;
		this.listOfCourses = listOfCourses;
	}

	public CourseDetails(String listName, LocalDate startDate, Student student) {
		super();
		this.listName = listName;
		this.startDate = startDate;
		this.student = student;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the listOfCourses
	 */
	public List<Course> getListOfCourses() {
		return listOfCourses;
	}

	/**
	 * @param listOfCourses the listOfCourses to set
	 */
	public void setListOfCourses(List<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}
}
