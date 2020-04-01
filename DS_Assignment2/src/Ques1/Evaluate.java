package Ques1;

/**
 * This class is used to evaluate a infix expression
 * @author Akanksha
 *
 */
public class Evaluate {

	/**
	 * This method is used to convert infix expression to postfix expression
	 * @param expression is infix expression
	 * @return postfix expression
	 * @throws Assertion Error if expression is invalid
	 */
	String infixToPostfix(String expression){
		String expArray[]=expression.split(" ");
		String result="";
		Stack stack=new Stack(expArray.length);

		for(int i=0;i<expArray.length;i++){
			if(Character.isDigit(expArray[i].charAt(0))){
				result+=expArray[i]+" ";
			}
			else if(expArray[i].charAt(0)=='('){
				stack.push(expArray[i]);
			}
			else if(expArray[i].charAt(0)==')'){
				while(!stack.isEmpty() && stack.peek().charAt(0)!='('){
					result+=stack.pop()+" ";
				}
				if(!stack.isEmpty() && stack.peek().charAt(0)=='('){
					stack.pop();
				}
				else if(stack.isEmpty()){
					throw new AssertionError("invalid expression");
				}
			}

			else{

				while(!stack.isEmpty() && precedence(expArray[i]) <= precedence(stack.peek())){
					result+=stack.pop()+" ";
				}
				stack.push(expArray[i]);
			}
		}

		while(!stack.isEmpty()){
			if(stack.peek().charAt(0)=='(' || stack.peek().charAt(0)==')'){
				throw new AssertionError("invalid expression");
			}
			result+=stack.pop()+" ";
		}

		return result;

	}

	
	/**
	 * This method is used to get the precedence of an operator
	 * @param operator
	 * @return integer value as precedence
	 */
	private int precedence(String operator){
		switch(operator){
		case "||":
			return 1;
		case "&&":
			return 2;
		case "==":
		case "!=":
			return 3;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 4;
		case "+":
		case "-":
			return 5;
		case "*":
		case "/":
			return 6;
		}
		return -1;
	}


	/**
	 * This method is used to evaluate the postfix expression
	 * @param expression is converted postfix expression
	 * @return evaluated result
	 */
	Integer evaluateExpression(String expression){
		Integer result=null;
		String []expressionArray=expression.split(" ");
		int size=expressionArray.length;
		Stack stack=new Stack(size);
		for(int i=0;i<size;i++){
			
			if(Character.isDigit(expressionArray[i].charAt(0))){
				stack.push(expressionArray[i]);
			}
			else
			{
				performOperation(expressionArray[i],stack);
			}
		}
		result=Integer.parseInt(stack.pop());
		return result;
	}

	/**
	 * This method is used to perform different operations on values
	 * @param operator represents type of operation
	 * @param stack represents stack which is used in whole operation
	 */
	private void performOperation(String operator,Stack stack){
		Integer value1=Integer.parseInt(stack.pop());
		Integer value2=Integer.parseInt(stack.pop());
		Integer result;
		Boolean boolValue1,boolValue2,answer;
		boolValue1=boolValue2=null;

		switch(operator){
		case "+":
			result=value1+value2;
			stack.push(result.toString());
			break;
		case "-":
			result=value2-value1;
			stack.push(result.toString());
			break;
		case "*":
			result=value1*value2;
			stack.push(result.toString());
			break;
		case "/":
			result=value2/value1;
			stack.push(result.toString());
			break;
		case "<":
			result=value2<value1?1:0;
			stack.push(result.toString());
			break;
		case ">":
			result=value2>value1?1:0;
			stack.push(result.toString());
			break;
		case "<=":
			result=value2<=value1?1:0;
			stack.push(result.toString());
			break;
		case ">=":
			result=value2>=value1?1:0;
			stack.push(result.toString());
			break;
		case "==":
			result=value2==value1?1:0;
			stack.push(result.toString());
			break;
		case "!=":
			result=value2<value1?1:0;
			stack.push(result.toString());
			break;

		case "&&":
			if(value1==0){
				boolValue1=false;
			}
			else if(value2==0){
				boolValue2=false;
			}
			else if(value1==1){
				boolValue1=true;
			}
			else if(value2==1){
				boolValue2=true;
			}

			result=boolValue1&&boolValue2 ? 1:0;
			stack.push(result.toString());
			break;

		case "||":
			if(value1==0 && value2==0){
				boolValue1=false;
				boolValue2=false;
			}
			else if(value1==1 && value2==0){
				boolValue1=true;
				boolValue2=false;
			}
			else if(value1==0 && value2==1){
				boolValue1=false;
				boolValue2=true;
			}
			else if(value1==1 && value2==1){
				boolValue1=true;
				boolValue2=true;
			}
			result=(boolValue1 || boolValue2) ? 1:0;
			stack.push(result.toString());
			break;
		}

	}
}
