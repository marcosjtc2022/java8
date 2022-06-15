package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

//Digita 'main' + ctrl + backspace a IDE cria o método main.
//CTRL + SHIFT + F organiza o código.
public class OrdenaStrings {
	public static void main(String[] args) {
		
		//Classe String utiliza comaparable ordena de [A-Z].
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		//Comparação feita pela classe string. 
		//Collections.sort(palavras);
		//Nova Comparação feita com o método comparador 
		//Collections.sort(palavras,comparador);
		//Nova comparação o método sort da classe List.
		//Agora as interfaces tem métodos concretos. (Java8).
		//São chamados default methods que permitem a evolução das 
		//interfaces sem que quebrem as classes antigas.
		//É uma estratégia de evolução de interfaces.
		//Métodos default permitem que sejam inseridos métodos 
		//nas interfaces, e que estes métodos tenham corpo.
		//É diferente de uma classe abastrata que pode ter atributos,
		//pode ter estados. Uma interface não pode ter estado, mas,
		//apenas métodos concretos.
		palavras.sort(comparador);
		
		System.out.println(palavras);
		
		for (String p: palavras) {
			System.out.println(p);			
		}
		
		//For each recebe um consumidor de strings.
		//forEach faz parte da classe Iterable.
		//Todas as collections são da clase Iterable.
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		
		

	}

}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String s) {
		System.out.println(" Nova implementação " + s);
		
	}
	
}

//Obrigatoriamente tem que implementar a interface Comparator.
class ComparadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}
