class Pez{

  public static void main(String[] args) throws CloneNotSupportedException
  {
   Stack container = new Stack(); 
   addPez(container);
   System.out.println("Now printing the original pez container:");
   print(container);
   removeGreen(container);
   System.out.println("Now printing without green");
   print(container);

  }

  public static void addPez(Stack container)
  {
    
     container.push("yellow");
     container.push("red");
     container.push("green");
     container.push("green");
     container.push("yellow");
     container.push("yellow");
     container.push("red");
     container.push("green");

  }

  /*public static void removeGreen(Stack container)throws CloneNotSupportedException
  {
    Stack temp = (Stack) container.clone();
    



  }v*/

  public static void reverse(Stack container) throws CloneNotSupportedException
  {
    Stack temp = (Stack) container.clone();
    while(!container.isEmpty())
    {
	temp.push(container.pop());
    }
    while(!temp.isEmpty())
    {
	container.push(temp.pop());
    }

  }

  public static void print(Stack container) throws CloneNotSupportedException
  {
    Stack temp = (Stack)container.clone();
    
    while(!temp.isEmpty())
    {
	System.out.println(temp.pop());
    }

  }

  public static void removeGreen(Stack container)
  {
    Stack temp = new Stack();
    while(!container.isEmpty())
    {
      String curr=(String)container.pop();
      if(!curr.equals("green"))
      {
        temp.push(curr);
      }
    }
    while(!temp.isEmpty())
    {
      container.push(temp.pop());
    }
  }

}
