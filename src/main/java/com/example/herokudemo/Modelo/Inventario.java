package com.example.herokudemo.Modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Inventario {
	private String fechaInventario;
	private String ventas;
	private double valorInventarioVentas;
	private int TotalProductosVenta;
	private String caducado;
	private double valorInventarioCaducado;
	private int TotalProductosCaducados;
	private String promocion;
	private double valorInventarioPromocion;
	private int TotalProductosPromocion;
	public Inventario() {
		java.util.Date fecha = new Date();
		this.fechaInventario=new SimpleDateFormat("dd/MM/yyyy").format(fecha)+"a las "+Hora()+":"+Minuto()+":"+Segundo();
	}
	public  String Hora() {
		Calendar calendario = new GregorianCalendar();
		if (String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)).length() == 2) {
		return String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
		} else {
		return String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
		}
	}
	public String Minuto() {
		Calendar calendario = new GregorianCalendar();
		if (String.valueOf(calendario.get(Calendar.MINUTE)).length() == 2) {
		return String.valueOf(calendario.get(Calendar.MINUTE));
		} else {
		return String.valueOf(calendario.get(Calendar.MINUTE));
		}
	}

		public String Segundo() {
		Calendar calendario = new GregorianCalendar();
		if (String.valueOf(calendario.get(Calendar.SECOND)).length() == 2) {
		return String.valueOf(calendario.get(Calendar.SECOND));
		} else {
		return  String.valueOf(calendario.get(Calendar.SECOND));
		}
		}
	public String getFechaInventario() {
		return fechaInventario;
	}
	public void setFechaInventario(String fechaInventario) {
		this.fechaInventario = fechaInventario;
	}
	public String getVentas() {
		return ventas;
	}
	public void setVentas(String ventas) {
		this.ventas = ventas;
	}
	public double getValorInventarioVentas() {
		return valorInventarioVentas;
	}
	public void setValorInventarioVentas(double valorInventarioVentas) {
		this.valorInventarioVentas = valorInventarioVentas;
	}
	public String getCaducado() {
		return caducado;
	}
	public void setCaducado(String caducado) {
		this.caducado = caducado;
	}
	public double getValorInventarioCaducado() {
		return valorInventarioCaducado;
	}
	public void setValorInventarioCaducado(double valorInventarioCaducado) {
		this.valorInventarioCaducado = valorInventarioCaducado;
	}
	public String getPromocion() {
		return promocion;
	}
	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}
	public double getValorInventarioPromocion() {
		return valorInventarioPromocion;
	}
	public void setValorInventarioPromocion(double valorInventarioPromocion) {
		this.valorInventarioPromocion = valorInventarioPromocion;
	}
	public int getTotalProductosVenta() {
		return TotalProductosVenta;
	}
	public void setTotalProductosVenta(int totalProductosVenta) {
		TotalProductosVenta = totalProductosVenta;
	}
	public int getTotalProductosCaducados() {
		return TotalProductosCaducados;
	}
	public void setTotalProductosCaducados(int totalProductosCaducados) {
		TotalProductosCaducados = totalProductosCaducados;
	}
	public int getTotalProductosPromocion() {
		return TotalProductosPromocion;
	}
	public void setTotalProductosPromocion(int totalProductosPromocion) {
		TotalProductosPromocion = totalProductosPromocion;
	}
	
	
	
}
