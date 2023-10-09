package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Tapet Left Corner

public class TLC extends Tile
{
    public TLC(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.TLC, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
