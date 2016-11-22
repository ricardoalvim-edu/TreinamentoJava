package br.com.fema.academicofx.vo;
import java.util.Date;

/*	PROJETO ACADÊMICO
 * 
 * 	TREINAMENTO JAVA
 * 
 * 	FUNDAÇÃO EDUCACIONAL DO MUNICÍPIO DE ASSIS
 * 
 *  VO do Aluno para mapeamento c/ Banco herdando o AbstractVO para geração do PK
 */
public class AlunoVO extends AbstractVO{
	//Atributos
	private String ra;
	private String nome;	
	private String sexo;
	private Date dataNascimento;
	private String email;
	private Boolean fgAtivo;
	private CursoVO curso;
		
	//construtor padrão
	public AlunoVO(){
		super();
	}
	
	//construtor que recebe o id via parametro
	public AlunoVO(Long id, String ra, String nome, String sexo, Date dataNascimento, String email, Boolean fgAtivo, CursoVO curso){
		this.id = id;
		this.ra = ra;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.fgAtivo = fgAtivo;
		this.curso = curso;
	}
	
	//construtor que gera o id
	public AlunoVO(String ra, String nome, String sexo, Date dataNascimento, String email, Boolean fgAtivo, CursoVO curso){
		this.id = this.generateGUID();
		this.ra = ra;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.fgAtivo = fgAtivo;
		this.curso = curso;
	}

	//getters e setters
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
