package tests.Excepciones;

import org.junit.jupiter.api.*;
import Exceptions.NegativeSideValuesException;
import Exceptions.SideWithCeroAsValueException;
import Exceptions.TriangleNotPossibleException;
import Triangle.Triangle;  
    
public class TriangleNotPossibleExceptionTest {

    final String IS_VALID_TRIANGLE_MSG = "No es un triangulo valido";
    final double VALID_SIDE_VALUE = 100.0;
    final double equilaterialSide = 3.0;

    @Test
    public void testTriangleNotPossibleException() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        TriangleNotPossibleException excepcionEsperada = Assertions.assertThrows(TriangleNotPossibleException.class, () -> new Triangle(VALID_SIDE_VALUE, equilaterialSide, equilaterialSide));
        Assertions.assertEquals(IS_VALID_TRIANGLE_MSG, excepcionEsperada.getMessage());
    }
}