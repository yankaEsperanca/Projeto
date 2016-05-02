package test;


import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import model.ManterCursoInformatica;
import to.InformaticaTO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoInformaticaModelTest {

	ManterCursoInformatica info, copia;

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
		InformaticaTO to = new InformaticaTO();

		
		to.setNome("Curso de info simples");
		to.setDataInicio("22/03/2016");
		to.setDataTermino("22/03/2017");
		to.setHorario("13:00");
		to.setNumeroVagas("100");
		to.setValor("245,00");
		to.setNumeroLab("12A");
		to.setRegistroSoft("Java");
		to.setDisponibilidade("Dispon�vel");
		
	    info = new ManterCursoInformatica(to);
		copia = new ManterCursoInformatica(to);
	}

	@Test
	public void test00Carregar() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone) values ('nome1', 'fone1');
		InformaticaTO info = new InformaticaTO();
		
		info.setNome("Inform�tica I");
		info.setDataInicio("02072016");
		info.setDataTermino("060112016");
		info.setHorario("0800");
		info.setNumeroVagas("30");
		info.setValor("230.00");
		info.setNumeroLab("09H");
		info.setRegistroSoft("Jgrasp");
		info.setDisponibilidade("Dispon�vel");
		

		InformaticaTO busca = new InformaticaTO();
		busca.setNome("Informatica I");

		ManterCursoInformatica fixture = new ManterCursoInformatica(info);
		ManterCursoInformatica novo = new ManterCursoInformatica(busca);
		novo.carregar();
		assertEquals("testa consulta", novo, fixture);
	}

	@Test
	public void test01Criar() {
		info.cadastrar();
		//info.carregar();
		copia.setCodigo(info.getCodigo());
		assertEquals("testa criacao", info, copia);
	}

	@Test
	public void test02Atualizar() {
		info.setValor("300.00");
		copia.setValor("300.00");		
		info.alterar();
		assertEquals("testa inclusao", info, copia);
	}

	@Test
	public void test03Excluir() {

		info.setNome(null);
		info.setDataInicio(null);
		info.setDataTermino(null);
		info.setHorario(null);
		info.setNumeroVagas(null);
		info.setValor(null);
		info.setNumeroLab(null);
		info.setRegistroSoft(null);
		info.setDisponibilidade(null);
		
		
		copia.setNome(null);
		copia.setDataInicio(null);
		copia.setDataTermino(null);
		copia.setHorario(null);
		copia.setNumeroVagas(null);
		copia.setValor(null);
		copia.setNumeroLab(null);
		copia.setRegistroSoft(null);
		copia.setDisponibilidade(null);
		
	
		info.deletar();
		assertEquals("testa inclusao", info, copia);
	}
}


