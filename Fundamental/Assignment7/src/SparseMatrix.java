import java.util.Arrays;
/**
 * Sparsematrix is an immutable class for representing two-dimensional sparse matrices
 * and performing operations on them
 * @author Akanksha
 *
 */
final public class SparseMatrix {

	private int compactmatrix[][];
	private int matrixRow;
	private int matrixColumn;
	
	/**
	 * This is the constructor used to change the original matrix into compact matrix
	 * which stores only non zero elements in form of Row,Column,Value 
	 * @param matrix is original sparse matrix
	 */
	public SparseMatrix(int matrix[][]) {
	    if(matrix.length==0){
	    	throw new AssertionError();
	    }
	    matrixRow=matrix.length;
	    matrixColumn=matrix[0].length;
	    convert(matrix);
	}
	
	/**
	 * This private method is used to convert the original sparse matrix into compact matrix
	 * @param matrix is original sparse matrix
	 */
	private void convert(int matrix[][]){
		int k=0;
		int countNonZero=0;
		for(int i=0;i<matrix.length;i++){
	    	for(int j=0;j<matrix[i].length;j++){
	    		if(matrix[i][j]!=0){
	    			countNonZero++;
	    		}
	    	}
	    }
	    
	    compactmatrix=new int[countNonZero][3];
	    
	    for(int i=0;i<matrix.length;i++){
	    	for(int j=0;j<matrix[i].length;j++){
	    		if(matrix[i][j]!=0){
	    			compactmatrix[k][0]=i;
	    			compactmatrix[k][1]=j;
	    			compactmatrix[k][2]=matrix[i][j];
	    			k++;
	    		}
	    	}
	    }
	}
	
	
	/**
	 * transpose method is used to find transpose of the compact form of sparse matrix
	 * @return transpose in form of 2D array
	 */
	public int[][] transpose(){
		int transposeMatrix[][]=new int[compactmatrix.length][3];
		int total[]=new int[matrixColumn];
		int index[]=new int[total.length+1];                                                                                                                          
		int rowTranspose,colTranspose;
		for(int i=0;i<total.length;i++){
			total[i]=0;
		}


		for(int i=0;i<total.length;i++){
			for(int j=0;j<compactmatrix.length;j++){
				if(i==compactmatrix[j][1]){
					total[i]++;
				}
			}
		}


		index[0]=0;

		for(int i=1;i<index.length;i++){
			index[i]=index[i-1]+total[i-1];
		}



		for(int i=0;i<compactmatrix.length;i++){
			rowTranspose=compactmatrix[i][1];
			colTranspose=compactmatrix[i][0];
			for(int j=0;j<index.length;j++){
				if(rowTranspose==j){
					transposeMatrix[index[j]][0]=rowTranspose;
					transposeMatrix[index[j]][1]=colTranspose;
					transposeMatrix[index[j]][2]=compactmatrix[i][2];
					index[j]++;
					break;
				}
			}
		}
		return transposeMatrix;
	}
	
	/**
	 * add method is used to add two sparse matrices
	 * @param matrix is the object of SparseMatrix which is added to the
	 * SparseMatrix object which calls the function.
	 * @return addition of two matrices in form of 2D array
	 */
	public int[][] add(SparseMatrix matrix)
	{
		if(this.matrixRow!=matrix.matrixRow || this.matrixColumn!=matrix.matrixColumn){
			System.out.println("matrices can't be added!!");
			throw new AssertionError();
		}
		else{
			int resultRows=this.compactmatrix.length+matrix.compactmatrix.length;
			int result[][]=new int[resultRows][3];
			int index=0;
			for(int i=0;i<this.compactmatrix.length;i++){
				for(int j=0;j<matrix.compactmatrix.length;j++){
					if(this.compactmatrix[i][0]!=-1 && matrix.compactmatrix[j][0]!=-1){
						if(this.compactmatrix[i][0]==matrix.compactmatrix[j][0]){

							if(this.compactmatrix[i][1]==matrix.compactmatrix[j][1]){
								result[index][0]=this.compactmatrix[i][0];
								result[index][1]=this.compactmatrix[i][1];
								result[index][2]=this.compactmatrix[i][2]+matrix.compactmatrix[j][2];
								index++;
								this.compactmatrix[i][0]=matrix.compactmatrix[j][0]=-1;
							}
							else if(this.compactmatrix[i][1]<matrix.compactmatrix[j][1]){
								result[index][0]=this.compactmatrix[i][0];
								result[index][1]=this.compactmatrix[i][1];
								result[index][2]=this.compactmatrix[i][2];
								index++;
								this.compactmatrix[i][0]=-1;
							}

							else{
								result[index][0]=matrix.compactmatrix[j][0];
								result[index][1]=matrix.compactmatrix[j][1];
								result[index][2]=matrix.compactmatrix[j][2];
								index++;
								matrix.compactmatrix[j][0]=-1;
							}
						}
						else if(this.compactmatrix[i][0]<matrix.compactmatrix[j][0]){
							result[index][0]=this.compactmatrix[i][0];
							result[index][1]=this.compactmatrix[i][1];
							result[index][2]=this.compactmatrix[i][2];
							index++;
							this.compactmatrix[i][0]=-1;
						}
						else{
							result[index][0]=matrix.compactmatrix[j][0];
							result[index][1]=matrix.compactmatrix[j][1];
							result[index][2]=matrix.compactmatrix[j][2];
							index++;
							matrix.compactmatrix[j][0]=-1;
						}
					}
				}
			}
			result=Arrays.copyOf(result, index);
			return result;
		}
		
	}
	
	/**
	 * multiply method is used to multiply two sparse matrices
	 * @param matrix is the object of SparseMatrix class which is multiplied with the
	 * SparseMatrix object which calls the function
	 * @return multiplication of two sparse matrices in form of 2D array
	 */
	public int[][] multiply(SparseMatrix matrix)
	{
		if(this.matrixColumn!=matrix.matrixRow){
			System.out.println("multiplication can't be done!!");
			throw new AssertionError();
		}
		int multiplication[][]=new int [this.matrixColumn][matrix.matrixRow];
		for(int i=0;i<multiplication.length;i++){
			for(int j=0;j<multiplication[i].length;j++){
				multiplication[i][j]=0;
			}
		}
		int trans[][]=matrix.transpose();
		
		
		for(int i=0;i<this.compactmatrix.length;i++){
			for(int j=0;j<trans.length;j++){
				
				if(this.compactmatrix[i][1]==trans[j][1]){
					multiplication[this.compactmatrix[i][0]][trans[j][0]]+=
							(this.compactmatrix[i][2] * trans[j][2]);
				}
				
					
			}
		}
		return multiplication;
	}
	
	
	/**
	 * This function is used to check if sparseMatrix is symmetric or not
	 * @return true if symmetric else false
	 */
	public boolean checkSymmetric(){
		
		if(this.matrixRow!=this.matrixColumn){
			throw new AssertionError();
		}
		    int transposeMatrix[][]=this.transpose();
			
			for(int i=0;i<this.compactmatrix.length;i++){
				for(int j=0;j<3;j++){
					if(this.compactmatrix[i][j]!=transposeMatrix[i][j]){
						return false;
					}
				}
			}
		return true;
	}
	
	/**
	 * This function prints the matrix
	 *//*
	public void print(){
		for(int i=0;i<compactmatrix.length;i++){
			for(int j=0;j<compactmatrix[i].length;j++){
				System.out.print(compactmatrix[i][j]+" ");
			}
			System.out.println();
		}
	}*/
	
	
}
