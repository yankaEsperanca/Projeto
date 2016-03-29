package test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import to.AlunoTO;
import daoAluno.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoDAOTest {
	static AlunoDAO dao;
	static AlunoTO to;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe AlunoTO
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		dao = new AlunoDAO();
		to = new AlunoTO();
		to.setNome("Luna");
		to.setEndereco("Rua Coronel Meireles");
		to.setTelefone("(11)2345-6789");
		to.setCpf("223456123-34");
		to.setRg("43567234-6");
		to.setEmail("Luna_2016@gmail.com");
		to.setLogin("Lulu");
		to.setSenha("lulu123");
	}

	@Test
	public void test00Carregar() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone) values ('nome1', 'fone1');
		AlunoTO fixture = new AlunoTO();

		fixture.setNome("Pitty");
		fixture.setEndereco("Rua Coronel Meireles");
		fixture.setTelefone("(11)9899-1123");
		fixture.setCpf("7677676123-34");
		fixture.setRg("43323244-6");
		fixture.setEmail("Pitty_2016@gmail.com");
		fixture.setLogin("Pitty");
		fixture.setSenha("pitty123");

		AlunoTO novo = dao.consultarCPF(fixture);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.inserir(to);
		AlunoTO novo = dao.consultarCPF(to);
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void test02Atualizar() {
		to.setLogin("Luluzinha");
		dao.alterar(to);
		AlunoTO novo = dao.consultarCPF(to);
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void test03Excluir() {
		to.setNome(null);
		to.setEndereco(null);
		to.setTelefone(null);
		to.setCpf(null);
		to.setRg(null);
		to.setEmail(null);
		to.setLogin(null);
		to.setSenha(null);

		dao.deletar(to);
		AlunoTO novo = dao.consultarCPF(to);
		assertEquals("testa inclusao", novo, to);
	}
}
