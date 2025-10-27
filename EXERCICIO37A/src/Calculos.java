
public class Calculos 
{
  public Calculos() {}
  
  public float calcTotQTD(String tipo,int cont, Massa [] array)
  {
	float acum=0;

	for(int i=0;i<cont;i++)
	{
	  if(array[i].getForma().equalsIgnoreCase(tipo))
		  acum += array[i].getQTD();
	}
	return acum;
  }

  public float calcTotForma(String forma,int cont, Massa [] array)
  {
	float acum=0;

	for(int i=0;i<cont;i++)
	{
	  if(array[i].getForma().equalsIgnoreCase(forma))
	  //if(array[i].getForma().equalsIgnoreCase(forma))
		  acum += (array[i].getVP() - array[i].getVIVA());
	}
	return acum;
  }

  public int contarQTD(char marca,int cont, Massa [] array)
  {
	int c=0;

	for(int i=0;i<cont;i++)
	{
	  if(array[i].getMarca().charAt(0) == marca)
		  c++;
	}
	return c;
  }
}