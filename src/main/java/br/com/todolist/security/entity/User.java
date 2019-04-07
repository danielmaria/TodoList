package br.com.todolist.security.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import br.com.todolist.security.enums.RoleEnum;

@Entity
@Table(name = "USER")
public class User implements Serializable{

	private static final long serialVersionUID = -6035452453698375006L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Date dtCreation;
	private Date dtEdit;
	private RoleEnum role;
	
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
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	@Column(unique=true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	@Column(name = "PASSWORD", nullable = false)
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

	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", nullable = false)
	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
	
}
