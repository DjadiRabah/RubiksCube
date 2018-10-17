import java.util.Scanner;

import graphic2d.Window;
import shuffle.ShuffleRandom;

public class Test 
{
	public static void main(String[] args)
	{
		/*boolean over = false;
		cube.Cube c = new cube.Cube(3);
		c.shuffle(new ShuffleRandom());
		Scanner sc = new Scanner(System.in); 
		
		while(!over)
		{
			System.out.println();
			System.out.println(c);
			System.out.println("1. Tourner une ligne vers la gauche");
			System.out.println("2. Tourner une ligne vers la droite");
			System.out.println("3. Tourner une colonne vers la haut");
			System.out.println("4. Tourner une colonne vers le bas");
			System.out.println("5. Tourner une face dans le sens horaire");
			System.out.println("6. Tourner une face dans le sens trigo");
			System.out.println();
			System.out.println("7. Tourner le cube vers la gauche");
			System.out.println("8. Tourner le cube vers la droite");
			System.out.println("9. Tourner le cube vers la haut");
			System.out.println("10. Tourner le cube vers le bas");
			System.out.println("11. Tourner le cube dans le sens horaire");
			System.out.println("12. Tourner le cube dans le sens trigo");
			System.out.println();
			System.out.println("13. Quitter");
			int rotation = sc.nextInt();
			
			if((rotation >= 0) && (rotation <= 6))
			{
				int indice;
				if((rotation == 1) || (rotation == 2))
					System.out.println("Quelle ligne ?");
				else if((rotation == 3) || (rotation == 4))
					System.out.println("Quelle colonne ?");
				else if((rotation == 5) || (rotation == 6))
					System.out.println("Quelle face ?");
				indice = sc.nextInt();
				c.rotate(rotation-1, indice-1, 1);
			}
			else if((rotation >= 7) && (rotation <= 12))
			{
				c.rotate(rotation - 7, 1);	
			}
			else if(rotation == 13)
			{
				over = true;
			}
			
			if(c.isSolved())
			{
				over = true;
				System.out.println();
				System.out.println(c);
				System.out.println("GG WP");
			}
		}
		sc.close(); */
		Window w = new Window();
		w.setVisible(true);
		
	}
}
