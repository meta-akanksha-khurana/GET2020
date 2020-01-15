import java.util.*;
/**
 * The class JobScheduler is used to simulate FCFS scheduling algorithm
 * @author Akanksha
 *
 */
public class JobScheduler {
	
	static List<Integer> completion_time=new ArrayList<Integer>();
	static List<Integer> waiting_time=new ArrayList<Integer>();
	static List<Integer> turnaround_time=new ArrayList<Integer>();
	
	/*
	 *  completionTime function is used to find completion time for each process
	 * @param process[][] This function takes an array containing arrival and burst time of all processes
	 * This function prints the completion time of each process
	 */
	static List completionTime(int process[][])
	{
		for(int i=0;i<process.length;i++){
			if(i == 0){
			  completion_time.add(process[i][0] + process[i][1]);
			}
			else{
			  if(process[i][0] > completion_time.get(i-1)){
			    completion_time.add(process[i][0] + process[i][1]);
			  }
			  else{
			    completion_time.add(completion_time.get(i-1) + process[i][1]);
			  }
			}
		}

		return completion_time;
	}

	/* 
	 * waitingTime function is used to find waiting time for each process
	 * @param process[][] This function takes an array containing arrival and burst time of all processes
	 * This function prints the waiting time of each process
	 */
	static List waitingTime(int process[][])
	{
		waiting_time.add(0);
	    for(int i=1 ; i<process.length; i++){
	        waiting_time.add(turnaround_time.get(i) - process[i][1]);
	    }
	
	    return waiting_time;
	}
	
	/* 
	 * turnaroundTime function is used to find completion time for each process
	 * @param process[][] This function takes an array containing arrival and burst time of all processes
	 * This function prints the turnaround time of each process
	 */
	static List turnaroundTime(int process[][])
	{
		for(int i=0;i<process.length;i++){
			turnaround_time.add(completion_time.get(i) - process[i][0]);
		}

		return turnaround_time;
	}
	
	/* 
	 * averageWaitingTime function is used find the average waiting time of process
	 * @return average waiting time
	 */
	static double averageWaitingTime()
	{
		int totalWaitingTime=0;
		double avg_WaitingTime=0;
		int no_of_processes=waiting_time.size();
		for(int i=0;i<no_of_processes;i++){
			totalWaitingTime+=waiting_time.get(i);
		}
		avg_WaitingTime=totalWaitingTime/no_of_processes;
		return avg_WaitingTime;
			
	}
	
	/*
	 * maximumWaitingTime function is used to find the maximum waiting time period for processes in queue
	 * @return maximum waiting time 
	 */
	static double maximumWaitingTime()
	{
		int max_WaitingTime=0;
		for(int i=0;i<waiting_time.size();i++){
			if(waiting_time.get(i)>max_WaitingTime){
				max_WaitingTime=waiting_time.get(i);
			}
		}
		return max_WaitingTime;
	}
	
	/**
	 * This function is used to sort the process according to arrival time
	 * @param process
	 */
	static void sort(int process[][])
	{
		int numOfProcess=process.length;
		for(int k = 0;k <numOfProcess; k++){
		   for(int j =0;j < (numOfProcess-1); j++){
		     if(process[j][0] > process[j+1][0]){
		       int temp1,temp2;
		       temp1 = process[j][0];
		       temp2 = process[j][1];

		       process[j][0] = process[j+1][0];
		       process[j][1] = process[j+1][1];

		       process[j+1][0] = temp1;
		       process[j+1][1] = temp2;
             }
		   }
		}
	}
	
	
	//main method
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of process:");
		int no_of_process=input.nextInt();
		if(no_of_process<=0){
			System.out.println("Enter a valid value!!");
		}
		else{
		     int process[][]=new int [no_of_process][2];
		     System.out.println("Enter arrival time and burst time:");
		     /*
		      * Read input from keyboard and stored it in process array
		      * as arrival time and burst time
		      */
		     for(int i=0;i<no_of_process;i++){
		         for(int j=0;j<2;j++){
			         process[i][j]=input.nextInt();
		         }
		     }
		     
		     JobScheduler.sort(process);
		     System.out.println("Sorted processes");
		     for(int j=0;j<no_of_process;j++)
		     {
		    	 System.out.println(process[j][0]+" "+process[j][1]);
		     }
		    	 
		     List<Integer> completionTimeList=JobScheduler.completionTime(process);
		     List<Integer> turnaroundTimeList=JobScheduler.turnaroundTime(process);
		     List<Integer> waitingTimeList=JobScheduler.waitingTime(process);
		     System.out.println("\nArrival  Burst  Complete  TurnAround  Waiting");
		     for(int i=0;i<no_of_process;i++)
		     {
		    	 System.out.println(process[i][0] + "\t  " + process[i][1] + "\t  " + completionTimeList.get(i) + "\t    " + turnaroundTimeList.get(i) + "\t\t" + waitingTimeList.get(i));
		     }
		     System.out.println("Average Waiting Time:"+JobScheduler.averageWaitingTime());
		     System.out.println("Maximum Waiting Time:"+JobScheduler.maximumWaitingTime());
		     input.close();
		}    
	}
	

}
