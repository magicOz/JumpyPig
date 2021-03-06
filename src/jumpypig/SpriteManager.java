package jumpypig;

import java.awt.Image;

import javax.swing.ImageIcon;

public final class SpriteManager {

		private static SpriteManager instance;
		
		//SPRITES URL
		private final String IMG_URL_PLATFORMBLOCK = "/Sprites/block.png";
		private final String IMG_URL_CLOUD_1 = "/Sprites/cloud_1.png";
		private final String IMG_URL_CLOUD_2 = "/Sprites/cloud_2.png";
		private final String IMG_URL_PLATFORM_LEFT = "/Sprites/platform_left.png";
		private final String IMG_URL_PLATFORM_RIGHT = "/Sprites/platform_right.png";
		private final String IMG_URL_PLATFORM_TOP = "/Sprites/platform_top.png";
		private final String IMG_URL_PLATFORM_BOTTOM = "/Sprites/platform_bottom.png";
		private final String IMG_URL_BACKGROUND = "/background.png";
		private final String IMG_URL_LOGO = "/logo.png";
		private final String IMG_URL_STARTBUTTON = "/menu_btn_start.png";
		private final String IMG_URL_HIGHSCOREBUTTON = "/menu_btn_highscore.png";
		private final String IMG_URL_EXITBUTTON = "/menu_btn_exit.png";
		private final String IMG_URL_RESTARTBUTTON = "/menu_btn_restart.png";
		private final String IMG_URL_RESUMEBUTTON = "/menu_btn_resume.png";
		private final String IMG_URL_SUBMITHIGHSCOREBUTTON = "/menu_btn_submit_highscore.png";
		private final String IMG_URL_MAINMENUBUTTON = "/menu_btn_main_menu.png";
		private final String IMG_URL_MENUHIGHLIGHT = "/menu_btn_pig.png";
		private final String IMG_URL_PLATFORMOFDEATH = "/Sprites/platform_of_death.png";
		private final String IMG_URL_BACKGROUNDMOUNTAIN = "/background_mountain.png";
		
		//SPRITES IMAGES
		public final Image IMAGE_PLATFORMBLOCK;
		public final Image IMAGE_CLOUD_1;
		public final Image IMAGE_CLOUD_2;
		public final Image IMAGE_PLATFORM_LEFT;
		public final Image IMAGE_PLATFORM_RIGHT;
		public final Image IMAGE_PLATFORM_TOP;
		public final Image IMAGE_PLATFORM_BOTTOM;
		public final Image IMAGE_BACKGROUND;
		public final Image IMAGE_LOGO;
		public final Image IMAGE_STARTBUTTON;
		public final Image IMAGE_HIGHSCOREBUTTON;
		public final Image IMAGE_EXITBUTTON;
		public final Image IMAGE_RESTARTBUTTON;
		public final Image IMAGE_RESUMEBUTTON;
		public final Image IMAGE_SUBMITHIGHSCOREBUTTON;
		public final Image IMAGE_MAINMENUBUTTON;
		public final Image IMAGE_MENUHIGHLIGHT;
		public final Image IMAGE_PLATFORMOFDEATH;
		public final Image IMAGE_BACKGROUNDMOUNTAIN;
		
		private SpriteManager() {
			//INIT.
			IMAGE_PLATFORMBLOCK = new ImageIcon(this.getClass().getResource(IMG_URL_PLATFORMBLOCK)).getImage();
			IMAGE_CLOUD_1 = new ImageIcon(this.getClass().getResource(IMG_URL_CLOUD_1)).getImage();
			IMAGE_CLOUD_2 = new ImageIcon(this.getClass().getResource(IMG_URL_CLOUD_2)).getImage();
			IMAGE_PLATFORM_LEFT = new ImageIcon(this.getClass().getResource(IMG_URL_PLATFORM_LEFT)).getImage();
			IMAGE_PLATFORM_RIGHT = new ImageIcon(this.getClass().getResource(IMG_URL_PLATFORM_RIGHT)).getImage();
			IMAGE_PLATFORM_TOP = new ImageIcon(this.getClass().getResource(IMG_URL_PLATFORM_TOP)).getImage();
			IMAGE_PLATFORM_BOTTOM = new ImageIcon(this.getClass().getResource(IMG_URL_PLATFORM_BOTTOM)).getImage();
			IMAGE_BACKGROUND = new ImageIcon(this.getClass().getResource(IMG_URL_BACKGROUND)).getImage();
			IMAGE_LOGO = new ImageIcon(this.getClass().getResource(IMG_URL_LOGO)).getImage();
			IMAGE_STARTBUTTON = new ImageIcon(this.getClass().getResource(IMG_URL_STARTBUTTON)).getImage();
			IMAGE_HIGHSCOREBUTTON = new ImageIcon(this.getClass().getResource(IMG_URL_HIGHSCOREBUTTON)).getImage();
			IMAGE_EXITBUTTON = new ImageIcon(this.getClass().getResource(IMG_URL_EXITBUTTON)).getImage();
			IMAGE_MENUHIGHLIGHT = new ImageIcon(this.getClass().getResource(IMG_URL_MENUHIGHLIGHT)).getImage();
			IMAGE_PLATFORMOFDEATH = new ImageIcon(this.getClass().getResource(IMG_URL_PLATFORMOFDEATH)).getImage();
			IMAGE_BACKGROUNDMOUNTAIN = new ImageIcon(this.getClass().getResource(IMG_URL_BACKGROUNDMOUNTAIN)).getImage();
			IMAGE_RESTARTBUTTON = new ImageIcon(this.getClass().getResource(IMG_URL_RESTARTBUTTON)).getImage();
			IMAGE_RESUMEBUTTON = new ImageIcon(this.getClass().getResource(IMG_URL_RESUMEBUTTON)).getImage();
			IMAGE_SUBMITHIGHSCOREBUTTON = new ImageIcon(this.getClass().getResource(IMG_URL_SUBMITHIGHSCOREBUTTON)).getImage();
			IMAGE_MAINMENUBUTTON = new ImageIcon(this.getClass().getResource(IMG_URL_MAINMENUBUTTON)).getImage();
		}
		
		public static SpriteManager getInstance() {
			if(instance == null) {
				synchronized (SpriteManager.class) {
					if(instance == null) {
						instance = new SpriteManager();
					}
				}
			}
			return instance;
		}
	
}
