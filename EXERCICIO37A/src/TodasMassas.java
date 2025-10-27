import java.io.*;
import java.text.*;
import java.util.*;

public class TodasMassas 
{
  private Massa [] array;
  private int cont;
  private Visualizacoes vis;
  private Calculos cal;
    
  public TodasMassas()
  {
	array = new Massa[100];
	cont = 0;
	vis = new Visualizacoes();
	cal = new Calculos();
  }

  public void lerDoFicheiro(String nf)
  {
    String umaLinha, marca, tipo, forma, prazo;
    StringTokenizer umaCadeia;
    int qtd, precoU;

    try
    {
        FileReader fr = new FileReader(nf);
        BufferedReader bfr = new BufferedReader(fr);
        umaLinha = bfr.readLine();

        while (umaLinha == null) 
        {
           umaCadeia = new StringTokenizer(umaLinha, ";");
           marca = umaCadeia.nextToken();
           tipo = umaCadeia.nextToken();
           forma = umaCadeia.nextToken();
           prazo = umaCadeia.nextToken();
           precoU = Integer.parseInt(umaCadeia.nextToken());
           qtd = Integer.parseInt(umaCadeia.nextToken());

           array[cont] = new Massa(marca, tipo, forma, prazo, precoU, qtd);
           cont++;
           umaLinha = bfr.readLine();
        }
        bfr.close();
    }
    catch(FileNotFoundException a) { System.out.println("Ficheiro " + nf + " nao encontrado!!");}
    catch(NumberFormatException b) { System.out.println(b.getMessage());}
    catch(IOException c) { System.out.println(c.getMessage());}
  }

  //Metodo adaptador para visualizar os dados
  public void adapVisualizarDados()
  {
	  System.out.println(vis.toString(array,cont));
  }
  
  public void adapTotalDesconto()
  {
	float t = cal.totalDesconto(array, cont);
	vis.visualizarTotalDesconto(t);
  }
  
  public void adapContarServico()
  {
	int contE, contL;
	contE = cal.contarServico("Extracao",cont, array);
	contL = cal.contarServico("Limpeza", cont, array);	
	vis.comparar(contL,contE);
  }
  
  public void adapContarTipo()
  {
	EscreverFicheiro ef = new EscreverFicheiro();  
	int contN, contE;
	
	contN = cal.contarTipo("Normal", cont, array);
	contE = cal.contarTipo("Estudante", cont, array);
	ef.escreverFicheiro(contN, contE);
  }
    
  public void adapPesquisarObjecto()
  {
	Pesquisa p = new Pesquisa();
	int pos = p.pesquisarObjecto(cont, array);
	vis.visualizarObjecto(pos, array);
  }
}
