package tests.Triangle;

import org.junit.jupiter.api.*;

import Exceptions.NegativaSideValuesException;
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

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {

    }
    
    @BeforeEach
    public void setUp() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativaSideValuesException{
    
    }

    @AfterEach
    public void tearDown() {
        
    }
        
    @Test
    public void testSetType1() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativaSideValuesException {
        Triangle triangle = new Triangle(equilaterialSide, equilaterialSide, equilaterialSide);
        Assertions.assertEquals(equilateralType, triangle.getType());
    }

    @Test
    public void testSetType2() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativaSideValuesException {
        Triangle triangle = new Triangle(isoscelesSide1, isoscelesSide1, isoscelesSide2);
        Assertions.assertEquals(isoscelesType, triangle.getType());
    }

    @Test
    public void testSetType3() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativaSideValuesException {
        Triangle triangle = new Triangle(isoscelesSide1, isoscelesSide2, isoscelesSide1);
        Assertions.assertEquals(isoscelesType, triangle.getType());
    }

    @Test
    public void testSetType4() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativaSideValuesException {
        Triangle triangle = new Triangle(isoscelesSide1, isoscelesSide2, isoscelesSide2);
        Assertions.assertEquals(isoscelesType, triangle.getType());
    }

    @Test
    public void testSetType5() throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativaSideValuesException {
        Triangle triangle = new Triangle(scaleneSide1, scaleneSide2, scaleneSide3);
        Assertions.assertEquals(scaleneType, triangle.getType());
    }
}
    