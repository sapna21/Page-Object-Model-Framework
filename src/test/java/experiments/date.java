package experiments;

import java.util.Date;

public class date {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		//System.out.println(date.toString().replace(" ", "_").replace(":", "_"));
		
		//date.toString().replace(" ", "_").replace(":", "_") OR BELOW 
		
		String dateText = date.toString();
		String dateTextWithoutSpaces = dateText.replace(" ", "_");
		String dateTextWithoutSpacesAndColon = dateTextWithoutSpaces.replace(":", "_");
		System.out.println(dateTextWithoutSpacesAndColon);
	}

	//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   - token for git repo
}
