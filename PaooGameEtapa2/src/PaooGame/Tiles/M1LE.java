package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

//M1 left Edge

public class M1LE extends Tile
{
    public M1LE(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.M1LE, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
