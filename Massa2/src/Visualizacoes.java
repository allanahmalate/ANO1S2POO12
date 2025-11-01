import java.text.DecimalFormat;

public class Visualizacoes
{
    private DecimalFormat mt;

    public Visualizacoes()
    {
        mt = new DecimalFormat("###,###.00 Mts");
    }
    public void visualizarTotal(float c, float f, float e)
    {
        System.out.println("Total cotovelo: "+mt.format(c));
        System.out.println("Total fettucini: "+mt.format(f));
        System.out.println("Total esparguete: "+mt.format(e));
    }
    public String toString(Massa[] array, int cont)
    {
        String x="";

        for(int i=0; i<cont; i++)
            x+= array[i]+"\n";

        return x;
    }
    public void visualizarLetras(int c, char x)
    {
        System.out.println("Quantidade de marcas que comecam com a letra '"+x+"': "+c);
    }
    public void comparar(int i, int t)
    {
        if(i>t)
            System.out.println("tem mais integral");
        else if(t>i)
            System.out.println("tem mais trigo");
        else
            System.out.println("tem a mesma quantidade");
    }
    public void visualizarMarca(int pos, Massa[] array)
    {
        if(pos == -1)
            System.out.println("A marca nao foi encontrada");
        else
            System.out.println(array[pos]);
    }
}
