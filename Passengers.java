import java.util.*;
class Passengers
{
    public String name;
    public byte age;
    public  int Train_no;
    public int Ticket_id;
    public  int seats;
    public String Train_name;
    public String From,To;
  
   void input()
  { 
    Scanner sc=new Scanner(System.in);
     System.out.println("Enter your name");
     name=sc.next();
     System.out.println("Enter your age");
     age=sc.nextByte();
     System.out.println("Enter number of seats you required");
     seats=sc.nextInt();
    
  }
      
}

class Main
{
  public static void main(String args[]) 
  {
    int ticket_counter=101;
    Passengers p1 = new Passengers();
    Scanner sc = new Scanner(System.in);
    List<Passengers> l =new ArrayList<>();

    
    HashMap<String, Object> obj = new HashMap<>();
    obj.put("Train_name", "GODAVARI EXPRESS");
    obj.put("Train_no", 12727);
    obj.put("Total_seats", 100);
    obj.put("Avail_seats", 15);
    obj.put("From","VISHAKAPTNAM");
    obj.put("To","HYDERABD");
    
    
    HashMap<String, Object> obj2 = new HashMap<>();
    obj2.put("Train_name", "ANDHRA PRADESH EXPRESS");
    obj2.put("Train_no", 20805);
    obj2.put("Total_seats", 600);
    obj2.put("Avail_seats", 6);
    obj2.put("From","VISHAKAPTNAM");
    obj2.put("To","NEW DELHI");
    
    
     System.out.println("-----RAILWAY RESERVATION SYSTEM --");
      System.out.println("1.VIEW AVAILABLE TRAIN DETAILS ");
      System.out.println("2.BOOK TICKETS ");
      System.out.println("3.CANCEL TICKETS ");
      System.out.println("4.VIEW RESERVATION STATUS ");
      System.out.println("5.EXIT");

    while (true)
    {
      
      System.out.println("ENTER YOUR CHOICE ");
      byte ch = sc.nextByte();

      switch (ch)
      {
        case 1:
          System.out.println();
          System.out.println("     " + obj.get("Train_name"));
          System.out.println("TRAIN NO :  " + obj.get("Train_no"));
          System.out.println("TOTAL SEATS :    " + obj.get("Total_seats"));
          System.out.println("AVAILABLE SEATS :    " + obj.get("Avail_seats"));
          System.out.println("From : "+obj.get("From"));
          System.out.println("To : "+obj.get("To"));
          System.out.println();

          System.out.println("     " + obj2.get("Train_name"));
          System.out.println("TRAIN NO :  " + obj2.get("Train_no"));
          System.out.println("TOTAL SEATS :    " + obj2.get("Total_seats"));
          System.out.println("AVAILABLE SEATS :    " + obj2.get("Avail_seats"));
          System.out.println("From :  "+obj2.get("From"));
          System.out.println("To : "+obj2.get("To"));
          System.out.println();
          break;

        case 2:
          System.out.println();
          System.out.println("Enter Train number");
          int a = sc.nextInt();
          if (obj.get("Train_no").equals(a) )
          {
            System.out.println("Train found. Proceeding with booking...");
            System.out.println();
            p1.input();
            int available= (int)obj.get("Avail_seats");
            if(p1.seats<=available)
            {
              obj.put("Avail_seats",available-p1.seats);//it will modify the available seats in the list
              System.out.println("Your Reseravtion is Successfully Completed ");
              System.out.println();
              p1.Ticket_id = ticket_counter;
              p1.Train_no= a;
              p1.Train_name= (String)obj.get("Train_name");
              p1.From=(String)obj.get("From");
              p1.To=(String)obj.get("To");
              System.out.println("Ticket ID :  TKD"+(ticket_counter++));
              System.out.println("Train name :   "+(obj.get("Train_name")));
              System.out.println("TRAIN NO :    " + obj.get("Train_no"));
              System.out.println("From : "+obj.get("From"));
              System.out.println("To : "+obj.get("To"));
              System.out.print("Passenger :  "+(p1.name));
              System.out.println("("+p1.age+")");
              System.out.println("Tickets  "+p1.seats);
              System.out.println();
              
              l.add(p1);          /*this is to store the passengers data,
                                     by storing this they can able to
                                         view their details in future */
                p1= new Passengers();//to reset the class object
              
            }
            else
            {
              System.out.println("Seats are unavailable");
            }
            
          }
        else if(obj2.get("Train_no").equals(a))
        {
            System.out.println("Train found. Proceeding with booking...");
            System.out.println();
            p1.input();
            int available2= (int)obj2.get("Avail_seats");// it store current available seats
            if(p1.seats<=available2)
            { 
             obj2.put("Avail_seats",available2-p1.seats);
              System.out.println();
              System.out.println("Your Reseravtion is Successfully Completed ");
              p1.Ticket_id = ticket_counter;//assign the ticketid into the class property
              p1.Train_no=a;
              p1.Train_name= (String)obj2.get("Train_name");//assign the train name into the class property
              p1.From=(String)obj2.get("From");
              p1.To=(String)obj2.get("To");
              System.out.println("Ticket ID :   TKD"+(ticket_counter++));
              System.out.println("Train name :  "+(obj2.get("Train_name")));
              System.out.println("TRAIN NO :    " + obj2.get("Train_no"));
              System.out.println("From :  "+obj2.get("From"));
              System.out.println("To : "+obj2.get("To"));
              System.out.print("Passenger :   "+(p1.name));
              System.out.println("("+p1.age+")");
              System.out.println("Tickets   "+p1.seats);
              System.out.println();
              
              l.add(p1);/*this is to store the passengers data,
                             by storing this they can able to
                           view their details in future */
              p1=new Passengers();//to reset the class object
            }
            else
            {
              System.out.println("Seats are unavailable");
            }
         }
        else
        {
            System.out.println("Invalid Train number or Train Not Available");
        }
          break;
        
        case 3:
         System.out.println("Enter TICKET ID to Cancel rservation");
         int cancel_id= sc.nextInt();
         boolean found = false;
        for (int i = 0; i < l.size(); i++) 
          {
              if (l.get(i).Ticket_id ==cancel_id)//checks the entered id in the list
              {
                l.remove(i);
                System.out.println("Cancellation is successful");
                found = true;
                break;
              }
          }

           if (!found)
           {
             System.out.println("Invalid ticket id");
           }
           break;
        case 4:
        
        System.out.println();
        System.out.println("Enter ticket id to see Status ");
        int status_id = sc.nextInt();
        boolean found1 = false;
        for(int j=0;j<l.size();j++)
        {
          if(l.get(j).Ticket_id==status_id)
          {  
              found1= true;
              System.out.println("Ticket ID :  TKD"+(l.get(j).Ticket_id));
              System.out.println("Train name :   "+(l.get(j).Train_name));
              System.out.println("TRAIN NO :    " + (l.get(j).Train_no));
              System.out.println("From :   "+(l.get(j).From));
              System.out.println("To : "+(l.get(j).To));
              System.out.print("Passenger :  "+(l.get(j).name));
              System.out.println("("+l.get(j).age+")");
              System.out.println("Tickets  "+l.get(j).seats);
              System.out.println();
              break;
              
          }
        }
        if (!found1)
        {
             System.out.println("Invalid ticket id");
        }
           break;
        
        case 5:
        
          System.out.println("Exiting from the system");
          System.exit(0);
          break;
        
      }
    }
  }
}