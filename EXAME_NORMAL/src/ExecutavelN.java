import java.text.DecimalFormat;

public class ExecutavelN 
{
    public static void main(String[] args) 
    {
		TodosCigarros p = new TodosCigarros();
	    p.lerDoFicheiro("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXERCICIO32B\\src\\Dados32b.txt");
	    System.out.println(p);
        int qM = p.calcTotMenta();
        visualizarTotal("Quantidade total de Cigarros cujo sabor entra menta: ", qM);
	    p.gravar("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXAME_NORMAL\\src\\BalancoN.txt");
    }
    
    public static void visualizarTotal(String msg, float total) 
    { 
        System.out.println(msg + total); 
    }
    public static void visualizarTotalMT(String msg, float total) 
    { 
        DecimalFormat m = new DecimalFormat("###,###,###.00 MTS");
        System.out.println(msg + m.format(total)); 
    }
}
