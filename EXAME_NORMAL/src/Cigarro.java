import java.text.DecimalFormat;

public class Cigarro 
{
    private String marca, sabor, tipo;
    private int qtdP, qtd, precoU, qtdR;
    private float vp, vR, vD, viva;
    private DecimalFormat mt;

    public Cigarro(String marca, String sabor, String tipo, int qtdP, int qtd, int precoU, int qtdR)
    {
        this.marca = marca;
        this.sabor = sabor;
        this.tipo = tipo;
        this.qtdP = qtdP;
        this.qtd = qtd;
        this.precoU = precoU;
        this.qtdR = qtdR;
        vp = calcularvCigarros();
        vR = calcularVRecargas();
        vp += vR; 
        vD = calcularVD();
        vp -= vD;
        viva = calcularVIVA();
        vp += viva;
        mt = new DecimalFormat("###,###,###.00 MTS");
    }

    public float calcularvCigarros() { return qtd*precoU; }

    public float calcularVRecargas() 
    { 
        if(tipo.equalsIgnoreCase("Recarregavel"))
            return qtdR*200; 
        else
            return 0;
    }

    public float calcularVD() 
    {
        if(qtd > 10)
            return vp*(23/100f);
        else
            return 0;
    }

    public float calcularVIVA() { return vp*(16/100f);}

    //metodos de acessos
    public String getMarca() { return marca; }
    //public int getQTDP() { return qtdP; }
    public String getSabor() { return sabor; }
    public String getTipo() { return tipo; }
    public int getQTD() { return qtd; }
    //public int getPrecoU() { return precoU; }
    //public int getQTDR() { return qtdR; }
    public float getVP() { return vp; }
    public float getVIVA() { return viva; }
    public float getD() { return vD; }

    public String toString()
    {
        return "Marca: " + marca + "\tQuantidade de Puffs: " + qtdP + "\tSabor: " + sabor + "\nTipo: " + tipo + "\tQuantidade: " + qtd + "\nQuantidade de Recargas: " + qtdR + "\tValor a pagar: " + mt.format(vp);
    }
}
