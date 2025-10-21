import java.io.*;
import java.text.*;
import java.util.*;


public class EX1 
{
    public static void main(String[] args) 
    {
        byte linhas=3, colunas=4, livres;
        float[][] cofre = new float[linhas][colunas];
        byte[] indice;
        double total=0;

        cofre = preencherArray(linhas,colunas);
        livres = contarLivres(cofre);
        total = calcTotGlobal(cofre);
        indice = procValorMaior(cofre);

        visualizarArray(cofre);
        visualizar(cofre, livres, total, indice);
    }

    public static byte contarLivres(float[][] array)
    {
        byte cont=0;

        for(int i=0; i<array.length; i++)
            for(int j=0; j<array[0].length; j++)
            if(array[i][j] == 0)
            cont++;
            
            return cont;
    }
        
        public static byte[] procValorMaior(float[][] array)
        {
            byte indiceL=0,indiceC=0;
            float maior;
            
            
        for(int i=0; i<array.length; i++)
        { 
            maior = array[i][0];
            for(int j=1; j<array[0].length; j++)
                if(array[i][j] > maior)
                {
                    maior = array[i][j];
                    indiceL = i;
                    indiceC = j;
                }
            }
            
            byte[] indice = {indiceL,indiceC};
            return indice;
        }
        
        public static double calcTotGlobal(float[][] array)
        {
            double total=0;
    
            for(int i=0; i<array.length; i++)
                for(int j=0; j<array[0].length; j++)
                total += array[i][j];
                
                return total;
        }

        public static float[][] preencherArray(byte l, byte c)
        {
            float[][] array = new float[l][c];
            
            for(int i=0; i<array.length; i++)
            {
                System.out.println((i+1) + "o Nivel");
                for(int j=0; j<array[0].length; j++)
                    array[i][j] = validarFloat(j);  
            }
            return array;
        }

        public static void visualizarArray(float[][] array)
        {
            
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[0].length; j++)
            {
                System.out.println(array[i][j] + " ");
            }
            System.out.println();
        }        
    }

    
}
