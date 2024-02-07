package Triangle;

import Exceptions.NegativeSideValuesException;
import Exceptions.SideWithCeroAsValueException;
import Exceptions.TriangleNotPossibleException;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;
    private String type;

    public Triangle(double side1,double side2,double side3) throws TriangleNotPossibleException, SideWithCeroAsValueException, NegativeSideValuesException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (hasNegativeValue())
            throw new NegativeSideValuesException("No se permiten valores negativos");
        if (hasCeroAsValue())
            throw new SideWithCeroAsValueException("No puede tener un lado con valor 0");
        if (!isValidTriangle())
            throw new TriangleNotPossibleException("No es un triangulo valido");
        setType();
    }

    // Getters
    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    public String getType() {
        return this.type;
    }

    // Setters
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public void setType(){
        if (this.side1 == this.side2 && this.side2 == this.side3) {
            this.type = "Equilatero";
        } else if (this.side1 == this.side2 || this.side1 == this.side3 || this.side2 == this.side3) {
            this.type = "Isosceles";
        } else {
            this.type = "Escaleno";
        }
    }

    public boolean isValidTriangle() throws TriangleNotPossibleException {
        if (this.side1 + this.side2 > this.side3 && this.side1 + this.side3 > this.side2 && this.side2 + this.side3 > this.side1) 
            return true;

        return false;
    }

    public boolean hasCeroAsValue() throws SideWithCeroAsValueException {
        if (this.side1 == 0 || this.side2 == 0 || this.side3 == 0) 
            return true;
        
        return false;
    }

    public boolean hasNegativeValue() throws NegativeSideValuesException {
        if (this.side1 < 0 || this.side2 < 0 || this.side3 < 0) 
            return true;
        
        return false;
    }

    public double getArea() {
        double s = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
    }

} 