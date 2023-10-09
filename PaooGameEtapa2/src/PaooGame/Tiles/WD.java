package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Down

public class WD extends Tile
{
    public WD(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WD, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
