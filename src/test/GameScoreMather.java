package test;

import main.Game;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class GameScoreMather extends TypeSafeMatcher< Game > {

	private int score;

	public GameScoreMather(int score) {
		this.score = score;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText( " a game with score " ).appendValue( score );
	}
	
	@Override
	protected void describeMismatchSafely(Game game, Description description) {
		description.appendText( " a game with score " ).appendValue( game.score() );
	}

	@Override
	protected boolean matchesSafely(Game game) {
		return game.score() == score;
	}
	
	public static Matcher<? super Game> finishedWithScore(int score) {
		return new GameScoreMather( score );
	}

}
