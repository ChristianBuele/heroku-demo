package com.example.demo.Modelo;

public class ProductoGI {
	private String nombreProducto;
	private Double precioProducto;
	private Categoria nombreCategoria;
	private int stockProducto;
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	public int getStockProducto() {
		return stockProducto;
	}
	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}
	public Categoria getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(Categoria nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	
}
