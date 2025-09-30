package pakotne;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class metodes {

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
	
	public static int studSk, kritSk;
	
	static void audzeknuIevade() {
		studSk = main.skaitlaParbaude("Ievadi audzēkņu skaitu", 1, 10);
		String[] studenti = new String[studSk];
		for(int i=0; i<studenti.length; i++) {
			studenti[i] = virknesParbaude("Ievadi skolena "+(i+1)+" vārdu", "Vektors");
	}
	
	}
	
	static void kriterijuIevade() {
	kritSk = skaitlaParbaude("Ievadi cik daudz būs kritēriju!", 1, 10);
	String[] kriteriji = new String[kritSk];
	int[] kriterijaSvars = new int[kritSk];
	int[][] kriterijaVertejums = new int[studSk][kritSk];
	double[] semestraVertejums = new double[studSk];
		int maxSvars = 100, sk = 1;
		double atlSvars;
		for(int i=0; i<kriteriji.length; i++) {
			virknesParbaude("Ievadi "+(i+1)+". kritēriju", "PD");
			// Norāda katra kritērija svaru
				kriterijaSvars[i] = skaitlaParbaude("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")", 1, 100);
				//Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
				 //kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
				
				atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
			 while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
				  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
				  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
				  || atlSvars < 5);
			maxSvars -= kriterijaSvars[i];
			sk++;
		}
	}
}
