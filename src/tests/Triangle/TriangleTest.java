package tests.Triangle;

import org.junit.jupiter.api.*;

import Exceptions.NegativeSideValuesException;
import Exceptions.SideWithCeroAsValueException;
import Exceptions.TriangleNotPossibleException;
import Triangle.Triangle;
    
public class TriangleTest {
    
    final double NEGATIVE_SIDE_VALUE = -1;
    final double CERO_SIDE_VALUE = 0;
    final double LARGE_SIDE_VALUE = 100;

    final double equilaterialSide = 3.0;

    final double isoscelesSide1 = 5.0;
    final double isoscelesSide2 = 4.0;

    final double scaleneSide1 = 3.0;
    final double scaleneSide2 = 4.0;
    final double scaleneSide3 = 5.0;

    final String equilateralType = "Equilatero";
    final String isoscelesType = "Isosceles";
    final String scaleneType = "Escaleno";
    
    final String HAS_CERO_AS_VALUE_MSG = "No puede tener un lado con valor 0";
    final String NEGATIVE_VALUES_MSG = "No se permiten valores negativos";
    final String INVALID_TRIANGLE_MSG = "No es un triangulo valido";
    @BeforeAll
    public static void setUpClass() {
    	
    }

    @AfterAll
    public static void tearDownClass() {

    }
    
    @BeforeEach
    public void setUp() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException{
    
    }

    @AfterEach
    public void tearDown() {
        
    }

    @Test
    public void testTriangle1() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(3.0, triangle.getSide1(), 0.001);
        Assertions.assertEquals(4.0, triangle.getSide2(), 0.001);
        Assertions.assertEquals(5.0, triangle.getSide3(), 0.001);
    }
        
    @Test
    public void testSetType1() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        Triangle triangle = new Triangle(equilaterialSide, equilaterialSide, equilaterialSide);
        Assertions.assertEquals(equilateralType, triangle.getType());
    }

    @Test
    public void testSetType2() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        Triangle triangle = new Triangle(isoscelesSide1, isoscelesSide1, isoscelesSide2);
        Assertions.assertEquals(isoscelesType, triangle.getType());
    }

    @Test
    public void testSetType3() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        Triangle triangle = new Triangle(isoscelesSide1, isoscelesSide2, isoscelesSide1);
        Assertions.assertEquals(isoscelesType, triangle.getType());
    }

    @Test
    public void testSetType4() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        Triangle triangle = new Triangle(isoscelesSide1, isoscelesSide2, isoscelesSide2);
        Assertions.assertEquals(isoscelesType, triangle.getType());
    }

    @Test
    public void testSetType5() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        Triangle triangle = new Triangle(scaleneSide1, scaleneSide2, scaleneSide3);
        Assertions.assertEquals(scaleneType, triangle.getType());
    }
    
    @Test
    public void testIsValidTriangleValidTriangle() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        Triangle triangle = new Triangle(scaleneSide1, scaleneSide2, scaleneSide3);
        Assertions.assertTrue(triangle.isValidTriangle());
    }

    @Test
    public void testIsValidTriangleInvalidTriangle() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        TriangleNotPossibleException exception = Assertions.assertThrows(TriangleNotPossibleException.class, () -> {
            new Triangle(isoscelesSide1, isoscelesSide1, LARGE_SIDE_VALUE).isValidTriangle();
        });
        Assertions.assertEquals(INVALID_TRIANGLE_MSG, exception.getMessage());
    }

    @Test
    public void testHasNegativeValueWithNegativeValues() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
    		NegativeSideValuesException exception = Assertions.assertThrows(NegativeSideValuesException.class, () -> {
            	new Triangle(NEGATIVE_SIDE_VALUE, scaleneSide2, scaleneSide3);
            });
            Assertions.assertEquals(NEGATIVE_VALUES_MSG, exception.getMessage());
    }

    @Test
    public void testHasNegativeValueWithoutNegativeValues() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
         Triangle triangle = new Triangle(scaleneSide1, scaleneSide2, scaleneSide3);
         Assertions.assertFalse(triangle.hasNegativeValue());
    }
}
    