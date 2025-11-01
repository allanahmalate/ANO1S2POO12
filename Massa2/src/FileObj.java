import java.io.*;
public class FileObj
{
    public FileObj(){}

    public void escreverObj(Massa[] array)
    {
        try
        {
            FileOutputStream fo = new FileOutputStream("FichObj.dat");
            ObjectOutputStream os = new ObjectOutputStream(fo);

            os.writeObject(array);
            os.close();

            System.out.println("Fcheiro escrito com sucesso");
        }
        catch(IOException io){System.out.println(io.getMessage());}
    }
    public void LerObj(Massa[] array)
    {
        try
        {
            FileInputStream fi = new FileInputStream("FichObj.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);

            array = (Massa[]) oi.readObject();

            oi.close();
            System.out.println("Fcheiro lido com sucesso");
        }
        catch (ClassNotFoundException e) { System.out.println(e.getMessage());}
        catch(IOException io){System.out.println(io.getMessage());}
    }
}
