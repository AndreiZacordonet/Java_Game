package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Down Edge

public class WDE extends Tile
{
    public WDE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WDE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
