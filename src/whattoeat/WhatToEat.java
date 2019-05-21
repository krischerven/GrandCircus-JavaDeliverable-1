package whattoeat;
import java.util.Scanner;

public class WhatToEat {
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter event type (casual, semi-formal, formal):");
	    
	    var eventType = s.nextLine();
	    while (!eventType.equals("casual") && !eventType.equals("semi-formal") && !eventType.equals("formal")) {
	    	System.out.println("Invalid event type, please try again:");
	    	eventType = s.nextLine();
	    }

	    System.out.println("You have selected " + eventType + " as your event type.");
	    System.out.println("Enter party size:");

	    var partySize = 0;
	    try {
	    	var tmp = s.nextLine();
	    	s.close(); // do this here so if we error in the line below it still gets closed
	    	partySize = Integer.parseInt(tmp);
	    	if (partySize > 0) {
	    		 System.out.println("You have selected " + partySize + " as your party size.");
	    	} else {
	    		throw new Exception();
	    	}
	    } catch (Exception e) {
	    	System.out.println("Invalid party size, defaulting to 1...");
	    	partySize = 1;
	    }

	    var sugg1 = "";
	    var sugg2 = "";
	    var ERROR = "";
	    var result = "";

	    switch (eventType) {
	    	case "casual": {
    			sugg1 = "sandwiches";
	    		break;
	    	}
	    	case "semi-formal": {
	    		sugg1 = "fried chicken";
	    		break;
	    	}
	    	case "formal": {
	    		sugg1 = "chicken parmesan";
	    		break;
	    	}
	    	// won't happen anymore due to sanity check above
	    	default: {
	    		ERROR += "ERROR: eventType was not one of the available options";
	    	}
	    }

	    if (partySize == 1) {
			sugg2 = "in the microwave";
	    } else if (partySize > 1 && partySize < 13) {
			sugg2 = "in your kitchen";
	    } else if (partySize >= 13) {
			sugg2 = "by a caterer";
	    } else {
	    	if (!ERROR.equals("")) {
	    		ERROR += "\n";
	    	}
	    	// won't happen anymore due to sanity check above
	    	ERROR += "ERROR: partySize was <= 0";
	    }

	    result = ERROR;
	    if (result.equals("")) {
		    result = "Since you're hosting a " + eventType + " event" + " for " + partySize + " participants, " + 
		    		"you should serve " + sugg1 + " prepared " + sugg2 + ".";
	    }
	    
	    System.out.println(result);
	}
}