package br.edu.ifgoias.academico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Disciplina implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDisciplina;
	
	@Column(name = "nomedisciplina", nullable = false)
	private String nomeDisciplina;
	
	@Column(name = "cargaHoraria", nullable = false)
	private Integer cargaHoraria;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "aluno_disciplina",
				joinColumns = @JoinColumn(name = "idDisciplina"),
				inverseJoinColumns = @JoinColumn(name="idAluno"))
	private List<Aluno> listaAluno = new ArrayList<>();

	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "curso_disciplina",
				joinColumns = @JoinColumn(name = "idDisciplina"),
				inverseJoinColumns = @JoinColumn(name="idCurso"))
	private List<Curso> listaCurso = new ArrayList<>();
	
	public Disciplina() {

	}



	public Disciplina(Integer idDisciplina, String nomeDisciplina, Integer cargaHoraria) {
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
	}


	public List<Aluno> getListaAluno() {
		return listaAluno;
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}


	public void adicionarAluno(Aluno aluno) {
		if (!listaAluno.contains(aluno)) {
			listaAluno.add(aluno);
			aluno.adicionarDisciplina(this);
		}
		
	}
	
	public void adicionarCurso(Curso curso) {
		if (!listaCurso.contains(curso)) {
			listaCurso.add(curso);
			curso.adicionarDisciplina(this);
		}
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
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
		return Objects.hash(cargaHoraria, idDisciplina, nomeDisciplina);
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
		return Objects.equals(cargaHoraria, other.cargaHoraria) && Objects.equals(idDisciplina, other.idDisciplina)
				&& Objects.equals(nomeDisciplina, other.nomeDisciplina);
	}



	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", cargaHoraria="
				+ cargaHoraria + "]";
	}


}
