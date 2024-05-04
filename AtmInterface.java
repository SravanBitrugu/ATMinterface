import java.util.*;
class BankAccount{
    Scanner sc=new Scanner(System.in);
    String name;
    String userName;
    String password;
    String accountNum;
    String reciever;
    Float balance=1000f;
    float amount;
    String history;
    int transactions=0;
    String transhistory=" ";
    public void signUp(){
        System.out.println("Enter your name :");
        name=sc.nextLine();
        System.out.println(" Enter your UserName :");
        userName=sc.nextLine();
        System.out.println("Enter your password :");
        password=sc.nextLine();
        System.out.println("Enter your account number:");
        accountNum=sc.nextLine();
        System.out.println("********Registration is sucessfully completed.login into your account*******");
        System.out.println();

    }
    public boolean signIn(){
        boolean signin=false;
        while(!signin){
            System.out.println("Enter your UserName:");
            String  username=sc.nextLine();
            if(username.equals(userName)){
            while(!signin){
                System.out.println("Enter your password:");
                String passWord=sc.nextLine();
                if(passWord.equals(password)){
                    System.out.println("*******YOUR LOGIN IS SUCCESSFULL********");
                    System.out.println();
                    signin=true;
                }
                else{
                    System.out.println("password is incorrect .please enter correct password");

                }

            }
           }
           else{
            System.out.println("username is not present  .please enter a valid username");
            signin=false;
        }
    
       }
         return signin;
       
    }
    public void withdrawl(){
       System.out.println("Enter amount to withdrawn: ");
       amount=sc.nextFloat();
       try{
          if(amount <= balance){
              transactions+=1;
              balance-=amount;
              System.out.println(amount +" rs is sucessfully withdrawn");
              System.out.println();

              history=amount+" RS withdrawn \n" ;
              transhistory=transhistory.concat(history);
        }
          else{
            System.out.println(" Insufficent balance in your account .please check the available balance and then withdraw an amount");

        }
     }
     catch(Exception e){
        System.out.println(" error is occured ");

     }

    }
    public void deposit(){
        System.out.println("Enter amount to  be Deposited: ");
        amount=sc.nextFloat();
     try{
        if(amount <= 10000f){
            transactions+=1;
            balance+=amount;
            System.out.println(amount +" rs is sucessfully deposited");
            System.out.println();

            history=amount+" RS deposited \n" ;
            transhistory=transhistory.concat(history);

        }
        else{
            System.out.println(" the deposited amount limit is 10000 .your amount is exceeding the limit. please once check your depositing amount");

        }
     }
     catch(Exception e){
        System.out.println(" error is occured ");

     }
    }
    public void transferMoney(){
         System.out.println(" \n enter reciver name:");
         reciever=sc.nextLine();

         sc.nextLine();
         System.out.println("\n Enter amount to  be transfer: ");

         amount=sc.nextFloat();
     try{
        if(amount<=balance){
        if(amount <= 50000f){
            transactions+=1;
            balance-=amount;
            System.out.println( amount+"   is sucessfully transferred to   "+reciever);
            history=amount+" RS transfered  to " + reciever+"\n";
            transhistory=transhistory.concat(history);

        }
        else{
            System.out.println(" the transferred amount limit is 50000 .your amount is exceeding the limit. please once check your transfering amount");

        }
     }
     else{
        System.out.println("Insufficent balance in your account .please check the available balance and then transfer a amount");
        
    }
    }
     catch(Exception e){
        System.out.println(" error is occured ");

     }  
    }
    public void checkBalance(){
        System.out.println(balance+"RS");
        System.out.println();

    }
    public void transactionHistory(){
        if(transactions==0){
            System.out.println("transactions are empty");
            System.out.println();

        }
        else{
            System.out.println("\n transaction history \n"+transhistory);
            System.out.println();

        }

    }
 

}

public class AtmInterface {
 
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        BankAccount b=new BankAccount();
        System.out.println(" Welcome to ATM INTERFACE");
        boolean finishSignup=false;
        while(!finishSignup){
        System.out.println("1.Register");
        System.out.println("2.Exit");
        System.out.println("Enter your choice");
        int c=sc.nextInt();
        switch(c){
            case 1:b.signUp();
                  finishSignup=true;
                  break;
            case 2:
                    finishSignup=true;
                    System.exit(0);
                    break;
            default:System.out.println("enter correct choice");
                    finishSignup=false;
                    break;
        }
    }
        boolean finishSignin=false;
        while(!finishSignin){
 
        System.out.println("1.signin");
        System.out.println("2.Exit");
        System.out.println("Enter your choice");
        int d=sc.nextInt();
        switch(d){
            case 1:b.signIn();
                   System.out.println("welcome back "+b.name);
                    boolean flag=false;
                    while(!flag){
                    System.out.println("3.withdrawn " );
                    System.out.println("4.deposit ");
                    System.out.println("5.Transfer");
                    System.out.println("6.check balance");
                    System.out.println("7.Transaction history");
                    System.out.println("8.exit ");
                    System.out.println("Enter your choice");
                    int e=sc.nextInt();
                    switch(e){
            case 3:b.withdrawl();
                   break;
            case 4:b.deposit();
                   break; 
            case 5:b.transferMoney();
                   break;
            case 6:b.checkBalance();
                   break;
            case 7:b.transactionHistory();
                  break;
            case 8:flag=true;
                  System.exit(0);
                  break;
            default:System.out.println("enter correct choice");
                    break;
        }
    }
         finishSignin=true;
         break;
        case 2:finishSignin=true;
               System.exit(0);
               break;
        default:System.out.println("enter correct choice");
                finishSignin=false;
                break;
        }
  }
    sc.close();
}
}
