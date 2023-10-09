package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie

    public static Tile F = new F(0);
    
    public static Tile TI = new TI(1);
    public static Tile TLC = new TLC(2);
    public static Tile TRC = new TRC(3);
    public static Tile TDE = new TDE(4);
    public static Tile TLE = new TLE(5);
    public static Tile TRE = new TRE(6);

    public static Tile WI = new WI(7);
    public static Tile WLDC = new WLDC(8);
    public static Tile WRDC = new WRDC(9);
    public static Tile WLUC = new WLUC(10);
    public static Tile WRUC = new WRUC(11);
    public static Tile WUE = new WUE(12);
    public static Tile WDE = new WDE(13);
    public static Tile WLE = new WLE(14);
    public static Tile WRE = new WRE(15);
    public static Tile W = new W(16);
    public static Tile WU = new WU(17);
    public static Tile WD = new WD(18);
    public static Tile WL = new WL(19);
    public static Tile WR = new WR(20);
    public static Tile WV = new WV(21);
    public static Tile WO = new WO(22);

    public static Tile M1F = new M1F(23);
    public static Tile M1DE = new M1DE(24);
    public static Tile M1LE = new M1LE(25);
    public static Tile M1RE = new M1RE(26);
    public static Tile M1W = new M1W(27);
    public static Tile M1WD = new M1WD(28);


    

    public static final int TILE_WIDTH  = 64;                       /*!< Latimea unei dale.*/ //initial 32
    public static final int TILE_HEIGHT = 64;                       /*!< Inaltimea unei dale.*/ //initial 32

    public static final int tileSize = 64;

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }
}
