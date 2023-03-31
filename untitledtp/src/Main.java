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
          String[] nombresequipo= new String[4];
          int[] golesanotados= new int[4];

          for(int i=0;(lineares= br.readLine())!=null;i++) {
              String[] posicion = lineares.split(";");

              nombresequipo[i] = posicion[0];
              golesanotados[i] = Integer.parseInt(posicion[1]);
              nombresequipo[i+1] = posicion[2];
              golesanotados[i+1] = Integer.parseInt(posicion[3]);
              i++;
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
            i++;i++;
        }

        ronda ronda1 = new ronda();

            //       lista de equipos
            equipo equipo1 = new equipo(
                    nombresequipo[0],
                    "esta es la seleccion de Messi",
                    1);
            equipo equipo2 = new equipo(
                    nombresequipo[1],
                    "la que antes se preparo para el mundial",
                    2);
            equipo equipo3 = new equipo(
                    nombresequipo[2],
                    "de las mejores de concacaf",
                    3);
            equipo equipo4 = new equipo(
                    nombresequipo[3],
                    "esta es la seleccion lewandowsky",
                    4);

            //      lista de partidos
            partido partido1 = new partido(equipo1, equipo2, golesanotados[0], golesanotados[1]);
            partido partido2 = new partido(equipo3, equipo4, golesanotados[2], golesanotados[3]);

            ronda1.partidos.add(partido1);
            ronda1.partidos.add(partido2);
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
        System.out.println("sumaste :"+puntaje+" puntos con tu pronostico");
    }
}