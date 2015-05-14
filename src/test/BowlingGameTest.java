package test;

import static org.junit.Assert.assertThat;
import static test.GameScoreMatcher.endedWithScore;
import main.Game;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	
	private Game game;

	@Before
	public void setUp(){
		game = new Game();
	}
	
	@Test
	public void testGutterGame(){
		rollMany(20, 0);
		assertThat( game , endedWithScore( 0 ) );
	}

	@Test
	public void allOneThrows_gameShouldEndWithScoreTwenty(){
		rollMany(20, 1);
		assertThat( game , endedWithScore( 20 ) );
	}
	
	@Test
	public void oneSpare_gameShouldEndWithScoreSixteen(){
		game.roll( 5 );
		game.roll( 5 );	// SPARE
		game.roll( 3 );
		rollMany(17, 0);
		
		assertThat( game , endedWithScore( 16 ) );
	}
	
	
	private void rollMany(int n, int pins) {
		for( int i = 0 ; i < n ; i++ ){
			game.roll( pins );
		}
	}

}
