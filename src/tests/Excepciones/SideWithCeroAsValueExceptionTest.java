package tests.Excepciones;

import org.junit.jupiter.api.*;

import Exceptions.NegativaSideValuesException;
import Exceptions.SideWithCeroAsValueException;
import Exceptions.TriangleNotPossibleException;
import Triangle.Triangle;  
    
public class SideWithCeroAsValueExceptionTest {

    final String HAS_CERO_AS_VALUE_MSG = "No puede tener un lado con valor 0";
    final double CERO_SIDE_VALUE = 0;
    final double equilaterialSide = 3.0;

    @Test
    public void testSideWithCeroAsValueExceptionTest() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativaSideValuesException{
        SideWithCeroAsValueException excepcionEsperada = Assertions.assertThrows(SideWithCeroAsValueException.class, ()->new Triangle(CERO_SIDE_VALUE, equilaterialSide, equilaterialSide));
        Assertions.assertEquals(HAS_CERO_AS_VALUE_MSG, excepcionEsperada.getMessage());
    }
}
    