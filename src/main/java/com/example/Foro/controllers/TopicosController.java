package com.example.Foro.controllers;

import com.example.Foro.services.DTO.Response.TopicosResponseDTO;
import com.example.Foro.services.IServiceTopicos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/topicos")
public class TopicosController {
    private IServiceTopicos iServiceTopicos;

    @GetMapping("/topicos")
    public ResponseEntity<List<TopicosResponseDTO>> obtenertodoslostopicos(){
        return  ResponseEntity.ok(iServiceTopicos.listarAllTopicos());
    }

}
