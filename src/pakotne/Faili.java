package pakotne;

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
			JOptionPane.showMessageDialog(null,str,"Tavs faktoriāls",
					JOptionPane.INFORMATION_MESSAGE);
			
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda nolasot failu", "Kļūda",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void Ieraksts(int n) {
		try {
			FileWriter fw = new FileWriter("fakstorial.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			
				pw.print();

			pw.close();
			JOptionPane.showMessageDialog(null, "GalaVērtējums saglabāts", "Aura",
					JOptionPane.INFORMATION_MESSAGE);
			
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda ierakstot failā", "Kļūda",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
