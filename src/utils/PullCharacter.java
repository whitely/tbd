package utils;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;

public class pullCharacter {

	//then this will get you the image at 
	public static BufferedImage getRedHero(){
		BufferedImage humanRedHeroImg = null;
		try{
		humanRedHeroImg = ImageIO.read(new File("character art/players/humanredhero.png"));
		} catch (IOException e) {}
	
		return humanRedHeroImg;	
	}

	public static BufferedImage getKnight(){
		BufferedImage humanKnightImg = null;
		try{
		humanKnightImg = ImageIO.read(new File("character art/players/humanknight.png"));
		} catch (IOException e) {}

		return humanKnightImg;
	}
	
	public static BufferedImage getSilverHero(){
		BufferedImage humanSilverHeroImg = null;
		try{
		humanSilverHeroImg = ImageIO.read(new File("character art/players/humansilverhero.png"));
		} catch (IOException e) {}

		return humanSilverHeroImg;
	}

	public static BufferedImage getGoldenHero(){
			BufferedImage humanGoldenHeroImg = null;
			try{
			humanGoldenHeroImg = ImageIO.read(new File("character art/players/humangoldenhero.png"));
			} catch (IOException e) {}

			return humanGoldenHeroImg;
	}

	public static BufferedImage getGeneric(){
			BufferedImage humanGenericImg = null;
			try{
			humanGenericImg = ImageIO.read(new File("character art/players/humangeneric.png"));
			} catch (IOException e) {}

			return humanGenericImg;
	}


	public static BufferedImage getFireFox(){
		BufferedImage humanFireFoxImg = null;
		try{
		humanFireFoxImg = ImageIO.read(new File("character art/players/humanfirefox.png"));
		} catch (IOException e) {}

		return humanFireFoxImg;
	}
}