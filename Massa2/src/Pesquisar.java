public class Pesquisar
{
    public Pesquisar(){}

    public int pesquisarMarca(String marca, Massa[] array, int cont)
    {
        for(int i=0; i<cont; i++)
            if(array[i].getMarca().equalsIgnoreCase(marca))
                return i;


        return -1;
    }
}
