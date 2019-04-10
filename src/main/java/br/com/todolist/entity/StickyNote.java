package br.com.todolist.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "STICKY_NOTE")
public class StickyNote implements Serializable {

	private static final long serialVersionUID = 1512091966798752879L;

	private Long id;
	private String note;
	private User userOwner;
	private User userCreated;
	private Date dtToFinish;
	private Date dtCreation;
	private Date dtEdit;
	private Date dtDone;
	
	@PrePersist
	public void prePersist() {
		dtCreation = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		dtEdit = new Date();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}
	@ManyToOne(cascade = CascadeType.DETACH)
	public User getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(User userCreated) {
		this.userCreated = userCreated;
	}
	public Date getDtToFinish() {
		return dtToFinish;
	}
	public void setDtToFinish(Date dtToFinish) {
		this.dtToFinish = dtToFinish;
	}
	public Date getDtCreation() {
		return dtCreation;
	}
	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}
	public Date getDtEdit() {
		return dtEdit;
	}
	public void setDtEdit(Date dtEdit) {
		this.dtEdit = dtEdit;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDtDone() {
		return dtDone;
	}

	public void setDtDone(Date dtDone) {
		this.dtDone = dtDone;
	}
	
}
