package matsudda;

public class Card {
	private int card1, card2;
	private int priority;

	public Card() {
		card1 = (int) (Math.random() * 20);
		card2 = (int) (Math.random() * 20);
		while (card2 == card1) {
			card2 = (int) (Math.random() * 20);
		}

		// priority 설정
	} // Card()

	public Card(int userCard1, int userCard2) {
		card1 = (int) (Math.random() * 20);
		while (card1 == userCard1 || card2 == userCard2) {
			card1 = (int) (Math.random() * 20);
		}
		card2 = (int) (Math.random() * 20);
		while (card2 == card1 || card2 == userCard1 || card2 == userCard2) {
			card2 = (int) (Math.random() * 20);
		}
		// priority 설정

	} // Card()

	public void setCard() {
		card1 = (int) (Math.random() * 20);
		card2 = (int) (Math.random() * 20);
		while (card2 == card1) {
			card2 = (int) (Math.random() * 20);
		}
	} // setCard()

	public void setCard(int userCard1, int userCard2) {
		card1 = (int) (Math.random() * 20);
		while (card1 == userCard1 || card2 == userCard2) {
			card1 = (int) (Math.random() * 20);
		}
		card2 = (int) (Math.random() * 20);
		while (card2 == card1 || card2 == userCard1 || card2 == userCard2) {
			card2 = (int) (Math.random() * 20);
		}
	} // setCard()

	public int getCard1() {
		return card1;
	}

	public int getCard2() {
		return card2;
	}

	public int getPriority() {
		return priority;
	}
} // Card class
