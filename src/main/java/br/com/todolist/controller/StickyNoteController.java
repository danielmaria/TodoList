package br.com.todolist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.dto.StickyNoteDTO;
import br.com.todolist.service.StickyNoteService;
import br.com.todolist.utils.Response;

@RestController
@RequestMapping("/stickyNote")
public class StickyNoteController {
	@Autowired
	private StickyNoteService stickyNoteService;
	
	@PostMapping
	public ResponseEntity<Response<StickyNoteDTO>> createStickyNote(@Valid @RequestBody StickyNoteDTO stickyNote, BindingResult result) {
		if(result.hasErrors()) {
			return new Response<StickyNoteDTO>().returnAllErrors(result);
		}
		
		Response<StickyNoteDTO> response = stickyNoteService.createStickyNote(stickyNote);
		if(response.hasErrors()) {
			return ResponseEntity.badRequest().body(response);	
		}
		return ResponseEntity.ok(response);
	}

}
