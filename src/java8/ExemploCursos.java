package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Curso {
	private String nome;
	private int alunos;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAlunos() {
		return alunos;
	}
	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	
	
	
}

public class ExemploCursos {
	public static void main(String[]args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Javascript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//Comparar o número de alunos.
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		//Quando executa um print no object chama o método toString.
		cursos.forEach(c -> System.out.println(c.getNome()));
		System.out.println("---------");
		
		//Filtra os cursos com o número de alunos igual ou maior que 100.
		//Não influencia na coleção original acima.
		//Tem que usar o próprio método for each.
		cursos.stream().filter(c -> c.getAlunos() >= 100)
		.forEach(c -> System.out.println(c.getNome()));
		System.out.println("---------");
		
		//Calcula o número de alunos.
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		//.map(c -> c.getAlunos())
		.map(Curso::getAlunos)
		//.forEach(total -> System.out.println(total));
		.forEach(System.out::println); //método reference. pode usar em 
		
	}

}
