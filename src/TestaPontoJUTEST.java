import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestaPontoJUTEST {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	}
	
	@Test
	void test() {
	    TestaPonto.main(null);
        String expected = "p1=>Ponto{x=1, y=2}";
        expected += "\r\np1=>Ponto{x=4, y=6}";
        expected += "\r\niguais=>false";
        expected += "\r\ndistancias=>5.0";
	    Assert.assertEquals(expected, outputStreamCaptor.toString()
	      .trim());
	}
	
	@Test
	void testEquals() {
		Ponto p1 = new Ponto(1,2);
		Ponto p2 = new Ponto(1,2);
		Assert.assertTrue(p1.equals(p2));
	}

	@Test
	void testDistancia() {
		Ponto p1 = new Ponto(1,2);
		Ponto p2 = new Ponto(9,8);
		Assert.assertTrue(Math.abs(p1.distancia(p2)-10) < 1e-12);
	}
}
