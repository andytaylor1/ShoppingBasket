package shoppingBasket;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class UserInterface {
	
	public static void main(String args[]) {
		
		ShoppingBasket basket = new ShoppingBasket();
		Checkout checkout = new Checkout(basket);
		
		JFrame frame = createFrame();
        
		JTable table = createGrid(basket);
		
		JPanel tablePanel = createPanel();
		
		JButton clear = createClearButton(table);
		
		JPanel addPanel = createPanel();
		
		JButton goToCheckout = createCheckoutButton(table, basket);
		
		JButton addToBasket = createAddButton(table, basket, goToCheckout);
		
		tablePanel.add(clear);
		
		addPanel.add(addToBasket);
		addPanel.add(goToCheckout);
		
		createContainer(frame, table, tablePanel, addPanel);
		
		frame.setVisible(true);
		
		
	}
	
	private static void createCheckoutScreen(ShoppingBasket basket, Checkout checkout) {
		JFrame frame = createFrame();
	}

	private static void createContainer(JFrame frame, JTable table, JPanel tablePanel, JPanel addPanel) {
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(table.getTableHeader(), BorderLayout.NORTH);
		container.add(table, BorderLayout.CENTER);
		container.add(tablePanel, BorderLayout.SOUTH);
		container.add(addPanel, BorderLayout.EAST);
	}

	private static JPanel createPanel() {
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new FlowLayout());
		tablePanel.setVisible(true);
		return tablePanel;
	}
	

	private static JFrame createFrame() {
		JFrame frame = new JFrame("Shopping basket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,660);
        frame.setVisible(true); 
        
        frame.setLayout(new BorderLayout());
		return frame;
	}

	private static JButton createClearButton(JTable table) {
		JButton clear = new JButton();
		clear.setVisible(true);
		clear.setText("clear selection");
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
			}
		});
		return clear;
	}
	
	private static JButton createAddButton(JTable table, ShoppingBasket basket, JButton checkoutButton) {
		JButton add = new JButton();
		add.setVisible(true);
		add.setText("Add to Basket");
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowNumber = table.getSelectedRow();
				Product pToAdd = basket.catalog.get(rowNumber);
				basket.basket.add(pToAdd);
				checkoutButton.setText("Checkout ("+basket.basket.size()+")");
				
			}
		});
		return add;
	}
	
	private static JButton createCheckoutButton(JTable table, ShoppingBasket basket) {
		JButton checkout = new JButton();
		checkout.setVisible(true);
		checkout.setText("Checkout ("+basket.basket.size()+")");
		return checkout;
	}

	private static JTable createGrid(ShoppingBasket basket) {
		BasketModel model = new BasketModel(basket);
		JTable table = new JTable(model);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setRowHeight(40);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setVisible(true);
		table.setDefaultRenderer(Object.class, new MyRenderer());
		return table;
	}

}

class MyRenderer implements TableCellRenderer {
	
	JLabel label = new JLabel();
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        label.setOpaque(true);
        label.setMaximumSize(new Dimension(200, 200));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLACK);
        label.setBackground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 35));
        
        label.setText(value.toString());
        
        if(isSelected) {
            label.setForeground(Color.WHITE);
            label.setBackground(Color.BLUE);
        }
    
        return label;
	}
	
}

class BasketModel extends AbstractTableModel {
	ShoppingBasket basket;
	
	
	BasketModel(ShoppingBasket basket){
		this.basket = basket;
	}

	public int getColumnCount() {
	
		return 2;
	}
	
	public int getRowCount() {
		return getRowCount(basket);
	}

	public int getRowCount(ShoppingBasket basket) {
	
		return basket.catalog.size();
	}
	
	@Override
	public boolean isCellEditable(int row, int col)
    { return false; }
	

	 public Object getValueAt(int row, int col) {
		 
		 
		 return getValueAt(row, col, basket);
	 }
	 
	 public Object getValueAt(int row, int col, ShoppingBasket basket) {
		 
		 String statusType = null;
		 
		 if(col == 0) {
			 statusType = basket.catalog.get(row).getName();
		 }
		 else {
			 DecimalFormat df = new DecimalFormat("#.00"); 
			 statusType = "£"+df.format(basket.catalog.get(row).getPrice());
		 }
		 
		 return statusType;
	 }
}
