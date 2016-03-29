package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import model.ManterAluno;
import to.AlunoTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoModelTestTest {
	ManterAluno aluno, copia;



		/*
		 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
		 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
		 * houver, delete. 
		 * Certifique-se também que sobrecarregou o equals na classe
		 * Cliente. 
		 * Certifique-se que a fixture cliente1 foi criada no banco.
		 * Além disso, a ordem de execução dos testes é importante; por
		 * isso a anotação FixMethodOrder logo acima do nome desta classe
		 */
		@Before
		public void setUp() throws Exception {
			AlunoTO to = new AlunoTO();

			to.setNome("Luna");
			to.setEndereco("Rua Coronel Meireles");
			to.setTelefone("(11)2345-6789");
			to.setCpf("223456123-34");
			to.setRg("43567234-6");
			to.setEmail("Luna_2016@gmail.com");
			to.setLogin("Lulu");
			to.setSenha("lulu123");

			aluno = new ManterAluno(to);
			copia = new ManterAluno(to);
		}
		
		@Test
		public void test00Carregar() {
			//para funcionar o cliente 1 deve ter sido carregado no banco por fora
			//delete from cliente;
			//insert into cliente (nome, fone) values ('nome1', 'fone1');
			AlunoTO alun = new AlunoTO();

			alun.setNome("Pitty");
			alun.setEndereco("Rua Coronel Meireles");
			alun.setTelefone("(11)9899-1123");
			alun.setCpf("7677676123-34");
			alun.setRg("43323244-6");
			alun.setEmail("Pitty_2016@gmail.com");
			alun.setLogin("Pitty");
			alun.setSenha("pitty123");
			
			AlunoTO busca = new AlunoTO();
			busca.setCpf("7677676123-34");
						
			ManterAluno fixture = new ManterAluno(alun);
			ManterAluno novo = new ManterAluno(busca);
			novo.carregar();
			assertEquals("testa consulta", novo, fixture);
		}

	@Test
		public void test01Criar() {
			aluno.cadastrar();
		//	aluno.carregar();
			copia.setCpf(aluno.getCpf());
			assertEquals("testa criacao", aluno, copia);
		}

		@Test
		public void test02Atualizar() {
			aluno.setTelefone("(11)8888-9999");
			copia.setTelefone("(11)8888-9999");		
			aluno.alterar();
			assertEquals("testa inclusao", aluno, copia);
		}

		@Test
		public void test03Excluir() {
				
			aluno.setNome(null);
			aluno.setEndereco(null);
			aluno.setTelefone(null);
			aluno.setCpf(null);
			aluno.setRg(null);
			aluno.setEmail(null);
			aluno.setLogin(null);
			aluno.setSenha(null);
			copia.setNome(null);
			copia.setEndereco(null);
			copia.setTelefone(null);
			copia.setCpf(null);
			copia.setRg(null);
			copia.setEmail(null);
			copia.setLogin(null);
			copia.setSenha(null);
		
			aluno.deletar();
			assertEquals("testa inclusao", aluno, copia);
		}
	}
	
	



