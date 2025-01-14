package com.example.Foro.controllers;

import com.example.Foro.services.DTO.Request.TopicosReqDTO;
import com.example.Foro.services.DTO.Response.TopicosResponseDTO;
import com.example.Foro.services.TopicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {
    private final TopicoService topicoService;
    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public ResponseEntity<List<TopicosResponseDTO>> getAllTopicos() {
        List<TopicosResponseDTO> topicos = topicoService.listarTopicos();
        return ResponseEntity.ok(topicos);
    }

    @PostMapping
    public TopicosResponseDTO crearTopico(@RequestBody TopicosReqDTO topicoRequestDTO) {
        return topicoService.crearTopico(topicoRequestDTO);
    }
    @PutMapping("/{id}")
    public TopicosResponseDTO actualizarTopico(@PathVariable Long id, @RequestBody TopicosReqDTO topicoRequestDTO) {
        return topicoService.actualizarTopico(id, topicoRequestDTO);
    }
}
