//POSIBLES IMPORTS
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

// 1)//RESUMEN
//VALIDAR → matches() → boolean
//EXTRAER/CONTAR → find() + while → List/int
//TRANSFORMAR → replaceAll() → String

//2) ESTRUCTURA BASE (siempre igual EN VALIDACIÓN)
String regex = "...";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(texto);
//Solo cambiás:
// la regex
// si usás matches(), find() o replaceAll()
//el tipo de retorno (boolean, lista, entero, string)

public class PatternMatchinn {
}

//3) EJEMPLOS
//Ejercicio 1
public class PatternMatchinn {
    public static boolean esEmailValido(String email) {
        if (email == null) return false;

        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    @Test
    public void testEsEmailValido() {
        assertTrue(esEmailValido("example@mail.com"));    // válido
        assertFalse(esEmailValido("examplemail.com"));    // falta @
        assertFalse(esEmailValido("example@mailcom"));    // falta punto en dominio
    }
}
//Ejercicio 2
public static boolean esCodigoPostalValido(String postalCode) {
    if (postalCode == null) return false;
    String regex = "^[0-9]{5}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(postalCode);

    return matcher.matches();
}

@Test
public void testEsCodigoPostalValido() {
    assertTrue(esCodigoPostalValido("12345"));
    assertFalse(esCodigoPostalValido("1234a"));   // letra
    assertFalse(esCodigoPostalValido("123"));     // pocos dígitos
}
//Ejercicio 3
public static boolean validarTelefono(String telefono) {
    if (telefono == null) return false;

    // +34-1234-567890
    String regex = "^\\+[0-9]{2}-[0-9]{4}-[0-9]{6}$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(telefono);

    return matcher.matches();
}

@Test
public void testValidarTelefono() {
    Assert.assertTrue(validarTelefono("+34-1234-567890"));
    Assert.assertFalse(validarTelefono("34-1234-567890"));     // falta +
    Assert.assertFalse(validarTelefono("+341234-567890"));     // falta el primer guion
    Assert.assertFalse(validarTelefono("+34-123-567890"));     // 123 (mal, deben ser 4 dígitos)
}
//Ejercicio 4
public static boolean esFechaValida(String fecha) {
//Validemos fechas en formato dd/mm/yyyy, donde:
//
//El día (dd) debe estar entre 01 y 31.
//El mes (mm) debe estar entre 01 y 12.
//El año (yyyy) debe tener exactamente 4 dígitos.
    String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$"; // <-- completado
    return fecha.matches(regex);
}

    @Test
    public void testEsFechaValida() {
        Assert.assertTrue(esFechaValida("25/12/2025"));
        Assert.assertFalse(esFechaValida("31/13/2025"));
        Assert.assertFalse(esFechaValida("00/01/2025"));
        Assert.assertFalse(esFechaValida("25/12/25"));
    }
//Ejercicio 5 ---------------------------------------------------
    public static boolean esMayusculas(String texto) {
        String regex = "^[A-Z]+$";
        return texto.matches(regex);

    }

    @Test
    public void testEsMayusculas() {
        Assert.assertTrue(esMayusculas("HELLO"));
        Assert.assertFalse(esMayusculas("Hello"));
        Assert.assertFalse(esMayusculas("HELLO123"));
        Assert.assertFalse(esMayusculas(""));
    }
//Ejercicio 6
    public static boolean esEnteroPositivo(String numero) {
        String regex = "^[1-9][0-9]*$";
        return numero.matches(regex);
    }

    @Test
    public void testEsEnteroPositivo() {
        Assert.assertTrue(esEnteroPositivo("12345"));
        Assert.assertFalse(esEnteroPositivo("-12345"));
        Assert.assertFalse(esEnteroPositivo("12.34"));
        Assert.assertFalse(esEnteroPositivo("abc"));
    }
//Ejercicio 7
// 1) Es número entero solo con dígitos (sin espacios, sin letras, no vacío)
public static boolean esNumeroEntero(String cadena) {
    String regex = "^[0-9]+$";
    return cadena.matches(regex);
}
    @Test
    public void testEsNumeroEntero() {
        Assert.assertTrue(esNumeroEntero("12345"));
        Assert.assertFalse(esNumeroEntero("12a45"));
        Assert.assertFalse(esNumeroEntero(" 123 "));
        Assert.assertFalse(esNumeroEntero(""));
    }

//Ejercicio 8
public static boolean validarTelefono(String telefono) {
    // formato = +, 2 digitos, guion, 4 digitos, guion, 6 digitos
    String regex = "^\\+[0-9]{2}-[0-9]{4}-[0-9]{6}$";
    return telefono.matches(regex);
}

