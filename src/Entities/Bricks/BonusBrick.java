package Entities.Bricks;
import Entities.BonusItems.BonusLive;
import Entities.BonusItems.ExtendTable;
import FX.Assets;
import Interfaces.Board;
import Interfaces.Item;
import Interfaces.Wall;
import java.awt.*;
import java.util.Random;

/**
 * Created by vb on 20.4.2016 г..
 */
public class BonusBrick extends NormalBrick {
    Item bonusItem;
    int bonusType;
    Random ran = new Random();

    public BonusBrick(int x, int y, Wall wall, Board table) {
        super(x, y,wall,table);
        bonusType = ran.nextInt(2);
        switch (bonusType) {
            case 0:
                this.bonusItem = new BonusLive(this.x, this.y, 20, 20, this.table, Assets.bounsBall);
                break;
            case 1:
                this.bonusItem = new ExtendTable(this.x, this.y, 20, 20,this.table, Assets.bounsExtend);
                break;
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawImage(Assets.bonusBrick, this.x, this.y, this.WIGHT, this.HIGHT, null);
    }

    @Override
    public void getHit() {
        super.getHit();
        this.bonusItem.activate(true);
        this.wall.getBonusItems().add(this.bonusItem);
    }
}
