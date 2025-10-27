import java.io.*;
import java.text.*;
//import java.util.*;


public class CEX1 //3.5V 
{
    public static void main(String[] args) throws IOException
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
        
        for(byte i=0; i<array.length; i++)
        { 
            maior = array[i][0];
            for(byte j=1; j<array[0].length; j++)
                if(array[i][j] > maior)
                {
                    maior = array[i][j];
                    indiceL = i;  //ERROR! Type mismatch: cannot convert from int to byte
                    indiceC = j;  //ERROR! Type mismatch: cannot convert from int to byte
                }
        }
        
        byte[] indice = {indiceL,indiceC};
        return indice;
    }
    
    public static double calcTotGlobal(float[][] array) //certo
    {
        double total=0;

        for(int i=0; i<array.length; i++)
            for(int j=0; j<array[0].length; j++)
            total += array[i][j];
            
            return total;
    }

    public static float[][] preencherArray(byte l, byte c) throws IOException 
    {
        float[][] array = new float[l][c];
        
        for(byte i=0; i<array.length; i++)
        {
            System.out.println((i+1) + "o Nivel");
            for(byte j=0; j<array[0].length; j++)
            {
                int cas = (i+1)*j;
                array[i][j] = validarFloat((byte)cas);      //ERROR: The method validarFloat(byte) int the type EX1 is not applicable for the argument (int)
            }
        } 
        return array;
    }

    public static void visualizarArray(float[][] array)
    {
        
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[0].length; j++)
                System.out.println(array[i][j] + " ");
            System.out.println();
        }        
    }

    public static float validarFloat(byte i) throws IOException
    {
        float val;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do
        {
            System.out.println("Valor da joalharia da " + (i+1) + "a coluna(>=0): "); //>= instead of >
            val = Float.parseFloat(br.readLine());
            if(val < 0)
                System.out.println("Erro!Tente Novamente.");
        }while(val < 0);

        return val;
    }

    public static void visualizar(float[][] array, byte livres, double total, byte[] indice)
    {
        DecimalFormat mt = new DecimalFormat("###,###,###.00 MTS");
        System.out.println("Existem " + livres + " posicoes do cofre que se encontram livres");
        System.out.println("Valor total que existe no banco: " + mt.format(total));
        System.out.println("O cliente com o maior valor monetario guardado encontra-se no \n" + indice[0] + "o Nivel\t" + indice[1] + "a coluna."); 
    }
}
