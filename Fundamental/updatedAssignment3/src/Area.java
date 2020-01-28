import java.util.*;
/**
 * The class Area is used to calculate area of different shapes
 * @author Akanksha
 *
 */
public class Area {

	/**
	 * areaOfRectangle method is used to calculate area of rectangle
	 * @param width in double. Assume width>0
	 * @param height in double. Assume height>0
	 * @return area as area of rectangle in double
	 * @throws ArithmeticException
	 */
	public static double areaOfRectangle(double width,double height) throws ArithmeticException
	{
		double area=width*height;
		return area;
	}
	
	
	/**
	 * areaOfTriangle method is used to calculate area of triangle
	 * @param width in double. Assume width>0
	 * @param height in double. Assume height>0
	 * @return area as area of triangle in double
	 * @throws ArithmeticException
	 */
	public static double areaOfTriangle(double width,double height) throws ArithmeticException
	{
		double area=0.5*width*height;
		return area;
	}
	
	
	/**
	 * areaOfCircle method isused to calculate area of circle
	 * @param radius in double. Assume radius>0
	 * @return area as area of circle in double 
	 * @throws ArithmeticException
	 */
	public static double areaOfCircle(double radius) throws ArithmeticException
	{
		double PI=3.14;
		double area=PI*radius*radius;
		return area;
	}
	
	/**
	 * areaOfSquare method isused to calculate area of square
	 * @param width in double. Assume width>0
	 * @return area as area of square in double
	 * @throws ArithmeticException
	 */
	public static double areaOfSquare(double width) throws ArithmeticException
	{
		double area;
		area=width*width;
		return area;
	}
	
	
	//main method
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Boolean option;
		try{
			do{
				System.out.println("1. Find area of rectangle");
				System.out.println("2. Find area of triangle");
				System.out.println("3. Find area of circle");
				System.out.println("4. Find area of square");
				System.out.println("5. Exit");
				System.out.println("Enter your choice");
				int choice=input.nextInt();

				switch(choice){
				case 1:
					System.out.println("Enter width and height of rectangle:");
					double widthRectangle=input.nextDouble();
					double heightRectangle=input.nextDouble();
					System.out.println("Area of Rectangle:"+Area.areaOfRectangle(widthRectangle, heightRectangle));
					break;

				case 2:
					System.out.println("Enter width and height of triangle:");
					double widthTriangle=input.nextDouble();
					double heightTriangle=input.nextDouble();
					System.out.println("Area of Triangle:"+Area.areaOfTriangle(widthTriangle, heightTriangle));
					break;

				case 3:
					System.out.println("Enter radius of circle:");
					double radius=input.nextDouble();
					System.out.println("Area of circle:"+Area.areaOfCircle(radius));
					break;

				case 4:
					System.out.println("Enter width(side) of square:");
					double widthSquare=input.nextDouble();
					System.out.println("Area of Square:"+Area.areaOfSquare(widthSquare));
					break;

				case 5:
					System.exit(0);

				default:
					System.exit(0);
				}

				System.out.println("Do you want to continue?");
				String ans=input.next();
				if(ans.equalsIgnoreCase("yes"))
					option = true;
				else
					option=false;
			}while(option);

			input.close();
		}
		catch(ArithmeticException ae){
			System.out.println("Arithmetic Exception occurred!!");
		}
	}

}
