package br.com.todolist.entity.builder;

import br.com.todolist.entity.StickyNote;
import br.com.todolist.entity.User;

public class StickyNoteBuilder {
	
	private StickyNote stickyNote;
	
	private StickyNoteBuilder() {}
	
	public static StickyNoteBuilder newStickNote() {
		StickyNoteBuilder builder = new StickyNoteBuilder();
		builder.stickyNote = new StickyNote();
		return builder;
	}
	
	public StickyNoteBuilder withNote(String note){
		this.stickyNote.setNote(note);
		return this;
	}
	
	public StickyNoteBuilder wasCreatedBy(Long idUserCreator){
		User user = new User();
		user.setId(idUserCreator);
		this.stickyNote.setUserCreated(user);
		return this;
	}
	
	public StickyNoteBuilder belongingBy(Long idUserOwner){
		User user = new User();
		user.setId(idUserOwner);
		this.stickyNote.setUserOwner(user);
		return this;
	}
	
	public StickyNote now() {
		return stickyNote;
	}

}
