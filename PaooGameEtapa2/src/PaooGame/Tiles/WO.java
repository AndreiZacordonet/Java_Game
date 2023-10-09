package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Orizontal

public class WO extends Tile
{
    public WO(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WO, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
