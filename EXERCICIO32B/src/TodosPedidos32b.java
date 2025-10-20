/*
 * 32.	O Mimmos pretende gerir os pedidos de pizzas dos seus 
 * clientes. Cada pedido contém, o sabor da pizza (que pode ser 
 * Mexicana, Havaiana ou Regina que custam 750MT, 620MT e 500MT 
 * respectivamente) e a quantidade. Leia os dados de 5 linhas de um 
 * ficheiro de texto e armazene em um array de objectos. De seguida:
    a) Visualize todos os dados inclusive o valor a pagar.
    b) Calcule a quantidade de pizzas mexicana vendidas.
    c) Calcule a quantidade de pizzas havaiana vendidas.
    d) Calcule a quantidade de pizzas regina vendidas.
    e) Calcule o valor total obtido em cada tipo de pizza.
    f) Calcule a valor total obtido pelo Mimmos.
 */

import java.util.StringTokenizer;
import java.io.*;
import java.text.DecimalFormat;

public class TodosPedidos32b
{
   private Pedido32b array[]; //Array de objectos para guardar obj Pedido32b
	private int cont;  //contador para controlar as posições do array

	public TodosPedidos32b()
	{ 
		array = new Pedido32b[100];
		cont=0;  
	}

   //metodo para ler os dados do ficheiro, criar o objecto e guardar no array de objectos
   public void lerFichCriarArray(String nf) 
	{
		//Para ler do ficheiro
		StringTokenizer umaCadeia;   
		String umaLinha="", sabor;
		short qtd=0;
		//Para operacoes
		int qM=0, qH=0, qR=0;
		float tM=0, tH=0, tR=0;

		try
		{ 
			FileReader fr = new FileReader(nf);
			BufferedReader br = new BufferedReader(fr);
			umaLinha = br.readLine();
			
			while (umaLinha != null) 
			{
				umaCadeia = new StringTokenizer (umaLinha,";"); //Lemos a linha como um pedaco de string
				sabor = umaCadeia.nextToken(); 					//Ler o primeiro pedaco
            	qtd = Short.parseShort(umaCadeia.nextToken());  //Ler segundo pedaco
				
				//criacao do objecto pedido32b e armazenamento no array de objectos
				Pedido32b p = new Pedido32b(sabor, qtd);
            	System.out.println(p); //visualizacao do objecto criado
				array[cont] = p; //ou array[cont] = new Pedido32(sabor,vp);
				cont++;			//deve-se actualizar o contador para garantir que o proximo objecto va para a proxima posicao vazia
				
            switch (sabor.toLowerCase()) 
            {
               case "Mexicana": qM += qtd; tM += p.getVP();break;
               case "Havaiana": qH += qtd; tH += p.getVP();break;
               case "Regina" :  qR += qtd; tR += p.getVP();break;
            }

            umaLinha = br.readLine();
			}
			br.close();
		} 
		catch (FileNotFoundException a)	{ System.out.println("Ficheiro "+ nf +"nao encontrado!"); }
		catch (NumberFormatException b) { System.out.println(b.getMessage()); }
		catch (IOException c) {System.out.println(c.getMessage()); }

      visualizarQtd(qM, qH, qR);
      visualizarTotal(tM,tH,tR);
      visualizarTot(tM,tH,tR);
	}

   public static void visualizarQtd(int c1, int c2, int c3)
    {
        
         System.out.println("Visualizar quantidade de clientes por tipo de sabor: ");
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-3s |%n", "Tipo", "Qtd");
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-3s |%n", "Mexicana", c1);
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-3s |%n", "Havaina", c2);
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-3s |%n", "Regina", c3);
         System.out.printf("=====================================\n");
    }

    public static void visualizarTot(float t1, float t2, float t3)
    {
        float total = (t1 + t2 + t3);
        DecimalFormat mt = new DecimalFormat("###,###,###.00Mtn");

        System.out.println("Valor total obtido: "+ mt.format(total));
    }

    public static void visualizarTotal(float t1, float t2, float t3)
    {
        DecimalFormat mt = new DecimalFormat("###,###,###.00Mtn");
        
         System.out.println("Visualizar valor total de clientes por tipo de sabor: ");
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-20s |%n", "Tipo", "Valor total");
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-20s |%n", "Mexicana", mt.format(t1));
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-20s |%n", "Havaiana", mt.format(t2));
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-20s |%n", "Regina", mt.format(t3));
         System.out.printf("=====================================\n");
    }

    //metodo para gravar os nomes e respectivos totais de cada pedido32b
	public void gravar(String nf) 
	{ 
		DecimalFormat mt = new DecimalFormat("###,###,###.00Mts");
		try
		{ 
			FileWriter fw = new FileWriter(nf);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int k = 0; k < cont; k++)
			{ 
				bw.write(array[k].getSabor()+";"+mt.format(array[k].getVP()));
				bw.newLine();
			}
			bw.close();
		} 
		catch (IOException x) { System.out.println(x.getMessage()); }
		System.out.println ("O ficheiro de saida foi criado com nome "+nf);
	}

	//metodo para calcular o total global
	public float calcTotGlobal()
	{ 
		float soma = 0;
		for (int j = 0; j < cont; j++)
			soma += array[j].getVP();
		return soma;
	}

	/*
	 * public int contarQtd(String sabor)
		{ 
			int x = 0;
			for (int a = 0; a < cont; a++)
				if(pedido[i].getSabor().equalsIgnoreCase(sabor))
					x++
			return x;
		}
	 */

	//metodo para visualizar todos os dados de todos objectos
	public String toString()
	{ 
		String x = "";
		for (int a = 0; a < cont; a++)
			x += array[a] + "\n";  //.toString() é opcional
		return x;
	}
}
