import java.text.DecimalFormat;

public class Visualizacoes
{
  private DecimalFormat mt;
  
  public Visualizacoes()
  {
	mt = new DecimalFormat("###,###,###.00 MTS");
  }
  
  public void visualizarObjecto(int i,Massa [] array)
  {
	if(i==-1)
	  System.out.println("Objecto nao foi encontrado!");
	else
	  System.out.println(array[i]);  
  }

  
  public void visualizarTotalDesconto(float t)
  {
	System.out.println("Total de desconto e:"+mt.format(t));  
  }
  
  public void comparar(int t, int i)
  {
	if(t>i)
	  System.out.println("Tipo Trigo tem mais em stock.");
	else
	{
	  if(i>t)
		System.out.println("Tipo Integral tem mais em stock.");
	  else
		System.out.println("Ambos tem a mesma quantidade no stock!");
	}
  }

  public String toString(Massa[] array,int cont)
  {
	String str = "";
	for(int i=0;i<cont;i++)
	  str += array[i] + "\n";
	return str;
  }
}
