package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class M1DE extends Tile
{
    public M1DE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.M1DE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
