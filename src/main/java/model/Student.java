package model;

/**
 * @author Dylan Thomas - djthomas4 
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students") // Changed table name to students
public class Student {
	// attributes
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="StudentName")
	private String studentName;
	
	// default no args constructor
	public Student() {
		super();
	}
	
	// constructor with args
	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	// toString method
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}
}
