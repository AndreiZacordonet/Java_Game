package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Vertical

public class WV extends Tile
{
    public WV(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WV, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
