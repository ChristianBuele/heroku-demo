package com.example.demo.Modelo;

import javax.persistence.*;

@Entity
@Table (name="seccion")

public class Seccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_seccion;
	private String nombre_seccion;
	private String descripcion_seccion;
	
	@ManyToOne
	private Ubicacion id_ubicacion_producto;

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}

	public String getNombre_seccion() {
		return nombre_seccion;
	}

	public void setNombre_seccion(String nombre_seccion) {
		this.nombre_seccion = nombre_seccion;
	}

	public String getDescripcion_seccion() {
		return descripcion_seccion;
	}

	public void setDescripcion_seccion(String descripcion_seccion) {
		this.descripcion_seccion = descripcion_seccion;
	}

	public Ubicacion getId_ubicacion_producto() {
		return id_ubicacion_producto;
	}

	public void setId_ubicacion_producto(Ubicacion id_ubicacion_producto) {
		this.id_ubicacion_producto = id_ubicacion_producto;
	}
	
	
}
