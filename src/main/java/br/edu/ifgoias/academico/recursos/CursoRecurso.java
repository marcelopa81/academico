package br.edu.ifgoias.academico.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.services.CursoService;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "cursos")
public class CursoRecurso {
	
	@Autowired
	private CursoService servico;
	
	@GetMapping
	public ResponseEntity< List<Curso> > findAll() {
		List<Curso> cursos = servico.findAll();
		return ResponseEntity.ok().body(cursos);
	}
}
