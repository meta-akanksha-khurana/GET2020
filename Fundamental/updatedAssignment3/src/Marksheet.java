import java.text.DecimalFormat;
import java.util.*;

/**
 * The class Marksheet is used to perform different operations on grades of students in the class.
 * @author Akanksha
 *
 */
public class Marksheet {
	
	/**
	 * maxOfGrades method is used to find maximum grade in the grades of all students
	 * @param grades i.e. grades of students
	 * @return maxGrade as maximum grade
	 * @throws ArithmeticException
	 */
	public static float maxOfGrades(float grades[]) throws ArithmeticException
	{
		float maxGrade=grades[0];
		for(int i=1;i<grades.length;i++){
			if(grades[i]>maxGrade){
				maxGrade=grades[i];
			}
		}
		return maxGrade;
	}
	

	/**
	 * minOfGrades method is used to find minimum grade in the grades of all students
	 * @param grades i.e. grades of students
	 * @return minGrade as minimum grade
	 * @throws ArithmeticException
	 */
	public static float minOfGrades(float grades[]) throws ArithmeticException
	{
		float minGrade=grades[0];
		for(int i=1;i<grades.length;i++){
			if(grades[i]<minGrade){
				minGrade=grades[i];
			}
		}
		return minGrade;
	}
	
	/**
	 * averageOfGrades method is used to find average of grades of students
	 * @param grades i.e. grades of students
	 * @return average as average of grades
	 * @throws ArithmeticException
	 */
	public static float averageOfGrades(float grades[]) throws ArithmeticException
	{
		int totalStudents=grades.length;
		float sumOfGrades=0;
		float average=0;
		for(int i=0;i<totalStudents;i++){
			sumOfGrades+=grades[i];
		}
		
		average=sumOfGrades/totalStudents;
		return average;
	}
	
	/**
	 * percentageOfPassedStudents method is used to find the percentage of passed students. Assume grade>=40 as Pass
	 * @param grades i.e. grades of students
	 * @return percent as percentage of students passed 
	 * @throws ArithmeticException
	 */
	public static float percentageOfPassedSttudents(float grades[]) throws ArithmeticException
	{
		float percent;
		int totalStudents=grades.length;
		int passedStudents=0;
		for(int i=0;i<grades.length;i++){
			if(grades[i]>=40){
				passedStudents++;
			}
		}

		percent=(float)(passedStudents*100)/totalStudents;
		return percent;
	}
	
	//main method
	public static void main(String[] args) {
		
		/*  DecimalFormat class is used to set floating point values upto 2 decimal places  */
		DecimalFormat df=new DecimalFormat("#0.00");
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of students:");
		int numOfStudents=input.nextInt();
		
		/* n should be positive  */
		if(numOfStudents<=0){
			System.out.println("Enter valid number!!");
		}
		System.out.println("Enter grades of students between 0 and 100");  // 0 and 100 both inclusive
		float grades[]=new float[numOfStudents];
		for(int i=0;i<numOfStudents;i++){
			grades[i]=input.nextFloat();
			
			if(grades[i]<0 || grades[i]>100){
				System.out.println("Enter valid values!!");
				return;
			}
		}
		System.out.println("Average of grades:"+df.format(Marksheet.averageOfGrades(grades)));
		
		System.out.println("Maximum of grades:"+Marksheet.maxOfGrades(grades));
		
		System.out.println("Minimum of grades:"+Marksheet.minOfGrades(grades));
        
        System.out.println("Percentage of students passed:"+df.format(Marksheet.percentageOfPassedSttudents(grades)));
        
         input.close();
	}

}
