package edu.hit1160300610.experiment4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class delete extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_did;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			delete dialog = new delete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public delete() {
		setTitle("删除学生信息");
		setBounds(100, 100, 722, 460);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 20);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 388, 706, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JButton button = new JButton("确认删除");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String index=textField_did.getText();
					students.remove(index);
					JOptionPane.showConfirmDialog(null, "删除成功！");
				}
			});
			button.setBounds(50, 108, 94, 23);
			getContentPane().add(button);
		}
		{
			textField_did = new JTextField();
			textField_did.setBounds(224, 43, 146, 21);
			getContentPane().add(textField_did);
			textField_did.setColumns(10);
		}
		{
			JLabel label = new JLabel("所删除学生的学号：");
			label.setBounds(50, 46, 120, 15);
			getContentPane().add(label);
		}
	}

}
