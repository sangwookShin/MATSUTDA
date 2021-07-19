package matsudda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private JButton start, Explanation, finish, back, back2;
	private JPanel main;
	private MainListener mainL;
	private RuleExplanationPanel ExplanationPanel;
	private UserPanel startPanel;

	public MainPanel() {
		main = new JPanel();
		main.setPreferredSize(new Dimension(1000, 760));
		main.setBackground(Color.white);
		main.setLayout(null);
		add(main);

		start = new JButton("게임시작");
		Explanation = new JButton("게임설명");
		finish = new JButton("게임종료");
		back = new JButton("메인화면으로 가기");
		back2 = new JButton("메인화면으로 가기");

		mainL = new MainListener();
		start.addMouseListener(mainL);
		Explanation.addMouseListener(mainL);
		finish.addMouseListener(mainL);
		back.addMouseListener(mainL);
		back2.addMouseListener(mainL);
		start.setFont(new Font("HY견명조 보통", Font.BOLD, 23));
		Explanation.setFont(new Font("HY견명조 보통", Font.BOLD, 23));
		finish.setFont(new Font("HY견명조 보통", Font.BOLD, 23));
		back.setFont(new Font("HY견명조 보통", Font.BOLD, 23));
		back2.setFont(new Font("HY견명조 보통", Font.BOLD, 23));
		start.setBounds(350, 150, 300, 100);
		Explanation.setBounds(350, 250, 300, 100);
		finish.setBounds(350, 350, 300, 100);
		main.add(start);
		main.add(Explanation);
		main.add(finish);

		ExplanationPanel = new RuleExplanationPanel();
		ExplanationPanel.setVisible(false);
		ExplanationPanel.setBounds(0, 0, 1000, 760);
		main.add(ExplanationPanel);

		startPanel = new UserPanel();
		startPanel.setVisible(false);
		startPanel.setBounds(0, 0, 1000, 760);
		main.add(startPanel);

		back.setBounds(750, 0, 250, 40);
		ExplanationPanel.add(back);

		back2.setBounds(750, 0, 250, 40);
		startPanel.add(back2);
	}

	class MainListener implements MouseListener {
		public void mouseClicked(MouseEvent event) {
			JButton obj = (JButton) event.getSource();
			if (obj == start) {
				startPanel.setVisible(true);
				start.setVisible(false);
				Explanation.setVisible(false);
				finish.setVisible(false);
			} else if (obj == Explanation) {
				ExplanationPanel.setVisible(true);
				start.setVisible(false);
				Explanation.setVisible(false);
				finish.setVisible(false);
			} else if (obj == finish) {
				System.exit(0);
			} else if (obj == back) {
				ExplanationPanel.setVisible(false);
				start.setVisible(true);
				Explanation.setVisible(true);
				finish.setVisible(true);
			} else if (obj == back2) {
				startPanel.setVisible(false);
				start.setVisible(true);
				Explanation.setVisible(true);
				finish.setVisible(true);
			}
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {

		}

		public void mousePressed(MouseEvent event) {

		}

		public void mouseReleased(MouseEvent event) {

		}
	}
}
