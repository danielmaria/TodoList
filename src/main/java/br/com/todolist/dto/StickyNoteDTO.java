package br.com.todolist.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class StickyNoteDTO  {

	private String note;
	private UserDTO userOwner;
	private UserDTO userCreated;
	private Date dtToFinish;
	private Date dtDone;
	
	@NotNull(message = "O usuário dono da nota deve ser informado.")
	public UserDTO getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(UserDTO userOwner) {
		this.userOwner = userOwner;
	}

	@NotNull(message = "O usuário criador da nota deve ser informado.")
	public UserDTO getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(UserDTO userCreated) {
		this.userCreated = userCreated;
	}

	public Date getDtToFinish() {
		return dtToFinish;
	}
	public void setDtToFinish(Date dtToFinish) {
		this.dtToFinish = dtToFinish;
	}

	@NotNull(message = "A mensagem da nota não pode ser vazia.")
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
