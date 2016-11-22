package br.com.fema.academicofx.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ProfessorVO extends AbstractVO{
	private String matricula;
	private String nome;
	private String sexo;
	private Date dataNascimento;
	private Date dataMatricula;
	private BigDecimal valorSalario;
	private TitulacaoAcademica titulacao;
	private CursoVO curso;
	
	public ProfessorVO(){
		super();
	}
	
	public ProfessorVO(Long id, 
			String matricula, 
			String nome, 
			String sexo,
			Date dateNascimento,
			Date dateMatricula,
			BigDecimal valorSalario,
			TitulacaoAcademica titulacao,
			CursoVO curso){
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.dataMatricula = dataMatricula;
		this.valorSalario = valorSalario;		
		this.titulacao = titulacao;
		this.curso = curso;
	}
	
	public ProfessorVO(
			String matricula, 
			String nome, 
			String sexo,
			Date dateNascimento,
			Date dateMatricula,
			BigDecimal valorSalario,
			TitulacaoAcademica titulacao,
			CursoVO curso){
		this.id = this.generateGUID();
		this.matricula = matricula;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.dataMatricula = dataMatricula;
		this.valorSalario = valorSalario;		
		this.titulacao = titulacao;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public BigDecimal getValorSalario() {
		return valorSalario;
	}

	public void setValorSalario(BigDecimal valorSalario) {
		this.valorSalario = valorSalario;
	}

	public TitulacaoAcademica getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(TitulacaoAcademica titulacao) {
		this.titulacao = titulacao;
	}

	public CursoVO getCurso() {
		return curso;
	}

	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}
}
