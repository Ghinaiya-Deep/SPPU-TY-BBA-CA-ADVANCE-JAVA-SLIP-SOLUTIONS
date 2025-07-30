import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Set;

public class q2 extends JFrame {

    JComboBox empNoComboBox;
    JTable table;
    DefaultTableModel tableModel;

    // Dummy employee data
    HashMap<String, String[]> employeeData = new HashMap<String, String[]>();

    public q2() {
        setTitle("Employee Details Viewer");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize dummy data
        employeeData.put("101", new String[]{"101", "Alice", "50000"});
        employeeData.put("102", new String[]{"102", "Bob", "55000"});
        employeeData.put("103", new String[]{"103", "Charlie", "60000"});

        JLabel label = new JLabel("Select Emp No");

        Set<String> empKeys = employeeData.keySet();
        empNoComboBox = new JComboBox(empKeys.toArray());

        // Table setup
        String[] columns = {"ENo", "EName", "Salary"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // ComboBox selection event
        empNoComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showEmployeeDetails();
            }
        });

        // Add components to frame
        add(label);
        add(empNoComboBox);
        add(scrollPane);

        setVisible(true);
    }

    private void showEmployeeDetails() {
        String selectedEmpNo = (String) empNoComboBox.getSelectedItem();
        String[] empDetails = employeeData.get(selectedEmpNo);

        // Clear table before adding new data
        tableModel.setRowCount(0);
        tableModel.addRow(empDetails);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new q2();
            }
        });
    }
}
