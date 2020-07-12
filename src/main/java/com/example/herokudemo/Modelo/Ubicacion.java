package com.example.herokudemo.Modelo;

import javax.persistence.*;

@Entity
@Table (name="ubicacion")
public class Ubicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_ubicacion;
	private String descripcion;
	public int getId_ubicacion() {
		return id_ubicacion;
	}
	public void setId_ubicacion(int id_ubicacion) {
		this.id_ubicacion = id_ubicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
