import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class TodosCigarros
{
    private Cigarro[] array;
    private int cont;
    private DecimalFormat mt;

    public TodosCigarros()
    {
        array = new Cigarro[100];
        cont = 0;
        mt = new DecimalFormat("###,###,###.00 MTS");
    }

    public void lerDoFicheiro(String nf)
    {
      String umaLinha, marca, sabor, tipo;
      StringTokenizer umaCadeia;
      int qtdP, qtd, precoU, qtdR;

      try
      {
         FileReader fr = new FileReader(nf);
         BufferedReader bfr = new BufferedReader(fr);
         umaLinha = bfr.readLine();
         

         while(umaLinha != null)
         {
            umaCadeia = new StringTokenizer(umaLinha, ";");
            marca = umaCadeia.nextToken();
            sabor = umaCadeia.nextToken();
            tipo = umaCadeia.nextToken();
            qtdP = Integer.parseInt(umaCadeia.nextToken()); 
            qtd = Integer.parseInt(umaCadeia.nextToken()); 
            precoU = Integer.parseInt(umaCadeia.nextToken()); 
            qtdR = Integer.parseInt(umaCadeia.nextToken()); 
  
            array[cont] = new Cigarro(marca, sabor, tipo, qtdP, qtd, precoU, qtdR);
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
        float[] totais = new float[2];
        totais[0] = calcTotTipo("Recarregavel");
        totais[1] = calcTotTipo("Descartavel");
		try
		{  
			FileWriter fw = new FileWriter(nf);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int k = 0; k < 2; k++)
			{ 
            }
            bw.write("Recarregavel"+";"+mt.format(totais[0]));
            bw.newLine();
            bw.write("Descartavel"+";"+mt.format(totais[1]));
            bw.newLine();
            bw.close();
		} 
		catch (IOException x) { System.out.println(x.getMessage()); }
		System.out.println ("O ficheiro de saida foi criado com nome "+nf);
	}
	//metodo para calcular o total POR TIPO  
	public int calcTotMenta()
	{ 
		int acum = 0;
		for (int j = 0; j < cont; j++)
        {
            if(array[j].getSabor().toLowerCase().contains("menta"))
			    acum += array[j].getQTD();

                //if(array[i].getSabor().toLowerCase().indexOf("menta") != -1)
                //if(array[i].getSabor().toLowerCase().contains("menta"))
        }
		return acum;
	}
	//metodo para calcular o total POR TIPO  
	public float calcTotTipo(String tipo)
	{ 
		float acum = 0;
		for (int j = 0; j < cont; j++)
        {
            if(array[j].getTipo().equalsIgnoreCase(tipo))
			    acum += array[j].getVP();
        }
		return acum;
	}
	//metodo para calcular o total global  
	public float calcTotGlobal()
	{ 
		float acum = 0;
		for (int j = 0; j < cont; j++)
			acum += (array[j].getVP() - array[j].getVIVA());
		return acum;
	}

    /*public String validaString() 
    {
        String x;
        BufferedReader br = new BufferedReader(null);
        return x;
    }
        */
}
