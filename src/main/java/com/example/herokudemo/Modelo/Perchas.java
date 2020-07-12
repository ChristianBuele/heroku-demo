package com.example.herokudemo.Modelo;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="perchas")
public class Perchas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_perchas;
	@ManyToOne
	private Seccion id_seccion;
	private String descripcion_perchas;
	public int getId_perchas() {
		return id_perchas;
	}
	public void setId_perchas(int id_perchas) {
		this.id_perchas = id_perchas;
	}
	public String getDescripcion_perchas() {
		return descripcion_perchas;
	}
	public void setDescripcion_perchas(String descripcion_perchas) {
		this.descripcion_perchas = descripcion_perchas;
	}
	

}
