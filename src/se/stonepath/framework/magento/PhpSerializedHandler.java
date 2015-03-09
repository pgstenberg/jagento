package se.stonepath.framework.magento;

import org.lorecraft.phparser.SerializedPhpParser;

public class PhpSerializedHandler {

	
	public static Object deserialize(String input){
		SerializedPhpParser serializedPhpParser = new SerializedPhpParser(input);
		return serializedPhpParser.parse();
	}
	
	
}
