package br.edu.ifgoias.academico.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.services.DisciplinaService;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "disciplinas")

public class DisciplinaRecurso {
	@Autowired
	private DisciplinaService servico;

	@GetMapping
	public ResponseEntity<List<Disciplina>> findAll() {
		List<Disciplina> disciplinas = servico.findAll();
		return ResponseEntity.ok().body(disciplinas);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Disciplina> findAll(@PathVariable Integer id) {
		Disciplina disciplina = servico.findById(id);
		return ResponseEntity.ok().body(disciplina);
	}
}
