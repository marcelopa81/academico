package br.edu.ifgoias.academico.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.AlunoRepository;
import br.edu.ifgoias.academico.repositories.CursoRepository;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Configuration
public class Config implements CommandLineRunner {

	
	@Autowired
	private CursoRepository cursoRep;
	
	@Autowired
	private DisciplinaRepository discRep;
	
	private AlunoRepository alunoRep;
	
	@Override
	public void run(String... args) throws Exception {

		//Curso c1 = new Curso(null, "Spring");
		//Curso c2 = new Curso(null, "RestFull");
		
		//cursoRep.save(c1);
		//cursoRep.save(c2);
		
		
		//System.out.println("Quantidade de cursos: " + cursoRep.count());
		
		
		//Disciplina d3 = new Disciplina();
		//d3.setNomeDisciplina("Lógica de programação");
		//d3.setCargaHoraria(54);
		
		//discRep.save(d3);
		
		
	}

}
