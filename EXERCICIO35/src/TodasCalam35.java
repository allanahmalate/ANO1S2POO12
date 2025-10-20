/*
 * 35. Faça um programa com POO, sem menu, para poder fazer a 
 * gestão de calamidades que afectam varias cidades em Moçambique.
    Sabe-se que cada calamidade caracteriza-se pelo nome da cidade, 
    número de edifícios danificados, valor monetário perdido em 
    meticais e a data do evento (DD/MM/AAAA). Pretende-se ler 
    os dados do ficheiro de texto de 5 linhas e armazenar em um array de 
    objectos e de seguida:
    a) Visualizar todos os dados no ecrã.
    b) Calcular o numero total de edifícios danificados.
    c) Calcular o número total de calamidades que aconteceram no ano actual.
    d) Escrever no ficheiro de texto o valor total de dinheiro que foi perdido.
    e) Sabendo que o país recebe 100 000USD de doações, verifique se o valor chega ou não para gerir as calamidades (Considere o cambio 72)
 */

import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class TodasCalam35 
{
    private Calamidade35[] array;
    private int cont;
    private DecimalFormat mt;

    public TodasCalam35()
    {
      array = new Calamidade35[100];
      cont=0;
      mt = new DecimalFormat("###,###,###.00 MTS");
    }

    public void lerFichCriarArray(String nf)
    {
      String umaLinha, nomeC, data;
      StringTokenizer umaCadeia;
      int qtd;
      float total=0;

      try
      {
         FileReader fr = new FileReader(nf);
         BufferedReader bfr = new BufferedReader(fr);
         umaLinha = bfr.readLine();
         

         while(umaLinha != null)
         {
            umaCadeia = new StringTokenizer(umaLinha, ";");
            nomeC = umaCadeia.nextToken();
            qtd = Integer.parseInt(umaCadeia.nextToken()); 
            total = Float.parseFloat(umaCadeia.nextToken()); 
            data = umaCadeia.nextToken();
           

            Calamidade35 c = new Calamidade35(nomeC, qtd, total, data);
            //System.out.println(c);
            array[cont] = c;
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

	public int acumData()
	{ 
		int acum = 0;
		for (int j = 0; j < cont; j++)
         if(array[j].getData().substring(6,10).equals("2025"))
			   acum ++;
		return acum;
	}

	public int acumQtd()
	{ 
		int acum = 0;
		for (int j = 0; j < cont; j++)
			acum += array[j].getQtd();
		return acum;
	}

    public static void visualizarTotal(String msg, float total) { System.out.println(msg + total); }

    public static void visualizarMais(float t1, final float t2)
    {
        if (t1 <= t2)
         System.out.println("O valor das doacoes chega para gerir as calamidades."); 
        else
         System.out.println("O valor das doacoes não chega para gerir as calamidades."); 
    }
    //METODOS DE FICHEIRO DE TEXTO
	public void gravar(String nf) 
	{ 
		try
		{ 
			FileWriter fw = new FileWriter(nf);
			BufferedWriter bw = new BufferedWriter(fw);
         float total = calcTotGlobal();
			bw.write("Valor total de dinheiro que foi perdido "+": "+mt.format(total));
			bw.newLine();
			bw.close();
		} 
		catch (IOException x) { System.out.println(x.getMessage()); }
		System.out.println ("O ficheiro de saida foi criado com nome "+nf);
	}
	//metodo para calcular o total global  
	public float calcTotGlobal()
	{ 
		float acum = 0;
		for (int j = 0; j < cont; j++)
			acum += array[j].getTotal();
		return acum;
	}
}
