package br.com.fema.academicofx.vo;
/*	PROJETO ACADÊMICO
 * 
 * 	TREINAMENTO JAVA
 * 
 * 	FUNDAÇÃO EDUCACIONAL DO MUNICÍPIO DE ASSIS
 * 
 * Este projeto está aplicando um DP chamado de Value Object (VO)
 */
public abstract class AbstractVO {
	protected Long id;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public Long generateGUID(){
		return null;
	}
}
