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
public class Menu 
{
  public Menu() {}
  
  public void menu()
  {
	int op;
	Validacoes val = new Validacoes();
	TodasMassas m = new TodasMassas();
	
	do
	{
	  System.out.println("   *** MENU ***  ");
	  System.out.println("1. Ler do ficheiro e armazenar no array de objectos");
	  System.out.println("2. Visualizar os dados");
	  System.out.println("3. Valor total com IVA, por forma");
	  System.out.println("4. Escrever no ficheiro quantidade de marcas com inicial 'M'");
	  System.out.println("5. Tipo de massa mais em stock!");
	  System.out.println("6. Pesquisar massa com base na marca");
	  System.out.println("7. Escrever os dados em um ficheiro de objectos");
	  System.out.println("8. Sair do programa");
	  
	  op = val.validarInt(1, 8, "Introduza a opcao(1-8)");
	  
	  switch(op)
	  {
	  case 1: m.lerDoFicheiro("C:\\Users\\allan\\OneDrive\\Documents\\ClinicaDentariaPOOFichTexto\\FABRICA_MASSA\\DadosM.txt"); break;
	  case 2: m.adapVisualizarDados(); break;
	  case 3: m.adapTotalDesconto(); break;
	  case 4: m.adapContarTipo(); break;
	  case 5: m.adapContarServico(); break;
	  case 6: m.adapPesquisarObjecto(); break;
	  case 7: m.escrevernoFichOBJ("C:\\Users\\allan\\OneDrive\\Documents\\ClinicaDentariaPOOFichTexto\\FABRICA_MASSA\\Balanco.txt"); break;
	  }
	} while(op!=8);
  }
}
