package br.com.fema.academicofx.vo;

import java.util.Date;

public class AlunoVO extends AbstractVO{
	private String ra;
	private String nome;	
	private String sexo;
	private Date dataNascimento;
	private String email;
	private Boolean fgAtivo;
	private CursoVO curso;
		
	public AlunoVO(){
		super();
	}
	
	public AlunoVO(Long id, String ra, String nome, String sexo, Date dataNascimento, String email, Boolean fgAtivo, CursoVO curso){
		this.setId(id);
		this.ra = ra;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.fgAtivo = fgAtivo;
		this.curso = curso;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getFgAtivo() {
		return fgAtivo;
	}

	public void setFgAtivo(Boolean fgAtivo) {
		this.fgAtivo = fgAtivo;
	}

	public CursoVO getCurso() {
		return curso;
	}

	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}
}
