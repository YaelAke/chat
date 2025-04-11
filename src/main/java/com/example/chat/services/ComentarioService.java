package com.example.chat.services;

import com.example.chat.anotaciones.RevisarFiltro;
import com.example.chat.modelos.Comentario;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    //Aplicar el filtrado AOP antes de su ejecución
    @RevisarFiltro
    public void procesarComentario(String mensaje) {
        Comentario comentario = new Comentario(mensaje);
        System.out.println("Mensaje procesado: " + comentario.getMensaje());
    }
}
