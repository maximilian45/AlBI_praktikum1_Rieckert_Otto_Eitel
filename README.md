README!

-------------------------------------------

Pragrammausführung:
Die JAVA-Datei muss lediglich Kompiliert und ausgeführt werden (bspw. über die Kommandozeile oder mit einer IDE wie "Eclipse") und erfordert daraufhin einen Eingabe-String, sprich die zu untersuchende Sequenz.
Im Anschluss fragt das Programm nach der Länge der k-mere, einem uInt, und zeigt die Ergebnisse für jeden einzelnen Algorithmus untereinander an. 

-------------------------------------------

Die von uns beutzten Sequenzen der geforderten Organismen rund um den Origin of Replication:

//Kann per per copy&paste als Input verwendet werden. 
Vibrio Cholerae:
tgtcgatgcgcccagtttcgagcaggccaagcaaaccggagaagttcgcagtaacaaactcgaccttataatcattacgtttaccaatttcattccacacatccacttcaaagccttgcagctcgtcttgtttcacgaaggtgaaggggaaataacggcccgacatgccgactttcacctcggtagctgcctgaacggtggcagaagaaagggctagggcagccagagcgatgttaaaccagtgtttcattgtgtgactcctgtataatttatgtttatatcctactggcaattaaatcattaaaagaaataaccagtagttattaacaataactgatcaaaatcaaaaacatggggataactactaaagatcttgagatatgtggatctttatgtgggtagcacgggcaaaatgtgtgaggatcttagttatcggtcgaaaaataatgtgaataacttagatcttattcactggatcgacgatccagcgctggcgatctgagttatcaacaggtagaattgttcctctttaccgatcgttgatttttgagtgagggaatcgtgtcatcttcgctatggttgcaatgtttgcaacggcttcaggaagagctacctgccgcagaattcagtatgtgggtgcgtccgcttcaagcggagctcaatgacaatactctcactttattcgccccgaaccgctttgtgttggattgggtacgcgataagtacctcaataacatcaatcgtctgctgatggaattcagtggcaatgatgtgcctaatttgcgctttgaagtggggagccgccctgtgg

Thermotoga Petrophila:
tggcagctgccctgtcaaggaagttgtacctgccgctgcgcaaaagttcaatcacacctgtatctgccagagtgagggaaccaccagccgataccgttgcaccctccgggataagctctttcactctctcaagaatttcttcacgatcacgagcaatccatacctcatgtttcttttttcttaagttgttagccacgtgctctgcgagtttctcttttttccatagccatagttcctctctcaagctcataactctatacctcctttttgtcgaatttgtgtgatttatagagaaaatcttattaactgaaactaaaatggtaggtttggtggtaggttttgtgtacattttgtagtatctgatttttaattacataccgtatattgtattaaattgacgaacaattgcatggaattgaatatatgcaaaacaaacctaccaccaaactctgtattgaccattttaggacaacttcagggtggtaggtttctgaagctctcatcaatagactattttagtctttacaaacaatattaccgttcagattcaagattctacaacgctgttttaatgggcgttgcagaaaacttaccacctaaaatccagtatccaagccgatttcagagaaacctaccacttacctaccacttacctaccacccgggtggtaagttgcagacattattaaaaacctcatcagaagcttgttcaaaaatttcaatactcgaaacctaccacctgcgtcccctattatttactactactaataatagcagtataattgatctgaaaagaggtggtaaaaaaatgaactggaaggtagagctctcggaaatagaaaaaaagaagcgattctttctagaaggcatctttgataaggacggtatagaactcgatgtgggtttctgcagattcttggaacctgttcgagtgaaaatggtcgttgcaaagacaaaagatggtttcacagtcggtggatacgttcacacggcaatagaacatccctgtgccaggtgtcttgaacccgctcgtgtcgaaataagtggagttatagaag


-------------------------------------------

Laufzeitanalyse ist im Programm nicht enthalten, da dies nicht erforderlich war.
Die Laufzeitanalyse erfolgte durch eine Änderung der Main()-Funktion und kann ggf. durch folgende Main() ersetzt werden, um die Analysen den Algorithmen hinzuzufügen:



        Scanner scan = new Scanner(System.in);
		System.out.println("Bitte geben sie das zu durchsuchende Genom ein. Gross- und Kleinbuchstaben NICHT mischen!");
		String input =scan.next();
		System.out.println("Bitte geben sie die groesse der zu findenen K-Mere ein.");
		int k = scan.nextInt();
		System.out.println("");
		long startTime = System.nanoTime();
		frequentWords(input,k);
		long endTime = System.nanoTime ();
		long a = endTime - startTime;
		System.out.println("");
		startTime = System.nanoTime();
		fasterFrequentWords(input,k);
		endTime = System.nanoTime ();
		long b = endTime - startTime;
		System.out.println("");
		startTime = System.nanoTime();
		findingFrequentWordsBySorting(input,k);
		endTime = System.nanoTime ();
		long c = endTime - startTime;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		

Ich hatte leider am Tag der Abgabe beim hochladen der Dateien einige Internetprobleme, und habe sie mehrere Male neu uploaden müssen. Fertig war jedoch alles vor 23:59. 
		