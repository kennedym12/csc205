 import java.util.*;
 import java.io.File;
import java.io.FileNotFoundException;
 class TimeShare{
    //class variables
    static int clock = 1;
    static int idle = 0;
    static int usage = 0;
    static Queue input = new Queue();
    static Queue jobs = new Queue();
    static Queue output = new Queue();

    public static void main(String args[])throws FileNotFoundException, CloneNotSupportedException{
        
        try{
        //nest try catch statements so they function properly
          String fileName=args[0];  
          try{
          //get the queue values from a file
            File file = new File(fileName);
            Scanner scanny = new Scanner(file);
            try{
                while(scanny.hasNext()){
                String name  = scanny.next();
                int arrive = scanny.nextInt();
                int run = scanny.nextInt();
                Job nube = new Job(name, arrive, run);
                input.enqueue(nube); 
                }
                scanny.close();
                //run jobs through each queue
                runJobs(); 
                //adjust idle clock so it doesn't include count removal of last job
                idle--;
                //Present information here
                summaryReport(); 
            }
            catch(InputMismatchException exc){
              System.out.println("Please enter a valid .dat file.");
            }
          }
          catch(FileNotFoundException ex){
            System.out.println("Please enter an existing file.");
          } 
        }
        catch(ArrayIndexOutOfBoundsException e){//catch nonexistent input
          System.out.println("Please list the .dat file you'd like to reference for this program.");
        }
        
          
        
        
        
        
        
        //Job front = (Job)input.front();
        //System.out.println(front instanceof Job);
        //System.out.println(front);
        //print(input);

        
         
        
        
    }
    
    public static void runJobs(){
      while(!input.isEmpty() || !jobs.isEmpty()){
            //run until both queues are empty
            if(!input.isEmpty()){
                Job curr = (Job)input.front();
                if(curr.arrivalTime==clock){
                    //move front node of input into jobs queue
                    Node temp = (Node)input.dequeue();
                    jobs.enqueue(temp.getItem());
                }
            }
            if(!jobs.isEmpty()){//ready to debug
                Job curr = (Job)jobs.front();
                if(curr.startTime!=-1 && curr.runTime==clock-curr.startTime){
                    //update turnaround time then remove the front node
                    curr.turnTime = curr.runTime+curr.waitTime;
                    Node temp = (Node)jobs.dequeue();
                    output.enqueue(temp.getItem());
                }
                
            }
            if(!jobs.isEmpty()){
                Job curr = (Job)jobs.front();
                if(curr.startTime==-1 && curr.arrivalTime<=clock){
                    //start the frontmost job
                    curr.startTime = clock;
                    curr.waitTime = clock-curr.arrivalTime;
                }
            }
            if(!jobs.isEmpty()){
                usage++;
            }
            else{
                idle++;
            }
            clock++;
        }
    }

    public static void print(Queue q)throws CloneNotSupportedException{
        if(q.isEmpty()){
            System.out.println("This queue is empty.");
        }
        else{
            System.out.println("~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~~~~");
            System.out.println("job id  arrival start   run     wait    turnaround");
            System.out.println("        time    time    time    time    time ");
            System.out.println("~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~ ~~~~~~~~~~");
            Queue temp = (Queue) q.clone();
            while(!temp.isEmpty()){
              Node curr = (Node)temp.dequeue();
              System.out.println(curr.getItem()); 
            }
        //System.out.println("The values in the "+q+" queue are: ");
                 
        }
    }
    
    public static double avgWaitTime()throws CloneNotSupportedException{ 
      if(output.isEmpty()){
          return 0;
      }
      Queue temp = (Queue)output.clone();
      double avg = 0;
      double total = 0;
      while(!temp.isEmpty()){
          Node curr = (Node)temp.dequeue();
          Job conv = (Job)curr.getItem();
          avg+=conv.waitTime;
          total++;
      }
      return avg/total;
    }

    public static void summaryReport()throws CloneNotSupportedException{
        System.out.println();
        System.out.println("Job Control Analysis: Summary Report");
        print(output);
        System.out.println();
        System.out.println("The average wait time is: "+String.format("%.2f",avgWaitTime())+"s");
        System.out.println("The amount of CPU idle time: "+idle+"s");
        System.out.println("The amount of CPU usage time: "+usage+"s");
        System.out.println("The percentage of CPU usage time: "+String.format("%.2f",(usage*100.0/(usage+idle)))+"%");
        System.out.println();
    }

}
