package com.sahoo.camel.aries.example.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.sahoo.camel.aries.example.domain.base.BaseAware;
import com.sahoo.camel.aries.example.domain.base.StudentBaseListener;
import com.sahoo.camel.aries.example.domain.base.StudentsBase;

@NamedQueries({
	@NamedQuery(name="StudentsResultDBO.findPercentageById",
			query="SELECT s.percentage FROM StudentsResultDBO s WHERE s.id=:id")
})

@Entity
@Table(name="STUDENTS_RESULT")
@EntityListeners(StudentBaseListener.class)
public class StudentsResultDBO implements BaseAware, Serializable {
	
	private static final long serialVersionUID = -3466133454311181946L;
	
	@Id
	private Long id;
	
	@Column(name="FIRST_NAME", length=30)
	private String firstName;
	
	@Column(name="LAST_NAME", length=30)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="PERCENTAGE")
	private Double percentage;
	
	@Version
	@Column(name="JPA_VERSION_NUMBER")
	private Long jpaVersionNumber;
	
	@Embedded
	private StudentsBase studentsBase;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public StudentsBase getStudentsBase() {
		if(studentsBase == null) {
			studentsBase = new StudentsBase();
		}
		return studentsBase;
	}

	public void setStudentsBase(StudentsBase studentsBase) {
		this.studentsBase = studentsBase;
	}

	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
