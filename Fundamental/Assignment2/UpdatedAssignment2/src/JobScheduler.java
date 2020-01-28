import java.util.*;
/**
 * The class JobScheduler is used to simulate FCFS scheduling algorithm
 * @author Akanksha
 *
 */
public class JobScheduler {
	
	int process[][];
	
	
	JobScheduler(int numberOfProcess){
		Scanner input=new Scanner(System.in);
		this.process=new int[numberOfProcess][2];
		
	     System.out.println("Enter arrival time and burst time:");
	     /*
	      * Read input from keyboard and stored it in process array
	      * as arrival time and burst time
	      */
	     for(int i=0;i<numberOfProcess;i++){
	         for(int j=0;j<2;j++){
		         process[i][j]=input.nextInt();
	         }
	     }
	     
	     sort();
	     input.close();
	}
	
	
	/*
	 * sort is the private function which is used to sort the data on the basis of arrival time
	 */
	private void sort()
	{
		int numberOfProcess=process.length;
		for(int k = 0; k <numberOfProcess; k++){
			   for(int j =0;j < (numberOfProcess-1); j++){
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
	
	/*
	 *  completionTime function is used to find completion time for each process
	 * @return This function  the completion time of each process in list
	 */
	List completionTime()
	{
		List<Integer> completion_time=new ArrayList<Integer>();
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
	 * @return This function returns a list containing waiting time of each process
	 */
    List waitingTime()
	{
        List<Integer> waiting_time=new ArrayList<Integer>();
		waiting_time.add(process[0][0]);
	    for(int i=1 ; i<process.length; i++){
	        if(process[i][0]>process[i-1][1]){
	        	waiting_time.add(0);
	        }
	        else{
	        	waiting_time.add(process[i-1][1]-process[i][0]);
	        }
	    }
	
	    return waiting_time;
	}
	
	/* 
	 * turnaroundTime function is used to find completion time for each process
	 * @return This function returns a list containing turnaround time of each process
	 */
	List turnaroundTime()
	{
		List<Integer> turnaround_time=new ArrayList<Integer>();
		turnaround_time.add(process[0][1]-process[0][0]);
		for(int i=1;i<process.length;i++){
			if(process[i][0]<process[i-1][1]){
				turnaround_time.add((process[i][1]+process[i-1][1])-process[i][0]);
			}
			else{
				turnaround_time.add(process[i][1]);
			}
		}

		return turnaround_time;
	}
	
	
	/* 
	 * averageWaitingTime function is used to find the average waiting time of process
	 * @return average waiting time
	 */
	double averageWaitingTime()
	{
		double totalWaitingTime=0;
		double avg_WaitingTime=0;
		List<Integer> waiting_time=waitingTime();
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
	double maximumWaitingTime()
	{
		int max_WaitingTime=0;
		List<Integer> waiting_time=waitingTime();
		for(int i=0;i<waiting_time.size();i++){
			if(waiting_time.get(i)>max_WaitingTime){
				max_WaitingTime=waiting_time.get(i);
			}
		}
		return max_WaitingTime;
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
			JobScheduler job=new JobScheduler(no_of_process);
		    	 
			List<Integer> completionTimeList=job.completionTime();
			List<Integer> turnaroundTimeList=job.turnaroundTime();
			List<Integer> waitingTimeList=job.waitingTime();
			System.out.println("\nCompletion  TurnAround  Waiting");
			for(int i=0;i<no_of_process;i++)
			{
				System.out.println(completionTimeList.get(i) + "\t    " + turnaroundTimeList.get(i) + "\t\t" + waitingTimeList.get(i));
			}
			System.out.println("Average Waiting Time:"+job.averageWaitingTime());
			System.out.println("Maximum Waiting Time:"+job.maximumWaitingTime());
			input.close();
		}    
	}
	

}
