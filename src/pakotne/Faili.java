package pakotne;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Faili {
	static void Nolasit() {
		String teksts, str = "";
		
		try {
			
			FileReader fr = new FileReader("Saraksts.txt");
			BufferedReader br = new BufferedReader(fr);
			while((teksts=br.readLine()) != null) {
				str+= teksts+"\n";
			}
			br.close();
			JOptionPane.showMessageDialog(null,str,"Saraksts",
					JOptionPane.INFORMATION_MESSAGE);
			
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda nolasot failu", "Kļūda",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void Ieraksts(String teksts) {
		try {
			FileWriter fw = new FileWriter("Saraksts.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			
				pw.print(teksts);

			pw.close();
			JOptionPane.showMessageDialog(null, "Gala Vērtējums saglabāts", "Aura",
					JOptionPane.INFORMATION_MESSAGE);
			
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda ierakstot failā", "Kļūda",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
