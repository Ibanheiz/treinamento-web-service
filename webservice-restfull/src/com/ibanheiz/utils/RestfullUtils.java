package com.ibanheiz.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

public class RestfullUtils {
	public static void preencherReferenciaNasListas(Object objetoPai) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> noparams[] = {};
		Class<?> classe = objetoPai.getClass();
		
		for (Field atributosDoObjetoPai : classe.getDeclaredFields()) {
			XmlSetReferences xmlSetReference = atributosDoObjetoPai.getAnnotation(XmlSetReferences.class);
			
			if (xmlSetReference != null) {
				Method methodGet = classe.getMethod(xmlSetReference.getter(), noparams);
				Collection<?> lista = (Collection<?>) methodGet.invoke(objetoPai); 
				
				for (Object objeto : lista) {
					Class<?> objetoAlvo = objeto.getClass();
					Method method = objetoAlvo.getMethod("set" + objetoPai.getClass().getSimpleName(), objetoPai.getClass());
					method.invoke(objeto, objetoPai);
				}
			}
		}
	}
}
