package com.totalcross;
import totalcross.ui.MainWindow;
import totalcross.sys.Settings;
public class DropcapText extends MainWindow {
    
    public DropcapText() {
        setUIStyle(Settings.MATERIAL_UI);
    }

    @Override
    public void initUI() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus volutpat hendrerit leo quis venenatis. Praesent semper id tellus placerat volutpat. Morbi tincidunt fringilla ornare. Pellentesque porttitor sagittis placerat. Nullam mollis facilisis enim ac tempus. Praesent elementum lectus a feugiat eleifend. Quisque sagittis sodales felis, vitae dignissim est fermentum ac. Praesent tristique nisl at interdum finibus. Ut fermentum, libero nec molestie accumsan, magna nunc semper nunc, in ornare diam ligula nec erat. Nam nisi diam, malesuada ac mattis vel, consectetur non lacus.";
        DropcapLabel dt = new DropcapLabel(text, 50);
        add(dt, CENTER, CENTER, PARENTSIZE + 80, PARENTSIZE);
    }
}
