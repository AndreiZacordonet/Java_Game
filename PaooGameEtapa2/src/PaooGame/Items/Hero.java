package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;

import static PaooGame.Tiles.Tile.tileSize;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    public final int screenX = refLink.GetWidth()/2 - tileSize/2;
    public final int screenY = refLink.GetHeight()/2 - tileSize/2;
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    private static Hero instance = null;
    public static Hero getInstance(RefLinks refLink, float x, float y)
    {
        if(instance == null)
        {
            instance = new Hero(refLink, x, y);
        }
        return instance;
    }

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    private Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        //refLink = new RefLinks(this);
        //this.refLink = refLink;
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
            ///Seteaza imaginea de start a eroului

        image = Assets.heroDown1;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        solidArea = new Rectangle();
        solidArea.x = 10;
        solidArea.y = 22;       //this is collision area
        solidAreaDefaultX =  solidArea.x;
        solidAreaDefaultY =  solidArea.y;
        solidArea.width = 40;
        solidArea.height = 35;

            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 14;
        attackBounds.width = 38;
        attackBounds.height = 50;
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
            ///Verifica daca a fost apasata o tasta
        GetInput();
            ///Actualizeaza pozitia
        collision = false;
        CollisionCheker cChecker = new CollisionCheker(refLink);
        cChecker.checkTile(this);
        int objIndex = cChecker.checkObj(this, true);
        if(!collision)
        {
            Move();
        }
            ///Actualizeaza imaginea
        if(refLink.GetKeyManager().left)
        {
            if (spriteNum == 1) {
                image = Assets.heroLeft1;
            }
            if (spriteNum == 2)
                image = Assets.heroLeft2;
        }
        if(refLink.GetKeyManager().right)
        {
            if (spriteNum == 1)
                image = Assets.heroRight1;
            if (spriteNum == 2)
                image = Assets.heroRight2;
        }
        if(refLink.GetKeyManager().down)
        {
            if (spriteNum == 1)
                image = Assets.heroDown1;
            if (spriteNum == 2)
                image = Assets.heroDown2;
        }
        if(refLink.GetKeyManager().up)
        {
            if (spriteNum == 1)
                image = Assets.heroUp1;
            if (spriteNum == 2)
                image = Assets.heroUp2;
        }

        spriteCounter++;
        if (spriteCounter > 13) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        float alterated_speed = speed;
            ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().boost)
        {
            alterated_speed = (float)4 * speed;
        }
        if(refLink.GetKeyManager().up)
        {
            yMove = -alterated_speed;
        }
            ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = alterated_speed;
        }
            ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            xMove = -alterated_speed;
        }
            ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = alterated_speed;
        }
        if(refLink.GetKeyManager().up && refLink.GetKeyManager().left)
        {
            xMove = (float)-0.7*alterated_speed;
            yMove = (float)-0.7*alterated_speed;
        }
        if(refLink.GetKeyManager().up && refLink.GetKeyManager().right)
        {
            xMove = (float)0.7*alterated_speed;
            yMove = (float)-0.7*alterated_speed;
        }
        if(refLink.GetKeyManager().down && refLink.GetKeyManager().left)
        {
            xMove = (float)-0.7*alterated_speed;
            yMove = (float)0.7*alterated_speed;
        }
        if(refLink.GetKeyManager().down && refLink.GetKeyManager().right)
        {
            xMove = (float)0.7*alterated_speed;
            yMove = (float)0.7*alterated_speed;
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafic in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)screenX, (int)screenY, width, height, null);

            ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        //g.setColor(Color.red);
        //g.fillRect((int)(screenX + solidArea.x), (int)(screenY + solidArea.y), solidArea.width, solidArea.height);
    }
}
