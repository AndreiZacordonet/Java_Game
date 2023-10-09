package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Up

public class WU extends Tile
{
    public WU(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WU, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
