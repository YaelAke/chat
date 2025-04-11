# Chat de Consola en Java con Spring Boot, AOP y Filtro de Palabras Prohibidas

Este proyecto implementa una aplicación de consola en Java con Spring Boot, que simula un chat con filtrado de contenido mediante AOP (Programación Orientada a Aspectos). La aplicación filtra automáticamente palabras prohibidas escritas por el usuario desde la terminal.

## Características Principales
- **Spring AOP:** Utiliza un aspecto para interceptar métodos anotados y aplicar lógica de censura sin modificar la lógica de negocio.
- **Anotación Personalizada (@RevisarFiltro):** Se marca el método a interceptar, permitiendo separar responsabilidades y mantener el código limpio.
- **Filtrado de Palabras Prohibidas:** Reemplaza palabras sensibles por caracteres especiales (!#?%@) o bloquea el mensaje si excede el límite.
- **Bloqueo por Exceso:** Si el mensaje contiene más de 3 palabras prohibidas, se muestra una advertencia y se cancela su publicación.
- **Aplicación de Terminal:** Ejecuta el flujo de mensajes desde consola utilizando `Scanner`.

## Tecnologías Utilizadas
- **Java 17**  
- **Spring Boot**  
- **Spring AOP**  
- **Maven** como sistema de construcción  
- **Scanner (Java SE)** para entrada por consola  

---

## **¿Qué es AOP (Programación Orientada a Aspectos)?**
AOP es un paradigma que permite aplicar funcionalidades transversales (como logging, seguridad o filtrado) sin modificar directamente la lógica central de la aplicación.

### **Características del Uso de AOP**
- **Separación de responsabilidades:** El aspecto maneja el filtrado, mientras el servicio se enfoca en la lógica del chat.
- **Transparencia:** La anotación `@RevisarFiltro` permite interceptar sin alterar la implementación del método.
- **Escalabilidad:** Nuevas reglas pueden añadirse al aspecto sin modificar servicios existentes.
- **Reutilización:** Cualquier método anotado puede beneficiarse del filtrado automáticamente.
- **Organización:** Mejora la limpieza y claridad del código al mantener lógica transversal aislada.

### **Diagrama UML de la Aplicación**
![Diagrama UML](https://drive.google.com/uc?export=view&id=1Lm6kjK0TPAtlmk6CSW6TFGy6omXmWpuX)

