package test;

import main.Game;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class GameScoreMatcher extends TypeSafeMatcher<Game> {

	private int expectedScore;

	public GameScoreMatcher(int expectedScore) {
		this.expectedScore = expectedScore;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText( " a game with score of " ).appendValue( expectedScore );
	}
	
	@Override
	protected void describeMismatchSafely(Game game,
			Description description) {
		description.appendText( " a game with score of " ).appendValue( game.score() );
	}

	@Override
	protected boolean matchesSafely(Game game) {
		return game.score() == expectedScore;
	}
	
	public static Matcher<? super Game> endedWithScore(int expectedScore) {
		return new GameScoreMatcher( expectedScore );
	}

}
