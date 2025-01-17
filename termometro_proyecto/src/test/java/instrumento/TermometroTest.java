package instrumento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TermometroTest {
	Termometro termometro;

	@BeforeEach
	void setUp() throws Exception {
		termometro = new Termometro(5.0);
		
	}

	@Test
	@DisplayName("Comprobar si la conversión a Fahrenheit está bien")
	void testConvertirFahrenheit() {
		Double valorEsperado = 41.0;
		Double valor = termometro.convertirAFahrenheit();
		
		assertEquals(valorEsperado, valor);
	}
	
	@Test
	@DisplayName("Temperatura Kelvin no válida")
	void testKelvinNoVálido() {
		termometro = new Termometro(-350);
		String mensajeEsperado = "La temperatura no puede estar por debajo del cero absoluto.";
		Exception e = assertThrows(IllegalArgumentException.class,() -> termometro.convertirAKelvin());
		String mensaje = e.getMessage();
		assertEquals(mensajeEsperado, mensaje);
	}
	
	@Test
	@DisplayName("Temperatura Kelvin Válida")
	void testKelvinVálido() {
		Double valorEsperado = 278.15;
		Double valor = termometro.convertirAKelvin();
		
		assertEquals(valorEsperado, valor);
	}
	

}
