package test;

import static org.junit.Assert.*;
import main.Game;

import org.hamcrest.Matcher;
import org.junit.Test;

public class BowlingGameTest {
	
	@Test
	public void testGutterGame(){
		Game game = new Game();
		
		for( int i = 0 ; i < 20 ; i++ ){
			game.roll( 0 );
		}
		
		assertThat( game , endedWithScore( 0 ) );
	}

	private Matcher<? super Game> endedWithScore(int expectedScore) {
		return new GameScoreMatcher( expectedScore );
	}

}
