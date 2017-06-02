import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Dsp_Managment{
	public Map<Integer,String> bCache = new LinkedHashMap<Integer,String>();
	
	String [] lerLinhas;
	private int qtdLinhasArq = 0;
	private int meio;
	private int maisQmeio;
	

	public Dsp_Managment(){}

	public void preencherBuffer(int tamanho){
		String [] n = new String[tamanho];
		String []str = new String[tamanho];
		String [] down = new String[tamanho];
		meio = tamanho/2;
		maisQmeio = meio +1;
		String ler = null;

		//Achar total de linhas do arquivo
		try{
			FileReader fr = new FileReader("customer.tbl");
			BufferedReader br = new BufferedReader(fr);
			while(br.readLine()!=null){
				qtdLinhasArq++;
		}
		System.out.println("Total Linha da Tabela:" +qtdLinhasArq); 
		System.out.println(" Metade = "+meio);
		System.out.println(" Mais da Metade = "+maisQmeio);

	}catch (IOException ex){
		System.err.printf("Erro ao abrir arquivo %s.\n",ex.getMessage());
	}

		try{
			FileReader fr = new FileReader("customer.tbl");
			BufferedReader br = new BufferedReader(fr);
			//ler=br.readLine();
			//System.err.printf("\n"+ler);
			for (int i=0;i < tamanho; i++){
					//if (br.readLine()!= null) {
						ler = br.readLine();
						lerLinhas = ler.split("[|]");
						n[i]= lerLinhas[1];
						str[i] = lerLinhas[4];


					//}
				
				System.out.println(" " +n[i]+ "--->"+str[i]);
				this.bCache.put(i,ler);
			}
						

		}catch(IOException e){
			System.err.printf("Erro ao abrir arquivo %s.\n",e.getMessage());
		}
		//mergeS(n,down,0,inicial);
	}


	public void mergeS( String[] origin, String [] strAux, int inicio , int fim){
		if (inicio < fim) {
			int m = (inicio + fim)/2;
			mergeS(origin,strAux,inicio,fim);
			mergeS(origin,strAux,m+1,fim);
			
		}
	}


	public void intercalar(String [] str1Origin, String [] str2Aux, int inicio,int meio, int fim ){
		

		for (int k=inicio;k<=fim;k++ ) { //copia td mundo do original para auxiliar
			str2Aux[k] = str1Origin[k];

			int i = inicio;
			int j = meio +1;

			for (int cont=inicio;cont<=fim ;cont++ ) {
				if (i > meio) {
					str1Origin[cont] = str2Aux[j++]; // a parte 1 mais rapida do que a 2
					
				}else if (j > fim) {
					str1Origin[cont] = str2Aux[i++]; // a parte 2 mais rapaida que a 1
				}else if (str2Aux[i].compareTo(str2Aux[j])< 0) {
					str1Origin[cont] = str2Aux[i++];
				}else
					str1Origin[cont] = str2Aux[j++];

				
			}

			
		}
	}
}