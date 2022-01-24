
public class Clock {
    int hrs;
    int mins;
    int secs;

    //initializing constructor
    public Clock(int myHrs, int myMins, int mySecs) {
        hrs=myHrs;
        mins=myMins;
        secs=mySecs;
    }

    //default constructor
    public Clock(){
        hrs=0;
        mins=0;
        secs=0;
    }

    //toString
    public String toString(){
        return(hrs+":"+mins+":"+secs);
    }

    //modifier that resets the time to 0
    public void reset(){
        hrs=0;
        mins=0;
        secs=0;
    }

    //modifier that accepts parameters to set the time to
    public void reset(int hr, int min, int sec){
        hrs=hr;
        mins=min;
        secs=sec;
    }

    //modifier that moves the time forward by 1 second
    public void advance(){
        secs++;
        if(secs==60){
            secs=0;
            mins++;
        }
        if(mins==60){
            mins=0;
            hrs++;
        }
        if(hrs==24){
            hrs=0;
        }
    }
}
