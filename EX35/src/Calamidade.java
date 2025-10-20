import java.text.DecimalFormat;
//Nao escrever metodos de acesso right away, deixar linhas para fazer dps;
//bidimenensional e POO
public class Calamidade 
{
    private String cidade, data;
    private int numeroEdificios, valorMonetario;
    private DecimalFormat mt;

    public Calamidade(String c, int n, int v, String d)
    {
        cidade = c;
        numeroEdificios = n;
        valorMonetario = v;
        data = d;
        mt = new DecimalFormat("###,###,###.00 MTS");
    }

    //Metodos de acesso
    public String getcidade() { return cidade; }
    public int getNumeroEdificio() { return numeroEdificios; }
    public float getValorMonetario() { return valorMonetario; }
    public String getData() { return data; }

    public String toString()
    {
      return "Nome da cidade: " + cidade + "\tNúmero de edifícios danificados: " + numeroEdificios + "\tValor monetário perdido: " + mt.format(valorMonetario) + "\tData do evento: " + data;
    }
}
