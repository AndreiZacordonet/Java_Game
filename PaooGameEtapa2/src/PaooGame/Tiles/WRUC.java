package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class WRUC extends Tile
{
    public WRUC(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WRUC, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}