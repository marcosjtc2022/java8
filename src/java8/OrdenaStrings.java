package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

//Digita 'main' + ctrl + backspace a IDE cria o m�todo main.
//CTRL + SHIFT + F organiza o c�digo.
public class OrdenaStrings {
	public static void main(String[] args) {

		// Classe String utiliza comaparable ordena de [A-Z].
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		// passa direto em palvras.sort(comparador);
		// Comparator<String> comparador = new ComparadorPorTamanho();

		// Compara��o feita pela classe string.
		// Collections.sort(palavras);
		// Nova Compara��o feita com o m�todo comparador
		// Collections.sort(palavras,comparador);
		// Nova compara��o o m�todo sort da classe List.
		// Agora as interfaces tem m�todos concretos. (Java8).
		// S�o chamados default methods que permitem a evolu��o das
		// interfaces sem que quebrem as classes antigas.
		// � uma estrat�gia de evolu��o de interfaces.
		// M�todos default permitem que sejam inseridos m�todos
		// nas interfaces, e que estes m�todos tenham corpo.
		// � diferente de uma classe abastrata que pode ter atributos,
		// pode ter estados. Uma interface n�o pode ter estado, mas,
		// apenas m�todos concretos.
		// palavras.sort(comparador);
		// Transformar em um lambda que funciona sempre para uma interface que tem um
		// m�todo abstrato (Interface funcional).
//		palavras.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String s1, String s2) {
//				if (s1.length() < s2.length())
//					return -1;
//				if(s1.length() > s2.length())
//					return 1;
//				return 0;
//			}});
		// ctrl + shift + f para formatar/endentar.
//		palavras.sort((String s1, String s2) -> {
//			if (s1.length() < s2.length())
//				return -1;
//			if (s1.length() > s2.length())
//				return 1;
//			return 0;
//		});
//		palavras.sort((s1,s2) -> {
//			if (s1.length() < s2.length())
//				return -1;
//			if (s1.length() > s2.length())
//				return 1;
//			return 0;
//		});

//		palavras.sort((s1,s2) -> {
//			return Integer.compare(s1.length(), s2.length());
//		});
        
		//Princ�pio b�sico do lambda: consegue ser convertido para uma classe funcional.
		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		//Recebe uma interface funcional. Uma interface com um �nico m�todo abstrato. 
		//Usa uma factory dentro da pr�pria interface comparator, que recebe um lambda (dado uma string pega o tamanho dela).
		//Factory de comparators. "Palavras ordene, comparando s.length".
		palavras.sort(Comparator.comparing(s -> s.length()));
		//Equivale �
		//Function<String, Integer> funcao = s -> s.length();
		//Comparator<String> comparador = Comparator.comparing(funcao);
		//palavras.sort(comparador);
		palavras.sort(Comparator.comparing(String::length));

		System.out.println(palavras);

		for (String p : palavras) {
			System.out.println(p);
		}

		// For each recebe um consumidor de strings.
		// forEach faz parte da classe Iterable.
		// Todas as collections s�o da clase Iterable.
		// Consumer<String> consumidor = new ImprimeNaLinha();
		// Pode executar o new em um consumer de string diretamente
		// Classe an�nima retira a necessidade de delcarar a classe.
		Consumer<String> consumidor = new Consumer<String>() {

			@Override
			public void accept(String s) {
				System.out.println(" Nova implementa��o s " + s);

			}
		};

		// palavras.forEach(consumidor);
		// Pode passar toda a classe como par�metro.
//		palavras.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//				System.out.println(" Nova implementa��o s " + s);
//				
//			}});
		// O compildor infere a classe an�nima acima. (Lambda)
//			palavras.forEach((String s) -> {
//								System.out.println(s);
//								
//			});
		// S� tem uma interface e um argumento.
//			palavras.forEach(s -> {
//				System.out.println(s);
//				
//});
		//palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
		
		//Transformando em lambda. (Equivalente ao comando de cima).
		//Consumer<String> impressor  = s -> System.out.println(s);
		//Converte System.out::println para um Consumer.
		Consumer<String> impressor  =  System.out::println;
		palavras.forEach(impressor);
		
		//N�o funciona por n�o ser uma interface funcional � esquerda.
		//Object o = s -> System.out.println(s);
		
		//N�o funciona pq o comparator exige dois argumentos e retorna um integer.
		//E a express�o lambda recebe um argumento e devolve void.
		//Express�o lambda Tem que receber argumento e devolve o mesmo tipo de par�metro.
		//Comparator<String> comparador = s -> System.out.println(s);

	}

}

//Classe an�nima retira a necessidade de delcarar esta classe.
class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(" Nova implementa��o " + s);

	}

}

//Obrigatoriamente tem que implementar a interface Comparator.
class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}

}
