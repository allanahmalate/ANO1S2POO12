import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class TObj 
{
    Calamidade[] array;
    int cont;

    public TObj()
    {
        array = new Calamidade[100];
        cont = 0;
    }

    public void lerDoFicheiro(String nf)
    {
      String umaLinha, cidade, data;
      StringTokenizer umaCadeia;
      int numeroEdificios,valorMonetario=0;

      try
      {
         FileReader fr = new FileReader(nf);
         BufferedReader bfr = new BufferedReader(fr);
         umaLinha = bfr.readLine();
         

         while(umaLinha != null)
         {
            umaCadeia = new StringTokenizer(umaLinha, ";");
            cidade = umaCadeia.nextToken();
            numeroEdificios = Integer.parseInt(umaCadeia.nextToken()); 
            valorMonetario = Integer.parseInt(umaCadeia.nextToken()); 
            data = umaCadeia.nextToken();

            array[cont] = new Calamidade(cidade, numeroEdificios, valorMonetario, data);
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
            n += array[i].toString() + "\n";
        return n;
    }

    public int totalEdificios()
    {
      int contE = 0;

      for(int i=0; i<cont; i++)
        contE += array[i].getNumeroEdificio();

      return contE;
    }

    public int numeroAno()
    {
      int num = 0;

      for(int i=0; i<cont; i++)
        if(array[i].getData().substring(6,10).equals("2025"))
          num++;
      return num;
    }

    	//metodo para calcular o total global  
    public int totalPerdido()
    { 
      int acum = 0;
      for (int j = 0; j < cont; j++)
        acum += array[j].getValorMonetario();
      return acum;
    }

  //METODOS DE FICHEIRO DE TEXTO
	public void gravar(String nf) 
	{ 
    DecimalFormat mt = new DecimalFormat("###,###,###.00 MTS");
		try
		{ 
			FileWriter fw = new FileWriter(nf);
			BufferedWriter bw = new BufferedWriter(fw);
      float total = totalPerdido();
			bw.write("Valor total de dinheiro que foi perdido "+": "+mt.format(total));
			bw.newLine();
			bw.close();
		} 
		catch (IOException x) { System.out.println(x.getMessage()); }
		System.out.println ("O ficheiro de saida foi criado com nome "+nf);
	}
}
