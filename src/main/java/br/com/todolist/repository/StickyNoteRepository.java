package br.com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todolist.entity.StickyNote;

public interface StickyNoteRepository extends JpaRepository<StickyNote, Long>{

}
