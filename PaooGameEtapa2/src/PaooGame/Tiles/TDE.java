package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Tapet Down Edge

public class TDE extends Tile
{
    public TDE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.TDE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
