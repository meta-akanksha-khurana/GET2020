import java.util.*;
/**
 * Poly is an immutable class which uses an array to represent single variable polynomial 
 * and perform operations on it.
 * @author Akanksha
 *
 */
final public class Poly {
	final private int coefficient[];
	final private int exponent[];
	
	
	/**
	 * This is the constructor to intialize coefficient and exponent
	 * @param coeff array containing coeffiecients
	 * @param exp array containing exponents
	 */
	public Poly(int []coeff,int exp[]) {
		if(coeff.length==0 || exp.length==0 || coeff.length!=exp.length){
			throw new AssertionError();
		}
		int tempCoeff[]=new int[coeff.length];
		int tempExp[]=new int[exp.length];
		int tempCoeffindex=0;
		int tempExpindex=0;
		int count=0;
		for(int i=0;i<coeff.length;i++){
			if(coeff[i]==0){
				count++;
				continue;
			}
			else{
				tempCoeff[tempCoeffindex]=coeff[i];
				tempExp[tempExpindex]=exp[i];
				tempCoeffindex++;
				tempExpindex++;
			}
		}
		coefficient=Arrays.copyOf(tempCoeff, tempCoeff.length-count);
		exponent=Arrays.copyOf(tempExp, tempExp.length-count);
	}
     
     /**
      * This method is used to evaluate polynomial by using value in place of variable
      * @param value.It is an integer value used in place of variable
      * @return final result after the evaluation
      */
    public float evaluate(float value)
    {
    	float result=0;
    	int length=coefficient.length;
    	for(int i=0;i<length;i++){
    		result+=coefficient[i]*Math.pow(value, exponent[i]);
    	}
    	return result;
    }
    
    
    /**
     * This method is used to add two polynomials 
     * @param polynomial1 first polynomial of type Poly
     * @param polynomial2 second polynomial of type Poly
     * @return addition of two polynomials in Poly type
     */
    public Poly add(Poly polynomial1,Poly polynomial2 )
    {
    	Poly tempPolynomial1=polynomial1;
    	Poly tempPolynomial2=polynomial2;
    	int indexResult=-1;

    	int size1=tempPolynomial1.coefficient.length;
    	int size2=tempPolynomial2.coefficient.length;
    	int resultSize=size1+size2;
    	int resultCoeff[]=new int[resultSize];
    	int resultExp[]=new int[resultSize];
    	
    	for(int i=0;i<size1;i++){
    		for(int j=0;j<size2;j++){
    			if(tempPolynomial1.exponent[i]==tempPolynomial2.exponent[j]){
    				indexResult++;
    				resultCoeff[indexResult]=tempPolynomial1.coefficient[i]+tempPolynomial2.coefficient[j];
    				resultExp[indexResult]=tempPolynomial1.exponent[i];
    				tempPolynomial1.coefficient[i]=0;
    				tempPolynomial2.coefficient[j]=0;
    				break;
    			}
    		}	
    	}
    	
    	for(int i=0;i<size1;i++){
    		if(tempPolynomial1.coefficient[i]!=0){
    			indexResult++;
    			resultCoeff[indexResult]=tempPolynomial1.coefficient[i];
    			resultExp[indexResult]=tempPolynomial1.exponent[i];
    		}
    	}
    	
    	for(int i=0;i<size2;i++){
    		if(tempPolynomial2.coefficient[i]!=0){
    			indexResult++;
    			resultCoeff[indexResult]=tempPolynomial2.coefficient[i];
    			resultExp[indexResult]=tempPolynomial2.exponent[i];
    		}
    	}
    	
    	Poly sumPolynomial=new Poly(resultCoeff,resultExp);
    	
    	return sumPolynomial;
    }
    
    /**
     * This method is used to do the multiplication of two polynomials
     * @param polynomial1 first polynomial of type Poly
     * @param polynomial2 second polynomial of type Poly
     * @return multiplication of two polynomials in Poly type
     */
    public Poly multiply(Poly polynomial1,Poly polynomial2)
    {
    	Poly tempPolynomial1=polynomial1;
    	Poly tempPolynomial2=polynomial2;
    	int indexResult=-1;

    	int size1=tempPolynomial1.coefficient.length;
    	int size2=tempPolynomial2.coefficient.length;
    	int resultSize=size1+size2;
    	int resultCoeff[]=new int[resultSize];
    	int resultExp[]=new int[resultSize];
    	
    	for(int i=0;i<size1;i++){
    		
    		for(int j=0;j<size2;j++){
    			if(tempPolynomial1.exponent[i]==tempPolynomial2.exponent[j]){
    				indexResult++;
    				resultCoeff[indexResult]=tempPolynomial1.coefficient[i]*tempPolynomial2.coefficient[j];
    				resultExp[indexResult]=tempPolynomial1.exponent[i];
    				tempPolynomial1.coefficient[i]=0;
    				tempPolynomial2.coefficient[j]=0;
    				break;
    			}
    		}	
    	}
    	
    	for(int i=0;i<size1;i++){
    		if(tempPolynomial1.coefficient[i]!=0){
    			indexResult++;
    			resultCoeff[indexResult]=tempPolynomial1.coefficient[i];
    			resultExp[indexResult]=tempPolynomial1.exponent[i];
    		}
    	}
    	
    	for(int i=0;i<size2;i++){
    		if(tempPolynomial2.coefficient[i]!=0){
    			indexResult++;
    			resultCoeff[indexResult]=tempPolynomial2.coefficient[i];
    			resultExp[indexResult]=tempPolynomial2.exponent[i];
    		}
    	}
    	
        Poly multiplyPolynomial=new Poly(resultCoeff,resultExp);
    	
    	return multiplyPolynomial;

    }
    
    
    /**
     * This method returns the degree of the polynomial
     * @return degree in integer format
     */
    public int degree()
    {
    	int length=exponent.length;
    	int max=exponent[0];
    	for(int i=1;i<length;i++){
    		if(max<exponent[i]){
    			max=exponent[i];
    		}
    	}
    	return max;
    }
    
    
	
    /**
     * prints the polynomial
     *//*
    void print()
    {
    	
    	for(int i=0;i<coefficient.length;i++){
    		System.out.print(coefficient[i]+"X^"+exponent[i]+" ");
    	}
    	System.out.println();
    }*/
    
    /**
     * This function is used to return coefficient array
     * @return coefficient array
     */
    public int[] getCoefficient(){
    	return this.coefficient;
    }
    
    /**
     * This function is used to return exponent array
     * @return exponent array
     */
    public int[] getExponent(){
    	return this.exponent;
    }

}
