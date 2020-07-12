package com.example.herokudemo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.herokudemo.Modelo.Producto;
import com.example.herokudemo.Modelo.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
	public  Usuario findByCorreo(String correo);
}
