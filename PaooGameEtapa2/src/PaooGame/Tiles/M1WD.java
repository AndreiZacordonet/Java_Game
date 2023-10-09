package PaooGame.Tiles;

//Map 1 Wall down

import PaooGame.Graphics.Assets;

public class M1WD extends Tile
{
    public M1WD(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.M1WD, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
