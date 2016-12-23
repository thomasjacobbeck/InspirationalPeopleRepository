
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * This class that connects to the Inspirational People Database 
 * and makes a simple GUI based on the information.
 *
 * @author Tom Beck
 *
 */
public class InspirationalPeopleFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> jcbPeople;
	private static Connection c = InspirationalDB.getConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InspirationalPeopleFrame frame = new InspirationalPeopleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame.
	 * No info will be displayed until the user selects a person.
	 * After selection the text box will be populated with facts from the database
	 * associated with that person. The text box is scrollable and the components will resize with the window.
	 */
	public InspirationalPeopleFrame() {
		Dimension minSize=new Dimension(450,350);
		this.setMinimumSize(minSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);

		jcbPeople = new JComboBox<String>();
		populateJCBPeople();
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(textArea);
		jcbPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedPerson = jcbPeople.getSelectedItem().toString();
				try {
					Statement statement = c.createStatement();
					String query = "select p.personname, f.facttext from people "
							+ "p, facts f where p.personid=f.personid AND p.personname="
							+ "'"+selectedPerson+"'";
					ResultSet rs = statement.executeQuery(query);
					textArea.setText("");
					while (rs.next()) {
						textArea.append(rs.getString("facttext")+"\n\n");
					}
					textArea.setCaretPosition(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblPeople = new JLabel("People");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(jcbPeople, 0, 394, Short.MAX_VALUE))
						.addComponent(lblPeople)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblPeople)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jcbPeople, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addGap(0))
		);
		panel.setLayout(gl_panel);
	}

	/**
	 * Take every person's name in the database and adds them to the JComboBox
	 */
	public void populateJCBPeople() {
		try (Statement statement = c.createStatement();
				ResultSet rs = statement.executeQuery("select personname from people")) {
			while (rs.next()) {
				jcbPeople.addItem(rs.getString("personname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
