/*
 * 34. Faça um programa com POO, para ajudar a gerir os processos 
 * clínicos da Clinica Dentária do ISCTEM. Cada processo é 
 * caracterizado pelo código do paciente, nome do paciente, serviço 
 * solicitado (Limpeza, Extração) e tipo de paciente (Normal ou Estudante).
    Pretende-se ler os dados do ficheiro de texto de 5 linhas e de seguida:
    a) Calcular o valor a pagar sabendo que Extração custa 5500mt e 
    Limpeza 2000mt e se o paciente for estudante terá direito a 15% de desconto.
    b) Visualizar todos os processos clinicos.
    c) Calcular o valor total de desconto.
    d) Escrever no ficheiro de texto a quantidade de processos por tipo de paciente.
    e) Saber qual é o serviço mais requisitado a fim de ajudar a clínica 
    melhor gerir seus consumíveis.
    Nota: Formatar os dados com a moeda em metical
 */

import java.text.DecimalFormat;
public class Processo34
{
    String cod, nome, servico, tipo;
    short preco;
    float desconto, vp;
    DecimalFormat mt;

    //Metodo construtor
    public Processo34(String cod, String nome, String servico, String tipo)
    {
        this.cod = cod.toLowerCase();
        this.nome = nome.toLowerCase();
        this.servico = servico.toLowerCase();
        this.tipo = tipo.toLowerCase();
        this.preco = definirPreco();
        this.desconto = calcularD();
        this.vp = calcularVP();
        mt = new DecimalFormat("###,###,###.00 MTS");
    }
    //Metodos de calculo
    public short definirPreco()
    {
        switch(servico)
        {
            case "limpeza": return 2000;
            case "extracao": return 5500;
        }
        return 0;
    }

    public float calcularD()
    {
        if(tipo.equals("estudante"))
            return preco * 15/100f;
        return 0;
    }

    public float calcularVP() { return preco - desconto; }

    //Metodos de acesso
    public String getTipo() { return tipo; }
    public String getServico() { return servico; }      
    public float getDesconto() { return desconto; }
    public float getVP() { return vp; }
    
    //Metodos de visualizacao de dados
    public String toString()
    {
        return "Codigo: " + cod + "\tNome: " + nome + "\tTipo: " + tipo + "\tServico: " + servico + "\tPreco: " +mt.format(preco) + "\tDesconto: " + mt.format(desconto) + "\tValor a Pagar: " + mt.format(vp);
    }
}