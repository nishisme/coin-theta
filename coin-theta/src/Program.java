import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Program implements ActionListener {

	Frame f;
	TextField t1;
	TextField t2;
	TextField t3;
	Label l1, l2, l3;
	Button b1;
	Button b2;

	Program() {
		f = new Frame("Entry");
		b1 = new Button("Save");
		b2 = new Button("Cancel");
		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		l1 = new Label("Name");
		l2 = new Label("Phone no.");
		l3 = new Label("Email ID");
		f.setSize(400, 400);
		f.setLayout(null);
		l1.setBounds(20, 40, 100, 30);
		t1.setBounds(130, 40, 200, 30);
		l2.setBounds(20, 100, 100, 30);
		t2.setBounds(130, 100, 200, 30);
		l3.setBounds(20, 160, 100, 30);
		t3.setBounds(130, 160, 200, 30);

		b1.setBounds(20, 220, 380, 30);
		b2.setBounds(20, 280, 380, 30);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(b1);
		f.add(b2);
		f.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				File f = new File("contacts.txt");
				FileWriter fw = new FileWriter(f, true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(t1.getText() + "---" + t2.getText() + "---" + t3.getText());
				t1.setText("");
				t2.setText("");
				t3.setText("");
				pw.close();
				fw.close();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		} else if (e.getSource() == b2)
			f.dispose();
	}

	public static void main(String ar[]) {
		Program p = new Program();
	}
}