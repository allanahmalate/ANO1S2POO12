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
                                                     
import java.text.DecimalFormat; 
public class Calamidade35 
{
    private String nomeC, data;
    private int qtd;
    private float total;
    DecimalFormat mt;

    public Calamidade35(String nomeC, int nE, float tP, String data)
    {
      this.nomeC = nomeC.toUpperCase();
      this.qtd = nE;
      this.total = tP;
      this.data = data;
      mt = new DecimalFormat("###,###,###.00 MTS");
    }

    //Metodos de acesso
    public String getNomeC() { return nomeC; }
    public int getQtd() { return qtd; }
    public float getTotal() { return total; }
    public String getData() { return data; }

    public String toString()
    {
      return "Nome da cidade: " + nomeC + "\tNúmero de edifícios danificados: " + qtd + "\tValor monetário perdido: " + mt.format(total) + "\tData do evento: " + data;
    }
   }