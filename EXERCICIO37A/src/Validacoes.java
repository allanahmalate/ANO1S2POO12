import java.io.*;

public class Validacoes 
{
	private BufferedReader br;
	
	public Validacoes()
	{
	  br = new BufferedReader(new InputStreamReader(System.in));	
	}
	
    //VALIDAR STRING
	public int validarInt(int a, int b,String msg)
	{
		int z=0;
		
		do
		{
		  System.out.println(msg);
		  try
		  {
		    z = Integer.parseInt(br.readLine());
		  }
		  catch(NumberFormatException n)
		  {
			System.out.println(n.getMessage());  
		  }
		  catch(IOException e)
		  {
			System.out.println(e.getMessage());
		  }
		  if(z<a || z>b)
			System.out.println("Erro!");
		} while(z<a || z>b);
		return z;
	}
}
