package com.example.herokudemo.servicio;

import java.util.List;

import com.example.herokudemo.Modelo.BuscarProducto;
import com.example.herokudemo.Modelo.Categoria;
import com.example.herokudemo.Modelo.Estado;
import com.example.herokudemo.Modelo.Producto;

public interface ProductoServicio {
	public Producto updateStock(int id,int cantidad,double costo);
	public Producto getProductoById(int id);
	public Producto vender(int id,int cantidad);
	public List<Producto> findByCategoria(Categoria category);
	public List<Producto> findByEstado(Estado estado);
	public List<Producto> listAllProduct();
	public Producto findByNombre(String nombre);
	public List<Producto> listarProductosAgotados();
	public Producto updateValoracion(int id, double valoracion);
	public Producto calcularPrecio(int id,double precio);
	public Producto addDescuento(int id, double descuento);
	/*public Producto actualizarEstado();
	public Producto getAllProductos();
	public Producto getProductosCaducados();
	//public Product updateStock(int id, Double quantity);
*/
}
