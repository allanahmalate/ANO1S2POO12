public class Responsavel 
{
    private String[] membros = {"Allanah", "Vinicius", "Wango"};
    private String[] cadeiras = {"AM2", "ASC", "ING2" , "MD2", "POO1", "TC"};
    private byte[] cadeira;
    private int reselecao;

    public Responsavel() 
    {
        cadeira = gerarArray(6);
        for(byte i=0; i<2; i++)
            if(cadeira[i+2] == 3)
                troca(i);
    }

    public void troca(byte i)
    {
        reselecao = gerarreselecao();
        byte aux= cadeira[reselecao];
        cadeira[reselecao] = 3;
        cadeira[i] = aux;
    }

    public byte[] gerarArray(int size)
    {
        /*
         * int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int num;
            boolean exists;
            do {
                num = (int)(Math.random() * maxValue); // or any number generation logic
                exists = false;
                for (int j = 0; j < i; j++) {
                    if (arr[j] == num) {
                        exists = true;
                        break;
                    }
                }
            } while (exists);
            arr[i] = num;
        }
         */
        byte[] arr = new byte[size];

        for (byte i = 0; i < size; i++) 
        {
            byte num;
            boolean exists;
            do 
            {
                num = (byte)(Math.random() * size); // or any number generation logic
                exists = false;
                for (byte j = 0; j < i; j++) 
                {
                    if (arr[j] == num) 
                        exists = true;
                }
            } while (exists);
            arr[i] = num;
        }
        return arr;
    }
    public int gerarreselecao()
    {
        byte num = (byte)(Math.random() * 1);

        switch(num)
        {
            case 0: return 0;
            case 1: return 2;
        }
        return 0;
    }



    //metodos de acesso
    public String[] getmembro() { return membros; }
    public String[] getcadeiras() { return cadeiras; }
    public byte[] getcadeira() { return cadeira; }

    public String toString() 
    {
        return "RE" + reselecao + "Membro: " + membros[0] + "\tCadeira 1: " + cadeiras[cadeira[0]] + "\tCadeira 2: " + cadeiras[cadeira[1]] + "\nMembro: " + membros[1] + "\tCadeira 1: " + cadeiras[cadeira[2]] + "\tCadeira 2: " + cadeiras[cadeira[3]] + "\nMembro: " + membros[2] + "\tCadeira 1: " + cadeiras[cadeira[4]] + "\tCadeira 2: " + cadeiras[cadeira[5]];
    }
}