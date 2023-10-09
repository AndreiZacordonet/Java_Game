package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// TApet Left Edge

public class TLE extends Tile
{
    public TLE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.TLE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
