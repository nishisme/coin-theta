import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Home implements ActionListener {
	int i;
	Frame f;
	Panel p1;
	Button b1, b2;
	TextField t1, t2;
	Label l1, l2;

	Home() {
		f = new Frame("Contacts");
		b1 = new Button("Save");
		b2 = new Button("Cancel");
		l1 = new Label("Phone No.");
		l2 = new Label("Name");
		t1 = new TextField();
		t2 = new TextField();
		p1 = new Panel();
		f.add(p1);
		p1.setLayout(new GridLayout(3, 2));
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(b1);
		p1.add(b2);
		b1.addActionListener(this);
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public static void main(String ar[]) {
		Home h = new Home();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				File f = new File("contacts.txt");
				FileWriter fw = new FileWriter(f, true);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(t1.getText() + "---" + t2.getText());
				t1.setText("");
				t2.setText("");
				pw.close();
				fw.close();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
}