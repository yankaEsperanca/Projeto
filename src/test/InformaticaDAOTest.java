package test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import to.InformaticaTO;
import daoInformatica.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InformaticaDAOTest {

	static InformaticaDAO dao;
	static InformaticaTO to;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe InformaticaTO
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@BeforeClass
	public static void setUp() throws Exception {
	
		dao = new InformaticaDAO();
		to = new InformaticaTO();
				
		to.setCodigo("info201601");
		to.setNome("Curso de info simples");
		to.setDataInicio("22/03/2016");
		to.setDataTermino("22/03/2017");
		to.setHorario("13:00");
		to.setNumeroVagas("100");
		to.setValor("245,00");
		to.setNumeroLab("12A");
		to.setRegistroSoft("Java");
		to.setDisponibilidade("Dispon�vel");
	}

	@Test
	public void test00Carregar() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone) values ('nome1', 'fone1');
		InformaticaTO fixture = new InformaticaTO();
				
		fixture.setCodigo("Informatica I");
		fixture.setNome("Inform�tica I");
		fixture.setDataInicio("02072016");
		fixture.setDataTermino("060112016");
		fixture.setHorario("0800");
		fixture.setNumeroVagas("30");
		fixture.setValor("230.00");
		fixture.setNumeroLab("09H");
		fixture.setRegistroSoft("Jgrasp");
		fixture.setDisponibilidade("Dispon�vel");

		InformaticaTO novo = dao.consultar(fixture);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.inserir(to);
		InformaticaTO novo = dao.consultar(to);
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void test02Atualizar() {
		to.setValor("550.00");
		dao.alterar(to);
		InformaticaTO novo = dao.consultar(to);
		assertEquals("testa inclusao", novo, to);
	}

	@Test
	public void test03Excluir() {
		to.setCodigo(null);
		to.setNome(null);
		to.setDataInicio(null);
		to.setDataTermino(null);
		to.setHorario(null);
		to.setNumeroVagas(null);
		to.setValor(null);
		to.setNumeroLab(null);
		to.setRegistroSoft(null);
		to.setDisponibilidade(null);

		dao.deletar(to);
		InformaticaTO novo = dao.consultar(to);
		novo.setCodigo(null);
		novo.setNome(null);
		novo.setDataInicio(null);
		novo.setDataTermino(null);
		novo.setHorario(null);
		novo.setNumeroVagas(null);
		novo.setValor(null);
		novo.setNumeroLab(null);
		novo.setRegistroSoft(null);
		novo.setDisponibilidade(null);

		assertEquals("testa inclusao", novo, to);
	}
}
