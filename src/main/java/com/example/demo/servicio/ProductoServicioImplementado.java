package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Modelo.BuscarProducto;
import com.example.demo.Modelo.Categoria;
import com.example.demo.Modelo.Estado;
import com.example.demo.Modelo.Producto;
import com.example.demo.Repositorio.Repositorio;

@Service
public class ProductoServicioImplementado implements ProductoServicio {
	@Autowired
	Repositorio servicio;
	
	@Override
	public Producto updateStock(int id, int cantidad) {
		// TODO Auto-generated method stub
		Producto productDB = getProductoById(id);
        if (null == productDB){
            return null;
        }
        int stock =  productDB.getStock_producto() + cantidad;
        productDB.setStock_producto(stock);;
        return servicio.save(productDB);
	}
	

	@Override
	public Producto getProductoById(int id) {
		// TODO Auto-generated method stub
		System.out.print("llea a prod servicio implementado "+id);
		return servicio.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Producto no encontrado");
		});
	}
	


	@Override
	public Producto vender(int id, int cantidad) {
		Producto product = getProductoById(id);
        if (null == product){
            return null;
        }else {
        	 if(product.getStock_producto()==0 || product.getStock_producto()<cantidad) {
	 	        	return null;
	 	        }else {
	 	        	int stock =  product.getStock_producto() - cantidad;
	 	           product.setStock_producto(stock);;
	 	           return servicio.save(product);
	 	        }
        }
        
	}
	@Override
    public List<Producto> listAllProduct() {
        return servicio.findAll();
    }
	@Override
    public List<Producto> findByCategoria(Categoria category) {
		System.out.println("llega la categoria "+category.getId_categoria());
        return servicio.findByCategoria(category);
    }


	@Override
	public List<Producto> findByEstado(Estado estado) {
		// TODO Auto-generated method stub
		return servicio.findByEstado(estado);
	}


	@Override
	public Producto findByNombre(String nombre) {
		
		return servicio.findByNombre(nombre);
	}


	@Override
	public List<Producto> listarProductosAgotados() {
		
		return servicio.findAll();
	}
	
	@Override
	public Producto updateValoracion(int id, double valoracion) {
		Producto product = getProductoById(id);
        if (null == product){
            return null;
	 	   }
        product.setValoracion(valoracion);
        return servicio.save(product);
        }



	
}
