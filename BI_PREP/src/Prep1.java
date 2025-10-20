import java.io.*;
import java.text.DecimalFormat; //ERROR faltava importar decimal format

public class Prep1 
{
    public static void main(String[] args) throws IOException
    {
        byte linhas = validarByte("vendedores", 10);
        byte colunas = validarByte("meses", 12);

        double[][] matrizV = preencherArray(linhas, colunas); //ERRO! faltava [][] 
        double[] totalVendas = preencherArrV(matrizV);
        double[] totalMensal = preencherArrM(matrizV);

        double total = calcularTot(totalVendas);
        byte indiceMaior = procValorMaior(totalMensal);

        visualizarMatriz(matrizV,totalVendas,totalMensal,total);
        visualizarVolume(totalMensal,indiceMaior);
    }

    public static byte validarByte(String item, int max) throws IOException //ERRO! faltava max
    {
        byte val;
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("Introduza o numero de " + item + "(1-" +max + "): ");
            val = Byte.parseByte(br.readLine());
            if(val <= 0 || val>max)  //ERROR =< instead of <=
                System.out.println("Erro!Tente Novamente.");
        }while(val <= 0 || val>max); //ERROR =< instead of <=

        return val;
    }

    public static double validarDouble() throws IOException
    {
        double val;
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        do
        {
            val = Double.parseDouble(br.readLine());
            if(val < 0)
              System.out.println("Erro!Tente Novamente.");
        }while(val < 0);

        return val;
    }
    public static double[][] preencherArray(byte l, byte c) throws IOException
    {
        double[][] array = new double[l][c];

        for (int i=0; i<c; i++) //percorrer colunas
        {
            System.out.println("\n--- " + (i+1) + "o Mes ---");
            for(int j=0; j<l; j++) //percorrer linhas
            {
                System.out.print("Total de vendas do " + (j+1) + "o vendendor(>0): "); //ERROR faltava (>0)
                array[j][i] = validarDouble(); //ERROR faltava metodode validar; deve ser [j][i] pois i percorr e colunas
            }
        }

        return array;
    }

    public static double[] preencherArrV(double[][] matriz)
    {
        double[] array = new double[matriz.length];

        for(byte i=0; i < matriz.length; i++) // CORRIGIDO: 'i' percorre as linhas (vendedores).
            for(byte j=0; j < matriz[0].length; j++) // 'j' percorre as colunas (meses).
                array[i] += matriz[i][j];

        /*for(byte i=0; i<matriz[0].length; i++)
            for(byte j=0; j<matriz.length; j++)
                array[i] += matriz[i][j];
        */

        return array;

    }

    public static double[] preencherArrM(double[][] matriz)
    {
        double[] array = new double[matriz[0].length];

        for(byte i=0; i < matriz[0].length; i++) // CORRIGIDO: 'i' percorre o array de totais mensais (colunas).
            for(byte j=0; j < matriz.length; j++) // 'j' percorre as linhas.
                array[i] += matriz[j][i]; // Lógica de soma de colunas: somar linha 'j' da coluna 'i'.

        /*for(byte i=0; i<matriz.length; i++)
            for(byte j=0; j<matriz[0].length; j++)
                array[i] += matriz[i][j];
        */

        return array;
    }

    public static double calcularTot(double[] array)
    {
        double acum=0;

        for(byte i=0; i<array.length; i++)
                acum += array[i];

        return acum;
    }

    public static byte procValorMaior(double[] totalM) 
    {
        byte indice=0;
        double maior= totalM[0]; //ERROR faltava = totalM[0] (tinha =0)

        for(byte j=1; j<totalM.length; j++) //percorrer as colunas //ERROR j nao era byte
        {
            if(totalM[j] > maior) // ERROR: Lógica invertida. Deve ser '>' para encontrar o MAIOR.
            {
                maior = totalM[j];
                indice = j;
            }
        }

        return indice;
    }

    public static void visualizarMatriz(double[][] matriz, double[] v, double[] m, double tot)
    {
        System.out.println("***MATRIZ DE VENDAS***");
        for(int i=0; i<matriz.length; i++) //percorrer as linhas //ERROR array.lenght instead of matriz.length
        {
            for(int j=0; j<matriz[i].length; j++) //percorrer as colunas
            {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        visualizarArray("Total de Vendas por vendedor", v);
        visualizarArray("Total de Vendas por mes", m);
        System.out.println("\n***TOTAL GERAL DE VENDAS***: " + tot); //ERROR faltava
    }

    public static void visualizarArray(String title, double[] array)
    {
        System.out.println("\n***"+ title + "***");
        for(int i=0; i<array.length; i++) //percorrer as linhas //ERROR array.lenght instead of matriz.length
        {
           System.out.print(array[i] + "\t");
            System.out.println();
        }
    }

    public static void visualizarVolume(double[] tot, byte indice) //ERRROR colocar; instead of ,
    {
        DecimalFormat mt = new DecimalFormat("###,###,###.00 MTS"); //ERROR chamar decimal format sem importar decimal format
        System.out.println("O mes com maior volume de vendas foi Mes " + (indice+1) + "com um total de vendas de " + mt.format(tot[indice]));
    }
}
