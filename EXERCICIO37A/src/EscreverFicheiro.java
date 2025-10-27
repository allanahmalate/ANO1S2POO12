import java.io.*;

public class EscreverFicheiro 
{
  public EscreverFicheiro() {}
  
  public void escreverFicheiro(int cont)
  {
	try
	{
	  FileWriter fw = new FileWriter("NovoFicheiro.txt");
	  BufferedWriter bw = new BufferedWriter(fw);
	  
	  bw.write("Quantidade de marcas com inicial 'M': " + cont);
	  bw.close();
	  System.out.println("Ficheiro foi escrito com sucesso!");
	}
	catch(NumberFormatException z)
	{
      System.out.println(z.getMessage());
	}
	catch(IOException x)
	{
	  System.out.println(x.getMessage());
	}
  }
}
