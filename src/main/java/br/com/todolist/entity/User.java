package br.com.todolist.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = -6035452453698375006L;
	
	private Long id;
	private String name;
	private String login;
	private String password;
	private Date dtCreation;
	private Date dtEdit;
	
	public User() {
	}
	
	@PrePersist
	public void prePersist() {
		dtCreation = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		dtEdit = new Date();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	@Column(unique=true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@NotBlank
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDtEdit() {
		return dtEdit;
	}

	public void setDtEdit(Date dtEdit) {
		this.dtEdit = dtEdit;
	}
	
	
	
}
