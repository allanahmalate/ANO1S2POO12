public class Calculos
{
    public Calculos() {}

    public float totalMassa(Massa []array, int cont, String forma)
    {
        float a=0;

        for(int i=0; i<cont; i++)
            if(array[i].getForma().equalsIgnoreCase(forma))
                a+= array[i].getValorF();

        return a;
    }
    public int  contarLetra(Massa []array, int cont, char x)
    {
        int c=0;

        for(int i=0; i<cont; i++)
            if(array[i].getMarca().toUpperCase().charAt(0) == x)
                c++;

        return c;
    }
    public int contarTipo(Massa[] array, int cont, String tipo)
    {
        int a=0;

        for(int i=0; i<cont; i++)
            if(array[i].getTipo().equalsIgnoreCase(tipo))
                a+= array[i].getQtd();

        return a;
    }
}
