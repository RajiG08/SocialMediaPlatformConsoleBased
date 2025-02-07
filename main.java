package socialMedia;

import java.util.Scanner;

public class Main {
	 String userName;
	 String email;
	 String userid;
	 String password;
	 public Main(String userid, String userName, String email, String password) {
			super();
			this.userName = userName;
			this.email = email;
			this.userid = userid;
			this.password = password;
	 }
	    public String getUserName() {
			return userName;
		}
		public String getEmail() {
			return email;
		}
		public String getUserid() {
			return userid;
		}
		public String getpassword() {
			return password;
		}
 
	
       public static void main(String[] args) {
    	   System.out.println("------------WELCOME TO INSTAGRAM-------------");
    	   System.out.println();
    	   Management manage = new Management();
    	   Scanner sc = new Scanner(System.in);
    	   
    	   while(true) {
    		  // int logCount=0;
    		   System.out.println("Enter 1 to Signup");
    		   System.out.println("Enter 2 to Login");
    		   System.out.println();
    		   int n = sc.nextInt();
    		   if(n ==1) {
    			   System.out.println("Enter userId");
    			   String userId = sc.next();
    			   System.out.println("Enter userName");
    			   String userName = sc.next();
    			   System.out.println("Enter emailId");
    			   String emailId = sc.next();
    			   System.out.println("Enter Password");
    			   String password = sc.next();
    			   Main main = new Main(userId, userName,emailId, password);
    			   manage.addUser(main);
    		   }
    		   
    		   if(n==2) {
    			   System.out.println("Enter userId");
    			   String userId = sc.next();
    			   System.out.println("Enter Password");
    			   
    			   String password = sc.next();
    			   int a =manage.checkUser(userId,password);
//    			   int b =manage.receiveNotifcation();
//    			   if(b>0) {
//    				   manage.receiveNotifcation();
//    			   }
    		   while(a!=0) {
    			   System.out.println("Enter 3 to Add Friend");
        		   System.out.println("Enter 4 to Remove Friend");
        		   System.out.println("Enter 5 to Show Users");
        		   System.out.println("Enter 6 to Show Following list");
        		   System.out.println("Enter 7 to Send Messages");
        		   System.out.println("Enter 8 to See Messges");
        		   System.out.println("Enter 9 to LogOut");
        		   System.out.println();
        		   int number = sc.nextInt();
        		   
    		   if(number ==3) {
    			   //if(manage.checkUser()==true)
    			   System.out.println("UserList");
    			   Object s[] = manage.map.values().toArray();
    				  for(int i=0;i<s.length;i++) {
    					  System.out.println(s[i].toString());
    				  }
    				  
//    			   String userId1 = sc.next();
    			   System.out.println("Enter the userId to follow");
    			   String targetId = sc.next();
    			   manage.follow(targetId);
    		   }
    		   if(number ==4) {
    			   System.out.println("Following List");
    			   Object s[] = manage.follow.values().toArray();
    				  for(int i=0;i<s.length;i++) {
    					  System.out.println(s[i].toString());
    				  }
// System.out.println("Enter your userId");
//    			   String userId1 = sc.next();
    			   System.out.println("Enter the userId to unfollow");
    			   String targetId = sc.next();
    			   manage.unfollow(targetId);
    		   }
    		   if(number ==5) {
    			   manage.display();
    		   }
    		   if(number ==6) {
    			   System.out.println("Enter your userId");
    			   String userId1 = sc.next();
    			   manage.followList(userId1);
    		   }
    		   if(number ==7) {
    			   System.out.println("users List");
    			   Object s[] = manage.map.values().toArray();
    				  for(int i=0;i<s.length;i++) {
    					  System.out.println(s[i].toString());
    				  }
    			   System.out.println("Enter the userId to Messages");
    			   String targetId = sc.next();
    			   System.out.println("Enter the message");
    			   String msg = sc.next();
    			   manage.sendMessage(targetId, msg);
    		   }
    		   if(number==8) {
    			   //System.out.println("Enter the userId to unfollow");
    			   //String targetId = sc.next();
    			   manage.viewMessages();
    		   }
    		   if(number ==9) {
    			   System.out.println("Logged Out Successfully");
    			   System.out.println();
    			   a=0;
    			   break;
    		   }
    		   }
    		   }
      		   
    	   }
       }
       @Override
       public String toString() {
           return userid;
       }
	
	
//       System.out.print("USER ID      --- "+ entry.getKey());
//	    System.out.print("USER NAME    --- "+ entry.getValue().getUserName());
//	    System.out.print("USER EMAILID --- "+ entry.getValue().getEmail());
//	    System.out.println("------------------------------------------");
	
	}
