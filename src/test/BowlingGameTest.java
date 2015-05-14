package test;

import static org.junit.Assert.assertThat;
import static test.GameScoreMatcher.endedWithScore;
import main.Game;

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
	
	@Test
	public void allOneThrows_gameShouldEndWithScoreTwenty(){
		Game game = new Game();
		
		for( int i = 0 ; i < 20 ; i++ ){
			game.roll( 1 );
		}
		
		assertThat( game , endedWithScore( 20 ) );
	}

}
