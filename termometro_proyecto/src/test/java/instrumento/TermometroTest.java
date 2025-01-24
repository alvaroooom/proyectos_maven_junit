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
	@DisplayName("Prueba del constructor")
	void testPruebaConstructor() {
		termometro = new Termometro(5);
		Double valorEsperado = (double) 5;
		Double valor = termometro.getTemperaturaCelsius();
		
		assertEquals(valorEsperado, valor);
	}
	
	@Test
	@DisplayName("Poner Temperatura")
	void testSetTemperatura() {
		termometro.setTemperaturaCelsius(30.0);
        assertEquals(30.0, termometro.getTemperaturaCelsius());
	}

	@Test
	@DisplayName("Comprobar si la conversión a Fahrenheit está bien")
	void testConvertirFahrenheit() {
		Double valorEsperado = 41.0;
		Double valor = termometro.convertirAFahrenheit();
		assertEquals(valorEsperado, valor);
	}
	
	@Test
	@DisplayName("Temperatura Kelvin válida")
	void testKelvinVálido() {
		Double valorEsperado = 278.15;
		Double valor = termometro.convertirAKelvin();
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
	@DisplayName("Temperatura no en rango")
	void testTemperaturaNoEnRango() {
		assertFalse(termometro.estaEnRango(10, 20), "No está en rango");
	}
	
	@Test
	@DisplayName("Temperatura en rango")
	void testTemperaturaEnRango() {
		assertTrue(termometro.estaEnRango(0, 10));
	}

	@Test
	@DisplayName("Temperatura en congelación")
	void testTemperaturaEnCongelación() {
		termometro = new Termometro (-5);
		assertTrue(termometro.esCongelacion());
	}
	
	@Test
	@DisplayName("Temperatura no en congelación")
	void testTemperaturaEnNoCongelación() {
		assertFalse(termometro.esCongelacion());
	}
	
	@Test
	@DisplayName("Temperatura en ebullición")
	void testTemperaturaEnEbullición() {
		termometro = new Termometro (180);
		assertTrue(termometro.esEbullicion());
	}
	
	@Test
	@DisplayName("Temperatura no en ebullición")
	void testTemperaturaNoEnEbullición() {
		assertFalse(termometro.esEbullicion());
	}
	
	@Test
	@DisplayName("Ajustar temperatura")
	void testAjustarTemperatura() {
		Double valorEsperado = 40.0;
		termometro.ajustarTemperatura(35);
		Double valor = termometro.getTemperaturaCelsius();
		
		assertEquals(valorEsperado, valor);
	}
	
	@Test
	@DisplayName("Coger temperatura")
	void testCogerTemperatura() {
		Double valorEsperado = 40.0;
		termometro.ajustarTemperatura(35);
		Double valor = termometro.getTemperaturaCelsius();
		
		assertEquals(valorEsperado, valor);
	}

}
