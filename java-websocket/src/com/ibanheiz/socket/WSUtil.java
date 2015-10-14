package com.ibanheiz.socket;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class WSUtil {

	public static String getJsonFromUser(User user) throws JAXBException,
			JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
		mapper.setAnnotationIntrospector(introspector);
		String jsonData = mapper.writeValueAsString(user);
		return jsonData;
	}

	public static User getUserFromJson(String jsonData) throws JAXBException,
			JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
		mapper.setAnnotationIntrospector(introspector);
		User user = mapper.readValue(jsonData, User.class);
		return user;
	}

}
