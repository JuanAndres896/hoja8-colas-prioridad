/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos - Seccion 31
* Juan Andres Garcia - 15046
* Rodrigo Barrios - 15009
* Guatemala, octubre 3 de 2016
*/

public class Paciente implements Comparable <Paciente> {
   
    private String nombre, estado, prioridad;
    
    public Paciente (String nombre, String estado, String prioridad){
        this.nombre = nombre;
        this.estado = estado;
        this.prioridad = prioridad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public String getPrioridad(){
        return prioridad;
    }
    
    @Override
    public int compareTo(Paciente otro){
        if (getPrioridad().compareTo(otro.getPrioridad()) > 0){
            return 1;
        }
        else if (getPrioridad().compareTo(otro.getPrioridad()) < 0){
            return -1;
        }
        else return 0;
    }
    
    public String toString(){
        return (nombre+", "+estado+", "+prioridad);
    }
}
