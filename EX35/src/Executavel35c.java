
public class Executavel35c 
{
    public static void main(String[] args) 
    {
        TObj c = new TObj();
        c.lerDoFicheiro("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EX35\\src\\Dados35c.txt");
        System.out.println(c);
        float tTotal = c.totalPerdido();
        final double doacoes = 100000.00*72;
        visualizarMais(tTotal, doacoes);
        int tE = c.totalEdificios();
        visualizarTotal("Numero total de edifícios danificados: ", tE);
        int c25 = c.numeroAno();
        visualizarTotal("Número total de calamidades que aconteceram no ano actual: ", c25);
        c.gravar("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EX35\\src\\Balanco.txt");
    }

    public static void visualizarTotal(String msg, float total) { System.out.println(msg + total); }

    public static void visualizarMais(float t1, final double t2)
    {
        if (t1 <= t2)
         System.out.println("O valor das doacoes chega para gerir as calamidades."); 
        else
         System.out.println("O valor das doacoes não chega para gerir as calamidades."); 
    }
}
