/*
 * 34. Faça um programa com POO, para ajudar a gerir os processos 
 * clínicos da Clinica Dentária do ISCTEM. Cada processo é 
 * caracterizado pelo código do paciente, nome do paciente, serviço 
 * solicitado (Limpeza, Extração) e tipo de paciente (Normal ou Estudante).
    Pretende-se ler os dados do ficheiro de texto de 5 linhas e de seguida:
    a) Calcular o valor a pagar sabendo que Extração custa 5500mt e 
    Limpeza 2000mt e se o paciente for estudante terá direito a 15% de desconto.
    b) Visualizar todos os processos clinicos.
    c) Calcular o valor total de desconto.
    d) Escrever no ficheiro de texto a quantidade de processos por tipo de paciente.
    e) Saber qual é o serviço mais requisitado a fim de ajudar a clínica 
    melhor gerir seus consumíveis.
    Nota: Formatar os dados com a moeda em metical
 */

import java.text.DecimalFormat;

public class Executavel34 
{
    public static void main(String[] args) 
    {
      TodosProcessos34 p = new TodosProcessos34();
      p.lerFichCriarArray("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXERCICIO34\\src\\Dados34.txt");
      System.out.println(p);
      float tD = p.calcTotGlobal();
      visualizarTotal(tD); 
      int cL = p.contar("limpeza");
      int cE = p.contar("extraccao");
      visualizarMais(cL, cE);
      p.gravar("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXERCICIO34\\src\\Balanco34.txt");    
    }

    public static byte acharMaior(float[] array)
    {   
        float maior = array[0];
        byte indice_do_maior = 0;
        
        for(byte i=1; i<array.length; i++)
        {
            if(array[i] > maior)
            {
                indice_do_maior = i;
            }
        }

        return indice_do_maior;
    }

    public static void visualizarMais(float t1, float t2)
    {
        if (t1 == t2)
        {
            System.out.println("Os dois servicos foram igualmente requisitados.");
        }
        else
        {
            float[] totais = {t1, t2};
            byte indice = acharMaior(totais);

            System.out.print("O tipo de servico mais requisitado foi a ");

            switch(indice)
            {
                case 0: System.out.println("limpeza."); break;
                case 1: System.out.println("extraccao."); break;
            }

            System.out.println(totais[indice]);
        }
    }

    public static void visualizarTotal(float total) 
    {
        DecimalFormat mt = new DecimalFormat("###,###,###.00 MTS"); 
        System.out.println("Valor total de desconto: "+ mt.format(total)); 
    }
}
 