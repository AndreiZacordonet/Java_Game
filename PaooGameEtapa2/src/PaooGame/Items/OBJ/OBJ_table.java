package PaooGame.Items.OBJ;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OBJ_table extends SuperObject
{

    public OBJ_table(int id, int x, int y, int height, int width)
    {
        super(Assets.table, id);
        this.height = height;
        this.width = width;
        worldX = x*32;
        worldY = y*32;
        collision = true;
    }
}
