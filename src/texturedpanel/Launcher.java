package texturedpanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * JPanel with repeated/texture background image
 */

/**
 *
 * @author Konglie
 */
public class Launcher {
    private static void initComponents(){
        // initialize frame
        JFrame frame = new JFrame();
        frame.setTitle("JPanel with Textured/Repeating Background");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set a little padding
        ((JComponent)frame.getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(5, 0, 5, 0)
        );
        
        // the main menu
        // with initial texture image
        final TexturedPanel tp = new TexturedPanel(
                Launcher.class.getResource("/texturedpanel/images/t1.png")
        );
        tp.setLayout(new BorderLayout());
        
        // an example if we have child on the texturedpanel
        tp.add(new JLabel("Panel Child example (JLabel)"), BorderLayout.CENTER);
        frame.getContentPane().add(tp, BorderLayout.CENTER);
        
        JPanel header = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Pilih Teksture Background");
        header.add(lbl);
        
        // the combobox for choosing the background image
        final JComboBox cb = new JComboBox();
        for(int i = 1; i <= 3; i++){
            cb.addItem("Tekstur " + i);
        };
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = cb.getSelectedIndex();
                
                // why i + 1 ?
                // because selectedIndex is starting from 0 zero
                // whilst our image is started from 1
                URL image = Launcher.class.getResource(
                        String.format("/texturedpanel/images/t%s.png", i + 1)
                );
                
                // set the background
                tp.setBackgroundImage(image);
            }
        });
        header.add(cb);
        frame.add(header, BorderLayout.NORTH);
        
        // hello there
        JLabel footer = new JLabel("<html>"
                + "<center>ali LIM<br/>konglie@kurungkurawal.com</center>"
                + "</html>");
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        
        frame.getContentPane().add(footer, BorderLayout.SOUTH);
        
        frame.setMinimumSize(new Dimension(480,320));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        // show it
        frame.setVisible(true);
        
        // thank your for watching.
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                initComponents();
            }        
        });
    }
}
