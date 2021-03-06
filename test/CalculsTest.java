import static org.junit.jupiter.api.Assertions.*;


import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
class CalculsTest {

	// Fournisseur de données
    static Stream<Arguments> chargerJeuDeTestMultiplication() throws Throwable 
    {
        return Stream.of(
            Arguments.of(2,2,4), // appellera : testMultiplier(2,2,4)
            Arguments.of(6,6,36),
            Arguments.of(3,2,6)
        );
    }
    
    static Stream<Arguments> chargerJeuDeTestAdditions() throws Throwable 
    {
        return Stream.of(
            Arguments.of(2,2,4),
            Arguments.of(6,6,12),
            Arguments.of(3,2,5)
        );
    } 
    
    static Stream<Arguments> chargerJeuDeTestSoustraire() throws Throwable 
    {
        return Stream.of(
            Arguments.of(2,2,0),
            Arguments.of(7,6,1),
            Arguments.of(3,2,1)
        );
    }
    
    static Stream<Arguments> chargerJeuDeTestDivision() throws Throwable 
    {
        return Stream.of(
            Arguments.of(2,2,1),
            Arguments.of(21,7,3),
            Arguments.of(6,2,3)
        );
    }
    
    
    
	@ParameterizedTest(name="Additionner numéro {index}: nombre1={0}, nombre2={1}, résultat attendu = {2}")
	@MethodSource("chargerJeuDeTestAdditions")
	void testAdditionner(int firstNumber, int secondNumber, int expectedResult) 
	{
	        Calculs monCal = new Calculs(firstNumber, secondNumber);
	        assertEquals(expectedResult, monCal.additionner(), "test en échec pour " + firstNumber + " + " + secondNumber + " != " + expectedResult); 
	}
	
	
	@ParameterizedTest(name="Soustraire numéro {index}: nombre1={0}, nombre2={1}, résultat attendu = {2}")
	@MethodSource("chargerJeuDeTestSoustraire")
	void testSoustraire(int firstNumber, int secondNumber, int expectedResult) 
	{
	        Calculs monCal = new Calculs(firstNumber, secondNumber);
	        assertEquals(expectedResult, monCal.soustraire(), "test en échec pour " + firstNumber + " - " + secondNumber + " != " + expectedResult); 
	}
	

	@ParameterizedTest(name="Multiplication numéro {index}: nombre1={0}, nombre2={1}, résultat attendu = {2}")
	@MethodSource("chargerJeuDeTestMultiplication")
	void testMultiplier(int firstNumber, int secondNumber, int expectedResult) 
	{
	        Calculs monCal = new Calculs(firstNumber, secondNumber);
	        assertEquals(expectedResult, monCal.multiplier(), "test en échec pour " + firstNumber + " * " + secondNumber + " != " + expectedResult); 
	}
	
	
	@ParameterizedTest(name="Division numéro {index}: nombre1={0}, nombre2={1}, résultat attendu = {2}")
	@MethodSource("chargerJeuDeTestDivision")
	void testDiviser(int firstNumber, int secondNumber, int expectedResult) 
	{
			Calculs monCal = new Calculs(firstNumber, secondNumber);
	        assertEquals(expectedResult, monCal.diviser(), "test en échec pour " + firstNumber + " / " + secondNumber + " != " + expectedResult); 	
	}
	
	@Test
	void testDiviserParZero() 
	{
			Calculs monCal = new Calculs(50, 0);
	        assertThrows(ArithmeticException.class, () -> {
	        	monCal.diviser();
	        }); 	
	}

}
