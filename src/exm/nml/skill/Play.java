package exm.nml.skill;

import java.util.ArrayList;
import java.util.Collections;

public class Play {

	
	private static final String[] SUITES = {"Spades", "Hearts", "Diamonds", "Clubs"};
	private static final String[] CARDS = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	public ArrayList<String> deck = new ArrayList<String>(52);
	public int playerCount;
	
	private int STATUS = 0; 

	public Play(int playerCount) {

			// Do not initialize the Play if the number of players in Invalid
			if(playerCount<0 || playerCount>51)
			{
				STATUS = 400;
				return;
			}
			// Initialize Play if input is valid
			this.playerCount = playerCount;
					
			for(int i=0; i<SUITES.length; i++)
			{
				for(int j=0; j<CARDS.length; j++)
					deck.add(SUITES[i]+CARDS[j]);
			}
			STATUS = 200;

	}
	
	/*
	 * Shuffle the cards
	 */
	public void shuffle()
	{
		System.out.println("Shuffling Cards!!!!");
		Collections.shuffle(deck);
	}
	
	/*
	 * Print the current Deck
	 */
	public void print()
	{
		for(String card: deck)
			System.out.println(card);
	}
	
	/*
	 * Deal Cards to Players
	 */
	public void deal()
	{
		
		if (STATUS == 400)
		{
			System.out.println("Bad Input - Deck not properly initialized");
			return;
		}
		
		System.out.println("Dealing Cards!!!!");
		int count = 0;
		ArrayList<String[]> playerHands = new ArrayList<String[]>(playerCount);
		
		for(int i=0; i<playerCount; i++)
		{
			playerHands.add(new String[52/playerCount]);
			
			for(int j=0; j<52/playerCount; j++)
				playerHands.get(i)[j]= deck.get(count++);
			System.out.println("\n Player "+i +" Hand  :: ");
			for(int j=0; j<playerHands.get(i).length; j++)
			{
				System.out.print(playerHands.get(i)[j]+"   ");

			}
		}		
	}
	public int getStatus()
	{
		return STATUS;
	}
}
