package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall RIght Edge

public class WRE extends Tile
{
    public WRE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WRE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
