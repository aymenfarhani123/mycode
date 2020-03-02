package com.example;
import static java.lang.System.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class StringToBase64 {

	public static void main(String[] args) {
		String normalString="Aymen Farhani";
		String encodedString="QXltZW4gRmFyaGFuaQ==";
		encodedStringBase64(normalString);
		decodedString(encodedString);
	}
	
	private static String encodedStringBase64(String normalString) {
		Base64.Encoder encoder=Base64.getEncoder();
		
		String encodedString=encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		out.println(encodedString);
		return encodedString;
	}
	
	private static String decodedString(String encodedString) {
		Base64.Decoder decoder=Base64.getDecoder();
		
		byte[] decodedByteArray=decoder.decode(encodedString);
		out.println(new String(decodedByteArray));
		return decodedByteArray.toString();
	}

}
