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

import java.text.DecimalFormat;

public class Pedido32b
{
    //Atributos
    private String sabor;
    private short qtd;
    private float preco, vp;
    private DecimalFormat mt;

    //Metodo construtor
    public Pedido32b(String s, short q)
    {
      sabor = s;
      qtd = q;
      preco = definirPreco();
      vp = calcularVP();
      mt = new DecimalFormat("###,###,###.00 MTS");
    }

    public float definirPreco()
    {
      float p=0;
      switch (sabor.toLowerCase()) //converte o texto do ficheiro para lowercase 
      {
        case "mexicana": p = 750;break;
        case "havaiana": p = 620;break;
        case "regina" :  p = 500;break;
      }

      return p;
    }

    /*
     * public int definirPreco()
      {
        int p=0;
        switch (sabor) 
        {
          case "Mexicana": p = 750;break;
          case "Havaiana": p = 620;break;
          case "Regina" :  p = 500;break;
        }

        return p*qtd;
     */

    public float calcularVP() { return qtd*preco; }

    //Metodos de acesso
    public String getSabor() { return sabor; }
    public short getQtd() { return qtd; }
    public float getPreco() { return preco; } //ERROR AQUI: NAO ERA NECESSARIO
    public float getVP() { return vp; }

    //Metodos de visualizacao
    public String toString() 
    { return "Sabor: " + sabor + "\tQuantidade: " + qtd + "\tPreco: " + mt.format(preco) + "\tValor a pagar: " + mt.format(vp); }
}
