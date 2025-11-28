//Main de Serialización
package edu.uca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Persona> integrantes = new ArrayList<>();

        integrantes.add(new Persona("Lucas", 22));
        integrantes.add(new Persona("Marta", 19));
        integrantes.add(new Persona("Sofía", 25));

        Grupo grupo = new Grupo("Grupo A", integrantes);

        System.out.println(grupo);
    }
}

//Persona de serialización
import java.io.Serializable;
public class Persona implements Serializable {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}
//Grupo Serializable
public class Grupo implements Serializable{
    private String nombreGrupo;
    private List<Persona> personas;

    public Grupo(String nombreGrupo, List<Persona> personas) {
        this.nombreGrupo = nombreGrupo;
        this.personas = personas;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }
    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public List<Persona> getPersonas() {
        return personas;
    }
    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    private String mostrarPersonas() {
        StringBuilder sb = new StringBuilder();
        for (Persona p : personas) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Grupo: " + nombreGrupo + "\n" +
                "Integrantes:\n" + mostrarPersonas();
    }
}
//Serializar Grupo
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializarGrupo {
    public static void main(String[] args) throws Exception{

        List<Persona> integrantes = new ArrayList<>();

        integrantes.add(new Persona("Lucas", 22));
        integrantes.add(new Persona("Marta", 19));
        integrantes.add(new Persona("Sofía", 25));

        Grupo grupo = new Grupo("Grupo A", integrantes);

        ObjectOutputStream salida= new ObjectOutputStream(
                new FileOutputStream("grupo.dat")
        );

        salida.writeObject(grupo);
        salida.close();

        System.out.println("Salida grupo A");
    }
}

//DeserializarGrupo
import java.io.ObjectInputStream;
import java.io.FileInputStream;


public class DeserializarGrupo {
    public static void main(String[] args) throws Exception {
        ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream("grupo.dat")
        );

        Grupo grupoLeido = (Grupo) entrada.readObject();
        entrada.close();

        System.out.println("Grupo leido desde archivo:");
        System.out.println(grupoLeido);
    }

}
