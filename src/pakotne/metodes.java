package pakotne;

import java.text.DecimalFormat;
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
	
	public static DecimalFormat df = new DecimalFormat("0.#");
	
	public static int studSk = 0, kritSk = 0;
	
	static String[] studenti;
	static String[] kriteriji;
	static int[] kriterijaSvars;
	static int[][] kriterijaVertejums;
	static double[] semestraVertejums;
	
	static void audzeknuIevade() {
		int StudentuSk;
		StudentuSk = skaitlaParbaude("Ievadi studentu skaitu!:",1 , 5);
		studSk = StudentuSk;
		studenti = new String[studSk];
		for(int i=0; i<studenti.length; i++) {
			studenti[i] = virknesParbaude("Ievadi skolena "+(i+1)+" vārdu", "Vektors");
	}
	
	}
	
	static void kriterijuIevade() {
		int KriterijSk;
		KriterijSk = skaitlaParbaude("Kāds būs kritēriju skaits?:", 1, 5);
		kritSk = KriterijSk;
		kriteriji = new String[kritSk];
		for(int i=0; i<studenti.length; i++) {
			kriteriji[i] = virknesParbaude("Ievadi "+(i+1)+" kriteriju", "PD");
		}
	}
	
	static void kriterijuSvaruIevade() {
		int maxSvars = 100, sk = 1, svars;
		double atlSvars;
		kriterijaSvars = new int[kritSk];
		for(int i=0; i<kriteriji.length; i++) {
			// Norāda katra kritērija svaru
			do {
				svars = skaitlaParbaude("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")", 1, 100);
				kriterijaSvars[i] = svars;
				//Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
				 //kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
				
				atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
			} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
				  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
				  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
				  || atlSvars < 5);
			maxSvars -= kriterijaSvars[i];
			sk++;
		}
		
	}
	
	public static void ievaditVertejumus() {
		kriterijaVertejums = new int[studSk][kritSk];
		int atzime;
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					atzime = skaitlaParbaude("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j], 0, 10);
					kriterijaVertejums[i][j] = atzime;
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
		
	}
	
	static void apreikinatGalaVert() {
		semestraVertejums = new double[studSk];
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		// Gala vērtējumu izvadīšana
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				
				JOptionPane.showMessageDialog(null ,"Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j], "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			JOptionPane.showMessageDialog(null ,"Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
}
