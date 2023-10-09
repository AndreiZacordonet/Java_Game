package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Tapet RIght Corner

public class TRC extends Tile
{
    public TRC(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.TRC, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
