package PaooGame.Graphics;

import PaooGame.Items.OBJ.OBJ_drower;
import PaooGame.Items.OBJ.OBJ_table;
import PaooGame.Items.OBJ.SuperObject;
import PaooGame.Tiles.Tile;
import PaooGame.Tiles.WI;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
//    public static BufferedImage soil;
//    public static BufferedImage grass;
    
    public static BufferedImage F;
    
    public static BufferedImage TI;
    public static BufferedImage TLC;
    public static BufferedImage TRC;
    public static BufferedImage TDE;
    public static BufferedImage TLE;
    public static BufferedImage TRE;

    public static BufferedImage WI;
    public static BufferedImage WLDC;
    public static BufferedImage WRDC;
    public static BufferedImage WLUC;
    public static BufferedImage WRUC;
    public static BufferedImage WUE;
    public static BufferedImage WDE;
    public static BufferedImage WLE;
    public static BufferedImage WRE;
    public static BufferedImage W;
    public static BufferedImage WU;
    public static BufferedImage WD;
    public static BufferedImage WL;
    public static BufferedImage WR;
    public static BufferedImage WV;
    public static BufferedImage WO;

    public static BufferedImage M1F;
    public static BufferedImage M1W;
    public static BufferedImage M1WD;
    public static BufferedImage M1LE;
    public static BufferedImage M1RE;
    public static BufferedImage M1DE;

    public static BufferedImage table;
    public static BufferedImage drower;


    public static BufferedImage heroLeft1;
    public static BufferedImage heroLeft2;
    public static BufferedImage heroRight1;
    public static BufferedImage heroRight2;
    public static BufferedImage heroUp1;
    public static BufferedImage heroUp2;
    public static BufferedImage heroDown1;
    public static BufferedImage heroDown2;


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilwaWwdizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/tiles.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.

        F = sheet.crop(3, 0);
        
        TI = sheet.crop(1, 0);
        TLC = sheet.crop(0, 1);
        TRC = sheet.crop(2, 1);
        TDE = sheet.crop(1, 1);
        TRE = sheet.crop(2, 0);
        TLE = sheet.crop(0, 0);

        WI = sheet.crop(1, 4);
        WLDC = sheet.crop(0, 5);
        WRDC = sheet.crop(2, 5);
        WLUC = sheet.crop(0, 3);
        WRUC = sheet.crop(2, 3);
        WUE = sheet.crop(1, 3);
        WDE = sheet.crop(1, 5);
        WLE = sheet.crop(0, 4);
        WRE = sheet.crop(2, 4);
        W = sheet.crop(3, 5);
        WU = sheet.crop(3, 2);
        WD = sheet.crop(3, 4);
        WL = sheet.crop(0, 2);
        WR = sheet.crop(2, 2);
        WV = sheet.crop(3, 3);
        WO = sheet.crop(1, 2);

        M1F = sheet.crop(4,0);
        M1DE = sheet.crop(5,1);
        M1LE = sheet.crop(6,1);
        M1RE = sheet.crop(4,1);
        M1W = sheet.crop(5,0);
        M1WD = sheet.crop(6,0);


        table = ImageLoader.LoadImage("/textures/objects/table.png");
        drower = ImageLoader.LoadImage("/textures/objects/drower.png");

        SuperObject.obj[0] = new OBJ_table(0, 13, 5, 40*32, 32*40);
        SuperObject.obj[1] = new OBJ_drower(1, 20, 15, 32*40, 32*40);


        SpriteSheet hero_sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/herosheeet.png"));

        heroLeft1 = hero_sheet.crop_hero(1,1);      //ImageLoader.LoadImage("/textures/boy_left_1.png");
        heroLeft2 = hero_sheet.crop_hero(1,0);      //ImageLoader.LoadImage("/textures/boy_left_2.png");
        heroRight1 = hero_sheet.crop_hero(0,0);     //ImageLoader.LoadImage("/textures/boy_right_1.png");
        heroRight2 = hero_sheet.crop_hero(0,1);     //ImageLoader.LoadImage("/textures/boy_right_2.png");
        heroUp1 = hero_sheet.crop_hero(3,0);        //ImageLoader.LoadImage("/textures/boy_up_1.png");
        heroUp2 = hero_sheet.crop_hero(3, 1);       //ImageLoader.LoadImage("/textures/boy_up_2.png");
        heroDown1 = hero_sheet.crop_hero(2,0);      //ImageLoader.LoadImage("/textures/boy_down_1.png");
        heroDown2 = hero_sheet.crop_hero(2, 1);     //ImageLoader.LoadImage("/textures/boy_down_2.png");
    }
}
