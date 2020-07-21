package com.totalcross;

import org.apache.tools.ant.taskdefs.Tstamp.Unit;

import totalcross.sys.Convert;
import totalcross.ui.Control;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

/**
 * DropcapLabel
 */
public class DropcapLabel extends Control {

    String text;
    int dropcapSize;
    int gap = UnitsConverter.toPixels(DP + 4);
    public DropcapLabel (String text, int dropcapSize) {
        this.text = text;
        this.dropcapSize = dropcapSize;
    }
    
    

    @Override
    public void onPaint(Graphics g) {
        char firstLetter = text.charAt(0);
        String remainder = text.substring(1, text.length()-1);
        Font firstLetterFont = font.getFont(false, dropcapSize);


        g.setFont(firstLetterFont);
        g.drawText(firstLetter + "", 0, 0);
        int firstLetterWidth = firstLetterFont.fm.stringWidth(firstLetter + "");
        int firstLetterHeight = firstLetterFont.fm.height;
        String [] splittedLines = Convert.insertLineBreak(getWidth() - firstLetter - gap, fm, remainder).split("\n");
        
        g.setFont(this.font);
        int xx = firstLetterWidth + gap;
        int yy = 0;
        int justifyWidth = getWidth() - xx;
        String alreadyDrawnLines = "";
        for (int i = 0; i < splittedLines.length; i++) {
            g.drawText(splittedLines[i], xx, yy, justifyWidth);
            yy += fm.height + gap;
            alreadyDrawnLines += splittedLines[i];
            if(yy > firstLetterHeight) break;    
        } 
        
        remainder = remainder.substring(alreadyDrawnLines.length());
        splittedLines = Convert.insertLineBreak(getWidth(), fm, remainder).split("\n");
        for (int i = 0; i < splittedLines.length - 1; i++) {
            g.drawText(splittedLines[i], 0, yy, getWidth());
            yy += fm.height + gap;    
        }
        // draw lastLine
        g.drawText(splittedLines[splittedLines.length-1], 0, yy);
       
        
    }
}