/*
 * 23. Armazenar em um array bidimensional de 10 linhas e 20 
 * colunas, valores aleatórios de 0 a 200, de seguida calcular e 
 * visualizar a soma de todos elementos pares do array, visualizar o 
 * menor valor de uma linha escolhida pelo utilizador, e visualizar o array.
 */

import java.io.*;
//import java.util.Random;

public class E23
{
    public static void main(String[] args) throws IOException
    {
        int linhas = 10;
        int colunas = 20;
        int[][] valores = preencherArray(linhas,colunas);
        visualizar(valores);

        long soma = soma(valores, linhas, colunas);
        visualizarsoma(soma);

        byte escolha = receberescolha(linhas-1); 
        int menor = acharMenor(valores, escolha);
        visualizarMenor(menor, escolha);

    }

    public static int[][] preencherArray(int l, int c)
    {
        int[][] array = new int[l][c];

        for (int i=0; i<array.length; i++)
            for(int j=0; j<array[0].length; j++)
                array[i][j] = (int)Math.random()*201;

        return array;
    }

    public static int[][] verificarpares(int[][] array, int l, int c)
    {
        int[][] pares = new int[l][c];
        for (int i=0; i<array.length; i++)
            for(int j=0; j<array[0].length; j++)
            {
                if(array[i][j] % 2 == 0)
                    pares[i][j] = array[i][j];
                else
                    pares[i][j] = 0;
            }

        return pares;
    }

    public static long soma(int[][] array, int l, int c)
    {
        int[][] pares = verificarpares(array, l, c);
        long soma = 0;

        for (int i=0; i<pares.length; i++)
            for(int j=0; j<pares[0].length; j++)
                soma += pares[i][j];
        
        return soma;
    }

    public static byte receberescolha(int l) throws IOException
    {
        byte escolha;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("Introduza a linha que deseja (1ª-9ª):");
            escolha = Byte.parseByte(br.readLine());
            if(escolha<=0 || escolha>l)
                System.out.println("Opcao Invalida!Tente Novamente");
        }while(escolha<=0 || escolha>l);

        return escolha;
    }

    public static void visualizarsoma(long soma)
    {
        System.out.println("Soma dos numeros pares: " + soma);
    }

    public static void visualizar(int[][] array) 
    {
        for(int i=0; i<array.length; i++) //percorrer as linhas
        {
            for(int j=0; j<array[i].length; j++) //percorrer as colunas
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int acharMenor(int[][] array, byte i) 
    {
        int menor = array[0][0];

        for(int j=0; j<array[i].length; j++) //percorrer as colunas
        {
            if(array[i][j] < menor)
                menor = array[i][j];
        }

        return menor;
    }

    public static void visualizarMenor(int menor, byte l)
    {
        System.out.println("Menor valor na "+ l + "a linha: "+ menor);
    }
}

