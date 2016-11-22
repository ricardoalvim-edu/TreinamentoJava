package br.com.fema.academicofx.vo;

import java.security.SecureRandom;

/*	PROJETO ACAD�MICO
 * 
 * 	TREINAMENTO JAVA
 * 
 * 	FUNDA��O EDUCACIONAL DO MUNIC�PIO DE ASSIS
 * 
 *  Este projeto est� aplicando um DP chamado de Value Object (VO)
 */
public abstract class AbstractVO {
	protected Long id;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public static Long generateGUID(){		
		Long id = new Long(0L);
		try{
			id = Math.abs(SecureRandom.getInstance("SHA1PRNG").nextLong());
		}
		catch (Exception ex){
			System.out.println("Exception: "+ex.getMessage().toString());
		}
		return id;
	}	
}
