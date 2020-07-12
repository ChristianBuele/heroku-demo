package com.example.demo.Modelo;


import java.util.Date;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String nombre;
	@NotNull
	private int stock_producto;
	@NotNull
	private int stock_minimo;
	
	private String descripcion_producto;
	@NotNull
	private double precio_producto;
	@NotNull
	private double costo_producto;
	private double descuento;
	@NotNull
	private String fecha_expiracion_producto;
	@NotNull
	private String proveedor_producto;
	@NotNull
	private String id_lote_producto;
	
	@ManyToOne
	@NotNull
	private Seccion id_seccion_producto;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Estado estado;

	private double valoracion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock_producto() {
		return stock_producto;
	}

	public void setStock_producto(int stock_producto) {
		this.stock_producto = stock_producto;
	}

	public int getStock_minimo() {
		return stock_minimo;
	}

	public void setStock_minimo(int stock_minimo) {
		this.stock_minimo = stock_minimo;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public double getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(double precio_producto) {
		this.precio_producto = precio_producto;
	}

	public double getCosto_producto() {
		return costo_producto;
	}

	public void setCosto_producto(double costo_producto) {
		this.costo_producto = costo_producto;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getFecha_expiracion_producto() {
		return fecha_expiracion_producto;
	}

	public void setFecha_expiracion_producto(String fecha_expiracion_producto) {
		this.fecha_expiracion_producto = fecha_expiracion_producto;
	}

	public String getProveedor_producto() {
		return proveedor_producto;
	}

	public void setProveedor_producto(String proveedor_producto) {
		this.proveedor_producto = proveedor_producto;
	}

	public String getId_lote_producto() {
		return id_lote_producto;
	}

	public void setId_lote_producto(String id_lote_producto) {
		this.id_lote_producto = id_lote_producto;
	}

	public Seccion getId_seccion_producto() {
		return id_seccion_producto;
	}

	public void setId_seccion_producto(Seccion id_seccion_producto) {
		this.id_seccion_producto = id_seccion_producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	
	
	

}
