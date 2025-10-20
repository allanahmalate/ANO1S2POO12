/*
 * 33.	A progym pretende gerir os seus membros. Sabendo que cada membro caracteriza-se por tipo de membro que pode ser Normal (2000mt), Estudante (1500mt) ou Exclusivo (2700mt), tem personal trainer(sim/nao) (500mt) e o número de meses. Pretende-se ler os dados de 5 linhas em um ficheiro de texto e de seguida armazenar em um Array de objectos e:
    a) Visualize os dados do membro inclusive o valor a pagar pela inscrição, sabendo que se o número de meses for igual ou superior a 3, terá direito a um desconto de 10%.
    b) Calcule a quantidade de clientes de cada tipo.
    c) Calcule a quantidade de clientes com personal trainer.
    d) Calcule o valor total de desconto.
    e) Calcule o valor total recebido pelo Progym.
    Nota: Formatar os dados com a moeda em metical
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class TodosMembros33 
{
    private Membro33 [] array;
    private int cont;

    public TodosMembros33()
    {
        array = new Membro33[100];
        cont = 0;
    }

    public void lerFichCriarArray(String nf)
    {
        String umaLinha, tipo, pT;
        StringTokenizer umaCadeia;
        byte qtd;
        int cN=0, cE=0, cX=0,cP=0;
        float tD=0, total=0;

        try
        {
            FileReader fr = new FileReader(nf);
            BufferedReader bfr = new BufferedReader(fr);

            umaLinha = bfr.readLine();

            while(umaLinha != null)
            {
                umaCadeia = new StringTokenizer(umaLinha,";");
                tipo = umaCadeia.nextToken();
                pT = umaCadeia.nextToken();
                qtd = Byte.parseByte(umaCadeia.nextToken());

                Membro33 m = new Membro33(tipo, pT, qtd);
                array[cont] = m;

                switch(tipo)
                {
                    case "Normal" : cN++; break;
                    case "Estudante" : cE++; break;
                    case "Exclusivo" : cX++; break; 
                }

                switch (pT) 
                {
                    case "sim":
                        cP++;
                        break;
                }

                tD += m.getD();

                total += m.getVP();

                cont++;
                umaLinha = bfr.readLine();
            }
            System.out.println("Os dados foram lidos com sucesso!");
            bfr.close();
        }
        catch (FileNotFoundException f) { System.out.println("Ficheiro nao encontrado!"); }
        catch (NumberFormatException n ) { System.out.println(n.getMessage()); }
        catch (IOException e) { System.out.println(e.getMessage()); }
        visualizarQtd(cN,cE,cX);
        System.out.println("Quantidade de clientes com personal trainer: " + cP);
        visualizarTot("Valor total de desconto: ", tD);
        visualizarTot("Valor total recebido pelo Progym: ", total);
    }

    //metodo para visualizar
    public String toString()
    {
        String n="";
        for(int i = 0; i < cont; i++)
            n += array[i] + "\n";
        return n;
    }

    public static void visualizarTot(String msg, float total)
    {
        DecimalFormat mt = new DecimalFormat("###,###,###.00Mtn");
        System.out.println(msg + mt.format(total));
    }

    public static void visualizarQtd(int c1, int c2, int c3)
    {
        
         System.out.println("Visualizar quantidade de clientes por tipo de sabor: ");
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-3s |%n", "Tipo", "Qtd");
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-3s |%n", "Normal", c1);
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-3s |%n", "Estudante", c2);
         System.out.printf("=====================================\n");
         System.out.printf("| %-11s | %-3s |%n", "Exclusivo", c3);
         System.out.printf("=====================================\n");
    }

}
