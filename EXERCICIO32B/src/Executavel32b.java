/*
 * 32.	O Mimmos pretende gerir os pedidos de pizzas dos seus 
 * clientes. Cada pedido contém, o sabor da pizza (que pode ser 
 * Mexicana, Havaiana ou Regina que custam 750MT, 620MT e 500MT 
 * respectivamente) e a quantidade. Leia os dados de 5 linhas de um 
 * ficheiro de texto e armazene em um array de objectos. De seguida:
    a) Visualize todos os dados inclusive o valor a pagar.
    b) Calcule a quantidade de pizzas mexicana vendidas.
    c) Calcule a quantidade de pizzas havaiana vendidas.
    d) Calcule a quantidade de pizzas regina vendidas.
    e) Calcule o valor total obtido em cada tipo de pizza.
    f) Calcule a valor total obtido pelo Mimmos.
 */

import java.text.DecimalFormat;

public class Executavel32b 
{
    public static void main(String[] args) 
	{
		TodosPedidos32b p = new TodosPedidos32b();
	    DecimalFormat m = new DecimalFormat("###,###,###.00 MTS");
	    p.lerFichCriarArray("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXERCICIO32B\\src\\Dados32b.txt");
	    float total = p.calcTotGlobal();
	    System.out.println("Total global="+m.format(total));
	    p.gravar("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXERCICIO32B\\src\\Balanco32b.txt");
	}
}
