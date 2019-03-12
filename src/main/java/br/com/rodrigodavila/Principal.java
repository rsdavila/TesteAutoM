package br.com.rodrigodavila;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.rodrigodavila.entity.Cadastro;
import br.com.rodrigodavila.entity.Historico;
import br.com.rodrigodavila.repository.CadastroRepository;
import br.com.rodrigodavila.repository.HistoricoRepository;

@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "br.com.rodrigodavila.repository" })
public class Principal implements CommandLineRunner {

	@Autowired
	private CadastroRepository cadastroRepository;

	@Autowired
	private HistoricoRepository historicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Principal.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Cadastro cadastro = new Cadastro();
		Historico historico = new Historico();

		System.out.println("Nome:");
		cadastro.setNome(sc.next());

		System.out.println("Valor:");
		historico.setValor(sc.next());

		this.cadastroRepository.save(cadastro);
		historico.setIdHistorico(cadastro.getId());
		this.historicoRepository.save(historico);

		List<Object[]> listUtil = this.cadastroRepository.findByJoin(cadastro.getId());

		System.out.println("#########################################");
		System.out.println("#########################################");
		for (Object[] obj : listUtil) {
			System.out.println("Nome: " + obj[0] + "\nValor: " + obj[1]);
		}
		System.out.println("#########################################");
		System.out.println("#########################################");
		// System.out.println(listUtil.get(0)[0]);

	}
}
