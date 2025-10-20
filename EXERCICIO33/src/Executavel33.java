/*
 * 33.	A progym pretende gerir os seus membros. Sabendo que 
 * cada membro caracteriza-se por tipo de membro que pode ser 
 * Normal (2000mt), Estudante (1500mt) ou Exclusivo (2700mt), 
 * tem personal trainer(sim/nao) (500mt) e o número de meses. 
 * Pretende-se ler os dados de 5 linhas em um ficheiro de texto e de 
 * seguida armazenar em um Array de objectos e:
    a) Visualize os dados do membro inclusive o valor a pagar pela 
    inscrição, sabendo que se o número de meses for igual ou superior a 
    3, terá direito a um desconto de 10%.
    b) Calcule a quantidade de clientes de cada tipo.
    c) Calcule a quantidade de clientes com personal trainer.
    d) Calcule o valor total de desconto.
    e) Calcule o valor total recebido pelo Progym.
    Nota: Formatar os dados com a moeda em metical
 */
 
public class Executavel33 
{
    public static void main(String[] args) 
    {
      TodosMembros33 m = new TodosMembros33();
      m.lerFichCriarArray("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXERCICIO33\\src\\Dados33.txt");
      System.out.println(m);
    }
}
