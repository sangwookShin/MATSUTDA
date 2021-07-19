package matsudda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RuleExplanationPanel extends JPanel {
	private int selectedIndex = 0; // ���õǾ��ִ� ��ư �ε���
	private JPanel selectPanel, textImagePanel; // ��ư�� ����ִ� �г�, �̹����� �۷� �����ϴ� �г�
	private JLabel textLabel, textLabel2, textLabel3; // �ۼ��� ��
	protected JButton[] btnSelectArray; // ������ ��ư
	private HoveringListener hoverL; // ���콺Ŭ��������
	private ImageIcon[] cardImage; // ī���̹��������ܹ迭
	private JLabel[] cardLabel1, cardLabel2, cardLabel3; // ī���̹����� ���ִ� ��x3

	public RuleExplanationPanel() {
		// ��������, �������, ���̾ƿ�����
		setBackground(Color.yellow);
		setPreferredSize(new Dimension(1000, 760));
		setLayout(null);

		// ī���̹��������ܹ迭 ���� �� �󺧿� �ֱ�
		cardImage = new ImageIcon[20];
		for (int i = 0; i < 20; i++) {
			cardImage[i] = new ImageIcon("images/" + i + ".PNG");
		}
		cardLabel1 = new JLabel[20];
		cardLabel2 = new JLabel[20];
		cardLabel3 = new JLabel[20];
		for (int i = 0; i < 20; i++) {
			cardLabel1[i] = new JLabel(cardImage[i]);
			cardLabel2[i] = new JLabel(cardImage[i]);
			cardLabel3[i] = new JLabel(cardImage[i]);
		}

		// ���ʿ� ��ư���� �ִ� �����гλ���, ����, ���콺������add
		selectPanel = new JPanel();
		selectPanel.setBounds(20, 20, 160, 720);
		selectPanel.setBackground(Color.yellow);
		selectPanel.setLayout(new GridLayout(6, 1));
		add(selectPanel);

		hoverL = new HoveringListener();
		btnSelectArray = new JButton[6];
		for (int i = 0; i < 6; i++) {
			btnSelectArray[i] = new JButton(RuleExplanationConstants.JOKBO[i]);
			btnSelectArray[i].setFont(new Font("HY�߸��� ����", Font.BOLD, 16));
			btnSelectArray[i].setBackground(RuleExplanationConstants.JOKBO_EXIT[0]);
			btnSelectArray[i].setForeground(RuleExplanationConstants.JOKBO_EXIT[1]);
			btnSelectArray[i].addMouseListener(hoverL);
			selectPanel.add(btnSelectArray[i]);
		}
		btnSelectArray[0].setBackground(RuleExplanationConstants.JOKBO_ENTER[0]);
		btnSelectArray[0].setForeground(RuleExplanationConstants.JOKBO_ENTER[1]);

		// �����ʿ� �̹����� ���� �̿��� �����ϴ� �гλ���, ī���̹���add
		textImagePanel = new JPanel();
		textImagePanel.setBounds(180, 20, 800, 720);
		textImagePanel.setBackground(Color.white);
		textImagePanel.setLayout(null);
		add(textImagePanel);
		textLabel = new JLabel("<html>���ٴ� ȭ���� 2������ ���� ������ ������븦 �����ϴ� ���ð����Դϴ�.<br>"
				+ "���ȱ���, �嶯 ���� �Ϲ����� ������, ����, ������, ������ ���� Ư�� ������ ������ �ѳ���� ��ġ ������ ����˴ϴ�.<br>" + "��ü ȭ���д� 20���Դϴ�.<br>"
				+ "�������� ���� ����� ȭ���� 2���� ��� ���� ���� �����Ͽ� �ºθ� �����ϴ�.<br><br><br>"
				+ "�Ϲ����� : ����, ��, �˸�, ����, ����, ���, ���, ����, ����, ��, ����<br>" + "Ư������ : ����, ������, ������<br><br></html>");
		textLabel2 = new JLabel();
		textLabel3 = new JLabel();
		textLabel.setBounds(20, 20, 760, 680);
		textLabel.setFont(new Font("HY�߸��� ����", Font.BOLD, 23));
		textLabel2.setFont(new Font("HY�߸��� ����", Font.BOLD, 23));
		textLabel3.setFont(new Font("HY�߸��� ����", Font.BOLD, 23));
		textLabel.setVerticalAlignment(SwingConstants.CENTER);
		textLabel.setHorizontalAlignment(SwingConstants.LEFT);
		textLabel2.setVerticalAlignment(SwingConstants.TOP);
		textLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		textLabel3.setVerticalAlignment(SwingConstants.TOP);
		textLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		for (int i = 0; i < 20; i++) {
			textImagePanel.add(cardLabel1[i]);
			textImagePanel.add(cardLabel2[i]);
			textImagePanel.add(cardLabel3[i]);
		}
		textLabel.setVisible(true);
		textImagePanel.add(textLabel);
		textImagePanel.add(textLabel2);
		textImagePanel.add(textLabel3);
	}

	private class HoveringListener implements MouseListener {
		// ���콺�� ��ư�� Ŭ���� ��ư�� ���� ������ ����� �̹����� setvisible�� ���� ������
		public void mouseClicked(MouseEvent event) {
			JButton obj = (JButton) event.getSource();
			for (int i = 0; i < 6; i++) {
				// ���� ���õǾ� �ִ� ��ư�� �ٸ���� �ٲٰ� �������� ����
				if (obj == btnSelectArray[i]) {
					if (selectedIndex != i) {
						btnSelectArray[selectedIndex].setBackground(RuleExplanationConstants.JOKBO_EXIT[0]);
						btnSelectArray[selectedIndex].setForeground(RuleExplanationConstants.JOKBO_EXIT[1]);
						selectedIndex = i;
					}
					break;
				}
			}
			if (selectedIndex == 0) {
				for (int i = 0; i < 20; i++) {
					cardLabel1[i].setVisible(false);
					cardLabel2[i].setVisible(false);
					cardLabel3[i].setVisible(false);
				}
				textLabel.setVisible(false);
				textLabel2.setVisible(false);
				textLabel3.setVisible(false);
				textLabel.setVerticalAlignment(SwingConstants.CENTER);
				textLabel.setBounds(20, 20, 760, 680);
				textLabel.setText("<html>���ٴ� ȭ���� 2������ ���� ������ ������븦 �����ϴ� ���ð����Դϴ�.<br>"
						+ "���ȱ���, �嶯 ���� �Ϲ����� ������, ����, ������, ������ ���� Ư�� ������ ������ �ѳ���� ��ġ ������ ����˴ϴ�.<br>"
						+ "��ü ȭ���д� 20���Դϴ�.<br>" + "�������� ���� ����� ȭ���� 2���� ��� ���� ���� �����Ͽ� �ºθ� �����ϴ�.<br><br><br>"
						+ "�Ϲ����� : ����, ��, �˸�, ����, ����, ���, ���, ����, ����, ��, ����<br>"
						+ "Ư������ : ����, ������, ������<br><br></html>");
				textLabel.setVisible(true);
			} else if (selectedIndex == 1) {
				for (int i = 0; i < 20; i++) {
					cardLabel1[i].setVisible(false);
					cardLabel2[i].setVisible(false);
					cardLabel3[i].setVisible(false);
				}
				textLabel.setVisible(false);
				textLabel2.setVisible(false);
				textLabel3.setVisible(false);
				textLabel.setVerticalAlignment(SwingConstants.TOP);
				cardLabel1[12].setBounds(50, 50, 100, 150);
				cardLabel1[17].setBounds(150, 50, 100, 150);
				cardLabel1[10].setBounds(300, 50, 100, 150);
				cardLabel2[12].setBounds(400, 50, 100, 150);
				cardLabel2[10].setBounds(550, 50, 100, 150);
				cardLabel2[17].setBounds(650, 50, 100, 150);
				cardLabel1[13].setBounds(300, 350, 100, 150);
				cardLabel1[16].setBounds(400, 350, 100, 150);
				cardLabel1[12].setVisible(true);
				cardLabel1[17].setVisible(true);
				cardLabel1[10].setVisible(true);
				cardLabel2[12].setVisible(true);
				cardLabel2[10].setVisible(true);
				cardLabel2[17].setVisible(true);
				cardLabel1[13].setVisible(true);
				cardLabel1[16].setVisible(true);
				textLabel.setBounds(20, 220, 760, 300);
				textLabel.setText("<html>�����θ� ������ ������, ���� ���� �����̴�.<br>"
						+ "���ȱ����� ��� ������ �̱� �� ����, �ϻﱤ���� ���ȱ����� ������(Ư������)�θ� �̱� �� �ִ�.<html>");
				textLabel.setVisible(true);
				textLabel2.setBounds(20, 520, 760, 200);
				textLabel2.setText("<html>���ڸ� 4���� ���ڸ� 7���� �� �������μ� �ϻﱤ�� Ȥ�� ���ȱ����� �̱� �� �ֽ��ϴ�.<br>"
						+ "���� ���� �߿� ������ ���ٸ� 1������ ��� �˴ϴ�.</html>");
				textLabel2.setVisible(true);
			} else if (selectedIndex == 2) {
				for (int i = 0; i < 20; i++) {
					cardLabel1[i].setVisible(false);
					cardLabel2[i].setVisible(false);
					cardLabel3[i].setVisible(false);
				}
				textLabel.setVisible(false);
				textLabel2.setVisible(false);
				textLabel3.setVisible(false);
				textLabel.setVerticalAlignment(SwingConstants.TOP);
				cardLabel1[9].setBounds(50, 50, 100, 150);
				cardLabel1[19].setBounds(150, 50, 100, 150);
				cardLabel1[4].setBounds(300, 50, 100, 150);
				cardLabel1[14].setBounds(400, 50, 100, 150);
				cardLabel1[0].setBounds(550, 50, 100, 150);
				cardLabel1[10].setBounds(650, 50, 100, 150);
				cardLabel1[2].setBounds(200, 350, 100, 150);
				cardLabel1[12].setBounds(300, 350, 100, 150);
				cardLabel1[6].setBounds(400, 350, 100, 150);
				cardLabel1[16].setBounds(500, 350, 100, 150);
				cardLabel1[9].setVisible(true);
				cardLabel1[19].setVisible(true);
				cardLabel1[4].setVisible(true);
				cardLabel1[14].setVisible(true);
				cardLabel1[0].setVisible(true);
				cardLabel1[10].setVisible(true);
				cardLabel1[2].setVisible(true);
				cardLabel1[12].setVisible(true);
				cardLabel1[6].setVisible(true);
				cardLabel1[16].setVisible(true);
				textLabel.setBounds(20, 220, 760, 470);
				textLabel.setText("<html>���� ���� �����Դϴ�.<br>" + "�� ���� ������ ��쿡�� �嶯(10��)~�涯(1��)������ ���ڰ� �������� �̱�ϴ�.</html>");
				textLabel.setVisible(true);
				textLabel2.setBounds(20, 520, 760, 200);
				textLabel2.setText("<html>3���� 7���� �������μ� ���� ������ ������ �̱� �� �ֽ��ϴ�.<br>" + "�嶯�� ������ ���� �� �����ϴ�.<br>"
						+ "���� ���� �߿� ���� ���ٸ� ������0�̹Ƿ� �������� ���˴ϴ�.</html>");
				textLabel2.setVisible(true);
			} else if (selectedIndex == 3) {
				for (int i = 0; i < 20; i++) {
					cardLabel1[i].setVisible(false);
					cardLabel2[i].setVisible(false);
					cardLabel3[i].setVisible(false);
				}
				textLabel.setVisible(false);
				textLabel2.setVisible(false);
				textLabel3.setVisible(false);
				textLabel.setVerticalAlignment(SwingConstants.TOP);
				cardLabel1[0].setBounds(200, 50, 100, 150);
				cardLabel1[10].setBounds(300, 50, 100, 150);
				cardLabel1[1].setBounds(400, 50, 100, 150);
				cardLabel1[11].setBounds(500, 50, 100, 150);
				cardLabel2[0].setBounds(200, 257, 100, 150);
				cardLabel2[10].setBounds(300, 257, 100, 150);
				cardLabel1[3].setBounds(400, 257, 100, 150);
				cardLabel1[13].setBounds(500, 257, 100, 150);
				cardLabel3[0].setBounds(200, 464, 100, 150);
				cardLabel3[10].setBounds(300, 464, 100, 150);
				cardLabel1[8].setBounds(400, 464, 100, 150);
				cardLabel1[18].setBounds(500, 464, 100, 150);
				cardLabel1[0].setVisible(true);
				cardLabel1[10].setVisible(true);
				cardLabel1[1].setVisible(true);
				cardLabel1[11].setVisible(true);
				cardLabel2[0].setVisible(true);
				cardLabel2[10].setVisible(true);
				cardLabel1[3].setVisible(true);
				cardLabel1[13].setVisible(true);
				cardLabel3[0].setVisible(true);
				cardLabel3[10].setVisible(true);
				cardLabel1[8].setVisible(true);
				cardLabel1[18].setVisible(true);
				textLabel.setBounds(20, 210, 760, 207);
				textLabel.setText("<html>������ �� ������� 1���� 2���� �����Դϴ�.</html>");
				textLabel.setVisible(true);
				textLabel2.setBounds(20, 417, 760, 107);
				textLabel2.setText("<html>������ �� ������� 1���� 4���� �����Դϴ�.</html>");
				textLabel2.setVisible(true);
				textLabel3.setBounds(20, 624, 760, 96);
				textLabel3.setText("<html>������ �� ������� 1���� 9���� �����Դϴ�.</html>");
				textLabel3.setVisible(true);
			} else if (selectedIndex == 4) {
				for (int i = 0; i < 20; i++) {
					cardLabel1[i].setVisible(false);
					cardLabel2[i].setVisible(false);
					cardLabel3[i].setVisible(false);
				}
				textLabel.setVisible(false);
				textLabel2.setVisible(false);
				textLabel3.setVisible(false);
				textLabel.setVerticalAlignment(SwingConstants.TOP);
				cardLabel1[0].setBounds(200, 50, 100, 150);
				cardLabel1[10].setBounds(300, 50, 100, 150);
				cardLabel1[9].setBounds(400, 50, 100, 150);
				cardLabel1[19].setBounds(500, 50, 100, 150);
				cardLabel1[3].setBounds(200, 257, 100, 150);
				cardLabel1[13].setBounds(300, 257, 100, 150);
				cardLabel2[9].setBounds(400, 257, 100, 150);
				cardLabel2[19].setBounds(500, 257, 100, 150);
				cardLabel2[3].setBounds(200, 464, 100, 150);
				cardLabel2[13].setBounds(300, 464, 100, 150);
				cardLabel1[5].setBounds(400, 464, 100, 150);
				cardLabel1[15].setBounds(500, 464, 100, 150);
				cardLabel1[0].setVisible(true);
				cardLabel1[10].setVisible(true);
				cardLabel1[9].setVisible(true);
				cardLabel1[19].setVisible(true);
				cardLabel1[3].setVisible(true);
				cardLabel1[13].setVisible(true);
				cardLabel2[9].setVisible(true);
				cardLabel2[19].setVisible(true);
				cardLabel2[3].setVisible(true);
				cardLabel2[13].setVisible(true);
				cardLabel1[5].setVisible(true);
				cardLabel1[15].setVisible(true);
				textLabel.setBounds(20, 210, 760, 207);
				textLabel.setText("<html>������ �� ������� 1���� 10���� �����Դϴ�.</html>");
				textLabel.setVisible(true);
				textLabel2.setBounds(20, 417, 760, 107);
				textLabel2.setText("<html>������ �� ������� 4���� 10���� �����Դϴ�.</html>");
				textLabel2.setVisible(true);
				textLabel3.setBounds(20, 624, 760, 96);
				textLabel3.setText("<html>������ �� ������� 4���� 6���� �����Դϴ�.</html>");
				textLabel3.setVisible(true);
			} else if (selectedIndex == 5) {
				for (int i = 0; i < 20; i++) {
					cardLabel1[i].setVisible(false);
					cardLabel2[i].setVisible(false);
					cardLabel3[i].setVisible(false);
				}
				textLabel.setVisible(false);
				textLabel2.setVisible(false);
				textLabel3.setVisible(false);
				textLabel.setVerticalAlignment(SwingConstants.TOP);
				cardLabel1[2].setBounds(50, 50, 100, 150);
				cardLabel1[5].setBounds(150, 50, 100, 150);
				cardLabel1[0].setBounds(300, 50, 100, 150);
				cardLabel1[12].setBounds(400, 50, 100, 150);
				cardLabel1[6].setBounds(550, 50, 100, 150);
				cardLabel2[12].setBounds(650, 50, 100, 150);
				cardLabel2[3].setBounds(66, 300, 100, 150);
				cardLabel2[13].setBounds(166, 300, 100, 150);
				cardLabel2[8].setBounds(266, 300, 100, 150);
				cardLabel2[18].setBounds(366, 300, 100, 150);
				cardLabel3[13].setBounds(533, 300, 100, 150);
				cardLabel3[18].setBounds(633, 300, 100, 150);
				cardLabel1[2].setVisible(true);
				cardLabel1[5].setVisible(true);
				cardLabel1[0].setVisible(true);
				cardLabel1[12].setVisible(true);
				cardLabel1[6].setVisible(true);
				cardLabel2[12].setVisible(true);
				cardLabel2[3].setVisible(true);
				cardLabel2[13].setVisible(true);
				cardLabel2[8].setVisible(true);
				cardLabel2[18].setVisible(true);
				cardLabel3[13].setVisible(true);
				cardLabel3[18].setVisible(true);
				textLabel.setBounds(20, 220, 760, 250);
				textLabel.setText(
						"<html>������ 9���� 1�϶� ���� 9��(����), 8��, 7��, 6��, 5��, 4��, 3��, 2��, 1��, 0��(����)�̶�� �ϸ�, ���ڰ� �������� ���� �����Դϴ�.</html>");
				textLabel.setVisible(true);
				textLabel2.setBounds(20, 470, 760, 250);
				textLabel2.setText("<html>4���� 9���� �������μ� �˸� ������ ������ �̹� ���� ������ ���⸦ �� �� �ֽ��ϴ�.<br>"
						+ "���ڸ� 4���� ���ڸ� 9���� �� ������ ���ֱ��� ����μ�, �嶯������ ������ ���⸦ �� �� �ֽ��ϴ�.</html>");
				textLabel2.setVisible(true);
			}
		}

		public void mousePressed(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {

		}

		// ���콺�� ��ư�� �������� �������� ���� �����Ͽ� �������� ����
		public void mouseEntered(MouseEvent event) {
			JButton obj = (JButton) event.getSource();
			obj.setBackground(RuleExplanationConstants.JOKBO_ENTER[0]);
			obj.setForeground(RuleExplanationConstants.JOKBO_ENTER[1]);
		}

		public void mouseExited(MouseEvent event) {
			JButton obj = (JButton) event.getSource();
			if (obj != btnSelectArray[selectedIndex]) {
				obj.setBackground(RuleExplanationConstants.JOKBO_EXIT[0]);
				obj.setForeground(RuleExplanationConstants.JOKBO_EXIT[1]);
			}
		}
	}
}
