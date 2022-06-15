package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

//Digita 'main' + ctrl + backspace a IDE cria o m�todo main.
//CTRL + SHIFT + F organiza o c�digo.
public class OrdenaStrings {
	public static void main(String[] args) {
		
		//Classe String utiliza comaparable ordena de [A-Z].
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		//Compara��o feita pela classe string. 
		//Collections.sort(palavras);
		//Nova Compara��o feita com o m�todo comparador 
		//Collections.sort(palavras,comparador);
		//Nova compara��o o m�todo sort da classe List.
		//Agora as interfaces tem m�todos concretos. (Java8).
		//S�o chamados default methods que permitem a evolu��o das 
		//interfaces sem que quebrem as classes antigas.
		//� uma estrat�gia de evolu��o de interfaces.
		//M�todos default permitem que sejam inseridos m�todos 
		//nas interfaces, e que estes m�todos tenham corpo.
		//� diferente de uma classe abastrata que pode ter atributos,
		//pode ter estados. Uma interface n�o pode ter estado, mas,
		//apenas m�todos concretos.
		palavras.sort(comparador);
		
		System.out.println(palavras);
		
		for (String p: palavras) {
			System.out.println(p);			
		}
		
		//For each recebe um consumidor de strings.
		//forEach faz parte da classe Iterable.
		//Todas as collections s�o da clase Iterable.
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		
		

	}

}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String s) {
		System.out.println(" Nova implementa��o " + s);
		
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
