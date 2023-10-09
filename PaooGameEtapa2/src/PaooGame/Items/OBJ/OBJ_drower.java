package PaooGame.Items.OBJ;

import PaooGame.Graphics.Assets;

public class OBJ_drower extends SuperObject
{
        public OBJ_drower(int id, int x, int y, int height, int width)
        {
            super(Assets.drower, id);
            this.height = height;
            this.width = width;
            worldX = x*32;
            worldY = y*32;
            collision = true;
        }

}
