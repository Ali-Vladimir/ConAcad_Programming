# ConAcad_Programming

Explora proyectos y soluciones de la plataforma ConAcad. Estos programas están aquí para apoyar el aprendizaje de futuros compañeros del TecNM y servir como ejemplos de exploración y práctica. ¡Todas las contribuciones son bienvenidas! 🤝💻

### 💡 Consejos para la Plataforma ConAcad

Cuando trabajes en tus programas dentro de ConAcad, es fundamental que sigas estos consejos para aprovechar al máximo tu aprendizaje y asegurar tu éxito:

1. **Lee absolutamente todo**: El consejo más importante es leer todo lo que esté disponible en la página: instrucciones, secciones de ayuda, consejos, lenguajes requeridos, descripciones, etc. Cada dato está ahí por algo y te ayudará a resolver problemas o a empezar, incluso si nunca los habías visto antes.

### ⚠️ Descargo de Responsabilidad (Disclaimer)

En esta sección comparto algunos consejos basados en mi experiencia con la plataforma que podrían ayudarte. Sin embargo, ten en cuenta que la mayoría de estos consejos no deberían usarse de forma habitual, ya que podrían considerarse atajos o trampas. Si decides aplicarlos, lo haces bajo tu propio riesgo y responsabilidad.

## Cómo reducir el porcentaje de similitud en los programas

Como ya sabes, la plataforma cuenta con un juez que determina un porcentaje de similitud basado en lo siguiente:

a. Estructura general del programa
b. Métodos utilizados
c. Secuencia de ejecución
d. Subprocesos
e. Cantidades de variables y tipos de datos
f. Nombres en general

El juez revisa cuántas clases usas, cuántos objetos creas y las llamadas que haces. También detecta similitudes si usas métodos nativos de las librerías de Java (como `.pow` de Math o la configuración de Scanner), el orden en el que ejecutas tus operaciones y los subprocesos dentro de un mismo método (modularidad). La similitud se acumula por puntos; no se muestra hasta que alcanza el 70% y empieza a afectar tu calificación a partir del 77%, restándote puntos en la plataforma.

Formas comunes de reducir el porcentaje de similitud:

1. **Crear métodos basura:** Puedes programar métodos vacíos o que hagan acciones sin sentido que no afecten el flujo real del programa.
2. **Modularizar el código:** Divide tu código creando más métodos o clases para resolver el problema de manera distribuida.
3. **Cambiar nombres:** Modifica los nombres de tus variables, clases o métodos (puedes usar un estándar o pasarlos al inglés).

*Nota importante:* Cambiar el orden de las líneas visualmente (poner el método 3 antes del método 1) no sirve de nada, ya que el juez no lee el código de forma visual. Tampoco te obsesiones con esto: si hiciste tu código de forma completamente legal y original, recibirás todos tus puntos sin importar el porcentaje. Además, si agregas métodos basura, estos serán evidentes si un profesor llega a revisar tu código manualmente.

## Cómo crear un programa para obtener los casos de prueba

A continuación, te explico cómo integrar un programa sencillo dentro de tus ejercicios para recopilar y mostrar los casos de prueba del juez.

En ConAcad existen 3 tipos de retroalimentación: los que solo dicen si está correcto/incorrecto, los que dan un porcentaje de aciertos, y los que muestran tu salida junto con la salida correcta esperada. Nos enfocaremos en este último tipo.

Para recolectar la información, creamos un ciclo que lee la entrada de la consola y la concatena en una variable de texto (`String`). Esto eventualmente provocará un error por falta de líneas; capturamos esa excepción con un bloque `try-catch` y mandamos a imprimir todo lo acumulado en pantalla para conocer los casos exactos que evalúa el juez.

```java
import java.util.Scanner;

public class Recolectadora {
    public static void main(String[] args) {
        Recolectora objeto = new Recolectora();
        objeto.m_acepDatos();
    }
}

class Recolectora {
    Scanner a_teclado;
    String a_informacion = "";

    Recolectora() {
        a_teclado = new Scanner(System.in);
    }

    void m_acepDatos() {
        try {
            while (true) {
                a_informacion = a_informacion + "\n" + a_teclado.nextLine();
            }
        } catch (Exception e) {
            System.out.println(a_informacion);
        }
    }
}
```