    @Test
    public void testValidarTelefono() {
        Assert.assertTrue(validarTelefono("+34-1234-567890"));
        Assert.assertFalse(validarTelefono("34-1234-567890"));
        Assert.assertFalse(validarTelefono("+341234-567890"));
        Assert.assertFalse(validarTelefono("+34-123-567890"));
    }

//Ejercicio 9
public static int contarPalabras(String texto) {
    if (texto.trim().isEmpty()) return 0;
    return texto.split("\\s+").length;
}
    @Test
    public void testContarPalabras() {
        Assert.assertEquals(contarPalabras("Hola mundo"), 2);
        Assert.assertEquals(contarPalabras("Este es un test"), 4);
        Assert.assertEquals(contarPalabras(""), 0);
        Assert.assertEquals(contarPalabras("   "), 0);
    }

//Ejercicio 10
public static String cambiarFormatoFecha(String texto) {
    // (dd/mm/yyyy) → (yyyy-mm-dd)
    String regex = "(\\d{2})/(\\d{2})/(\\d{4})";
    return texto.replaceAll(regex, "$3-$2-$1");
}
    @Test
    public void testCambiarFormatoFecha() {
        Assert.assertEquals(cambiarFormatoFecha("Hoy es 25/12/2023"), "Hoy es 2023-12-25");
        Assert.assertEquals(cambiarFormatoFecha("Fecha: 01/01/2000"), "Fecha: 2000-01-01");
        Assert.assertEquals(cambiarFormatoFecha("Sin fecha"), "Sin fecha");
    }

// 5) Ejercicio 11
public static Map<String, Long> contarDominiosCorreo(List<String> correos) {
    // Capturamos el dominio después del @
    Pattern pattern = Pattern.compile("^[^@]+@([^@]+)$");

    return correos.stream()
            .map(correo -> {
                var matcher = pattern.matcher(correo);
                return matcher.find() ? matcher.group(1) : null;  // dominio o null
            })
            .filter(Objects::nonNull) // <completar> → filtramos los null
            .collect(Collectors.groupingBy(
                    dominio -> dominio,              // clave = dominio
                    Collectors.counting()            // valor = cantidad (Long)
            ));
}

    @Test
    public void testContarDominiosCorreo() {
        List<String> correos = Arrays.asList(
                "juan@mail.com", "pedro@gmail.com", "ana@mail.com",
                "carlos@yahoo.com", "maria@gmail.com", "test@mail.com"
        );

        Map<String, Long> resultado = contarDominiosCorreo(correos);

        Assert.assertEquals(resultado.get("mail.com"), Long.valueOf(3));
        Assert.assertEquals(resultado.get("gmail.com"), Long.valueOf(2));
        Assert.assertEquals(resultado.get("yahoo.com"), Long.valueOf(1));
    }

//SÍMBOLO - SIGNIFICADO- EJEMPLO
//. Cualquier carácter (excepto nueva línea)
    //"a.c" coincide con "abc", "a1c", pero no con "ac".

//*  Cero o más repeticiones
    //"a*" coincide con " ", "a", "aaa".

//+ Una o más repeticiones
    //"a+" coincide con "a", "aaa", pero no con "".

//? Cero o una repetición
    //"a?" coincide con "", "a", pero no con "aa".

//\d Dígito (0-9)
    //"\d" coincide con "5", pero no con "a".

//\w  Carácter alfanumérico o guion bajo
    //"\w" coincide con "a", "5", "_" pero no con "@".

//\s  Espacio en blanco
    //"\s" coincide con " ", "\t".

//^ Inicio de la cadena
    //"^a" coincide con "abc", pero no con "bac".

//$ Fin de la cadena
    //"a$" coincide con "cba", pero no con "abc".

//[abc] Cualquiera de los caracteres entre corchetes
    //"[abc]" coincide con "a", "b", "c", pero no con "d".

//[^abc] Cualquier carácter excepto los especificados
    //"[^abc]" coincide con "d", pero no con "a", "b", "c".

//[a-z] Rango de caracteres
    //"[a-z]" coincide con "a", "m", pero no con "A".

//`(x	y)` Coincide con x o y

//{n} Exactamente n repeticiones
    //"a{3}" coincide con "aaa", pero no con "aa".

//{n,} Al menos n repeticiones
    //"a{2,}" coincide con "aa", "aaa", "aaaa".

//{n,m} Entre n y m repeticiones
    //"a{2,4}" coincide con "aa", "aaa", "aaaa", pero no con "aaaaa".

//?= Es el operador que indica un lockheed (una condición)
    //Queremos matchear solo la palabra “ABC” cuando está seguida de 3 dígitos.
    //ABC(?=\d{3})
    //ABC123 ABC99 ABC000 coincide con; ABC      (del ABC123) , ABC      (del ABC000)


        Ejemplos
        URLs: ^(https?|ftp)://[^\s/$.?#].[^\s]*$

        Email: ^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,}$

        Contraseñas Seguras: ^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$