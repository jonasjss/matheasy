package com.principal.math.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bloco_de_notas")
public class BlocoDeNotas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 30)
	private String titulo;

	@Column(nullable = false)
	private String texto;

	@Column(nullable = true, length = 6)
	private String corHex;

	@Column(nullable = true)
	private byte[] anexo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public BlocoDeNotas() {

	}

	public BlocoDeNotas(Integer id, String titulo, String texto, String corHex,
			byte[] anexo, Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.corHex = corHex;
		this.anexo = anexo;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorHex() {
		return corHex;
	}

	public void setCorHex(String corHex) {
		this.corHex = corHex;
	}

	public byte[] getAnexo() {
		return anexo;
	}

	public void setAnexo(byte[] anexo) {
		this.anexo = anexo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
