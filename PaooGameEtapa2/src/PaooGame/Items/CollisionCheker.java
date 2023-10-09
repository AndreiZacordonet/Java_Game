package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.States.PlayState;

import static PaooGame.Items.OBJ.SuperObject.obj;
import static PaooGame.Tiles.Tile.tileSize;

public class CollisionCheker
{
    RefLinks refLink;
    public CollisionCheker(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    public void checkTile(Hero entity)
    {

        //laturile hitboxului caracterului
        int Left = (int)entity.GetX() + entity.solidArea.x;
        int Right = (int)entity.GetX() + entity.solidArea.x + entity.solidArea.width;
        int Top = (int)entity.GetY() + entity.solidArea.y;
        int Bottom = (int)entity.GetY() + entity.solidArea.y + entity.solidArea.height;

        //coordonatele tile-urilor de langa caracter
        int TopRow = Top/tileSize;
        int BottomRow = Bottom/tileSize;
        int LeftCol = Left/tileSize;
        int RightCol = Right/tileSize;

//        switch(entity.direction)
//        {
//            case "up":
//                TopRow = (Top - entity.speed)/gp.tileSize;
//                tileNum1 = gp.tileM.mapTileNum[TopRow][LeftCol];
//                tileNum2 = gp.tileM.mapTileNum[TopRow][RightCol];
//                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
//                {
//                    entity.collisionOn = true;
//                }
//                break;
//            case "down":
//                BottomRow = (Bottom + entity.speed)/gp.tileSize;
//                tileNum1 = gp.tileM.mapTileNum[BottomRow][LeftCol];
//                tileNum2 = gp.tileM.mapTileNum[BottomRow][RightCol];
//                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
//                {
//                    entity.collisionOn = true;
//                }
//                break;
//            case "left":
//                LeftCol = (Left - entity.speed)/gp.tileSize;
//                tileNum1 = gp.tileM.mapTileNum[TopRow][LeftCol];
//                tileNum2 = gp.tileM.mapTileNum[BottomRow][LeftCol];
//                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
//                {
//                    entity.collisionOn = true;
//                }
//                break;
//            case "right":
//                RightCol = (Right + entity.speed)/gp.tileSize;
//                tileNum1 = gp.tileM.mapTileNum[TopRow][RightCol];
//                tileNum2 = gp.tileM.mapTileNum[BottomRow][RightCol];
//                if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision)
//                {
//                    entity.collisionOn = true;
//                }
//                break;
//        }
        if(refLink.GetKeyManager().up)
        {
            TopRow = (int)(Top - entity.speed)/tileSize;
            if(refLink.GetMap().GetTile(TopRow, LeftCol).IsSolid() || refLink.GetMap().GetTile(TopRow, RightCol).IsSolid())
            {
                entity.collision = true;
            }
        }
        ///Verificare apasare tasta "jos"
         if(refLink.GetKeyManager().down)
        {
            BottomRow = (int)(Bottom + entity.speed)/tileSize;
            if(refLink.GetMap().GetTile(BottomRow, LeftCol).IsSolid() || refLink.GetMap().GetTile(BottomRow, RightCol).IsSolid())
            {
                entity.collision = true;
            }
        }
        ///Verificare apasare tasta "left"
         if(refLink.GetKeyManager().left)
        {
            LeftCol = (int)(Left - entity.speed)/tileSize;
            if(refLink.GetMap().GetTile(TopRow, LeftCol).IsSolid() || refLink.GetMap().GetTile(BottomRow, LeftCol).IsSolid())
            {
                entity.collision = true;
            }
        }
        ///Verificare apasare tasta "dreapta"
         if(refLink.GetKeyManager().right)
        {
            RightCol = (int)(Right + entity.speed)/tileSize;
            if(refLink.GetMap().GetTile(TopRow, RightCol).IsSolid() || refLink.GetMap().GetTile(BottomRow, RightCol).IsSolid())
            {
                entity.collision = true;
            }
        }
    }

    public int checkObj(Hero entity, boolean player)
    {
        int index = 999;

        for(int i = 0; i < 2; i++)
        {
            if(obj[i] != null)
            {
                /// Get entitys solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                // Get the objects solid area position
                obj[i].solidArea.x = obj[i].worldX + obj[i].solidArea.x;
                obj[i].solidArea.y = obj[i].worldY + obj[i].solidArea.y;

//                switch (entity.direction)
//                {
//                    case "up":
//                        entity.solidArea.y -= entity.speed;
//                        if(entity.solidArea.intersects(obj[i].solidArea))
//                        {
//                            if(obj[i].collision)
//                            {
//                                entity.collision = true;
//                            }
//                            if(player)
//                            {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "down":
//                        entity.solidArea.y += entity.speed;
//                        if(entity.solidArea.intersects(obj[i].solidArea))
//                        {
//                            if(obj[i].collision)
//                            {
//                                entity.collision = true;
//                            }
//                            if(player)
//                            {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "left":
//                        entity.solidArea.x -= entity.speed;
//                        if(entity.solidArea.intersects(obj[i].solidArea))
//                        {
//                            if(obj[i].collision)
//                            {
//                                entity.collision = true;
//                            }
//                            if(player)
//                            {
//                                index = i;
//                            }
//                        }
//                        break;
//                    case "right":
//                        entity.solidArea.x += entity.speed;
//                        if(entity.solidArea.intersects(obj[i].solidArea))
//                        {
//                            if(obj[i].collision)
//                            {
//                                entity.collision = true;
//                            }
//                            if(player)
//                            {
//                                index = i;
//                            }
//                        }
//                }

                if(refLink.GetKeyManager().up)
                {
                    entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(obj[i].solidArea))
                    {
                        if(obj[i].collision)
                        {
                            //entity.collision = true;
                            System.out.println("rightcoloisorn");
                        }
                        if(player)
                        {
                            index = i;
                        }
                    }
                }
                ///Verificare apasare tasta "jos"
                if(refLink.GetKeyManager().down)
                {
                    entity.solidArea.y += entity.speed;
                    if(entity.solidArea.intersects(obj[i].solidArea))
                    {
                        if(obj[i].collision)
                        {
                            //entity.collision = true;
                            System.out.println("dwoncoloisorn");
                        }
                        if(player)
                        {
                            index = i;
                        }
                    }
                }
                ///Verificare apasare tasta "left"
                if(refLink.GetKeyManager().left)
                {
                    entity.solidArea.x -= entity.speed;
                    if(entity.solidArea.intersects(obj[i].solidArea))
                    {
                        if(obj[i].collision)
                        {
                            //entity.collision = true;
                            System.out.println("leftcoloisorn");
                        }
                        if(player)
                        {
                            index = i;
                        }
                    }
                }
                ///Verificare apasare tasta "dreapta"
                if(refLink.GetKeyManager().right)
                {
                    entity.solidArea.x += entity.speed;
                    if(entity.solidArea.intersects(obj[i].solidArea))
                    {

                        if(obj[i].collision)
                        {
                            //entity.collision = true;
                            System.out.println("rightcoloisorn");
                        }
                        if(player)
                        {
                            index = i;
                        }
                    }
                }

                obj[i].solidArea.x = obj[i].solidAreaDefaultX;
                obj[i].solidArea.y = obj[i].solidAreaDefaultY;

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                obj[i].solidArea.x = obj[i].solidAreaDefaultX;
                obj[i].solidArea.y = obj[i].solidAreaDefaultY;
            }

        }
        return index;
    }
}
