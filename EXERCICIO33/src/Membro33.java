/*
 * 33.	A progym pretende gerir os seus membros. Sabendo que 
 * cada membro caracteriza-se por tipo de membro que pode ser 
 * Normal (2000mt), Estudante (1500mt) ou Exclusivo (2700mt), 
 * tem personal trainer(sim/nao) (500mt) e o número de meses. 
 * Pretende-se ler os dados de 5 linhas em um ficheiro de texto e de 
 * seguida armazenar em um Array de objectos e:
    a) Visualize os dados do membro inclusive o valor a pagar pela 
    inscrição, sabendo que se o número de meses for igual ou superior a 
    3, terá direito a um desconto de 10%.
    b) Calcule a quantidade de clientes de cada tipo.
    c) Calcule a quantidade de clientes com personal trainer.
    d) Calcule o valor total de desconto.
    e) Calcule o valor total recebido pelo Progym.
    Nota: Formatar os dados com a moeda em metical
 */

import java.text.DecimalFormat;

public class Membro33 
{
    private String tipo, pT;
    private byte qtd;
    private float preco, vp, d;
    private DecimalFormat mt;

    public Membro33(String t, String p, byte n) 
    {
        tipo = t;
        pT = p;
        qtd = n;
        preco = definirPreco();
        vp = calcularVP();
        d = calcularD();
        vp -= d;
        mt = new DecimalFormat("###,###,###.00 MTS");
    }

    public float definirPreco()
    {
        switch(tipo)
        {
            case "Normal": return 2000;
            case "Estudante" : return 1500;
            case "Exclusivo" : return 2700;
        }
        return 0;
    }

    public float calcularVP()
    {
        final float PT = 500;

        if(pT == "sim")
            return (preco + PT) * qtd;
        else 
            return preco * qtd;
    }


    public float calcularD() 
    {
        final float D3 = 10/100f;

        if(qtd >= 3)
            return (vp*D3);
        else 
            return 0;
    }

    //Metodos de acesso
    public String gettipo() { return tipo; }
    public String getpT() { return pT; }
    public byte getQtd() { return qtd; }
    public float preco() { return preco; }
    public float getVP() { return vp; }
    public float getD() { return d; }

    //Metodo de visualizacao de dados
    public String toString()
    { return "Tipo de membro: " + tipo + "\tTem personal trainer? " + pT + "\tQuantidade de meses: " + qtd + "\tPreco: " + mt.format(preco) + "\tValor a pagar: " + mt.format(vp); }
}
