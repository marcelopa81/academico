package br.edu.ifgoias.academico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Disciplina implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddisciplina;
	
	@Column(name = "nomedisciplina", nullable = false)
	private String nomeDisciplina;
	
	@Column(name = "cargahoraria", nullable = false)
	private Integer cargaHoraria;

	@ManyToMany(mappedBy = "listaDisciplina")
    private List<Aluno> listaAluno = new ArrayList<>();

	
		
	public Disciplina() {

	}



	public Disciplina(Integer idDisciplina, String nomeDisciplina, Integer cargaHoraria) {
		this.iddisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
	}


	  public List<Aluno> getListaAluno() {
	        return listaAluno;
	    }


	public void adicionarAluno(Aluno aluno) {
        if (!listaAluno.contains(aluno)) {
            listaAluno.add(aluno);
            aluno.getListaDisciplina().add(this); // Adiciona a disciplina na lista de disciplinas do aluno
        }
    }
	

	public void setIdDisciplina(Integer idDisciplina) {
		this.iddisciplina = idDisciplina;
	}



	public String getNomeDisciplina() {
		return nomeDisciplina;
	}



	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}



	public Integer getCargaHoraria() {
		return cargaHoraria;
	}



	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cargaHoraria, iddisciplina, nomeDisciplina);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(cargaHoraria, other.cargaHoraria) && Objects.equals(iddisciplina, other.iddisciplina)
				&& Objects.equals(nomeDisciplina, other.nomeDisciplina);
	}



	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + iddisciplina + ", nomeDisciplina=" + nomeDisciplina + ", cargaHoraria="
				+ cargaHoraria + "]";
	}


}
