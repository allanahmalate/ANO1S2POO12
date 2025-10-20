import java.text.DecimalFormat;

public class Prisioneiro  
{
   private String nome,data,duracao,motivo;
   private int valorE, fianca;
   private byte idade;
   private DecimalFormat mt;
   
   public Prisioneiro(String n, String da, String du, String m)
   {
      nome = n;
      data = da;
      duracao = du;
      motivo = m;
      valorE = 10000;
      idade = definirIdade();
      fianca = definirFianca();
      mt = new DecimalFormat("###,###,###.00 MTS");
   }

   public byte definirIdade()
   {
      // DD/ MM/ AAAA
      String ano = data.substring(6,10); 
      int anoN = Integer.parseInt(ano);
      return (byte)(2025-anoN);
   }

   public int definirFianca()
   {
      if(motivo.equalsIgnoreCase("assalto"))
         return 20000;
      else
         return 0;
   }

   public String getNome() { return nome; }
   public String getData() { return data; }
   public String getDuracao() { return duracao; }
   public String getMotivo() { return motivo; }
   public int getValorE() { return valorE;}
   public int getFianca() { return fianca;}
   public byte getIdade() { return idade;}

   public String toString()
    {
      //António Silva        | Idade: 55  | Data Nasc: 15/03/1970 | Pena: 5          | Motivo: Assalto    | Fiança: 20000
      return "Nome: " + nome + "\t| Idade:" + idade +  "\t| Data Nasc: " + data + "\t| Pena: " + duracao + "\t| Motivo: " + motivo + "\t| Fianca:" + mt.format(fianca);
    }
}
