public class LinhasSeguintes(){

	public LinhasSeguintes(){}

	public int lerLinhasSeguintes(int tamanho, int lidas, int total){
				String [] n = new String[tamanho];
				String []str = new String[tamanho];
				//String [] down = new String[tamanho];
				//int meio = tamanho/2;
				//int maisQmeio = meio +1;
				String ler = null;
				String [] lerLinhas;

				int num = 0;

				try{
					FileReader fr = new FileReader("customer.tbl");
					BufferedReader br = new BufferedReader(fr);
					Map<Integer,String> linhas = new LinkedHashMap<Integer,String>();
					ler=br.readLine();
					linhas.put(num,ler);
					num++;
					for (int i= 0; i < tamanho; i++){ //percorrer para pegar o tamanho
						if (num > lidas && lidas <= total ) { //ler a partir de linha anterior +1
							lerLinhas = ler.split("[|]");
							n[i]= lerLinhas[1];
							str[i] = lerLinhas[4];
							}			
						
						this.linhas.put(i,n);
					}
					return lidas + i;

								

					}catch(IOException e){
						System.err.printf("Erro ao abrir arquivo %s.\n",e.getMessage());
					}
			}
}