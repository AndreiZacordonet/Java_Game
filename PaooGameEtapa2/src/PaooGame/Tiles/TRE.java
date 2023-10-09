package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// TIle Right Edge

public class TRE extends Tile
{
    public TRE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.TRE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
