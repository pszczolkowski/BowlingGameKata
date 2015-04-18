package test;

import static org.junit.Assert.*;
import main.Game;

import org.hamcrest.Matcher;
import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void gameWithNoKnockDowns_expectedScore0() {
		Game game = new Game();
		
		for( int i = 0; i < 20 ; i++ )
			game.roll( 0 );
		
		assertThat( game , finishedWithScore( 0 ) );
	}

	private Matcher<? super Game> finishedWithScore(int score) {
		return new GameScoreMather( score );
	}

}
