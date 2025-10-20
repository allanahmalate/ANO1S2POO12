import java.io.*;
import java.util.*;
//import java.text.DecimalFormat; //ERROr IS NEVER USED

public class TodosPrisioneiros 
{
    private Prisioneiro[] array;
    private int cont;

    public TodosPrisioneiros()
    {
        array = new Prisioneiro[1000];
        cont=0;
    }

    public void lerDoFicheiro(String nf)
    {
      String umaLinha, nome, data, duracao, motivo;
      StringTokenizer umaCadeia;

      try
      {
         FileReader fr = new FileReader(nf);
         BufferedReader bfr = new BufferedReader(fr);
         umaLinha = bfr.readLine();
         

         while(umaLinha != null)
         {
            umaCadeia = new StringTokenizer(umaLinha, ";");
            nome = umaCadeia.nextToken(); 
            data = umaCadeia.nextToken();
            duracao = umaCadeia.nextToken();
            motivo = umaCadeia.nextToken();
           
            array[cont] = new Prisioneiro(nome, data, duracao, motivo);
            cont++;
            umaLinha = bfr.readLine();
         }
         bfr.close();
      }
      catch (FileNotFoundException a) { System.out.println("ficheiro " + nf + " nao encontrado!");}
      catch (NumberFormatException b) { System.out.println(b.getMessage());}
      catch (IOException i) { System.out.println(i.getMessage());}
    }

    //metodo para visualizar
    public String toString()
    {
        String n="";
        for(int i = 0; i < cont; i++)
            n += array[i] + "\n";
        return n;
    }

    //METODOS DE FICHEIRO DE TEXTO
	public void gravar(String nf) 
	{ 
        int cont = contarIdosos();
		try
		{ 
			FileWriter fw = new FileWriter(nf);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Numero de prisioneiros com mais de 50 anos "+": "+ cont);
			bw.newLine();
			bw.close();
		} 
		catch (IOException x) { System.out.println(x.getMessage()); }
		System.out.println ("O ficheiro de saida foi criado com nome "+nf);
	}
    public int contarIdosos()
    { 
        //tava dar error pq eu tava usar cont (uma var global), logo a solucao foi trocar o nome da var local para contador
        int contador = 0;
        for (int j = 0; j < cont; j++)
        {
            if(array[j].getIdade() > 50) //ERROR! SINTAX ERROR ON TOKEN "(", EXPRESSION EXPECTED AFTER THIS TOKEN
                contador++;
        }
        return contador;
    }

    /*
     * public int contarIdosos()
    { 
        int cont =0;
        for (int j = 0; j < cont; j++)
        {
            if(array[j].getIdade() == 50) //ERROR! SINTAX ERROR ON TOKEN "(", EXPRESSION EXPECTED AFTER THIS TOKEN
                cont ++;
            }
        return cont;
    }
     */

	//metodo para calcular o total global  
	public float calcTotGlobal()
	{ 
		float acum = 0;
		for (int j = 0; j < cont; j++)
			acum += (array[j].getValorE() + array[j].getFianca()); //ERRO! The method get Fianca() is undefined for the type Prisioneiro
		return acum;
	}

}
