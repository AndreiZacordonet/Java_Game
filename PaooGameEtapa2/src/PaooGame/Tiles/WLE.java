package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Left Edge

public class WLE extends Tile
{
    public WLE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WLE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
