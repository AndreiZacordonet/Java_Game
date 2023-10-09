package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Right

public class WR extends Tile
{
    public WR(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WR, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}