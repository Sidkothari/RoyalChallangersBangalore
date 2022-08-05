package Tests;
import PageObjects.PayloadRCB;
import io.restassured.path.json.JsonPath;

public class JsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

   //Write a test that validates team has only 4 foreign players
		
		JsonPath js = new JsonPath(PayloadRCB.royalChallangers());
		
		int count =js.get("player.size()");
		
		for(int i=0;i<count;i++) {
			
			String names=js.get("player["+i+"].name");
			
			String countries=js.get("player["+i+"].country");
			
			if(!countries.equalsIgnoreCase("India")) {
				
			    System.out.println(names);
				System.out.println(countries);
			}
		}
		
	//Write a test that validates that their is at least one wicket-keeper	
		
        for(int i=0;i<count;i++) {
			
			String roles=js.get("player["+i+"].role");
    
			boolean isWicketKeeper=false;
		if	(roles.equalsIgnoreCase("wicket-keeper")) {
			
			isWicketKeeper =true;
			
			}
		if(isWicketKeeper) {
			
			System.out.println("Wicket-Keeper is present");
		}
		
	}
		
		
	}
	
}
