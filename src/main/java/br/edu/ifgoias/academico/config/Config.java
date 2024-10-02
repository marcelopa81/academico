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
	
	@Autowired
	private AlunoRepository alunoRep;
	
	@Override
	public void run(String... args) throws Exception {

		//Curso c1 = new Curso(null, "Spring");
		//Curso c2 = new Curso(null, "RestFull");
		
		//cursoRep.save(c1);
		//cursoRep.save(c2);
		
		
		
		//System.out.println("Quantidade de cursos: " + cursoRep.count());
		
		
		//Disciplina d1 = new Disciplina();
	//	d1.setNomeDisciplina("Cálculo 1");
		//d1.setCargaHoraria(128);
		
		//System.out.println("Carga Horaria: " + d1.getCargaHoraria());

		
		//discRep.save(d1);
		
		
		Optional<Aluno> alunoOptional = alunoRep.findById(1);
		if (alunoOptional.isPresent()) {
		    Aluno aluno = alunoOptional.get();

		    // Crie a disciplina e associe o aluno
		    Disciplina d1 = new Disciplina();
		    d1.setNomeDisciplina("Cálculo 1");
		    d1.setCargaHoraria(128);
		    //d1.setAluno(aluno); // Setando o aluno

		    // Salve a disciplina no banco de dados
		    discRep.save(d1);

		    System.out.println("Disciplina salva com aluno: " + aluno.getNome());
		}
	}

}
