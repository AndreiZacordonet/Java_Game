package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class M1RE extends Tile
{
    public M1RE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.M1RE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
