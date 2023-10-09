package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

//Map 1 Floor

public class M1F extends Tile
{
    public M1F(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.M1F, id);
    }
    public boolean IsSolid()
    {
        return false;
    }
}
