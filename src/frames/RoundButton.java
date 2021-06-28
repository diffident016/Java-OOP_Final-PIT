package frames;

import java.awt.Insets;
import javax.swing.border.Border;

class RoundButton implements Border {

    private int radio;  

    RoundButton(int radius) {
        this.radio = radius;
    }  

    public Insets getBorderInsets(java.awt.Component c) {
        return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
    }  

    public boolean isBorderOpaque() {
        return true;
    }  

    public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radio, radio);
    }


  }