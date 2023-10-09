package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Left Up Corner

public class WLUC extends Tile
{
    public WLUC(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WLUC, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
