package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall

public class W extends Tile
{
    public W(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.W, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
