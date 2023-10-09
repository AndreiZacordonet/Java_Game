package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class M1W extends Tile
{
    public M1W(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.M1W, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
