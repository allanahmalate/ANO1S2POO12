import java.io.*;
import java.util.*;

public class TodasMassas
{
    private Massa[] array;
    private int cont;
    private Calculos cal;
    private Visualizacoes vis;

    public TodasMassas()
    {
        array = new Massa[100];
        cont =0;
        cal = new Calculos();
        vis = new Visualizacoes();
    }
    public void ler()
    {
        String marca, tipo, forma, prazo, linha;
        int preco, qtd;
        StringTokenizer tk;


        try
        {
            FileReader fr = new FileReader("Dados.txt");
            BufferedReader br = new BufferedReader(fr);

            linha = br.readLine();

            while(linha != null)
            {
                tk = new StringTokenizer(linha, ";");

                marca = tk.nextToken();
                tipo = tk.nextToken();
                forma = tk.nextToken();
                prazo = tk.nextToken();
                qtd = Integer.parseInt(tk.nextToken());
                preco = Integer.parseInt(tk.nextToken());

                array[cont] = new Massa(marca, tipo, forma, prazo, qtd, preco);

                cont++;

                linha = br.readLine();
            }
            br.close();
            System.out.println("Ficheiro lido com sucesso");
        }
        catch(FileNotFoundException fn) {System.out.println("Ficheiro nao encontrado");}
        catch(NoSuchElementException ne){System.out.println(ne.getMessage());}
        catch(NumberFormatException nf) {System.out.println(nf.getMessage());}
        catch(IOException io) {System.out.println(io.getMessage());}
    }
    public void adpVisualizarDados()
    {
       System.out.println(vis.toString(array,cont));
    }
    public void adpTotalMassa()
    {
        float tC = cal.totalMassa(array, cont, "Cotovelo");
        float tF = cal.totalMassa(array, cont, "Fettucini");
        float tE = cal.totalMassa(array, cont, "Esparguete");

       vis.visualizarTotal(tC,tF,tE);
    }
    public void adpContarLetra()
    {
        int c= cal.contarLetra(array, cont, 'M');

       vis.visualizarLetras(c, 'M');
       FileTxt esT = new FileTxt();

       esT.escreverTxt(c,'M');
    }
    public void adpContarTipo()
    {
        int cI = cal.contarTipo(array, cont, "Integral");
        int cT = cal.contarTipo(array, cont, "Trigo");

        vis.comparar(cI,cT);
    }
    public void adpEscreverObj()
    {
        FileObj fO = new FileObj();

        fO.escreverObj(array);
    }
    public void adpLerObj()
    {
        FileObj fO = new FileObj();

        fO.LerObj(array);
    }
    public void adpPesquisarMarca()
    {
        Pesquisar ps = new Pesquisar();
        Validacoes val = new Validacoes();

        String marca = val.validarString("Introduza a marca");
        int pos = ps.pesquisarMarca(marca, array, cont);

        vis.visualizarMarca(pos, array);
    }
    public void adpAcrescentar()
    {
        FileTxt ft = new FileTxt();
        Validacoes val = new Validacoes();

        String marca = val.validarString("Introduza a marca: ");
        String tipo = val.validarString("Intrduza o tipo");
        String forma = val.validarString("Introduza a forma");
        String prazo = val.validarString("Introduza o prazo no formato dd/mm/aaaa");
        int qtd = val.validarInt(0, 1000, "Introduza a quantidade:");
        int preco = val.validarInt(0, 90000, "Introduza o preco:");

        ft.acrescentar(marca, tipo, forma, prazo, qtd, preco);

    }

}
