/*
 * 34. Faça um programa com POO, para ajudar a gerir os processos 
 * clínicos da Clinica Dentária do ISCTEM. Cada processo é 
 * caracterizado pelo código do paciente, nome do paciente, serviço 
 * solicitado (Limpeza, Extração) e tipo de paciente (Normal ou Estudante).
    Pretende-se ler os dados do ficheiro de texto de 5 linhas e de seguida:
    a) Calcular o valor a pagar sabendo que Extração custa 5500mt e 
    Limpeza 2000mt e se o paciente for estudante terá direito a 15% de desconto.
    b) Visualizar todos os processos clinicos.
    c) Calcular o valor total de desconto.
    d) Escrever no ficheiro de texto a quantidade de processos por tipo de paciente.
    e) Saber qual é o serviço mais requisitado a fim de ajudar a clínica 
    melhor gerir seus consumíveis.
    Nota: Formatar os dados com a moeda em metical
 */

import java.io.*;
import java.util.StringTokenizer;

public class TodosProcessos34 
{
    private Processo34[] array;
    private int cont;

    public TodosProcessos34() 
    {
        array = new Processo34[100];
        cont = 0; 
    }

    public void lerFichCriarArray(String nf)
    {
        String umaLinha = "", cod, nome, servico, tipo;
        StringTokenizer umaCadeia;

        try
        {
            FileReader fr = new FileReader(nf);
            BufferedReader bfr = new BufferedReader(fr); //ERROR AQUI: BufferedReader bfr = new ufferedReader(fr);
            umaLinha = bfr.readLine();

            while(umaLinha != null)
            {
                umaCadeia = new StringTokenizer(umaLinha,";");
                cod = umaCadeia.nextToken();
                nome = umaCadeia.nextToken();
                servico = umaCadeia.nextToken();
                tipo = umaCadeia.nextToken();

                Processo34 p = new Processo34(cod, nome, servico, tipo);
                array[cont] = p;

                cont++;
                umaLinha = bfr.readLine();
            }
            //ERROR AQUI: as visualizacoes estavam depois dos catch
            bfr.close(); //ERROR AQUI: NAO EXISTIA
        }
        catch(FileNotFoundException a) { System.out.println("Ficheiro "+ nf +" nao encontrado.");}
        catch(NumberFormatException b) { System.out.println(b.getMessage());}
        catch(IOException c ) { System.out.println(c.getMessage());}
    }

    //metodo para visualizar
    public String toString()
    {
        String n="";
        for(int i = 0; i < cont; i++)
            n += array[i] + "\n";
        return n;
    }

    //metodo para calcular o total global  
	public int contar(String var)
	{ 
		int acum = 0;
		for (int j = 0; j < cont; j++)
            if((array[j].getServico().equals(var)))
			    acum ++;
		return acum;
	}

    //metodo para calcular o total global  
	public float calcTotGlobal()
	{ 
		float acum = 0;
		for (int j = 0; j < cont; j++)
			acum += array[j].getDesconto();
		return acum;
	}

    //METODOS DE FICHEIRO DE TEXTO
    public void gravar(String nf) 
	{ 
        int cE=0, cN=0;
        //contar quantos processos de cada tipo existem
        for (int j = 0; j < cont; j++)
        {
            if (array[j].getTipo().equals("estudante"))
                cE++;
            else
                cN++;
        }

		try
		{ 
			FileWriter fw = new FileWriter(nf);
			BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Quantidade de processos por tipo de paciente: ");
            bw.newLine();
            bw.write("Normal"+": "+cN);
            bw.newLine();
            bw.write("Estudante"+": "+cE);
            bw.newLine();
			bw.close();
		} 
		catch (IOException x) { System.out.println(x.getMessage()); }
		System.out.println ("O ficheiro de saida foi criado com nome "+nf);
	}
}
