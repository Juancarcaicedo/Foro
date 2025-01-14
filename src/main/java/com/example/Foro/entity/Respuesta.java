package com.example.Foro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Respuestas")
@Data
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String mensaje;
    private LocalDate fechaRespuesta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;
}

