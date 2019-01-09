/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suevey;

/**
 *
 * @author Vicsoft
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ChangeColor extends JLabel implements TableCellRenderer {

    private String columnName;

    public ChangeColor(String column, String connected) {
        this.columnName = column;
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean selected, boolean hasFocus, int row, int column) {
        Object columnValue = table.getValueAt(row, table.getColumnModel().getColumnIndex(columnName));
        if (value != null) {
            setText(value.toString());
        }

        setBackground(table.getBackground());
        setForeground(table.getForeground());

        if (columnValue.toString().trim().equals("-")) {
            setBackground(Color.yellow);
        }
        if (columnValue.toString().trim().equals("lost")) {
            setBackground(Color.red);
        }
        if (columnValue.toString().trim().equals("won")) {
            setBackground(Color.green);
        }
        if (columnValue.equals("undecided")) {
            setBackground(Color.blue);
        }
        if (columnValue.equals("draw")) {
            setBackground(Color.pink);
        }
        /*
         if (columnValue.equals("E")) {
         setBackground(Color.orange);
         }
         if (columnValue.equals("F")) {
         setBackground(Color.yellow);
         }*/
        return this;
    }
}
