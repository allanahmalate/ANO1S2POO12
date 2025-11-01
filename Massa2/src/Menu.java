public class Menu
{
    public Menu(){}

    public void menu()
    {
        int op;
        Validacoes val= new Validacoes();
        TodasMassas tm = new TodasMassas();

        do
        {
            System.out.println("====MENU====");
            System.out.println("1- Ler dados e armazenar no array");
            System.out.println("2- Visualizar dados do array");
            System.out.println("3- Visualizar o valor total com IVA por forma");
            System.out.println("4- Escrever no ficheiro de texto a quantidade de marcas que comecam com a letra M");
            System.out.println("5- Visualizar o tipo de massa mais existente");
            System.out.println("6- Escrever no ficheiro de objectos");
            System.out.println("7- Ler do ficheiro e objectos");
            System.out.println("8- Pesquisar objecto por marca");
            System.out.println("9- Acrescentar massa");
            System.out.println("10- Sair");

            op = val.validarInt(1, 10, "Introduza um opcao");


            switch(op)
            {
                case 1: tm.ler(); break;
                case 2: tm.adpVisualizarDados(); break;
                case 3: tm.adpTotalMassa(); break;
                case 4: tm.adpContarLetra(); break;
                case 5: tm.adpContarTipo(); break;
                case 6: tm.adpEscreverObj(); break;
                case 7: tm.adpLerObj(); break;
                case 8: tm.adpPesquisarMarca(); break;
                case 9: tm.adpAcrescentar(); break;
                case 10: System.out.println("Programa encerrado");

            }

        }while(op!=10);
    }
}
