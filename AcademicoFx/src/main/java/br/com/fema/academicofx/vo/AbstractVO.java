package br.com.fema.academicofx.vo;
/*	PROJETO ACAD�MICO
 * 
 * 	TREINAMENTO JAVA
 * 
 * 	FUNDA��O EDUCACIONAL DO MUNIC�PIO DE ASSIS
 * 
 * Este projeto est� aplicando um DP chamado de Value Object (VO)
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
