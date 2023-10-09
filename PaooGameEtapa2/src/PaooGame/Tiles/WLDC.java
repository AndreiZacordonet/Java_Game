package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Left Down Corner

public class WLDC extends Tile
{
    public WLDC(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WLDC, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
