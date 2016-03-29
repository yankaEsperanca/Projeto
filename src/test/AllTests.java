package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlunoDAOTest.class, AlunoModelTestTest.class, ArtesDAOTest.class, CursoArtesModelTest.class,
		CursoInformaticaModelTest.class, InformaticaDAOTest.class })

public class AllTests {

}
