/*
 * 37. Escreva um programa completo com menu em Java, utilizando POO, para fazer a gestão da venda
	de Massas na Indústria Alimentar em Moçambique. Sabe-se que cada massa é caracterizada pela marca,
	tipo (Trigo ou Integral), forma (esparguete, cotovelo e fettucine), prazo de validade, quantidade e preço
	unitário sem IVA. Pretende-se:
		Ler os Dados do ficheiro de texto e armazenar no array de objectos
		Visualizar todos os dados no ecrã, sabendo que se a quantidade da massa for acima de 50, existe
		um desconto de 11%, e se for acima de 100 existe um desconto de 23%. A todos os valores deverá
		se acrescentar o IVA de 16%.
		Calcular o valor total com IVA da massa existente, por forma.
		Escrever no ficheiro de texto a quantidade de marcas de massa que começam com a letra M.
		Verificar qual é o tipo de massa que existe mais em stock.
		Pesquisar uma massa e visualizar no ecrã, recebendo a marca do teclado.
		Escrever os dados em um ficheiro de objectos
		Ler os dados do ficheiro de objectos
	Nota: escolhe os tipos de dados com cuidado, escolha soluções simples para cada tarefa, evite a
	repetição de código. Faça a validação de todos os dados de entrada com o tratamento das excepções.
	Faça apenas os gets necessários. Faça a formatação dos valores monetários. Se possível utilize sempre
	métodos genéricos. Utilize a divisão em classes.

 */

import java.text.DecimalFormat;

public class Executavel 
{
    public static void main(String[] args) 
    {
        TodasMassas t = new TodasMassas();
        DecimalFormat mt = new DecimalFormat("###,###,###.00 MTS");

        t.lerFicheiroOBJ("C:\\Users\\allan\\OneDrive\\Documents\\ClinicaDentariaPOOFichTexto\\CORRECAO_EX37\\DadosOBJ.txt");
        System.out.println(t.toString());

        float tE = t.totalEstoque("Esparguete");
        float tC = t.totalEstoque("Cotovelo");
        float tF = t.totalEstoque("Fettucine");
        System.out.println("Valor total por forma: ");
        System.out.println("Esparguete: " + mt.format(tE) + " Cotovelo: " + mt.format(tC) + " Fettucine: " + mt.format(tF));
        int contM = t.contarM();
        t.escreverFicheiro(contM);

        //

        //int pos = 

    }
}
