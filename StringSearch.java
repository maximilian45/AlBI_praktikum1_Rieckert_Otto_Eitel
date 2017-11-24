import java.util.*;


class StringSearch {
	
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte geben sie das zu durchsuchende Genom ein. Gross- und Kleinbuchstaben NICHT mischen!");
		String input =scan.next();
		System.out.println("Bitte geben sie die groesse der zu findenen K-Mere ein.");
		int k = scan.nextInt();
		System.out.println("");
		frequentWords(input,k);
		System.out.println("");
		fasterFrequentWords(input,k);
		System.out.println("");
		findingFrequentWordsBySorting(input,k);
		
		//Konsolenversion
		/*frequentWords(args[0], Integer.parseInt(args[1]));
		System.out.println("");
		fasterFrequentWords(args[0], Integer.parseInt(args[1]));
		System.out.println("");
		findingFrequentWordsBySorting(args[0], Integer.parseInt(args[1]));
		*/
	}

	public static int patternCount(String text, String pattern){
		//Durchsuchendes Textes und zählen wie oft das übergebene Pattern im Text auftaucht. Dieser Wert wird zurück gegeben.
		int count = 0;
		for(int i = 0; i < text.length()-pattern.length(); i++){
			String temp = "";
			for(int j = 0; j < pattern.length(); j++){
				temp += text.charAt(i+j);
			}

			if(temp.equals(pattern)){
				count++;
			}
		}
		return count;
	}
	
	public static void frequentWords(String text, int k){
		//Implementireung des FrequentWords-Algorythmus
		List<String> frequentPatterns = new ArrayList<String>();
		int[] count = new int[text.length()-k];
		int maxCount = 0;
		//Bilden aller möglichen k-mere und zählen wie oft sie im text auftauchen
		for(int i = 0; i < text.length()-k ; i++){
			String pattern = "";
			for(int j = 0; j<k ; j++){
				pattern += text.charAt(i+j);
			}
			count[i] = patternCount(text, pattern);
			
		}
		//Ermitteln wie oft das meist aufgetauchte Pattern auftauchte
		for(int i = 0; i < count.length; i++){
			if(count[i] > maxCount){
				maxCount = count[i];
			}
		}
		//abspeichern der meist gefundenen Pattern
		for(int i = 0; i < text.length()-k; i++){
			if(count[i] == maxCount){
				String pattern = "";
				for(int j = 0; j<k ; j++){
					pattern += text.charAt(i+j);
				}
				frequentPatterns.add(pattern);
			}
		}
		//Entfernen von dublikaten
		for(int i = 1; i < frequentPatterns.size(); i++){
			for(int j = 0; j < i; j++){
				if(frequentPatterns.get(i).equals(frequentPatterns.get(j))){
					frequentPatterns.remove(i);
					i--;
				}
			}
		}
		//Ausgabe der Pattern
		for(int i = 0; i<frequentPatterns.size(); i++){
			System.out.println(frequentPatterns.get(i));
		}
		
	}
	
	public static int[] computingFrequencies(String text, int k){
		//Funktion zum abspeichern der auftauchenden Pattern als Zahlen
		int[] frequencyArray = new int[square(4,k)];
		for(int i = 0; i < square(4,k)-1; i++ ){
			frequencyArray[i] = 0;
		}
		
		for(int i = 0; i < text.length()-k; i++){
			String pattern = "";
			for(int j = 0; j<k ; j++){
				pattern += text.charAt(i+j);
			}
			int j = patternToNumber(pattern);
			frequencyArray[j] = frequencyArray[j]+1;
		}
		return frequencyArray;
	}
	
	public static void fasterFrequentWords(String text, int k){
		//Funktion, die die Pattern findet, indem sie sie als Zahlen in einem Array zwischen speichert
		List<String> frequentPatterns = new ArrayList<String>();
		int[] frequencyArray = computingFrequencies(text, k);
		int maxCount = 0;
		
		
		//Ermitteln wie oft das meist aufgetauchte Pattern auftauchte
		for(int i = 0; i < frequencyArray.length; i++){
			if(frequencyArray[i] > maxCount){
				maxCount = frequencyArray[i];
			}
		}
		//Ermitteln welche Pattern zu den meist auftauchenden gehören
		for(int i = 0; i < square(4,k)-1; i++){
			if(frequencyArray[i] == maxCount){
				String pattern = numberToPattern(i,k);
				frequentPatterns.add(pattern);
			}
		}
		//Entfernen von Doppelung
		for(int i = 1; i < frequentPatterns.size(); i++){
			for(int j = 0; j < i; j++){
				if(frequentPatterns.get(i).equals(frequentPatterns.get(j))){
					frequentPatterns.remove(i);		
					i--;
				}
			}
		}
		//Ausgabe
		for(int i = 0; i<frequentPatterns.size(); i++){
			System.out.println(frequentPatterns.get(i));
		}
		
	}
	
	public static void findingFrequentWordsBySorting(String text, int k){
		//Algorythmus, der den Pattern zahlenwerte Zuweist und sortiert um so die häufigsten Pattern zu finden
		List<String> frequentPatterns = new ArrayList<String>();
		int[] index = new int[text.length()-k];
		int[] count = new int[text.length()-k];
		int maxCount = 0;
		
		//finden aller möglichen k-mere
		for(int i = 0; i < text.length()-k ; i++){
			String pattern = "";
			for(int j = 0; j<k ; j++){
				pattern += text.charAt(i+j);
			}
			//umwandlung in zahlen und Sortierung
			index[i] = patternToNumber(pattern);
			count[i] = 1;
		}
		Arrays.sort(index);
		//Finden von doppelten k-meren
		for(int i = 1; i < text.length()-k; i++){
			if(index[i] == index[i-1]){
				count[i] = count[i-1]+1;
			}
		}
		//Ermitteln des maximalwertes
		for(int i = 0; i < count.length; i++){
			if(count[i] > maxCount){
				maxCount = count[i];
			}
		}
		//Finden des häufigsten pattern und dessen Umwandlung in Zahlen
		for(int i = 1; i < text.length()-k; i++){
			if(count[i] == maxCount){
				String pattern = numberToPattern(index[i],k);
				frequentPatterns.add(pattern);
			}
		}
		//Entfernen von Doppelung
		for(int i = 1; i < frequentPatterns.size(); i++){
			for(int j = 0; j < i; j++){
				if(frequentPatterns.get(i).equals(frequentPatterns.get(j))){
					frequentPatterns.remove(i);		
					i--;
				}
			}
		}
		//Ausgabe
		for(int i = 0; i<frequentPatterns.size(); i++){
			System.out.println(frequentPatterns.get(i));
		}
		
	}
	
	public static int square(int number, int exponent){
		if(exponent == 0) return 1;
		return number*square(number,exponent-1);
	}
	
	public static int patternToNumber(String pattern){
		//umwandlung des patterns in eine Zahl der Basis 4
		if(pattern == ""){
			return 0;
		} 
		char symbol = pattern.charAt((pattern.length()-1));
		String prefix = "";
		
		for(int i = 0; i <= (pattern.length()-2);i++){
			prefix += pattern.charAt(i);
		}
		return (4*patternToNumber(prefix) + symbolToNumber(symbol));
	}
	
	public static int symbolToNumber(char symbol){
		//Umwandlung eines Buchstaben in eine Zahl
		switch (symbol){
			case 'A': return 0;
			case 'C': return 1;
			case 'G': return 2; 
			case 'T': return 3;
			case 'a': return 0;
			case 'c': return 1;
			case 'g': return 2;
			case 't': return 3;
			default: System.out.println("Fehlerhafte Eingabe!!!");
		}
		return -1;
	}
	
	public static String numberToPattern(int index,int k){
		//Rueckwandlung des Patterns aus einer Zahl in ein String
		if (k==1){
			return ""+numberToSymbol(index);
		}
		int r = (index%4);
		int prefixIndex = (index - r)/4;
		char symbol = numberToSymbol(r);
		String prefixPattern = numberToPattern(prefixIndex, k-1);
		return prefixPattern + symbol;
		}
		
	public static char numberToSymbol(int number){
		//Rueckwandlung von einer Zhal in ein Buchstaben
		switch(number){
			case 0: return 'A';
			case 1: return 'C';
			case 2: return 'G';
			case 3: return 'T';
			default: return 'E';
		}
	}	

	
}