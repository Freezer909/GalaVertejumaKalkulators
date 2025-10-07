package pakotne;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class main {

	public static String virknesParbaude(String zinojums, String noklusejums) {
		 String virkne;
		 do {
			 virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			 if(virkne == null)
				 return null;
		 }while(!Pattern.matches("^[\\p{L} .]+$", virkne));
		 
		return virkne;
	}
	
	public static int skaitlaParbaude(String zinojums, int min, int max) {
		  String ievade;
		  int skaitlis;
		  
		  while(true) {
			  ievade = JOptionPane.showInputDialog(null, zinojums, 
					  "datu ievade", JOptionPane.INFORMATION_MESSAGE);
			  if (ievade == null)
				  return -1;
			  
			  try {
				  skaitlis = Integer.parseInt(ievade);
				  if(skaitlis < min || skaitlis > max) {
					  JOptionPane.showMessageDialog(null, "Norādīts nederīgs intervāls",
							  "nekorekti dati", JOptionPane.WARNING_MESSAGE);
					  continue;
				  }
				  return skaitlis;
			  }catch(NumberFormatException e) {
				  JOptionPane.showMessageDialog(null, 
						  "netika ievadīts vesels skaitlis",
						  "Nekorekti dati", JOptionPane.ERROR_MESSAGE);
			  }
			  
		  }
		}
	
	public static void main(String[] args) {
		
		int izvele;
		do {
			izvele = skaitlaParbaude(
					"Ko vēlies darīt?\n"
					+ "0 - Apturēt\n"
					+ "1 - Ievadīt audzēkni\n"
					+ "2 - Ievadīt kritērijus\n"
					+ "3 - Ievadīt kritēriju svaru\n"
					+ "4 - Ievadīt vērtējumu\n"
					+ "5 - Labot kritēriju\n"
					+ "6 - Labot kritēriju svaru \n"
					+ "7 - Labot iegūto vērtējumu \n"
					+ "8 - Apreiķināt gala vērtējumu\n"
					+ "9 - Saglabāt rezultātu failā\n"
					+ "10 - nolsaīt rezultātus no faila", 0, 10);
			if (izvele == -1)
				izvele = 0;
			
			switch (izvele) {
			case 0:
				JOptionPane.showMessageDialog(null,
				"Programma apturēta!", "Paziņojums", 
				JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case 1:
				metodes.audzeknuIevade();
				break;
			
			case 2:
				metodes.kriterijuIevade();
				break;
				
			case 3:
				metodes.kriterijuSvaruIevade();
				break;
				
			case 4:
				metodes.ievaditVertejumus();
				break;
			case 5:
				metodes.kriterijuIevade();
				break;
			case 6:
				metodes.kriterijuSvaruIevade();
				break;
			case 7:
				metodes.ievaditVertejumus();
				break;
			case 8:
				metodes.apreikinatGalaVert();
				break;
				
			case 9:
				Faili.Ieraksts(metodes.teksts);
				break;
				
			case 10:
				Faili.Nolasit();
				break;
				
			}
		} while (izvele != 0);
		
	}
}