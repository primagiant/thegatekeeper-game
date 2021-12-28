import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (giant and adiani) 
 * @version (0.1 alpha)
 */
public class MyWorld extends World
{
    private int frame = 0;
    private int spawnSpeed = 180; // semakin kecil angkanya semakin cepat spawn enemynya
    public int randomSpawnPosition;
    
    public static Guardian guardian = new Guardian();
    
    public MyWorld()
    {    
        super(600, 600, 1); 
        prepare();
    }
    
    private void prepare() 
    {   
        addObject(guardian, 300, 350);
        addObject(new Portal(), getWidth()/2, getHeight()/2);

        wallSetup();

        Counter counter = new Counter("Health : ");
        addObject(counter,51,573);
        Counter counter2 = new Counter("Score : ");
        addObject(counter2,51,24);
    }
    
    public void act() 
    {
        spawnEnemy();
        frame++;
    }
    
    private void spawnEnemy()
    {
        if(frame % spawnSpeed == 80){
            randomSpawnPosition = Greenfoot.getRandomNumber(4);
            switch(randomSpawnPosition)
            {
                case 0 : addObject(new FireHead(), 0, getHeight()/2);break;
                case 1 : addObject(new FireHead(), getWidth(), getHeight()/2);break;
                case 2 : addObject(new FireHead(), getWidth()/2, 0);break;
                case 3 : addObject(new FireHead(), getWidth()/2, getHeight());break;
            }   
        }else if(frame % spawnSpeed == 0){
            randomSpawnPosition = Greenfoot.getRandomNumber(4);
            switch(randomSpawnPosition)
            {
                case 0 : addObject(new Skeleton(), 0, getHeight()/2);break;
                case 1 : addObject(new Skeleton(), getWidth(), getHeight()/2);break;
                case 2 : addObject(new Skeleton(), getWidth()/2, 0);break;
                case 3 : addObject(new Skeleton(), getWidth()/2, getHeight());break;
            }
        }else if(frame % spawnSpeed == 40){
            randomSpawnPosition = Greenfoot.getRandomNumber(4);
            switch(randomSpawnPosition)
            {
                case 0 : addObject(new Vampire(), 0, 0); break;
                case 1 : addObject(new Vampire(), getWidth(), 0);break;
                case 2 : addObject(new Vampire(), 0, getHeight()); break;
                case 3 : addObject(new Vampire(), getWidth(), getHeight());break;
            }
        }
    }
    
    private void wallSetup()
    {
          for (int i = 10; i < getHeight()/2-40; i+=20){
               addObject(new Wall(), 10, i);  
               addObject(new Wall(), getWidth()-10, i);
          }
          
          for (int i = getHeight()-10; i > getHeight()/2+40; i-=20){
               addObject(new Wall(), 10, i); 
               addObject(new Wall(), getWidth()-10, i);  
          }
          
          for (int i = 40; i < getWidth()/2-30; i+=30){
               addObject(new Wall(), i, 10); 
               addObject(new Wall(), i, getHeight()-10); 
          }
          
          for (int i = getWidth()-40; i > getWidth()/2+30; i-=30){
               addObject(new Wall(), i, 10); 
               addObject(new Wall(), i, getHeight()-10); 
          }
    }
}
