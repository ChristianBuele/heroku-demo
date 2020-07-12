package com.example.demo.Repositorio;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.BuscarProducto;
import com.example.demo.Modelo.Categoria;
import com.example.demo.Modelo.Estado;
import com.example.demo.Modelo.Producto;
import com.example.demo.Modelo.Ubicacion;




@Repository
public interface Repositorio extends JpaRepository<Producto, Integer>{
	public List<Producto> findByCategoria(Categoria category);
	public List<Producto> findByEstado(Estado estado);
	public  Producto findByNombre(String nombre);
}
