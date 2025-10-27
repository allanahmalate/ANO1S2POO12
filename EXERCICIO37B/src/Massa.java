import java.io.*;
import java.text.DecimalFormat;

public class Massa implements Serializable
{
    private String marca, tipo, forma, prazo; 
    private int pU, qtd;
    private float vp, vd, viva;
    private DecimalFormat mt;

    public Massa(String m, String t, String f, String p, int pu, int q)
    {
        marca = m; 
        tipo = t;
        forma = f;
        prazo = p;
        pU = pu;
        qtd = q;
        vp = calcVP();
        vd = calcD();
        vp -= vd;
        viva = calcIVA();
        vp += viva;
        mt = new DecimalFormat("###,###,###.00 MTS");
    }

    public float calcD()
    {
        final float DESC1 = 1/1f, DESC2 = 1/1f;
        if(qtd>100)
            return vp*DESC1;
        else if (qtd>50)
            return vp*DESC2;
        return 0;
    }

    public float calcVP()
    {
        return pU * qtd;
    }

    public float calcIVA()
    {
        final float IVA = 16/100f;
        return vp * IVA;
    }

    public String getMarca() { return marca; }
    public String getTipo() { return tipo; }
    public String getForma() { return forma; } 
    //public String getPrazo() { return prazo; }
    public int getQTD() { return qtd; }
    //public int getPrecoU() { return pU; }
    public float getVP() { return vp; }
    //public float getVD() { return vd; }
    public float getVIVA() { return viva; }

    public String toString() {
		return "Massa [marca=" + marca + ", tipo=" + tipo + ", forma=" + forma + ", prazo=" + prazo + ", quantidade="
				+ qtd + ", preco unitario=" + mt.format(pU) + ", Valor a pagar=" + mt.format(vp) + "]";
	}
}
