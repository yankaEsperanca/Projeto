package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import model.ManterCursoArtes;
import to.ArtesTO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CursoArtesModelTest {

	ManterCursoArtes artes, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se tambÃ©m que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * AlÃ©m disso, a ordem de execuÃ§Ã£o dos testes Ã© importante; por
	 * isso a anotaÃ§Ã£o FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		ArtesTO to = new ArtesTO();

		
		to.setCodigo("Artes201601");
		to.setNome("Curso de artes simples");
		to.setDataInicio("22/03/2016");
		to.setDataTermino("22/03/2017");
		to.setHorario("13:00");
		to.setNumeroVagas("100");
		to.setValor("245,00");
		to.setDescricaoMaterial("Tintas e pincéis");
		to.setNomeLivrosUtilizados("Livros de artes");
		to.setDisponibilidade("Disponível");
		
	    artes = new ManterCursoArtes(to);
		copia = new ManterCursoArtes(to);
	}

	@Test
	public void test00Carregar() {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone) values ('nome1', 'fone1');
		ArtesTO artes = new ArtesTO();
		
		artes.setCodigo("Artes I");
		artes.setNome("Artes I");
		artes.setDataInicio("02022016");
		artes.setDataTermino("06072016");
		artes.setHorario("0800");
		artes.setNumeroVagas("29");
		artes.setValor("150.00");
		artes.setDescricaoMaterial("pincéis");
		artes.setNomeLivrosUtilizados("livros de artes");
		artes.setDisponibilidade("Disponível");
		

		ArtesTO busca = new ArtesTO();
		busca.setCodigo("Artes I");

		ManterCursoArtes fixture = new ManterCursoArtes(artes);
		ManterCursoArtes novo = new ManterCursoArtes(busca);
		novo.carregar();
		assertEquals("testa consulta", novo, fixture);
	}

	@Test
	public void test01Criar() {
		artes.cadastrar();
		//artes.carregar();
		copia.setCodigo(artes.getCodigo());
		assertEquals("testa criacao", artes, copia);
	}

	@Test
	public void test02Atualizar() {
		artes.setValor("300.00");
		copia.setValor("300.00");		
		artes.alterar();
		assertEquals("testa inclusao", artes, copia);
	}

	@Test
	public void test03Excluir() {

		artes.setCodigo(null);
		artes.setNome(null);
		artes.setDataInicio(null);
		artes.setDataTermino(null);
		artes.setHorario(null);
		artes.setNumeroVagas(null);
		artes.setValor(null);
		artes.setDescricaoMaterial(null);
		artes.setNomeLivrosUtilizados(null);
		artes.setDisponibilidade(null);
		
		
		copia.setCodigo(null);
		copia.setNome(null);
		copia.setDataInicio(null);
		copia.setDataTermino(null);
		copia.setHorario(null);
		copia.setNumeroVagas(null);
		copia.setValor(null);
		copia.setDescricaoMaterial(null);
		copia.setNomeLivrosUtilizados(null);
		copia.setDisponibilidade(null);
		
	
		artes.deletar();
		assertEquals("testa inclusao", artes, copia);
	}
}





