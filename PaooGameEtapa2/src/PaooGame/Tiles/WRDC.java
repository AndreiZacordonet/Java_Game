package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall RIght Down Corner

public class WRDC extends Tile
{
    public WRDC(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WRDC, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
