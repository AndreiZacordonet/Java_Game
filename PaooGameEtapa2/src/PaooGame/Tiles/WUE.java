package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Up Edge

public class WUE extends Tile
{
    public WUE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WUE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
