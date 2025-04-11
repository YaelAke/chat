package com.example.chat;
import com.example.chat.services.ComentarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        ComentarioService service = context.getBean(ComentarioService.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Escribe un mensaje: ");
            String mensaje = scanner.nextLine();
            if (mensaje.equalsIgnoreCase("salir")) break;
            service.procesarComentario(mensaje);
        }
    }
}
