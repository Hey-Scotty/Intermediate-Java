import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/** PostFixGUI.java
 *
 *
 * @author TinieT
 * @version Feb 26, 2015
 * 
 */
public class PostFixGUI extends JFrame implements ActionListener {
	PostFixEvaluator postFix;
	public PostFixGUI() {
		super("PostFixer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		postFix = new PostFixEvaluator();
		
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		JLabel inputLabel = new JLabel("input Postfix expression here ");
		
		JTextField userField = new JTextField(20);
		
		JLabel outputLabel = new JLabel("result:");
		JTextField outputField = new JTextField(20);
		
		userField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                outputField.setText("");
            }
		});  
		p.add(inputLabel);
		p.add(userField);
		JButton solve = new JButton("Solve");	
		JButton clear = new JButton("Clear");
		solve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postFix.addInput(userField.getText());
				if(postFix.validate())
					outputField.setText(postFix.Evaluate() + "");
				else
					JOptionPane.showMessageDialog(null, "Incorrect postfix format please try again");
			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 userField.setText("");
				 outputField.setText("");
			}
		});
		p.add(solve);
		p.add(clear);
		p.add(outputLabel);
		p.add(outputField);
		add(p);
		setSize(400, 180);
		setResizable(false);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {

	}
		

}
