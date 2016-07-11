package texturedpanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Konglie
 */
public class TexturedPanel extends JPanel {
    private URL backgroundImage;
    
    // use custom painter to paint components
    // texturepaint
    private TexturePaint painter;
    
    public TexturedPanel(URL background){
        super();
        setBackgroundImage(background);
    }
    
    public void setBackgroundImage(URL background){
        // set the background image location
        this.backgroundImage = background;
        
        try{
            // decode the image
            BufferedImage image = ImageIO.read(this.backgroundImage);
            
            // setup the texture painter
            this.painter = new TexturePaint(
                    image, 
                    new Rectangle(image.getWidth(), image.getHeight())
            );
            
            // signal component painting
            repaint();
        } catch(Exception e){
            this.painter = null;
            e.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        // if we have custom painter
        if(this.painter != null){
            Graphics2D g2d = (Graphics2D) g;
            
            // use the custom painter
            g2d.setPaint(this.painter);
            
            // start painting
            g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
        }
    }
}
