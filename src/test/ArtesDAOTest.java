package test;


import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import to.ArtesTO;
import daoArtes.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtesDAOTest {
		static ArtesDAO dao;
		static ArtesTO to;

		/*
		 * Antes de rodar este teste, certifique-se que nao ha no banco
		 * nenhuma linha com o id igual ao do escolhido para o to instanciado
		 * abaixo. Se houver, delete. 
		 * Certifique-se de que o fixture cliente 1 existe no banco.
		 * Certifique-se tambÃ©m que sobrecarregou o equals na classe ArtesTO
		 * AlÃ©m disso, a ordem de execuÃ§Ã£o dos testes Ã© importante; por isso a anotaÃ§Ã£o
		 * FixMethodOrder logo acima do nome desta classe
		 */
		@BeforeClass
		public static void setUp() throws Exception {
		
			dao = new ArtesDAO();
			to = new ArtesTO();
					
			
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
		}

		@Test
		public void test00Carregar() {
			//para funcionar o cliente 1 deve ter sido carregado no banco por fora
			//delete from cliente;
			//insert into cliente (nome, fone) values ('nome1', 'fone1');
			ArtesTO fixture = new ArtesTO();
					
			fixture.setCodigo("Artes I");
			fixture.setNome("Artes I");
			fixture.setDataInicio("02022016");
			fixture.setDataTermino("06072016");
			fixture.setHorario("0800");
			fixture.setNumeroVagas("29");
			fixture.setValor("150.00");
			fixture.setDescricaoMaterial("pincéis");
			fixture.setNomeLivrosUtilizados("livros de artes");
			fixture.setDisponibilidade("Disponível");
			ArtesTO novo = dao.consultar(fixture);
			assertEquals("testa inclusao", novo, fixture);
		}

		@Test
		public void test01Inserir() {
			dao.inserir(to);
			ArtesTO novo = dao.consultar(to);
			assertEquals("testa inclusao", novo, to);
		}

		@Test
		public void test02Atualizar() {
			to.setValor("550.00");
			dao.alterar(to);
			ArtesTO novo = dao.consultar(to);
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
			to.setDescricaoMaterial(null);
			to.setNomeLivrosUtilizados(null);
			to.setDisponibilidade(null);

			dao.deletar(to);
			ArtesTO novo = dao.consultar(to);
			novo.setCodigo(null);
			novo.setNome(null);
			novo.setDataInicio(null);
			novo.setDataTermino(null);
			novo.setHorario(null);
			novo.setNumeroVagas(null);
			novo.setValor(null);
			novo.setDescricaoMaterial(null);
			novo.setNomeLivrosUtilizados(null);
			novo.setDisponibilidade(null);

			assertEquals("testa inclusao", novo, to);
		}
	}
