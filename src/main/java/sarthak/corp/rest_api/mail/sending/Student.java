package sarthak.corp.rest_api.mail.sending;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_mail")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Integer stdId;
	
	@Column
	private String stdName;
	@Column
	private Integer stdRoll;
	@Column
	private Long stdMob;
	
	@Column(name = "mail")
	private String stdMail;
	
	
	public Student() {
		super();
	}


	public Student( String stdName, Integer stdRoll, Long stdMob, String stdMail) {
		super();
		this.stdName = stdName;
		this.stdRoll = stdRoll;
		this.stdMob = stdMob;
		this.stdMail = stdMail;
	}


	public Integer getStdId() {
		return stdId;
	}


	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}


	public String getStdName() {
		return stdName;
	}


	public void setStdName(String stdName) {
		this.stdName = stdName;
	}


	public Integer getStdRoll() {
		return stdRoll;
	}


	public void setStdRoll(Integer stdRoll) {
		this.stdRoll = stdRoll;
	}


	public Long getStdMob() {
		return stdMob;
	}


	public void setStdMob(Long stdMob) {
		this.stdMob = stdMob;
	}


	public String getStdMail() {
		return stdMail;
	}


	public void setStdMail(String stdMail) {
		this.stdMail = stdMail;
	}


	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdRoll=" + stdRoll + ", stdMob=" + stdMob
				+ ", stdMail=" + stdMail + "]";
	}
	
	
	

}
