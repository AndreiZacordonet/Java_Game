package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

// Wall Interior
public class WI extends Tile
{
    public WI(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.WI, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
