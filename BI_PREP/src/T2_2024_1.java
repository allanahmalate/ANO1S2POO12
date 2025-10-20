import java.io.*;
//import java.text.DecimalFormat; //The import java.text.DecimalFormat is never used
import java.text.NumberFormat;

public class T2_2024_1
{
    public static void main(String[] args) throws IOException 
    {
        byte andares = validarByte("andares",(byte)1,(byte)10);
        byte flats = validarByte("flats por andar",(byte)2,(byte)20);
        float[][] aluguer = preencherArray(andares,flats,(float)100000);
        visualizarProc(aluguer);
    }

    public static byte validarByte(String msg, byte min, byte max) throws IOException
    {
        
        byte val;
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("Introduza o numero de " + msg + "("+ min + "-" +max + "): ");
            val = Byte.parseByte(br.readLine());
            if(val < min || val>max)  
                System.out.println("Erro!Tente Novamente.");
        }while(val < min || val>max); 

        return val;
    }

    public static float validarFloat(int j, float max) throws IOException 
    {
        
        float val;
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("Introduza o valor de aluguer do " + (j+1) + "o flat (0-" +max + "): ");
            val = Float.parseFloat(br.readLine());
            if(val < 0 || val>max)  
                System.out.println("Erro!Tente Novamente.");
        }while(val < 0 || val>max); 

        return val;
    }

    public static float[][] preencherArray(byte l,byte c, float max) throws IOException
    {
        float[][] array = new float[l][c];

        for(int i=0; i<array.length; i++) //percorrer linhas
        {
            System.out.println("***"+ (i+1) + "o Andar***");
            for(int j=0; j<array[0].length;j++) //percorrer colunas
                array[i][j] = validarFloat(j, max);
        }
        return array;
    }

    public static void visualizarProc(float[][] array)
    {
        byte[] indice = procValorMaior(array);
        float notA = percentagemNotA(array); // fraction between 0 and 1
        NumberFormat pct = NumberFormat.getPercentInstance();

        System.out.println("O andar e a flat que paga o aluguer mais caro do predio " + "\n" + (indice[0] + 1) + "o Andar" + "\t" + (indice[1]+1) + "o Flat");
        System.out.println(pct.format(notA) + " dos andares nao estao alugados.");
    }

    public static byte[] procValorMaior(float[][] array)
    {
        byte indiceL = 0, indiceC = 0;
        // Start with the first element as the global maximum
        float maior = array[0][0];

        for (byte i = 0; i < array.length; i++)
        {
            for (byte j = 0; j < array[i].length; j++)
            {
                if (array[i][j] > maior)
                {
                    maior = array[i][j];
                    indiceL = i;
                    indiceC = j;
                }
            }
        }

        byte[] indice = {indiceL, indiceC};
        return indice;
    }
    public static float percentagemNotA(float[][] array)
    {
        int cont = 0, cNA = 0;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                cont++;
                if (array[i][j] == 0.0f)
                    cNA++;
            }
        }

        if (cont == 0) 
            return 0.0f;
        return (float) cNA / (float) cont;
    }
}