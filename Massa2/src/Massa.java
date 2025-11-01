import java.io.Serializable;
import java.text.DecimalFormat;

public class Massa implements Serializable
{
    private String marca, tipo, forma, prazo;
    private int qtd, preco;
    private float valorSemD, valorComD, desconto, valorF, iva;
    private DecimalFormat mt;

    public Massa(String mar, String tp, String fo, String pr, int q, int pre)
    {
        marca = mar;
        tipo= tp;
        forma = fo;
        prazo =pr;
        qtd = q;
        preco = pre;

        valorSemD= calcularVp();
        desconto = calcularD();
        valorComD = calcularcomD();
        iva= calcularIva();
        valorF = calcularVf();
        mt = new DecimalFormat("###,###.00 Mts");
    }
    public int calcularVp()
    {
        return qtd*preco;
    }
    public float calcularD()
    {
        final float DESC50 = 11/100f, DESC100 = 23/100f;

        if(qtd>100)
            return valorSemD*DESC50;
        else if(qtd>50)
            return valorSemD* DESC100;

        return 0;
    }
    public float calcularcomD()
    {
        return valorSemD-desconto;
    }
    public float calcularIva()
    {
        final float IVA = 16/100f;

        return valorComD * IVA;
    }
    public float calcularVf()
    {
        return valorComD+ iva;
    }

    public String getMarca() {return marca;}

    public int getQtd() {return qtd;}

    public String getTipo() {return tipo;}

    public String getForma() {return forma;}

    public float getValorF() {return valorF;}

    public String toString()
    {
        return "Marca: "+marca+"\nTipo: "+tipo+"\nForma: "+forma+"\nPrazo: "
                +prazo+"\nQuant: "+qtd+"\nPreco: "+mt.format(preco)+
                "\nValor SemD: "+mt.format(valorSemD)+"\nDesconto: "+mt.format(desconto)+
                "\nValor com D: "+mt.format(valorComD)+"\nIva: "+mt.format(iva)+
                "\nValor com iva: "+mt.format(valorF)+"\n------------------------------------------------";
    }
}