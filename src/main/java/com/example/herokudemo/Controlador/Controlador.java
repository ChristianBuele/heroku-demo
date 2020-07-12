package com.example.demo.Controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Modelo.BuscarProducto;
import com.example.demo.Modelo.Categoria;
import com.example.demo.Modelo.Estado;
import com.example.demo.Modelo.Inventario;
import com.example.demo.Modelo.Producto;
import com.example.demo.Modelo.ProductoGI;
import com.example.demo.Modelo.Seccion;
import com.example.demo.Modelo.Ubicacion;
import com.example.demo.Repositorio.Repositorio;
import com.example.demo.servicio.ProductoServicio;
import com.example.demo.servicio.ProductoServicioImplementado;
import com.sun.el.parser.ParseException;

import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class Controlador {
	@Autowired
	Repositorio servicios;
	@Autowired
	ProductoServicio producto;

	 @GetMapping(value = "/{id}/stock")
    public ResponseEntity<Producto> updateStockProduct(@PathVariable  int id ,@RequestParam(name = "quantity", required = true) Integer quantity){
        Producto product = producto.updateStock(id, quantity);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
	 
	 @GetMapping(value = "/{id}")
	    public ResponseEntity<Producto> getProduct(@PathVariable("id") int id) {
		 System.out.println("entra a buscar el id"+id);
	        Producto product =  servicios.findById(id).orElseGet(()->{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Producto no encontrado");
			});
	        if (null==product){
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(product);
	    }
	 
	 @GetMapping(value = "/{id}/cantidad")
	    public ResponseEntity<Producto> venderProduct(@PathVariable  int id ,@RequestParam(name = "cantidad", required = true) Integer cantidad){
	        Producto product = producto.vender(id, cantidad);
	       
	        
	        if (product == null){
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(product);
	        
	    }
	 
	 @GetMapping
	    public ResponseEntity<List<Producto>> listProduct(@RequestParam(name = "categoria", required = false) Integer categoryId){
	        List<Producto> products = new ArrayList<>();
	        System.out.println("EL IDE A BUSCAR CATEGORIA ES "+categoryId);
	        if (null ==  categoryId){
	            products = producto.listAllProduct();
	            if (products.isEmpty()){
	                return ResponseEntity.noContent().build();
	            }
	        }else{
	        	Categoria cat= new Categoria();
	        	
	        	cat.setId_categoria(categoryId);
	        	System.out.println("entra a buscar "+cat.getId_categoria());
	            products = producto.findByCategoria(cat);
	            System.out.println("entra a buscar "+cat.getId_categoria()+" y obtiene x="+products.size()+" resultados");
	           
	        }
	        
	        return ResponseEntity.ok(products);
	 }
	 
@GetMapping(value = "/{id}/estado") 
	    public ResponseEntity<List<Producto>> obtenerEstados(@RequestParam(name = "estado", required = false) Integer estado){
	        List<Producto> products = new ArrayList<>();
	        System.out.println("EL IDE estado A BUSCAR ES "+estado);
	        if (null ==  estado){
	            products = producto.listAllProduct();
	            if (products.isEmpty()){
	                return ResponseEntity.noContent().build();
	            }
	        }else{
	        	Estado cat= new Estado();
	        	
	        	cat.setId_estado(estado);
	            products = producto.findByEstado(cat);
	           
	        }
	        
	        return ResponseEntity.ok(products);
	 }

@GetMapping(value = "nombre/{nombre}") 
public ResponseEntity<BuscarProducto> obtenerUbicaciones(@PathVariable("nombre") int id){
	System.out.print("entra a buscar producto por nombre"+id);

	Producto product =  servicios.findById(id).orElseGet(()->{
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Producto no encontrado");
	});
   
    	BuscarProducto buscar=new BuscarProducto();
    	buscar.setNombre_producto(product.getNombre());
    	buscar.setSeccion(product.getId_seccion_producto());
    	return ResponseEntity.ok(buscar);	
    
}
@GetMapping(value="listar/")
public ResponseEntity<List<Producto>> listarProductosAgotados(){
	System.out.println("Entra a ver los productos agotados");
	List<Producto> salida=new ArrayList<Producto>();//para almacwnar los que cumplen
	List<Producto> products;
	products=servicios.findAll();
	Producto producto;
	for	(int i=0;i<products.size();i++) {
		producto=products.get(i);
		if(producto.getStock_producto()<producto.getStock_minimo()) {
			salida.add(products.get(i));
			System.out.print("ingresando producto");
		}
	}
	return ResponseEntity.ok(salida);
}

@GetMapping(value="inventario/")
public ResponseEntity<Inventario> obtenerInventario(){
	System.out.println("Entra a ver inventario");
	List<Producto> salida=new ArrayList<Producto>();//para almacwnar los que cumplen
	List<Producto> products;
	products=servicios.findAll();
	Producto producto;
	Double precioVenta=0.0,precioPromocion=0.0,precioCaducado=0.0;
	int tV=0,tP=0,tC=0;
	for	(int i=0;i<products.size();i++) {
		producto=products.get(i);
		if(producto.getEstado().getId_estado()==1) {
			precioVenta+=producto.getPrecio_producto()*producto.getStock_producto();
			tV+=producto.getStock_producto();
		}else if(producto.getEstado().getId_estado()==2) {
			precioCaducado+=producto.getPrecio_producto()*producto.getStock_producto();
			tC+=producto.getStock_producto();
		}else {
			precioPromocion+=producto.getPrecio_producto()*producto.getStock_producto();
			tP+=producto.getStock_producto();

		}
	}
	Inventario inventario= new Inventario();
	inventario.setVentas("VENTAS");
	inventario.setPromocion("PROMOCION");
	inventario.setCaducado("CADUCADO");
	inventario.setValorInventarioVentas(precioVenta);
	inventario.setValorInventarioPromocion(precioPromocion);
	inventario.setValorInventarioCaducado(precioCaducado);
	inventario.setTotalProductosVenta(tV);
	inventario.setTotalProductosCaducados(tC);
	inventario.setTotalProductosPromocion(tP);
	return ResponseEntity.ok(inventario);
}

@GetMapping(value = "valoracion/{id}/valoracion")
public ResponseEntity<Producto> updateValoracion(@PathVariable  int id ,@RequestParam(name = "valoracion", required = true) Double valoracion){
    Producto product = producto.updateValoracion(id, valoracion);
    if (product == null){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(product);
}

@GetMapping(value="caducados/")
public ResponseEntity<List<Producto>> buscarProductosCaducados() throws java.text.ParseException{	
	Date fecha,fechaActual;
	java.util.Date fechaSimple = new Date();
	 fechaActual=ParseFecha(new SimpleDateFormat("dd/MM/yyyy").format(fechaSimple));
	List<Producto> salida=new ArrayList<Producto>();//para almacwnar los que cumplen
	List<Producto> products;
	products=servicios.findAll();
	Producto producto;
	for	(int i=0;i<products.size();i++) {
		fecha=ParseFecha(products.get(i).getFecha_expiracion_producto());
		if(fechaActual.compareTo(fecha)>0 && (products.get(i).getEstado().getId_estado()==1 || products.get(i).getEstado().getId_estado()==3)) {
			Producto pro=new Producto();
			pro=products.get(i);
			Estado estado=new Estado();
			estado.setId_estado(2);
			estado.setNombre_estado("producto caducado");
			pro.setEstado(estado);
			actualizarProducto(pro);
			salida.add(pro);
		}
	}
	return ResponseEntity.ok(salida);
}
public static Date ParseFecha(String fecha) throws java.text.ParseException
{
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaDate = null;
    fechaDate = formato.parse(fecha);
    return fechaDate;
}

public Producto actualizarProducto(Producto producto) {
	return servicios.save(producto);
}
	/* @GetMapping(value = "/{id}/cantidad")
	    public ResponseEntity<ProductoGI> venderProduct(@PathVariable  int id ,@RequestParam(name = "cantidad", required = true) Integer cantidad){
	        Producto product = producto.vender(id, cantidad);
	        ProductoGI x=new ProductoGI();
	        x.setNombreProducto(product.getNombre_producto());
	        x.setPrecioProducto(product.getPrecio_producto());
	        x.setNombreCategoria(product.getId_categoria_producto());
	        x.setStockProducto(product.getStock_producto());
	        
	        if (product == null){
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(x);
	    }*/
	
	/*
	@GetMapping
	public Iterable<Producto> getProductos(){
		return servicios.findAll();
	}
	
	@GetMapping("/{id_producto}")
	public Producto getById(@PathVariable(value="id_producto")Integer id) {
		return servicios.findById(id).orElseGet(()->{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Producto no encontrado");
		});
		
	}
	@PostMapping//para ingresae
	public Producto guardarProducto(@RequestBody Producto producto) { //@reques para transformar de json a  java
		return servicios.save(producto);
	}
	
	@PutMapping
	public Producto actualizarProducto(@RequestBody Producto producto) {
		return servicios.save(producto);
	}
	
	@DeleteMapping("/{id_producto}")
	public void borrarProducto(@PathVariable(value="id")Integer id) {
		if(servicios.findById(id).isPresent()) {
			servicios.delete(servicios.findById(id).get());
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Producto no Encontrado");
		}*/
	}


	/*
	 * esta consulta si vale
	 * http://localhost:8081/api/producto/1/stock?quantity=9  ///para actualizar el stock
	 * http://localhost:8081/api/producto/1/estado?estado=2 //para buscar los productos que esten en venta/caducados
	 * http://localhost:8081/api/producto/nombre/4 ///para buscar la ubicacion del producto por el id product
	 * http://localhost:8081/api/producto/listar/ //para listar los productos que tengan stock menor al minimo
<<<<<<< HEAD
	 * http://localhost:8081/api/producto/inventario/  //para realizar el inventario
=======
	 * http://localhost:8081/api/producto/valoracion/1/valoracion?valoracion=3.5 // valoracion del producto
	 * http://localhost:8081/api/producto/caducados//verificar productos caducados
>>>>>>> ef04d007eb3c2d77b2593a73d76df0bacbced4e7
	 */
	
	
	

