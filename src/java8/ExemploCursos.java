package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
		
		//Comparar o n�mero de alunos.
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
//		//Quando executa um print no object chama o m�todo toString.
//		cursos.forEach(c -> System.out.println(c.getNome()));
//		System.out.println("---------");
//		
//		//Filtra os cursos com o n�mero de alunos igual ou maior que 100.
//		//N�o influencia na cole��o original acima.
//		//Tem que usar o pr�prio m�todo for each.
//		cursos.stream().filter(c -> c.getAlunos() >= 100)
//		.forEach(c -> System.out.println(c.getNome()));
//		System.out.println("---------");
		
//		//Calcula o n�mero de alunos.
//		cursos.stream()
//		.filter(c -> c.getAlunos() >= 100)
//		//.map(c -> c.getAlunos())
//		.map(Curso::getAlunos)
//		//.forEach(total -> System.out.println(total));
//		.forEach(System.out::println); //m�todo reference. pode usar em 
		
		//ctrl + 1 = adiciona vari�vel.
		//Optional � uma classe nova do java 8 que ajuda a trabalhar com null.
		//Permite trabalhar com refer�ncias sem precisar do if == null.
		//Aqui tem um curso mas � opcional, pode ser que exista pode ser que n�o.
//		Optional<Curso> optionalCurso = cursos.stream()
//		.filter(c -> c.getAlunos() >= 100)
//		.findAny()
//		.ifPresent(c -> System.out.println(c.getNome()));
		
//		 cursos.stream()
//				.filter(c -> c.getAlunos() >= 100)
//				.findAny()
//				.ifPresent(c -> System.out.println(c.getNome()));
		
		//Curso curso = optionalCurso.orElse(null);
//		System.out.println(curso.getNome());
		//optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		 //Volta de uma string para uma collection.
//		 List<Curso> resultado = cursos.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.collect(Collectors.toList());
		 
//		 Map<String, Integer> map = cursos.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		//System.out.println(map);
		 
		 cursos.stream()
					.filter(c -> c.getAlunos() >= 100)
					.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
					.forEach((nome, alunos) -> 
					System.out.println((nome + " tem " + alunos + "alunos")));
    		
		 
		
	}

}
