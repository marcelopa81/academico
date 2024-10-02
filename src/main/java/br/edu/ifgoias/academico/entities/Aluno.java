package br.edu.ifgoias.academico.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Aluno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idaluno;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "sexo", nullable = false)
	private String sexo;
	
	@Column(name = "dt_nasc", nullable = false)
	private Date dt_nasc;
	
	 @ManyToMany
	    @JoinTable(
	        name = "aluno_disciplina",
	        joinColumns = @JoinColumn(name = "idaluno"),
	        inverseJoinColumns = @JoinColumn(name = "idedisciplina")
	    )
	    private Set<Disciplina> listaDisciplina = new HashSet<>();

	    @ManyToMany
	    @JoinTable(
	        name = "aluno_curso",
	        joinColumns = @JoinColumn(name = "idaluno"),
	        inverseJoinColumns = @JoinColumn(name = "idcurso")
	    )
	    private Set<Curso> listaCurso = new HashSet<>();

	    public Aluno() {}

	    public Aluno(Integer idaluno, String nome, String sexo, Date dt_nasc) {
	        this.idaluno = idaluno;
	        this.nome = nome;
	        this.sexo = sexo;
	        this.dt_nasc = dt_nasc;
	    }

	    public Set<Disciplina> getListaDisciplina() {
	        return listaDisciplina;
	    }

	    public Set<Curso> getListaCurso() {
	        return listaCurso;
	    }

	    public void adicionarDisciplina(Disciplina d) {
	        if (listaDisciplina.add(d)) {
	            d.getListaAluno().add(this);
	        }
	    }

	    public void adicionarCurso(Curso curso) {
	        if (listaCurso.add(curso)) {
	            curso.getListaAluno().add(this);
	        }
	    }
	    
	public Integer getIdaluno() {
		return idaluno;
	}

	public void setIdaluno(Integer idaluno) {
		this.idaluno = idaluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dt_nasc, idaluno, nome, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(dt_nasc, other.dt_nasc) && Objects.equals(idaluno, other.idaluno)
				&& Objects.equals(nome, other.nome) && Objects.equals(sexo, other.sexo);
	}

	@Override
	public String toString() {
		return "Aluno [idaluno=" + idaluno + ", nome=" + nome + ", sexo=" + sexo + ", dt_nasc=" + dt_nasc + "]";
	}
	
}