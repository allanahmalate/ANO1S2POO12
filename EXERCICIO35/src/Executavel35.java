/* 
 * 35. Faça um programa com POO, sem menu, para poder fazer a 
 * gestão de calamidades que afectam varias cidades em Moçambique.
    Sabe-se que cada calamidade caracteriza-se pelo nome da cidade, 
    número de edifícios danificados, valor monetário perdido em 
    meticais e a data do evento (DD/MM/AAAA). Pretende-se ler 
    os dados do ficheiro de texto de 5 linhas e armazenar em um array de 
    objectos e de seguida:
    a) Visualizar todos os dados no ecrã.
    b) Calcular o numero total de edifícios danificados.
    c) Calcular o número total de calamidades que aconteceram no ano actual.
    d) Escrever no ficheiro de texto o valor total de dinheiro que foi perdido.
    e) Sabendo que o país recebe 100 000USD de doações, verifique se o valor chega ou não para gerir as calamidades (Considere o cambio 72)
*/

public class Executavel35 
{
    public static void main(String[] args) 
    {
        TodasCalam35 c = new TodasCalam35();
        c.lerFichCriarArray("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXERCICIO35\\src\\Dados35.txt");
        System.out.println(c);
        float tTotal = c.calcTotGlobal();
        final double doacoes = 100000.00*72;
        visualizarMais(tTotal, doacoes);
        int tE = c.acumQtd();
        visualizarTotal("Numero total de edifícios danificados: ", tE);
        int c25 = c.acumData();
        visualizarTotal("Número total de calamidades que aconteceram no ano actual: ", c25);
        c.gravar("C:\\Users\\allan\\OneDrive\\Documents\\ANO1S2POO12\\EXERCICIO35\\src\\Balanco35.txt");
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
