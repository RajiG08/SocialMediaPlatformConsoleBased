package socialMedia;
 
import java.util.*;
 
public class Management {
	int logCount=0;
	 int receiveCount=0;
	String cuserId ="";
    Map<String, Main> map = new HashMap<>();
    Map<String, Set<String>> follow = new HashMap<>();
    Map<String, ArrayList<String>> message = new HashMap<>();
    int count=0;
	public void addUser(Main m) {
		if(map.containsKey(m.userid)) {
			System.out.println("UserId already exists!");
			System.out.println("Please select different userid");
			System.out.println("OR Please Login to Continue with continue in same userid");
			 System.out.println();
		}
		else {
		map.put(m.getUserid(), m);	
		System.out.println("Signed up successfully");
		   System.out.println("Please Login to continue");
		   System.out.println();
		}
	}
	public int checkUser(String userId, String password) {
		if(map.isEmpty()) {
				System.out.println("Please do signup first");
				System.out.println();
			
		}else if(!map.containsKey(userId)) {
			System.out.println("Invalid User Id");
			System.out.println();
		}
		else if(map.containsKey(userId)){
			Main user = map.get(userId);
			if(!user.getpassword().equals(password)){
			System.out.println("Invalid Password");
			System.out.println();
		}else {
			Main user1 = map.get(userId);
			if(user1.getpassword().equals(password)){
				System.out.println("Logged In successfully");
				System.out.println();
				cuserId = user1.getUserid();
				count =1;
				logCount=1;
				//return logCount;
				int b = notifcationCount();
				if(b>0) {
					if(b==1) {
						System.out.println("You got "+b+" new message");
					}
					else
					System.out.println("You got "+b+" new messages");
				}
			}
		}	
		}
		return logCount;
		
		}
	
	public void follow(String targetId) {
		if(logCount==1) {  
			//Main user1 = map.get(userId);
		if(!map.containsKey(targetId)) {
			System.out.println("Invalid User Id");
			System.out.println();
		}else if(map.containsKey(targetId)){
		follow.putIfAbsent(cuserId, new HashSet<>());
        
        if(targetId.equals(cuserId)) {
        	System.out.println("You can't follow you");
        	System.out.println("Please select other to follow");
        }
        else if(!targetId.equals(cuserId)) {
        	if(follow.get(cuserId).contains(targetId)) {
        		System.out.println("You are already following:" +targetId);
        	}
        	else {
        		follow.get(cuserId).add(targetId);
        		System.out.println("You are now following user with ID: " + targetId);
                System.out.println();
        	}
        }  
}
		else {
			System.out.println("Please do login first");
			System.out.println();
		}
		}
		
	}
	public void unfollow(String targetId) {
		if(logCount==1){
		if(cuserId.equals(targetId)) {
	        	System.out.println("You can't unfollow you");
	        	System.out.println("Please select other to unfollow");
	       }
		if(!map.containsKey(targetId)) {
			//if(!map.containsKey(cuserId)){
			System.out.println("User not found, Please select user from following list");
			//}
		}
		else if(follow.get(cuserId).contains(targetId)){
			follow.get(cuserId).remove(targetId);
			System.out.println("You have unfollowed " + targetId);
          	}
			else if(!follow.get(cuserId).contains(targetId)) {
			System.out.println("You are not following "+targetId);
		   }
		}
		else{
				System.out.println("Please do login first");
			}
		}
	
	public void display() {
//		map.put(m.userid, m);
		if(map.isEmpty()) {
			System.out.println("NO USERS EXIST");
			System.out.println();
			
		}
		else {
			System.out.println("-------------USERS LIST-------------------");
		for(Map.Entry<String, Main> entry : map.entrySet()) {
		//System.out.println("USER ID --- "+entry.getKey()+" "+"USER NAME --- "+entry.getValue().getUserName()+" "+"USER EMAILID --- "+entry.getValue().getEmail()+" ");
			System.out.print("USER ID--- "+entry.getKey());
	        System.out.print("USER NAME--- "+entry.getValue().getUserName());
	        System.out.print("USER EMAILID--- "+entry.getValue().getEmail());
	        System.out.println("------------------------------------------");
	        System.out.println();
		}
		}
	}
    	public void followList(String userId) {
    		if(follow.isEmpty()) {
    				System.out.println("Your not following anybody");
    				System.out.println();
    		}
    		else if(follow.containsKey(userId)) {
			  System.out.println("your follow list");
			  Object s[] = follow.values().toArray();
			  for(int i=0;i<s.length;i++) {
				  System.out.println(s[i]);
				  
			  }
			  System.out.println();
			  
		  }
		
	}
		public void sendMessage(String targetId, String messages) {
			if(logCount==1){
				if(cuserId.equals(targetId)) {
			        	System.out.println("You can't send messges to you");
			        	System.out.println();
			       }
				 else {
					message.putIfAbsent(targetId, new ArrayList<>());
					message.get(targetId).add(cuserId.concat(" MESSAGE:--"+messages));
	        		System.out.println("Message Sent to" + targetId);
	                System.out.println();
					
				}
			}
				else{
						System.out.println("Please select valid user");
					}
				
 
			
		}
		public int notifcationCount() {
			
			if(logCount==1) {
			if(!message.containsKey(cuserId)) {
				//System.out.println("You dont have any messages");
				System.out.println();
		     }else {  
			receiveCount = message.get(cuserId).size();
			}
			}
			return receiveCount;
		}
		public void viewMessages() {
			if(logCount==1) {
				if(!message.containsKey(cuserId)) {
					//System.out.println("You dont have any messages");
					System.out.println();
			}else {  
				  receiveCount+=1;
				  ArrayList<String> userMessages = message.get(cuserId);
		            for (String msg : userMessages) {
		                System.out.println(msg);
		            }
				  System.out.println();
				  }
				}
		}
		
}
 

