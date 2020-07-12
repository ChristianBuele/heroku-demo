package com.example.herokudemo.Repositorio;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.herokudemo.Modelo.Estado;
import com.example.herokudemo.Modelo.Categoria;
import com.example.herokudemo.Modelo.Producto;





@Repository
public interface Repositorio extends JpaRepository<Producto, Integer>{
	public List<Producto> findByCategoria(Categoria category);
	public List<Producto> findByEstado(Estado estado);
	public  Producto findByNombre(String nombre);
}
