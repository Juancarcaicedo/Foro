package com.example.Foro.services.DTO.Response;

import com.example.Foro.entity.Usuario;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TopicosResponseDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String curso; // Como cadena para evitar exponer el enum completo
    private String email; // Mostrar el nombre del usuario relacionado

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
