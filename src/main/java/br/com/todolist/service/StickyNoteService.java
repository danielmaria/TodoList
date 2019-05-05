package br.com.todolist.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.dto.StickyNoteDTO;
import br.com.todolist.entity.StickyNote;
import br.com.todolist.entity.builder.StickyNoteBuilder;
import br.com.todolist.repository.StickyNoteRepository;
import br.com.todolist.service.interfaces.IStickyNoteService;
import br.com.todolist.utils.Response;

@Service
public class StickyNoteService implements IStickyNoteService {
	
	@Autowired
	private StickyNoteRepository stickyNoteRepository;

	public Response<StickyNoteDTO> createStickyNote(@Valid StickyNoteDTO dto) {
		Response<StickyNoteDTO> response = new Response<>();
		StickyNote stick = StickyNoteBuilder.newStickNote()
							.withNote(dto.getNote())
							.wasCreatedBy(dto.getUserCreated().getId())
							.belongingBy(dto.getUserOwner().getId())
							.now();
		stickyNoteRepository.save(stick);
		response.setData(dto);
		return response;
	}

}
