/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos - Seccion 31
* Juan Andres Garcia - 15046
* Rodrigo Barrios - 15009
* Guatemala, octubre 3 de 2016
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;

public class MainPriorityQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre, estado, prioridad;
        PriorityQueue<Paciente> vh = new PriorityQueue<Paciente>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
           //Se crea un archivo tipo file que representa al diccionario
           //en la siguiente linea hay que ingresar la dirección completa del archivo de diccionario
           archivo = new File ("C:\\Users\\Rodrigo\\Documents\\2do ciclo 2016\\ADT\\hoja8\\HDT8\\src\\pacientes.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);//BufferedReader es un objeto que puede leer archivos de texto y guardarlos en Strings

           // Lectura del fichero
           String linea = br.readLine();
           //Mientras haya una linea que leer, la agrega a la lista palabras
           System.out.println("Los pacientes que deben ser atendidos, en desorden, son los siguientes: \n");
           while(linea!=null){
              int lugar1 = linea.indexOf(',');
              nombre = linea.substring(0, lugar1);
              String resto = linea.substring(lugar1+2);
              int lugar2 = resto.indexOf(',');
              estado = resto.substring(0, lugar2);
              prioridad = resto.substring(lugar2+2);
              System.out.println(linea);
              Paciente enfermo = new Paciente(nombre, estado, prioridad);
              vh.add(enfermo);
              linea = br.readLine();
           }
        }//excepcion
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos que se cierra tanto si todo va bien como si salta una excepcion
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        System.out.println("\nLos pacientes deben ser atendidos en el siguiente orden: \n");
        while(!vh.isEmpty()){
            Paciente siguiente = vh.poll();
            System.out.println(siguiente.getNombre()+", "+siguiente.getEstado()+", "+siguiente.getPrioridad());
        }
    }
    
}
