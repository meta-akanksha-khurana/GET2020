package Ques3;

/**
 * This class represents Polynomial node class
 * @author Akanksha
 *
 */
public class PolyNode 
{
	private int coefficient;
	private LinkedList polynomialData;
	private PolyNode nextPolyNode;
	
	PolyNode(int coefficient, LinkedList polynomialData)
	{
		this.coefficient = coefficient;
		this.polynomialData = polynomialData;
		this.nextPolyNode = null;
	}
	
	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public LinkedList getPolynomialData() {
		return polynomialData;
	}

	public void setPolynomialData(LinkedList polynomialData) {
		this.polynomialData = polynomialData;
	}

	public PolyNode getNextPolyNode() {
		return nextPolyNode;
	}

	public void setNextPolyNode(PolyNode nextPolyNode) {
		this.nextPolyNode = nextPolyNode;
	}
	
}
