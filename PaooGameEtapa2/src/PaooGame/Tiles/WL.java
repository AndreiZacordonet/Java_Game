package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Left

public class WL extends Tile
{
    public WL(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WL, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
