package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

public class DisciplinaService {
	@Autowired
	private DisciplinaRepository discRep;

	public List<Disciplina> findAll() {
		return discRep.findAll();
	}

	public Disciplina findById(Integer id) {
		return discRep.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Disciplina insert(Disciplina d) {
		return discRep.save(d);
	}

	public void delete(Integer id) {
		discRep.deleteById(id);
	}

	public Disciplina update(Integer id, Disciplina disciplinaAlterada) {
		return discRep.findById(id).map(cursoDB -> {
			cursoDB.setNomeDisciplina(disciplinaAlterada.getNomeDisciplina());
			return discRep.save(cursoDB);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)

		);

	}
}
