public class JavaStreams {
}
//.stream() representación de un flujo de datos
//Las colecciones tradicionales en Java (como List, Set, Map, etc.)
//Operaciones perezosas (Lazy): Las operaciones de un Stream, como filter(), map(), distinct(), no se ejecutan inmediatamente, sino que se acumulan y se ejecutan solo cuando el Stream se consume (por ejemplo, en una operación terminal).
//Operaciones finales: Son operaciones que causan que el Stream se "ejecute". Ejemplos son collect(), forEach(), reduce(), count(), etc.
//Los Streams permiten ejecutar operaciones en paralelo fácilmente, sin tener que gestionar manualmente los hilos. Usando el método .parallel(),
//No modifican la fuente de datos:

//IMPORT
import java.util.stream.Collectors;
//ESTRUCTURA
.stream()

//OPERACIONES INTERMEDIAS
//.filter(Predicate<T> predicate): //Filtra los elementos del Stream que cumplen con una condición.
//.map(Function<T, R> mapper): //Transforma cada elemento del Stream de tipo T en un nuevo tipo R.
//.distinct(): //Elimina elementos duplicados.
//.sorted(): //Ordena los elementos en el Stream.
//.limit(long maxSize): //Limita el tamaño del Stream.
//.flatMap(Function<T, Stream<R>> mapper): //Transforma cada elemento del Stream en otro Stream (para obtener un "Stream de Streams").

//OPERACIONES FINALES
//.collect(Collector<T, A, R> collector): //Transforma el Stream en una colección (como una lista, conjunto, mapa, etc.).
//.forEach(Consumer<T> action): //Realiza una acción en cada elemento del Stream (por ejemplo, imprimirlo).
//.reduce(BinaryOperator<T> accumulator): //Realiza una reducción de los elementos del Stream (suma, multiplicación, etc.).
//.count(): //Cuenta el número de elementos en el Stream.
//.anyMatch(Predicate<T> predicate): //Verifica si al menos un elemento cumple con la condición.
//.allMatch(Predicate<T> predicate): //Verifica si todos los elementos cumplen con la condición.
//.findFirst(): //Obtiene el primer elemento del Stream.




//MAS ESTRUCTURA
// list.stream()   Crear un stream desde una lista     nombres.stream()
//Arrays.stream(arr)   Crear stream desde array   Arrays.stream(nums)
//.filter(x -> condición) Deja pasar solo los elementos true (booleano)
        //.filter(n -> n % 2 == 0) (pares)
        //.filter(s -> s.startsWith("A")) Filtra por condición de String

//.map(x -> transformación) Convierte cada elemento
        //.map(n -> n * 2)
        //.map(String::toUpperCase) Métodos directos "hola" → "HOLA"

//.collect(Collectors.toList()) Recoger resultados y devolver una lista
    List<Integer> res = lista.stream().filter(...).collect(Collectors.toList());

//.collect(Collectors.joining(", ")) unir strings "A, B, C"

//.collect(Collectors.toSet()) convertir a Set

//.sorted() Orden natural

//.sorted((a, b) -> b - a) Orden descendente

//.sorted(String::compareTo) Con strings

//.forEach(x -> System.out.println(x)) Iterar sin devolver Imprimir cada elemento

//.count()   contar elementos

//long c = lista.stream().filter(...).count();

//.anyMatch(x -> cond) Búsquedas rápidas - Alguno cumple  .anyMatch(n -> n > 10)

//.allMatch(x -> cond) Búsquedas rápidas - Todos cumplen  .allMatch(n -> n > 0)

//.noneMatch(x -> cond) Búsquedas rápidas - Ninguno cumple .noneMatch(s -> s.isEmpty())

//.findFirst()    Obtener primero
//.orElse(valor)     Y sino..

//.distinct() Quitar duplicados   [1,2,2,3] → [1,2,3]

//CASOS ESPECIALES DE STRING
//.toUpperCase()  Convierte todo el texto a MAYÚSCULAS.   "hola" → "HOLA"
//.toLowerCase() Convierte todo el texto a minúsculas.  "HOLA" → "hola"
//.length() Devuelve la cantidad de caracteres del String. "Juan" → 4"
//.contains() Devuelve true si el String contiene la subcadena buscada. perro".contains("r") → true
//.charAt() Devuelve el carácter en la posición indicada (index desde 0). "casa".charAt(0) → 'c'"
//.substring() Devuelve una parte del String. "computadora".substring(0,4)"
//.replace() Reemplaza una letra/parte del texto por otra. casa".replace("a","o") → "coso"
//.split() Divide un String en partes y devuelve un array. "a,b,c" → ["a","b","c"]

