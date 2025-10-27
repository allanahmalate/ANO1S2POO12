
public class Pesquisa
{ 
  public Pesquisa() {}
  
  public int pesquisarObjecto(int cont, Processo [] array)
  {
	Validacoes v = new Validacoes();
	int codigo = v.validarInt(101,999,"Introduza o codigo(101-999)");
 	
	for(int i=0;i<cont;i++)
	{
	  if(array[i].getCodigo()==codigo)
		return i;  
	}
	return -1;
  }  
}
