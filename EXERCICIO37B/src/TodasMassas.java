import java.io.*;
import java.text.*;
import java.util.*;

public class TodasMassas 
{
  private Massa [] array;
  private int cont;
    
  public TodasMassas()
  {
	array = new Massa[100];
	cont = 0;
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

    /*public String toString()
    {
        String c = "";

        for(int i=0; i < Array.length; i++)
            if (array != null)
                c += array[i] + "\n";

        return c;
    }
    */
    public String toString()
    {
        String c = "";

        for(int i=0; i < cont; i++)
            c += array[i] + "\n";

        return c;
    }

    public void comparar(int i, int t)
    {
        if(i<t)
            System.out.println("Quantidade de Trigo maior");
        else if (i>t)
            System.out.println("Quantidade de Intergral maior");
        else
            System.out.println(" tem as mesmas quantidades!");
    }

    public void escrevernoFichOBJ()
    {
        try
        {
            FileOutputStream f = new FileOutputStream("Dados.dat");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(array);
            o.close();
            System.out.println("Ficheiro gravado com sucesso!");
        }
        catch(IOException e)
        {
            System.out.println("Erro ao gravar o ficheiro: " + e.getMessage());
        }
    }

    public void lerFicheiroOBJ()
    {
        try{
            FileInputStream fz = new FileInputStream("Dados.dat");
            ObjectInputStream oz = new ObjectInputStream(fz);

            array = (Massa[]) oz.readObject();
            o.close();
            System.out.println("Ficheiro lido com sucesso!");
        }
        catch (FileNotFoundException a ) { System.out.println("Ficheiro nao encontrado: " + a.getMessage()); } 
        catch (ClassNotFoundException c) { System.out.println(c.getMessage());} 
        catch (IOException b) { System.out.println(b.getMessage());}
    }

    public int pesquisarProd()
    {
        String marca = validarMarca();

        for(int i=0; i<cont; i++)
        {
            if(array[i].getMarca().equalsIgnoreCase(marca))
                return i;
        }

        return -1;
    }

    public void visualizarObjecto(int pos)
    {
        if ( pos == -1)
            System.out.println("Obj nao encontrado");
        else 
            System.out.println(array[pos]);
    }

    public String validarMarca() 
    {
        String m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in()));

        do
        {
            System.out.println("Introduza a marca a pesquisar: ");
            try
            {
                m = br.readLine();
            }
            catch(NumberFormatException b) { System.out.println();}

            if ( m.length() == 0)
                System.out.println(" ERRO");
         }while(m.length() == 0);
    }
}
