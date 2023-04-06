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
        BufferedReader br = new BufferedReader(new FileReader(resultados));
        lineares = br.readLine();
        String[] nombresequipo = new String[100];
        int[] golesanotados = new int[100];
        int equiposcant = 0;

        for (int i = 0; (lineares = br.readLine()) != null; i++) {
            String[] posicion = lineares.split(";");

            nombresequipo[i] = posicion[0];
            golesanotados[i] = Integer.parseInt(posicion[1]);
            nombresequipo[i + 1] = posicion[2];
            golesanotados[i + 1] = Integer.parseInt(posicion[3]);
            i++;
            equiposcant = equiposcant + 2;
        }

        //formador de equipos
        equipo equipos[] = new equipo[equiposcant];
        partido partidos[] = new partido[equiposcant];
        ronda ronda1 = new ronda();
        for (int i = 0; i < equiposcant; i++) {
            equipos[i] = new equipo(nombresequipo[i], i);
        }

        //formador de partidos
        int j = 0;
        for (int i = 0; i < (equiposcant / 2); i++) {
            partidos[i] = new partido(equipos[j], equipos[j + 1], golesanotados[j], golesanotados[j + 1]);
            ronda1.partidos.add(partidos[i]);
            j = j + 2;
        }

        // lectura del pronostico de los partidos

        String lineapro;
        BufferedReader br1 = new BufferedReader(new FileReader(pronostico));
        String[] resultadospro = new String[100];
        String[] nombres=new String[100];
        lineapro = br1.readLine();
        int proncant = 0;

        for (int i = 0; (lineapro = br1.readLine()) != null; i++) {

            String[] posicion = lineapro.split(";");

            resultadospro[i] = posicion[1];
            resultadospro[i + 1] = posicion[2];
            resultadospro[i + 2] = posicion[3];
            i = i + 2;
            proncant++;
        }

        ronda1.ListarGanadores();
        //detecta los pronosticos
        int puntaje = 0;
        j=0;int z=0; String aux=nombres[0];

        for (int i = 0; i <proncant; i++) {
            if (golesanotados[j] >  golesanotados[j+1] && resultadospro[z].equals("x"))   {puntaje++;}
            if (golesanotados[j] == golesanotados[j+1] && resultadospro[z+1].equals("x")) {puntaje++;}
            if (golesanotados[j] <  golesanotados[j+1] && resultadospro[z+2].equals("x")) {puntaje++;}
            j=j+2;z=z+3;
        }
            System.out.println("sumaste :" + puntaje + " puntos con tu pronostico ");
    }
}