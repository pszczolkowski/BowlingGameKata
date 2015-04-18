package test;

import static org.junit.Assert.assertThat;
import static test.GameScoreMather.finishedWithScore;
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
	public void gameWithNoKnockDowns_expectedScore0() {
		rollMany(20 , 0);
		
		assertThat( game , finishedWithScore( 0 ) );
	}
	
	@Test
	public void gameWithAllOnes_expectedScore20(){
		rollMany(20 , 1);
		
		assertThat(game, finishedWithScore( 20 ));
	}
	
	@Test
	public void gameWithOneSpare_expectedScore16(){
		rollSpare();
		game.roll( 3 );
		rollMany( 17 , 0 );
		
		assertThat(game, finishedWithScore( 16 ));
	}
	
	@Test
	public void gameWithOneStrike_expectedScore24(){
		rollStrike();
		game.roll( 3 );
		game.roll( 4 );
		rollMany(16, 0);
		
		assertThat(game, finishedWithScore( 24 ));
	}
	
	@Test
	public void perfectGame_expectedScore300(){
		rollMany( 12 , 10 );
		assertThat(game, finishedWithScore( 300 ));
	}

	private void rollStrike() {
		game.roll( 10 );
	}
	private void rollSpare() {
		game.roll( 5 );
		game.roll( 5 );
	}
	private void rollMany( int n , int pins ) {
		for( int i = 0; i < n ; i++ ) {
			game.roll( pins );
		}
	}

}
