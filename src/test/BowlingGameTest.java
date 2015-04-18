package test;

import static org.junit.Assert.assertThat;
import static test.GameScoreMather.finishedWithScore;
import main.Game;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void gameWithNoKnockDowns_expectedScore0() {
		Game game = new Game();		
		rollMany(game, 0, 20);
		
		assertThat( game , finishedWithScore( 0 ) );
	}

	private void rollMany(Game game, int pins, int n) {
		for( int i = 0; i < n ; i++ ) {
			game.roll( pins );
		}
	}

}
