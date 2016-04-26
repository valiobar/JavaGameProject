package Entities.BonusItems;

import Interfaces.Board;
import Interfaces.Item;

import java.awt.image.BufferedImage;

/**
 * Created by vb on 20.4.2016 г..
 */
public class ExtendTable extends BonusItem implements Item {
    private long start;
    private boolean isTrigger=false;

    public ExtendTable(int x, int y, int wigth, int hight, Board table, BufferedImage image) {
        super(x, y, wigth, hight, table, image);
    }

    @Override
    public void tick() {
    super.tick();
        if (isTrigger&&(System.currentTimeMillis()-start)/1000l>20){
            table.setRectWidth(100);
            isTrigger=false;
        }
    }

    @Override
    public void takeEffect() {
        isTrigger=true;
         start = System.currentTimeMillis();
        table.setRectWidth(200);
        activate(false);
    }

}
