import org.testng.Assert;
import org.testng.annotations.Test;

public class PatternMatching_RESUELTO {
    //Si se alteran los tests, se invalidará el ejercicio sin posibilidad de corregirlo.
    public static boolean esFechaValida(String fecha) {
        //Validemos fechas en formato dd/mm/yyyy, donde:
        //
        //El día (dd) debe estar entre 01 y 31.
        //El mes (mm) debe estar entre 01 y 12.
        //El año (yyyy) debe tener exactamente 4 dígitos.
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[1-2])/(\\d{4})$"; //<completar el resto donde están los ...";
        return fecha.matches(regex);
    }

    @Test
    public void testEsFechaValida() {
        Assert.assertTrue(esFechaValida("25/12/2025"));
        Assert.assertFalse(esFechaValida("31/13/2025"));
        Assert.assertFalse(esFechaValida("00/01/2025"));
        Assert.assertFalse(esFechaValida("25/12/25"));
    }

    public static boolean esMayusculas(String texto) {;
        return texto.matches("^[A-Z]*(\\D)$");
    }

    @Test
    public void testEsMayusculas() {
        Assert.assertTrue(esMayusculas("HELLO"));
        Assert.assertFalse(esMayusculas("Hello"));
        Assert.assertFalse(esMayusculas("HELLO123"));
        Assert.assertFalse(esMayusculas(""));
    }

    public static boolean esEnteroPositivo(String numero) {
        return numero.matches("^[^-]\\d*$");
    }

    @Test
    public void testEsEnteroPositivo() {
        Assert.assertTrue(esEnteroPositivo("12345"));
        Assert.assertFalse(esEnteroPositivo("-12345"));
        Assert.assertFalse(esEnteroPositivo("12.34"));
        Assert.assertFalse(esEnteroPositivo("abc"));
    }
}