package metody;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class wczytajTabele {

	public static Color[] wczytajKolory(String sciezkaDostepu, List<String> wynikWczytania) throws FileNotFoundException{
		
		Scanner scanner = new Scanner(new File(sciezkaDostepu));
        scanner.useDelimiter("\n");
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> letters = new ArrayList<String>();
        ArrayList<Integer[]> colors = new ArrayList<Integer[]>();
        while(scanner.hasNext()){
        	arrayList.add(scanner.next());
        }
        scanner.close();
        for(String record : arrayList) {
        	Pattern pattern = Pattern.compile("([a-z]);([0-9]*);([0-9]*);([0-9]*)");
        	Matcher matcher = pattern.matcher(record);
        	matcher.find();
        	letters.add(matcher.group(1));
        	Integer[] col = new Integer[3];
        	for(int i = 0; i < 3; i++) {
        		col[i] = Integer.parseInt(matcher.group(i+2));
        	}
        	colors.add(col);
        }
        Color[] kolory = new Color[wynikWczytania.size()];
        int j = 0;
        for(String litera : wynikWczytania) {       	
       	kolory[j] = new Color(colors.get(letters.indexOf(litera.toLowerCase()))[0], colors.get(letters.indexOf(litera.toLowerCase()))[1], colors.get(letters.indexOf(litera.toLowerCase()))[2]);
       	j++;
        }
        return kolory;
	}
	
	
	
}
