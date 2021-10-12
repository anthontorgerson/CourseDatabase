/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Oct 11, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entries")
public class Course {
	// attributes
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="CourseName")
	private String courseName;
	@Column(name="CourseTeacher")
	private String courseTeacher;
	
	// default no args constructor
	public Course() {
		super();
	}
	
	// constructor with args
	public Course(String courseName, String courseTeacher) {
		super();
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	// toString method
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseTeacher=" + courseTeacher + "]";
	}
	

}