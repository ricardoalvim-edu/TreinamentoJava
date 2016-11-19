package br.com.fema.academicofx.vo;

import java.util.List;

public class CursoVO extends AbstractVO{
	private String codigo;
	private String descricao;
	private String sigla;
	private int quantidadeAnos;
	private List<DisciplinaVO> disciplinas;
	
	public CursoVO(){
		super();
	}
	
	public CursoVO(Long id, String codigo, String descricao, String sigla, int quantidadeAnos){
		this.setId(id);
		this.codigo = codigo;
		this.descricao = descricao;
		this.sigla = sigla;
		this.quantidadeAnos = quantidadeAnos;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public int getQuantidadeAnos() {
		return quantidadeAnos;
	}
	public void setQuantidadeAnos(int quantidadeAnos) {
		this.quantidadeAnos = quantidadeAnos;
	}

	public List<DisciplinaVO> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaVO> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
