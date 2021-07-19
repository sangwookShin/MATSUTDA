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
		} // p1�� ���� �� ���� �а� ������ ����

		if (p1 == 02 && p2 == 07) {
			winRating = 0;
		} // 38 ����
		else if (p1 == 00 && (p2 == 02 || p2 == 07)) {
			winRating = 1;
		} // 13,18 ����
		else if (p1 % 10 == p2 % 10) {
			winRating = 11 - p1 % 10; // �嶯 2 ~ 1�� 11
		} // ���� ����
		else if (p1 % 10 == 0 && p2 % 10 == 1) {
			winRating = 12;
		} // �˸�
		else if (p1 % 10 == 0 && p2 % 10 == 3) {
			winRating = 13;
		} // ����
		else if (p1 % 10 == 0 && p2 % 10 == 8) {
			winRating = 14;
		} // ����
		else if (p1 % 10 == 0 && p2 % 10 == 9) {
			winRating = 15;
		} // ���
		else if (p1 % 10 == 3 && p2 % 10 == 7) {
			winRating = 16;
		} // ���
		else if (p1 % 10 == 5 && p2 % 10 == 8) {
			winRating = 17;
		} // ����
		else if (p1 % 10 == 3 && p2 % 10 == 8) {
			if (p1 == 13 && p2 == 18) {
				winRating = -1;
			} // ���ֱ��� ����
			else {
				winRating = -2;
			} // ����
		} // ����
		else if (p1 % 10 == 2 && p2 % 10 == 6) {
			winRating = -3;
		} // ������ 3~11�� �̰ܾ� �� (�嶯�� ���̱�� ���� ���� ����)
		else if (p1 == 13 && p2 == 16) {
			winRating = -4;
		} // ������ (���� ���� 1��)
		else if (p1 % 10 + p2 % 10 == 7) {
			winRating = 18;
		} // ���� 9���� ������ �θ�
		else if (p1 % 10 + p2 % 10 == 8) {
			winRating = 40;
		} // ���� (���ٿ��� ���� ���� ��)
		else {
			p1++;
			p2++;
			winRating = (9 - ((p1 % 10 + p2 % 10)) % 10) + 18;
		}

	}
}