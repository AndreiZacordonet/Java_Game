package PaooGame.Tiles;

// Tapet Interior

import PaooGame.Graphics.Assets;

public class TI extends Tile
{
    public TI(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.TI, id);
    }
    public boolean IsSolid()
    {
        return false;
    }
}
