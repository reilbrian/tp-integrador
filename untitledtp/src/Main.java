import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String pronostico = "C:\\Users\\brian\\OneDrive\\Escritorio\\escuela\\Argentina Programa\\tp integrador\\untitledtp\\pronostico.csv";
        String resultados = "C:\\Users\\brian\\OneDrive\\Escritorio\\escuela\\Argentina Programa\\tp integrador\\untitledtp\\resultados.csv";
        System.out.println("Este es nuestro string path:" + resultados);
        System.out.println("Este es nuestro string path:" + pronostico);

        //       lectura de los resultados de los partidos

          String lineares; //string que lee los resultados uno por uno
          BufferedReader br= new BufferedReader(new FileReader("resultados.csv"));
          lineares= br.readLine();
          String[] nombresequipo= new String[100];
          int[] golesanotados= new int[100];
          int equiposcant=0;

          for(int i=0;(lineares= br.readLine())!=null;i++) {
              String[] posicion = lineares.split(";");

              nombresequipo[i] = posicion[0];
              golesanotados[i] = Integer.parseInt(posicion[1]);
              nombresequipo[i+1] = posicion[2];
              golesanotados[i+1] = Integer.parseInt(posicion[3]);
              i++;equiposcant=equiposcant+2;
          }

          //formador de equipos
          equipo equipos[]=new equipo[equiposcant];
          partido partidos[]=new partido[equiposcant];
          ronda ronda1 = new ronda();
          for (int i=0;i<equiposcant;i++){
              equipos[i]=new equipo(nombresequipo[i],i);
          }

          //formador de partidos
          int j=0;
          for (int i=0;i<(equiposcant/2);i++){
              partidos[i]=new partido(equipos[j],equipos[j+1],golesanotados[j],golesanotados[j+1]);
              ronda1.partidos.add(partidos[i]);
              j=j+2;
          }

         // lectura del pronostico de los partidos

        String lineapro;
        BufferedReader br1= new BufferedReader(new FileReader("pronostico.csv"));
        String[] resultadospro = new String[6];
        lineapro= br1.readLine();

        for(int i=0;(lineapro = br1.readLine())!=null;i++) {

            String[] posicion2 = lineapro.split(";");

            resultadospro[i] = posicion2[1];
            resultadospro[i+1] = posicion2[2];
            resultadospro[i+2] = posicion2[3];
            i=i+2;
        }

        ronda1.ListarGanadores();

        int puntaje=0;

       if (golesanotados[0]>golesanotados[1] && resultadospro[0].equals("x")){
           puntaje++;
       }
       if (golesanotados[1]>golesanotados[0] && resultadospro[2].equals("x")){
           puntaje++;
       }
       if (golesanotados[0]==golesanotados[1] && resultadospro[1].equals("x")){
           puntaje++;
       }
       if (golesanotados[2]>golesanotados[3] &&  resultadospro[3].equals("x")){
           puntaje++;
       }
      if (golesanotados[3]>golesanotados[2] && resultadospro[5].equals("x")){
           puntaje++;
       }
      if (golesanotados[2]==golesanotados[3] && resultadospro[4].equals("x")){
           puntaje++;
       }
        System.out.println("sumaste :"+puntaje+" puntos con tu pronostico ");
    }
}