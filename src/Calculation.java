package matsudda;

public class Calculation {

	int p1, p2;
	int winRating;

	public Calculation(int p1, int p2) {
		if (p1 > p2) {
			int temp;

			temp = p1;
			p1 = p2;
			p2 = temp;
		} // p1에 값이 더 작은 패가 오도록 변경

		if (p1 == 02 && p2 == 07) {
			winRating = 0;
		} // 38 광떙
		else if (p1 == 00 && (p2 == 02 || p2 == 07)) {
			winRating = 1;
		} // 13,18 광떙
		else if (p1 % 10 == p2 % 10) {
			winRating = 11 - p1 % 10; // 장땡 2 ~ 1땡 11
		} // 각종 광떙
		else if (p1 % 10 == 0 && p2 % 10 == 1) {
			winRating = 12;
		} // 알리
		else if (p1 % 10 == 0 && p2 % 10 == 3) {
			winRating = 13;
		} // 독사
		else if (p1 % 10 == 0 && p2 % 10 == 8) {
			winRating = 14;
		} // 구삥
		else if (p1 % 10 == 0 && p2 % 10 == 9) {
			winRating = 15;
		} // 장삥
		else if (p1 % 10 == 3 && p2 % 10 == 7) {
			winRating = 16;
		} // 장사
		else if (p1 % 10 == 5 && p2 % 10 == 8) {
			winRating = 17;
		} // 새륙
		else if (p1 % 10 == 3 && p2 % 10 == 8) {
			if (p1 == 13 && p2 == 18) {
				winRating = -1;
			} // 멍텅구리 구사
			else {
				winRating = -2;
			} // 구사
		} // 구사
		else if (p1 % 10 == 2 && p2 % 10 == 6) {
			winRating = -3;
		} // 떙잡이 3~11을 이겨야 함 (장땡은 못이기고 땡이 없음 망통)
		else if (p1 == 13 && p2 == 16) {
			winRating = -4;
		} // 암행어사 (광떙 없음 1끗)
		else if (p1 % 10 + p2 % 10 == 7) {
			winRating = 18;
		} // 갑오 9끗은 갑오라 부름
		else if (p1 % 10 + p2 % 10 == 8) {
			winRating = 40;
		} // 망통 (섯다에서 가장 낮은 패)
		else {
			p1++;
			p2++;
			winRating = (9 - ((p1 % 10 + p2 % 10)) % 10) + 18;
		}

	}
}