package PaooGame.Maps;

import PaooGame.Items.Hero;
import PaooGame.Items.OBJ.SuperObject;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static PaooGame.Items.OBJ.SuperObject.obj;
import static PaooGame.Tiles.Tile.tileSize;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map
{
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    public String map_path = "res/maps/map3.txt";


    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(RefLinks refLink)
    {
            /// Retine referinta "shortcut".
        this.refLink = refLink;
            ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.

        loadMap(map_path);
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public  void Update()
    {
        if(refLink.GetKeyManager().map1)
        {
            map_path = "res/maps/map1.txt";
        }
        if(refLink.GetKeyManager().map2)
        {
            map_path = "res/maps/map2.txt";
        }
        if(refLink.GetKeyManager().map1)
        {
            map_path = "res/maps/map3.txt";
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {
            ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
//        for(int x = 0; x < height; x++)     //refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT
//        {
//            for(int y = 0; y < width; y++)      //refLink.GetGame().GetWidth()/Tile.TILE_WIDTH
//            {
//                GetTile(y, x).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);     //in getTile x, y sunt invers ca sa poata citi corect imaginea
//            }
//        }
        int worldCol = 0;
        int worldRow = 0;
        Hero hero = refLink.getHero();
        while(worldCol < width && worldRow < height)
        {
            //traduce din indici(linie, coloana) in coodonate(pixeli)
            int worldX = worldCol * tileSize;    //pixeli
            int worldY = worldRow * tileSize;    //pixeli



            int screenX_prim = (refLink.GetWidth()/2 - tileSize/2);
            int screenY_prim = (refLink.GetHeight()/2 - tileSize/2);

            int screenX = worldX - (int)hero.GetX() + screenX_prim;  //getX->world coord, celalalt termen in loc de screenX
            int screenY = worldY - (int)hero.GetY() + screenY_prim;

            if(worldX + tileSize > (int)hero.GetX() - screenX_prim &&
                    worldX - tileSize < (int)hero.GetX() + screenX_prim &&
                    worldY + tileSize > (int)hero.GetY() - screenY_prim &&
                    worldY - tileSize < (int)hero.GetY() + screenY_prim)    //verifica daca se afla in aria vizuala a playerului
            {
                //g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                GetTile(worldRow, worldCol).Draw(g, screenX, screenY);
                //bj[0].Draw(g, screenX + obj[0].worldX, screenY + obj[0].worldY);
            }
            worldCol++;
            if(worldCol == width)
            {
                worldCol = 0;
                worldRow ++;
            }
        }

        for(int i = 0; i < obj.length; i++)
        {
            if(obj[i] != null)
            {

                int screenX_prim = (refLink.GetWidth()/2 - tileSize/2);
                int screenY_prim = (refLink.GetHeight()/2 - tileSize/2);

                int screenX = obj[i].worldX - (int)hero.GetX() + screenX_prim;  //getX->world coord, celalalt termen in loc de screenX
                int screenY = obj[i].worldY - (int)hero.GetY() + screenY_prim;

                if(obj[i].worldX + tileSize > (int)hero.GetX() - screenX_prim &&
                        obj[i].worldX - tileSize < (int)hero.GetX() + screenX_prim &&
                        obj[i].worldY + tileSize > (int)hero.GetY() - screenY_prim &&
                        obj[i].worldY - tileSize < (int)hero.GetY() + screenY_prim)    //verifica daca se afla in aria vizuala a playerului
                {
                    //g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                    obj[i].Draw(g, screenX, screenY, obj[i].height, obj[i].width);
                }
            }
        }

//        for(int worldY = 0; worldY < height; worldY++)
//        {
//            for(int worldX = 0; worldX < width; worldX++)
//            {
//                int tileX = worldX * Tile.TILE_HEIGHT;
//                int tileY = worldY * Tile.TILE_WIDTH;
//                Hero hero = refLink.getHero();
//
//                int heroX = (int)hero.GetX();
//                int heroY = (int)hero.GetY();
//                int heroSX = (refLink.GetWidth()/2 - tileSize/2);
//                int heroSY = (refLink.GetHeight()/2 - tileSize/2);
//
//                int screenX = tileX - heroX + heroSX;
//                int screenY = tileY - heroY + heroSY;
//
//                if(
//                        tileX + Tile.TILE_HEIGHT > heroX - heroSX &&
//                                tileX - Tile.TILE_HEIGHT < heroX + heroSX &&
//                                tileY + Tile.TILE_WIDTH > heroY - heroSY &&
//                                tileY - Tile.TILE_WIDTH < heroY + heroSY
//                )
//                {
//                    GetTile(worldX, worldY).Draw(g, screenX, screenY);
//                }
//            }
//        }
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.F;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.F;
        }
        return t;
    }


    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    public void loadMap(String filePath)
    {
        try
        {
            Scanner input = new Scanner(new File(filePath));
            while (input.hasNextInt())
            {
                height = input.nextInt();
                width = input.nextInt();
                tiles = new int[width][height];
                for(int y = 0; y < height; y++)
                {
                    for(int x = 0; x < width; x++)
                    {
                        tiles[y][x] = input.nextInt();
                    }
                }
            }
            input.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

//    private void LoadWorld()
//    {
//        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
//        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
//            ///Se stabileste latimea hartii in numar de dale.
//        width = 20;
//            ///Se stabileste inaltimea hartii in numar de dale
//        height = 10;
//            ///Se construieste matricea de coduri de dale
//        tiles = new int[width][height];
//            //Se incarca matricea cu coduri
//        for(int y = 0; y < height; y++)
//        {
//            for(int x = 0; x < width; x++)
//            {
//                tiles[x][y] = MiddleEastMap(y, x);
//            }
//        }
//    }
//
//    /*! \fn private int MiddleEastMap(int x ,int y)
//        \brief O harta incarcata static.
//
//        \param x linia pe care se afla codul dalei de interes.
//        \param y coloana pe care se afla codul dalei de interes.
//     */
//    private int MiddleEastMap(int x ,int y)
//    {
//            ///Definire statica a matricei de coduri de dale.
//        final int map[][] = {
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
//        {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//        return map[x][y];
//    }

}