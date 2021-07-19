package matsudda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class UserPanel extends JPanel {
	private UserData dataUser;
	private UserData dataCom;
	private JPanel buttonPanel, betMoneyPanel, userMoneyPanel, comMoneyPanel;
	private JButton btnQuarter, btnCall, btnHalf, btnAllin;
	private ButtonListener buttonL;
	private JLabel lblUserMoney, lblComMoney, lblUserBetting, lblComBetting, lblBatting, lblUsersID, lblComID;
	private ImageIcon[] deckIcon;
	private JLabel[] lbldeck;
	private int BattingMoney = 1000000;
	private ImageIcon back;

	public UserPanel() {
		dataUser = new UserData();
		dataCom = new UserData(dataUser.getCard1(), dataUser.getCard2());
		setBackground(new Color(32, 164, 71));
		setPreferredSize(new Dimension(1000, 760));
		setLayout(null);

		buttonL = new ButtonListener();

		deckIcon = new ImageIcon[20];
		deckIcon[0] = new ImageIcon("images/0.PNG");
		deckIcon[1] = new ImageIcon("images/1.PNG");
		deckIcon[2] = new ImageIcon("images/10.PNG");
		deckIcon[3] = new ImageIcon("images/11.PNG");
		deckIcon[4] = new ImageIcon("images/20.PNG");
		deckIcon[5] = new ImageIcon("images/21.PNG");
		deckIcon[6] = new ImageIcon("images/30.PNG");
		deckIcon[7] = new ImageIcon("images/31.PNG");
		deckIcon[8] = new ImageIcon("images/40.PNG");
		deckIcon[9] = new ImageIcon("images/41.PNG");
		deckIcon[10] = new ImageIcon("images/50.PNG");
		deckIcon[11] = new ImageIcon("images/51.PNG");
		deckIcon[12] = new ImageIcon("images/60.PNG");
		deckIcon[13] = new ImageIcon("images/61.PNG");
		deckIcon[14] = new ImageIcon("images/70.PNG");
		deckIcon[15] = new ImageIcon("images/71.PNG");
		deckIcon[16] = new ImageIcon("images/80.PNG");
		deckIcon[17] = new ImageIcon("images/81.PNG");
		deckIcon[18] = new ImageIcon("images/90.PNG");
		deckIcon[19] = new ImageIcon("images/91.PNG");

		back = new ImageIcon("images/back.PNG");

		lbldeck = new JLabel[20];

		for (int i = 0; i < 20; i++) {
			lbldeck[i] = new JLabel(back);
			lbldeck[i].setBounds(450 + i, 295 + i, 100, 150);
			add(lbldeck[i]);
		}

		buttonPanel = new JPanel();
		buttonPanel.setBounds(700, 315, 260, 245);
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setLayout(null);
		add(buttonPanel);

		btnHalf = new JButton("Half");
		btnHalf.setBounds(90, 13, 80, 60);
		btnHalf.addActionListener(buttonL);
		buttonPanel.add(btnHalf);

		btnQuarter = new JButton("Quarter");
		btnQuarter.setBounds(5, 13, 80, 60);
		btnQuarter.addActionListener(buttonL);
		buttonPanel.add(btnQuarter);

		btnCall = new JButton("Call");
		btnCall.setBounds(175, 13, 80, 60);
		btnCall.addActionListener(buttonL);
		buttonPanel.add(btnCall);

		btnAllin = new JButton("All in");
		btnAllin.setBounds(5, 86, 80, 60);
		btnAllin.addActionListener(buttonL);
		buttonPanel.add(btnAllin);

		userMoneyPanel = new JPanel();
		userMoneyPanel.setBounds(700, 580, 260, 100);
		userMoneyPanel.setBackground(Color.white);
		userMoneyPanel.setLayout(null);
		add(userMoneyPanel);

		comMoneyPanel = new JPanel();
		comMoneyPanel.setBounds(40, 80, 260, 100);
		comMoneyPanel.setBackground(Color.yellow);
		comMoneyPanel.setLayout(null);
		add(comMoneyPanel);

		betMoneyPanel = new JPanel();
		betMoneyPanel.setBounds(40, 230, 260, 300);
		betMoneyPanel.setBackground(Color.cyan);
		betMoneyPanel.setLayout(null);
		add(betMoneyPanel);

		lblUserMoney = new JLabel("[" + dataUser.nMoney + "]");
		lblUserMoney.setBounds(0, 10, 260, 30);
		lblUserMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserMoney.setFont(new Font("Verdana", Font.BOLD, 20));
		userMoneyPanel.add(lblUserMoney);

		lblComMoney = new JLabel("[" + dataCom.nMoney + "]");
		lblComMoney.setBounds(0, 10, 260, 30);
		lblComMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblComMoney.setFont(new Font("Verdana", Font.BOLD, 20));
		comMoneyPanel.add(lblComMoney);

		lblUsersID = new JLabel("Me");
		lblUsersID.setBounds(110, 50, 260, 30);
		lblUsersID.setFont(new Font("Verdana", Font.BOLD, 20));
		userMoneyPanel.add(lblUsersID);

		lblComID = new JLabel("COMPUTER");
		lblComID.setBounds(70, 40, 260, 50);
		lblComID.setFont(new Font("Verdana", Font.BOLD, 20));
		comMoneyPanel.add(lblComID);

		lblBatting = new JLabel(BattingMoney + "Won");
		lblBatting.setBounds(0, 100, 260, 60);
		lblBatting.setHorizontalAlignment(SwingConstants.CENTER);
		lblBatting.setVerticalAlignment(SwingConstants.CENTER);
		lblBatting.setFont(new Font("Verdana", Font.BOLD, 15));
		betMoneyPanel.add(lblBatting);

		lblUserBetting = new JLabel("CALL");
		lblUserBetting.setBounds(0, 130, 260, 130);
		lblUserBetting.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserBetting.setVerticalAlignment(SwingConstants.CENTER);
		lblUserBetting.setFont(new Font("Verdana", Font.BOLD, 15));
		lblUserBetting.setVisible(false);
		betMoneyPanel.add(lblUserBetting);

		lblComBetting = new JLabel("CALL");
		lblComBetting.setBounds(0, 0, 260, 130);
		lblComBetting.setHorizontalAlignment(SwingConstants.CENTER);
		lblComBetting.setVerticalAlignment(SwingConstants.CENTER);
		lblComBetting.setFont(new Font("Verdana", Font.BOLD, 15));
		lblComBetting.setVisible(false);
		betMoneyPanel.add(lblComBetting);

	} // UserPanel()

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();

			if (obj == btnQuarter) {
				dataUser.setMoney(dataUser.nMoney - (BattingMoney / 4));
				lblUserBetting.setText("+ " + (BattingMoney / 4) + "WON");
				BattingMoney = BattingMoney + (BattingMoney / 4);
				lblUserMoney.setText("[" + dataUser.nMoney + "]");
				lblUserBetting.setVisible(true);
				lblBatting.setText(BattingMoney + "WON");

				if (dataUser.nMoney == 0) {
					btnHalf.setEnabled(false);
					btnQuarter.setEnabled(false);
					btnCall.setEnabled(false);
					btnAllin.setEnabled(false);
				} else if (dataUser.nMoney >= BattingMoney / 4 && dataUser.nMoney < BattingMoney / 2) {
					btnHalf.setEnabled(false);
					btnCall.setEnabled(false);
				} else if (dataUser.nMoney >= BattingMoney / 2 && dataUser.nMoney < BattingMoney) {
					btnCall.setEnabled(false);
				} else if (dataUser.nMoney < BattingMoney / 4) {
					btnHalf.setEnabled(false);
					btnQuarter.setEnabled(false);
					btnCall.setEnabled(false);
				}

			} else if (obj == btnHalf) {
				dataUser.setMoney(dataUser.nMoney - (BattingMoney / 2));
				lblUserBetting.setText("+ " + (BattingMoney / 2) + "WON");
				BattingMoney = BattingMoney + (BattingMoney / 2);
				lblUserMoney.setText("[" + dataUser.nMoney + "]");
				lblUserBetting.setVisible(true);
				lblBatting.setText(BattingMoney + "WON");

				if (dataUser.nMoney == 0) {
					btnHalf.setEnabled(false);
					btnQuarter.setEnabled(false);
					btnCall.setEnabled(false);
					btnAllin.setEnabled(false);
				} else if (dataUser.nMoney >= BattingMoney / 4 && dataUser.nMoney < BattingMoney / 2) {
					btnHalf.setEnabled(false);
					btnCall.setEnabled(false);
				} else if (dataUser.nMoney >= BattingMoney / 2 && dataUser.nMoney < BattingMoney) {
					btnCall.setEnabled(false);
				} else if (dataUser.nMoney < BattingMoney / 4) {
					btnHalf.setEnabled(false);
					btnQuarter.setEnabled(false);
					btnCall.setEnabled(false);
				}
			} else if (obj == btnCall) {
				dataUser.setMoney(dataUser.nMoney - BattingMoney);
				lblUserBetting.setText("+ " + (BattingMoney * 2) + "WON");
				BattingMoney = BattingMoney * 2;
				lblUserMoney.setText("[" + dataUser.nMoney + "]");
				lblUserBetting.setVisible(true);
				lblBatting.setText(BattingMoney + "WON");

				if (dataUser.nMoney == 0) {
					btnHalf.setEnabled(false);
					btnQuarter.setEnabled(false);
					btnCall.setEnabled(false);
					btnAllin.setEnabled(false);
				} else if (dataUser.nMoney >= BattingMoney / 4 && dataUser.nMoney < BattingMoney / 2) {
					btnHalf.setEnabled(false);
					btnCall.setEnabled(false);
				} else if (dataUser.nMoney >= BattingMoney / 2 && dataUser.nMoney < BattingMoney) {
					btnCall.setEnabled(false);
				} else if (dataUser.nMoney < BattingMoney / 4) {
					btnHalf.setEnabled(false);
					btnQuarter.setEnabled(false);
					btnCall.setEnabled(false);
				}

			} else if (obj == btnAllin) {
				lblUserBetting.setText("+ " + dataUser.nMoney + "WON");
				BattingMoney = BattingMoney + dataUser.nMoney;
				lblBatting.setText(BattingMoney + "WON");
				dataUser.setMoney(0);
				lblUserMoney.setText("[" + dataUser.nMoney + "]");
				lblUserBetting.setVisible(true);
				btnHalf.setEnabled(false);
				btnQuarter.setEnabled(false);
				btnCall.setEnabled(false);
				btnAllin.setEnabled(false);
			}
		} // actionPerformed()
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		page.setColor(new Color(22, 116, 50));
		page.fillRect(385, 515, 230, 170);
		page.fillRect(385, 75, 230, 170);

	}
}
