package application;


import javax.swing.*;

import number.*;

import java.awt.*;

 	
public class calculationExcerciseApplication extends createNumber{
	public int numberOfCal = 1;
	public int right = 0;
	public int wrong = 0;
	createNumber n;
	JFrame mainFrame;
	JPanel numberOne;
	JPanel numberTwo;
	JPanel symbol;
	int flag;
	JPanel line;
	JTextField answer;
	JButton checkButton;
	JPanel checkAnswer;
	JPanel showJpanel;
	JButton nextButton;
	int answerStringToInt;
	JPanel resultString;
	JPanel rightShow;
	JPanel wrongShow;
	JPanel numberShow;
	
	calculationExcerciseApplication(){
		this.mainFrame = new JFrame("100以内加减法练习小软件");
		this.n = new createNumber();
		this.numberOne = new JPanel();
		this.numberTwo = new JPanel();
		this.symbol = new JPanel();
		this.flag = n.getFlag();
		this.line = new JPanel();
		this.answer = new JTextField(5);	
		this.checkButton = new JButton("评判");
		this.checkAnswer = new JPanel();
		this.showJpanel = new JPanel();
		this.nextButton = new JButton("下一题");
		this.resultString = new JPanel();
		this.rightShow = new JPanel();
		this.wrongShow = new JPanel();
		this.numberShow = new JPanel();
	}
	public  void mainFrame() {
		//createNumber n = new createNumber();
		this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//mainFrame.getContentPane().setBackground(Color.white);//获取JFrame内容的根组件
		
		
		
		this.mainFrame.setLocation(300, 100);		
		this.mainFrame.setSize(960, 720);
		this.mainFrame.setLayout(null);
		
		numberOne.add(new JLabel(String.valueOf(n.getNumberOne())));
		numberOne.setBounds(400, 200, 20, 20);
		//numberOne.setFont(new Font("黑体", Font.BOLD, 5));
		mainFrame.add(numberOne);

		numberShow.add(new JLabel("出题总数："+String.valueOf(numberOfCal)));
		numberShow.setBounds(600, 170, 120, 20);
		mainFrame.add(numberShow);
		
		
		rightShow.add(new JLabel("正确题数："+String.valueOf(right)));
		wrongShow.add(new JLabel("错误题数："+String.valueOf(wrong)));
		rightShow.setBounds(600, 200, 120, 20);
		wrongShow.setBounds(600, 230, 120, 20);
		mainFrame.add(rightShow);
		mainFrame.add(wrongShow);
		
		
		if(flag % 2 == 0) {
			//偶数代表加法
			symbol.add(new JLabel("+"));
		}
		if(flag % 2 == 1) {
			//奇数代表减法
			symbol.add(new JLabel("-"));
		}
		symbol.setBounds(350, 220, 20, 20);
		mainFrame.add(symbol);
			
		
		numberTwo.add(new JLabel(String.valueOf(n.getNumberTwo())));
		numberTwo.setBounds(400, 220, 20, 20);		
		mainFrame.add(numberTwo);
				
		
		line.add(new JLabel("------------------"));
		line.setBounds(360,240,100,20);
		mainFrame.add(line);
		
		
		line.add(answer);		
		answer.setBounds(400,260,40,20);
		mainFrame.add(answer);
		
		
		checkButton.setBounds(460, 260, 100, 20);
		mainFrame.add(checkButton);
		
		
		checkAnswer.add(new JLabel("结果："));
		checkAnswer.setBounds(300,280,100,20);
		mainFrame.add(checkAnswer);

		
		nextButton.setBounds(460, 230, 100, 20);
		mainFrame.add(nextButton);
		
		nextButton.addActionListener((e) -> {
			n = this.next();
		});
		
		checkButton.addActionListener((e) -> {
			answerStringToInt = Integer.valueOf(answer.getText());
			this.checkAnswer(n.getNumberOne(),n.getNumberTwo());	
		}
		);
		
		

		mainFrame.getContentPane().setVisible(true);
		mainFrame.setVisible(true);
	}
	public createNumber next() {
		numberOfCal++;
		numberShow.removeAll();
		numberShow.repaint();
		numberShow.add(new JLabel("出题总数："+String.valueOf(numberOfCal)));
		numberShow.setBounds(600, 170, 120, 20);
		mainFrame.add(numberShow);
		mainFrame.getContentPane().setVisible(true);
		mainFrame.setVisible(true);
		
		createNumber n1 = new createNumber();
		 answer.setText("");
		 numberOne.removeAll();
		 numberOne.repaint();
		 numberOne.add(new JLabel(String.valueOf(n1.getNumberOne())));
		 numberOne.setBounds(400, 200, 20, 20);
			mainFrame.add(numberOne);
			
			
			flag = n1.getFlag();
			symbol.removeAll();
			symbol.repaint();
			if(flag % 2 == 0) {
				//偶数代表加法
				symbol.add(new JLabel("+"));
			}
			if(flag % 2 == 1) {
				//奇数代表减法
				symbol.add(new JLabel("-"));
			}
			symbol.setBounds(350, 220, 20, 20);
			mainFrame.add(symbol);
			

			numberTwo.removeAll();
			numberTwo.repaint();
			numberTwo.add(new JLabel(String.valueOf(n1.getNumberTwo())));
			numberTwo.setBounds(400, 220, 20, 20);		
			mainFrame.add(numberTwo);
			
			mainFrame.getContentPane().setVisible(true);
			mainFrame.setVisible(true);
			return n1;
	}
	public  void checkAnswer(int n1, int n2) {
		if(flag % 2 == 0) {
			if(answerStringToInt == n1 + n2) {
				resultString.setBounds(370, 280, 250, 20);
				resultString.removeAll();
				resultString.repaint();
				resultString.add(new JLabel("正确，小朋友你真棒"));
				mainFrame.add(resultString);
				mainFrame.getContentPane().setVisible(true);
				mainFrame.setVisible(true);
				right++;
				rightShow.removeAll();
				rightShow.repaint();
				rightShow.add(new JLabel("正确题数："+String.valueOf(right)));
				rightShow.setBounds(600, 200, 120, 20);
				mainFrame.add(rightShow);

			}
			if(answerStringToInt != n1 + n2) {
				resultString.setBounds(370, 280, 250, 20);
				resultString.removeAll();
				resultString.repaint();
				resultString.add(new JLabel("错误，结果应该是"+(n1 + n2)));
				mainFrame.add(resultString);
				mainFrame.getContentPane().setVisible(true);
				mainFrame.setVisible(true);
				wrong++;
				wrongShow.removeAll();
				wrongShow.repaint();
				wrongShow.add(new JLabel("错误题数："+String.valueOf(wrong)));
				wrongShow.setBounds(600, 230, 120, 20);
				mainFrame.add(wrongShow);
			}			
		}
		if(flag % 2 == 1) {
			if(answerStringToInt == n1 - n2) {
				resultString.setBounds(370, 280, 250, 20);
				resultString.removeAll();
				resultString.repaint();
				resultString.add(new JLabel("正确，小朋友你真棒"));
				mainFrame.add(resultString);
				mainFrame.getContentPane().setVisible(true);
				mainFrame.setVisible(true);
				right++;
				rightShow.removeAll();
				rightShow.repaint();
				rightShow.add(new JLabel("正确题数："+String.valueOf(right)));
				rightShow.setBounds(600, 200, 120, 20);
				mainFrame.add(rightShow);
			}
			if(answerStringToInt != n1 - n2) {
				resultString.setBounds(370, 280, 250, 20);
				resultString.removeAll();
				resultString.repaint();
				resultString.add(new JLabel("错误，结果应该是"+(n1 - n2)));
				mainFrame.add(resultString);
				mainFrame.getContentPane().setVisible(true);
				mainFrame.setVisible(true);
				wrong++;
				wrongShow.removeAll();
				wrongShow.repaint();
				wrongShow.add(new JLabel("错误题数："+String.valueOf(wrong)));
				wrongShow.setBounds(600, 230, 120, 20);
				mainFrame.add(wrongShow);
			}			
		}
		mainFrame.getContentPane().setVisible(true);
		mainFrame.setVisible(true);
	}
	public static void main(String argv[]) {
		calculationExcerciseApplication cal = new calculationExcerciseApplication();
		cal.mainFrame();
	}
}

