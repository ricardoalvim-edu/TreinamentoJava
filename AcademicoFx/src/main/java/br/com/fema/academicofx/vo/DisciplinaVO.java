package br.com.fema.academicofx.vo;

public class DisciplinaVO extends AbstractVO{
	private String descricao;
	private Long quantidadeAulasSemanais;
	private Boolean fgPossuiProvas;
	private Boolean fgPossuiSeminarios;
	private Boolean fgPossuiTrabalhosExtras;
	
	public DisciplinaVO(){
		super();
	}
	
	public DisciplinaVO(Long id, 
			String descricao, 
			Long quantidadeAulasSemanais, 
			Boolean fgPossuiProvas, 
			Boolean fgPossuiSeminarios, 
			Boolean fgPossuiTrabalhosExtras){
		this.id = id;
		this.descricao = descricao;
		this.quantidadeAulasSemanais = quantidadeAulasSemanais;
		this.fgPossuiProvas = fgPossuiProvas;
		this.fgPossuiSeminarios = fgPossuiSeminarios;
		this.fgPossuiTrabalhosExtras = fgPossuiTrabalhosExtras;
	}
	
	public DisciplinaVO( 
			String descricao, 
			Long quantidadeAulasSemanais, 
			Boolean fgPossuiProvas, 
			Boolean fgPossuiSeminarios, 
			Boolean fgPossuiTrabalhosExtras){
		this.id =  this.generateGUID();
		this.descricao = descricao;
		this.quantidadeAulasSemanais = quantidadeAulasSemanais;
		this.fgPossuiProvas = fgPossuiProvas;
		this.fgPossuiSeminarios = fgPossuiSeminarios;
		this.fgPossuiTrabalhosExtras = fgPossuiTrabalhosExtras;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQuantidadeAulasSemanais() {
		return quantidadeAulasSemanais;
	}

	public void setQuantidadeAulasSemanais(Long quantidadeAulasSemanais) {
		this.quantidadeAulasSemanais = quantidadeAulasSemanais;
	}

	public Boolean getFgPossuiProvas() {
		return fgPossuiProvas;
	}

	public void setFgPossuiProvas(Boolean fgPossuiProvas) {
		this.fgPossuiProvas = fgPossuiProvas;
	}

	public Boolean getFgPossuiSeminarios() {
		return fgPossuiSeminarios;
	}

	public void setFgPossuiSeminarios(Boolean fgPossuiSeminarios) {
		this.fgPossuiSeminarios = fgPossuiSeminarios;
	}

	public Boolean getFgPossuiTrabalhosExtras() {
		return fgPossuiTrabalhosExtras;
	}

	public void setFgPossuiTrabalhosExtras(Boolean fgPossuiTrabalhosExtras) {
		this.fgPossuiTrabalhosExtras = fgPossuiTrabalhosExtras;
	}
}
