package jumpypig;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	
	private int NUMBER_OF_PLATFORMS;
	private int PLATFORM_SPEED;
	private int NUMBER_OF_CLOUDS;
	private int LEVEL;
	
	private int MAX_CLOUD_RANGE;
	
	private final int PLATFORM_ORDINARY = 0;
	private final int PLATFORM_BLOCK = 2;
	private final int PLATFORM_OF_DEATH = 3;
	private final int PLATFORM_ELEVATOR = 1;
	
	private ArrayList<GameObject> platforms;
	private ArrayList<GameObject> clouds;
	
	private Random rand;
	
	
	public ObjectManager() {
		//INIT.
		LEVEL = 0;
		NUMBER_OF_PLATFORMS = 5;
		PLATFORM_SPEED = 5;
		NUMBER_OF_CLOUDS = 5;
		MAX_CLOUD_RANGE = GameFrame.SCREENSIZE.height/3;
		
		
		platforms = new ArrayList<GameObject>();
		clouds = new ArrayList<GameObject>();
		
		rand = new Random();
	}
	
	public void setNumberOfPlatforms(int n) {
		NUMBER_OF_PLATFORMS = n;
	}
	
	public void setNumberOfClouds(int n) {
		NUMBER_OF_CLOUDS = n;
	}
	
	public void setPlatformSpeed(int n) {
		PLATFORM_SPEED = n;
	}
	
	public void setMaxCloudRange(int n) {
		MAX_CLOUD_RANGE = n;
	}
	
	public void setLevel(int n) {
		LEVEL = n;
	}

	/**
	 * Add start objects
	 */
	public void initObjects() {
		platforms.add(new Platform(0, GameFrame.SCREENSIZE.height - 200, 20));
	}
	
	/**
	 * Handle number of objects, create new if needed 
	 */
	private void manageObjects() {
		//CHECK PLATFORMS
		if(NUMBER_OF_PLATFORMS > platforms.size()) {			
			int add = NUMBER_OF_PLATFORMS - platforms.size();
			
			//ADD MISSING OBJECTS
			for(int i=0;i<add;i++) {
				//Previous platform
				Platform prevPlatform = (Platform) platforms.get(platforms.size()-1);
				
				//Generate platform type
				int platformType = rand.nextInt(LEVEL+1);
				int posX = prevPlatform.getX() + prevPlatform.getWidth() + 40 + rand.nextInt(300);
				int posY = prevPlatform.getY() - 200 + rand.nextInt(400);
				//Correct if not visible
				
				if(posY + 40 >= GameFrame.SCREENSIZE.height) {
					posY = GameFrame.SCREENSIZE.height - 100;
				}
				//Lower limit
				else if(posY <= 10) {
					posY = 40;
				}
				int length = 1 + rand.nextInt(8);
				
				//Ordinary platform
				if(platformType == PLATFORM_ORDINARY) {
					Platform p = new Platform(posX, posY, length);
					platforms.add(p);
				}
				//Platform of death
				else if(platformType == PLATFORM_OF_DEATH) {
					
					Platform p = new PlatformBlock(posX, posY, length);
					platforms.add(p);
					p = new PlatformOfDeath(posX - 40, posY + 100, length);
					platforms.add(p);
				}
				//Platform block
				else if(platformType == PLATFORM_BLOCK) {
					Platform p = new PlatformBlock(posX, posY, length);
					platforms.add(p);
				}
				//Platform elevator
				else if(platformType == PLATFORM_ELEVATOR) {
					Platform p = new PlatformElevator(posX, posY, length);
					platforms.add(p);
				}
				
			}
			
		}
		//END PLATFORMS
		
		//CHECK CLOUDS
		if(NUMBER_OF_CLOUDS > clouds.size()) {
			int add = NUMBER_OF_CLOUDS - clouds.size();
			
			//ADD MISSING OBJECTS
			for(int i=0;i<add;i++) {
				Cloud p = new Cloud(GameFrame.SCREENSIZE.width + rand.nextInt(100),rand.nextInt(MAX_CLOUD_RANGE),rand.nextInt(50));
				clouds.add(p);
			}
			
		}
	}
	
	//UPDATE ALL OBJECTS
	public void update(PanelView gv) {
		
		//UPDATE PLATFORMS
		Iterator<GameObject> it = platforms.iterator();
		//Collided with player
		boolean collided = false;
		while(it.hasNext()) {
			Platform platform = (Platform) it.next();
			
			//MOVE PLATFORM
			platform.moveX(-1*PLATFORM_SPEED);
			
			if(!platform.isVisible()) {
				it.remove();
			}
			
			//IF NOT DEMO PLAY - CHECK FOR COLLISIONS WITH PLAYER
			if(gv instanceof GameView) {

				//COLLISION WITH PLAYER
				if(platform.intersecting(((GameView) gv).getPlayer().getJumpRect())) {
					collided = true;
					
					//Handle collision
					platform.collidePlayer(((GameView) gv).getPlayer());	
				}
				
			}
			
		}
		
		//if in gameplay - change state of player
		if(gv instanceof GameView) {
			if(!collided) {
				((GameView) gv).getPlayer().setState(Player.FALLING_STATE);
			}
		}
		//END PLATFORMS
		
		//UPDATE CLOUDS
		it = clouds.iterator();
		while(it.hasNext()) {
			Cloud cloud = (Cloud) it.next();

			//MOVE CLOUD
			cloud.moveX(cloud.getSpeed()*-1);
			
			//REMOVE IF OUTSIDE
			if(!cloud.isVisible()) {
				it.remove();
			}
		}
		//END CLOUDS
		
		
		
		//CORRECT NUMBER OF OBJECTS
		manageObjects();
	}
	
	public void paint(Graphics2D g) {
		
		//PAINT CLOUDS
		for(int i=0;i<clouds.size();i++){
			clouds.get(i).paint(g);
		}

		//PAINT PLATFORMS
		for(int i=0;i<platforms.size();i++){
			platforms.get(i).paint(g);
		}
		
	}

}
