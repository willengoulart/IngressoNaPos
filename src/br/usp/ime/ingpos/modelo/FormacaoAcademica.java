package br.usp.ime.ingpos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FormacaoAcademica {
	@Id
	@GeneratedValue
	private Long formacaoAcademicaId;
	@Column(length=50)
	private String Instituicao;
	@Column(length=50)
	private Integer ingressoAno;
	private Integer ingressoMes;
	private Integer terminoAno;
	private Integer terminoMes;
	private String Titulo;
	@Column(length=50)	
	private String nomeOrientador;
	@Column(length=50)
	private String tituloDissert;
	
	@ManyToOne
	@JoinColumn(name = "curriculoID")
	private Curriculo curriculo;
	
	public Curriculo getCurriculo() {
		return curriculo;
	}
	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}
	public Long getFormacaoAcademicaId() {
		return formacaoAcademicaId;
	}
	public void setFormacaoAcademicaId(Long formacaoAcademicaId) {
		this.formacaoAcademicaId = formacaoAcademicaId;
	}
	public String getInstituicao() {
		return Instituicao;
	}
	public void setInstituicao(String instituicao) {
		Instituicao = instituicao;
	}
	public Integer getIngressoAno() {
		return ingressoAno;
	}
	public void setIngressoAno(Integer ingressoAno) {
		this.ingressoAno = ingressoAno;
	}
	public Integer getIngressoMes() {
		return ingressoMes;
	}
	public void setIngressoMes(Integer ingressoMes) {
		this.ingressoMes = ingressoMes;
	}
	public Integer getTerminoAno() {
		return terminoAno;
	}
	public void setTerminoAno(Integer terminoAno) {
		this.terminoAno = terminoAno;
	}
	public Integer getTerminoMes() {
		return terminoMes;
	}
	public void setTerminoMes(Integer terminoMes) {
		this.terminoMes = terminoMes;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getNomeOrientador() {
		return nomeOrientador;
	}
	public void setNomeOrientador(String nomeOrientador) {
		this.nomeOrientador = nomeOrientador;
	}
	public String getTituloDissert() {
		return tituloDissert;
	}
	public void setTituloDissert(String tituloDissert) {
		this.tituloDissert = tituloDissert;
	}
	
}