package tests.Excepciones;

import org.junit.jupiter.api.*;
import Exceptions.NegativeSideValuesException;
import Exceptions.SideWithCeroAsValueException;
import Exceptions.TriangleNotPossibleException;
import Triangle.Triangle;  
    
public class NegativeSideValuesExceptionTest {

    final String HAS_NEGATIVE_VALUE_MSG = "No se permiten valores negativos";
    final double NEGATIVE_SIDE_VALUE = -3.0;
    final double equilaterialSide = 3.0;

    @Test
    public void testNegativaSideValuesException() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        NegativeSideValuesException excepcionEsperada = Assertions.assertThrows(NegativeSideValuesException.class, () -> new Triangle(NEGATIVE_SIDE_VALUE, equilaterialSide, equilaterialSide));
        Assertions.assertEquals(HAS_NEGATIVE_VALUE_MSG, excepcionEsperada.getMessage());
    }
}