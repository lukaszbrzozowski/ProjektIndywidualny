package metody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wczytajTekst {
	
public static String readBytesFromFile(File fileToRead) {
		
		if(fileToRead.exists()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(fileToRead);
				int available = fileInputStream.available();
				byte[] readBytes = new byte[available];
				fileInputStream.read(readBytes);		
				String wynik = parseBytes(readBytes);
				fileInputStream.close();
				
				return wynik;
				
			}catch(FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			}catch(IOException ioException) {
				ioException.printStackTrace();
			}
		}
		return "Wystapil blad";
	}
	
private static String parseBytes(byte[] bytesToParse) {
		try {
			String parsedStringInNewEncoding = new String(bytesToParse, "ISO-8859-3");
			return parsedStringInNewEncoding;
		}catch(UnsupportedEncodingException unsupportedEncodingException) {
			unsupportedEncodingException.printStackTrace();
		}
		return "Wystapil blad";
		
	}

public static List<String> podzielTekst(String givenString){
	Pattern pattern = Pattern.compile("[^a-zA-Z]");
	Matcher matcher = pattern.matcher(givenString);
	String[] items = matcher.replaceAll("").split("");
	List<String> itemList = Arrays.asList(items);
	return itemList;
}

public static List<String> wynikWczytania(File input2) {
	return podzielTekst(readBytesFromFile(input2));
}
}
