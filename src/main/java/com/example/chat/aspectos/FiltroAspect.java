package com.example.chat.aspectos;

import com.example.chat.anotaciones.RevisarFiltro;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Aspect
@Component
public class FiltroAspect {

    private final Set<String> palabrasProhibidas = new HashSet<>(
            Arrays.asList("tonto", "feo", "malo", "idiota", "bruto")
    );

    @Around("@annotation(revisarFiltro)")
    public Object revisarYFiltrar(ProceedingJoinPoint joinPoint, RevisarFiltro revisarFiltro) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof String) {
            String mensaje = (String) args[0];
            String[] palabras = mensaje.split("\\s+");

            // Contar cuantas palabras prohibidas tene el mensaje
            long cantidadProhibidas = Arrays.stream(palabras)
                    .filter(p -> {
                        String limpia = p.toLowerCase().replaceAll("[^a-záéíóúñ]", "");
                        return palabrasProhibidas.contains(limpia);
                    })
                    .count();

            if (cantidadProhibidas > 3) {
                System.out.println("[ADVERTENCIA] El mensaje contiene demasiadas palabras prohibidas y fue bloqueado.");
                return null;
            }

            //  Remplazar las palabras prohibidas
            String resultado = Arrays.stream(palabras)
                    .map(p -> {
                        String limpia = p.toLowerCase().replaceAll("[^a-záéíóúñ]", "");
                        return palabrasProhibidas.contains(limpia) ? "@#%?!" : p;
                    })
                    .collect(Collectors.joining(" "));

            args[0] = resultado;
        }
        return joinPoint.proceed(args);
    }
}
