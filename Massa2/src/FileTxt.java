import java.io.*;

public class FileTxt
{
    public FileTxt(){}

    public void escreverTxt(int c, char x)
    {
        try
        {
            FileWriter fw = new FileWriter("Qtd.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Quantidade da massas que comecam com letra '"+x+"': "+c);

            bw.close();
        }
        catch(NumberFormatException nf) {System.out.println(nf.getMessage());}
        catch(IOException io) {System.out.println(io.getMessage());}
    }
    public void acrescentar(String m, String t, String f, String pr, int q, int pre)
    {
        try
        {
            FileWriter fw = new FileWriter("Dados.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(m+";"+t+";"+f+";"+pr+";"+q+";"+pre);

            bw.close();
        }
        catch(FileNotFoundException fe){System.out.println("O ficheiro nao foi encontrado");}
        catch(IOException io){System.out.println(io.getMessage());}
    }
}
