package view;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author qphan
 */
public class HotelManagement extends JFrame{
    
    private final Container container = getContentPane();
    private final GridLayout gridLayout = new GridLayout();

    public HotelManagement() {
        initComponents();
    }
    
    private void initComponents() {
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // set rows only
        // cols = number of components / rows
        gridLayout.setRows(4);
        gridLayout.setColumns(8);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        
        container.setLayout(gridLayout);
        
        drawRooms(26);
    }
    
    private void drawRooms(int numberOfRooms) {
        for (int i = 1; i <= numberOfRooms; i++) {
            JButton btRoom = new JButton();
            btRoom.setText("Phòng " + (100 + i));
            container.add(btRoom);
        }
    }
    
   
    
}