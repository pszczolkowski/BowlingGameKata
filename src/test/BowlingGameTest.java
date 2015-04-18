package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void gameWithNoKnockDowns_expectedScore0() {
		Game game = new Game();
		
		for( int i = 0; i < 20 ; i++ )
			game.roll( 0 );
		
		assertThat( game , finishedWithScore( 0 ) );
	}

}
