


public class Players extends AbstractPlayer {
	/**
	 * constructor
	 * @param playerId - playerNumber
	 * @param chip
	 */
	public Players(Integer playerId, Chip chip) {
		super(playerId, chip);
	}
	/**
	 * @return playerId - String
	 */
	public String toString() {
		String str = getPlayerId().toString();
		return str;
	}
}
