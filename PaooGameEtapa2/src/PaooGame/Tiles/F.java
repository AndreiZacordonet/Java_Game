package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class F extends Tile
{
    public F(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.F, id);
    }
    public boolean IsSolid()
    {
        return false;
    }
}
