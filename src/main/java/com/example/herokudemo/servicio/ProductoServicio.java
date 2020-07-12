package com.example.demo.servicio;

import java.util.List;

import com.example.demo.Modelo.BuscarProducto;
import com.example.demo.Modelo.Categoria;
import com.example.demo.Modelo.Estado;
import com.example.demo.Modelo.Producto;

public interface ProductoServicio {
	public Producto updateStock(int id,int cantidad);
	public Producto getProductoById(int id);
	public Producto vender(int id,int cantidad);
	public List<Producto> findByCategoria(Categoria category);
	public List<Producto> findByEstado(Estado estado);
	public List<Producto> listAllProduct();
	public Producto findByNombre(String nombre);
	public List<Producto> listarProductosAgotados();
	public Producto updateValoracion(int id, double valoracion);
	/*public Producto actualizarEstado();
	public Producto getAllProductos();
	public Producto getProductosCaducados();
	//public Product updateStock(int id, Double quantity);
*/
}
