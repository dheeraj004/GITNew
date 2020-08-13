package resourses;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuilder {
	
	public static AddPlace addPlacePayload(String name, String language, String address)
	{
		AddPlace ad=new AddPlace();
		ad.setAccuracy(50);
		ad.setName(name);
		ad.setPhone_number("(+91) 983 893 3937");
		ad.setAddress(address);
		ad.setWebsite("http://google.com");
		ad.setLanguage(language);
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ad.setLocation(l);
		List<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		ad.setTypes(list);
		
		return ad;
	}
	
	public static String deleteAPIPayload(String place_id)
	{
		return  "{\r\n\"place_id\": \""+place_id+"\"\r\n}";
	}

}
