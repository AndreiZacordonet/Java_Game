package PaooGame.Items.OBJ;

import PaooGame.Items.Hero;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

import static PaooGame.Tiles.Tile.tileSize;

public class SuperObject
{
    public RefLinks reflink;
    public BufferedImage image;
    public int id;
    public int worldX,  worldY;
    public int height, width;
    public boolean collision = false;

    public Rectangle solidArea = new Rectangle(0,0,width,height);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public static SuperObject[] obj = new SuperObject[15];

    //public static SuperObject table = new OBJ_table(0, 13, 5, 40*32, 32*40);
    //public static SuperObject drower = new OBJ_drower(1, 20, 15, 32*40, 32*40);

    public SuperObject(BufferedImage image, int id)
    {
        this.image = image;
        this.id = id;

        obj[id] = this;
    }

    public void Draw(Graphics g, int x, int y, int height, int width)
    {
            //g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            g.drawImage(image, x, y, height, width,null);
    }


}
