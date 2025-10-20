import java.text.DecimalFormat;

public class Executavel 
{
    public static void main(String[] args) {
        TodosPrisioneiros t = new TodosPrisioneiros();
        t.lerDoFicheiro("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\FICH_PREP\\src\\Dados.txt");
        System.out.println(t);
        float total = t.calcTotGlobal();
        visualizarTotal(total);
        t.gravar("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\FICH_PREP\\src\\Balanco.txt");
    }

    public static void visualizarTotal(float total)
    {
        DecimalFormat mt = new DecimalFormat("###,###,###.00 MTS");
        System.out.println("Valor total recebido pela cadeia " + mt.format(total)); //ERROR! MT CANNOT BE RESOLVED
    }
}
