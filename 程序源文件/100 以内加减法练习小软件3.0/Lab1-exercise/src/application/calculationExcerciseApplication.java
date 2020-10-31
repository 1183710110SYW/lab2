package application;


import javax.swing.*;

import number.*;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



public class calculationExcerciseApplication extends createNumber{

	public int numberOfCal = 1;
	public int right = 0;
	public int wrong = 0;
	createNumber n;
	JFrame mainFrame;
	JLabel numberOne;
	JLabel numberTwo;
	JLabel symbol;
	int flag;
	JLabel line;
	JTextField answer;
	JButton checkButton;
	JLabel checkAnswer;
	JLabel showJpanel;
	JButton nextButton;
	int answerStringToInt;
	JPanel resultString;
	int timeControl;
	JPanel rightShow;
	JPanel wrongShow;
	JPanel numberShow;
	int num; 
	JTextField timePanel;
	JButton startTimeButton;
	JButton endTimeButton;
	JTextField totalTime;
	JButton voice;
	Calendar calendar ;
	Date date ;
	String time = null;
	String currentTime = null;
	
	calculationExcerciseApplication(){
		this.mainFrame = new JFrame("100以内加减法练习小软件");
		this.n = new createNumber();
		this.numberOne = new JLabel();
		this.numberTwo = new JLabel();
		this.symbol = new JLabel();
		this.flag = n.getFlag();
		this.line = new JLabel();
		this.answer = new JTextField(5);	
		this.checkButton = new JButton("评判");
		this.checkAnswer = new JLabel();
		this.showJpanel = new JLabel();
		this.nextButton = new JButton("下一题");
		this.resultString = new JPanel();
		this.resultString.setOpaque(false);
		this.timePanel = new JTextField();
		this.startTimeButton = new JButton("计时开始");
		this.endTimeButton = new JButton("计时结束");
		this.calendar = Calendar.getInstance();
		this.date = (Date) calendar.getTime();
		this.timeControl = 1;
		this.totalTime = new JTextField();
		this.voice = new JButton("音效：关");
		this.rightShow = new JPanel();
		rightShow.setOpaque(false);
		this.wrongShow = new JPanel();
		wrongShow.setOpaque(false);
		this.numberShow = new JPanel();
		numberShow.setOpaque(false);
		this.num = 0;
	}
	public  void mainFrame() {

		this.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.getContentPane().setBackground(Color.white);//获取JFrame内容的根组件

		this.mainFrame.setLocation(300, 100);		
		this.mainFrame.setSize(960, 720);
		this.mainFrame.setLayout(null);
		JLabel text = new JLabel("100以内加减法练习小软件");
		text.setBounds(100, 30, 300, 50);
		text.setFont(new Font("黑体", Font.BOLD, 24));
		mainFrame.add(text);
		JLabel text0 = new JLabel("制作人：王国庆");
		text0.setBounds(30, 290, 300, 50);
		text0.setFont(new Font("黑体", Font.BOLD, 18));
		mainFrame.add(text0);
		JLabel text1 = new JLabel("学号1183710131");
		text1.setBounds(30, 340, 300, 50);
		text1.setFont(new Font("黑体", Font.BOLD, 18));
		mainFrame.add(text1);
		JLabel text2 = new JLabel("制作人：孙英玮");
		text2.setBounds(30, 390, 300, 50);
		text2.setFont(new Font("黑体", Font.BOLD, 18));
		mainFrame.add(text2);
		JLabel text3 = new JLabel("学号1183710131");
		text3.setBounds(30, 440, 300, 50);
		text3.setFont(new Font("黑体", Font.BOLD, 18));
		mainFrame.add(text3);
		JLabel text4 = new JLabel("如有问题请联系");
		text4.setBounds(30, 490, 300, 50);
		text4.setFont(new Font("黑体", Font.BOLD, 18));
		mainFrame.add(text4);
		JLabel text5 = new JLabel("QQ 1113292969");
		text5.setBounds(30, 540, 300, 50);
		text5.setFont(new Font("黑体", Font.BOLD, 18));
		mainFrame.add(text5);
		
		
		numberOne.setText(String.valueOf(n.getNumberOne()));
		numberOne.setBounds(400, 200, 20, 20);
		//numberOne.setFont(new Font("黑体", Font.BOLD, 5));
		mainFrame.add(numberOne);

		if(flag % 2 == 0) {
			//偶数代表加法
			symbol.setText("+");
		}
		if(flag % 2 == 1) {
			//奇数代表减法
			symbol.setText("-");
		}
		symbol.setBounds(350, 220, 20, 20);
		mainFrame.add(symbol);


		numberTwo.setText(String.valueOf(n.getNumberTwo()));
		numberTwo.setBounds(400, 220, 20, 20);		
		mainFrame.add(numberTwo);


		line.setText("------------------");
		line.setBounds(360,240,100,20);
		mainFrame.add(line);


		line.add(answer);		
		answer.setBounds(400,260,40,20);
		mainFrame.add(answer);


		checkButton.setBounds(460, 260, 100, 20);
		mainFrame.add(checkButton);


		checkAnswer.setText("结果：");
		checkAnswer.setBounds(300,280,100,20);
		mainFrame.add(checkAnswer);


		nextButton.setBounds(460, 230, 100, 20);
		mainFrame.add(nextButton);
		
		voice.setBounds(650, 450, 100, 20);
		mainFrame.add(voice);
		
		numberShow.add(new JLabel("出题总数："+String.valueOf(numberOfCal)));
		numberShow.setBounds(600, 170, 120, 20);
		
		mainFrame.add(numberShow);
		
		
		rightShow.add(new JLabel("正确题数："+String.valueOf(right)));
		wrongShow.add(new JLabel("错误题数："+String.valueOf(wrong)));
		rightShow.setBounds(600, 200, 120, 20);
		wrongShow.setBounds(600, 230, 120, 20);
		mainFrame.add(rightShow);
		mainFrame.add(wrongShow);
		
		voice.addActionListener((e) -> {
			
			num++;
			if(num % 2 == 1) {
				voice.setText("音效：开");
				mainFrame.getContentPane().setVisible(true);
				mainFrame.setVisible(true);
				
			}
			else {
				voice.setText("音效：关");
				mainFrame.getContentPane().setVisible(true);
				mainFrame.setVisible(true);	
			}
		});

		nextButton.addActionListener((e) -> {
			n = this.next();
		});

		checkButton.addActionListener((e) -> {
			answerStringToInt = Integer.valueOf(answer.getText());
			this.checkAnswer(n.getNumberOne(),n.getNumberTwo());	
		}
		);

		startTimeButton.setBounds(300, 450, 100, 20);
		mainFrame.add(startTimeButton);

		endTimeButton.setBounds(300, 500, 100, 20);
		mainFrame.add(endTimeButton);

		timePanel.setBounds(450, 450, 150, 30);
		mainFrame.add(timePanel);

		totalTime.setBounds(450, 500, 150, 30);
		mainFrame.add(totalTime);

		startTimeButton.addActionListener((e) -> {
			timeControl = 1;
			if(timeControl == 1) {
				calendar = Calendar.getInstance();
				date = (Date) calendar.getTime();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				time = format.format(date);	        
				timePanel.setText(getTime());
				
				timePanel.setVisible(true);								
				Timer timer = new Timer();
				timer.schedule(new RemindTask(), 0, 1000);
				
			}


			mainFrame.getContentPane().setVisible(true);
			mainFrame.setVisible(true);	
		}			
				);

		endTimeButton.addActionListener((e) -> {
			this.timeControl = 0;
			String totalTimeString = timePanel.getText().replaceAll("已", "共");
			
			totalTime.setText(totalTimeString);


		}
				);
		mainFrame.getContentPane().setVisible(true);
		mainFrame.setVisible(true);
	}

	public String getTime() {
		long nd = 1000*24*60*60;//一天的毫秒数
		long nh = 1000*60*60;//一小时的毫秒数
		long nm = 1000*60;//一分钟的毫秒数
		long ns = 1000;//一秒钟的毫秒数
		String t = null;
		if(timeControl ==1) {
			Calendar calendar = Calendar.getInstance();
			Date date1 = (Date) calendar.getTime() ;

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			currentTime = format.format(date1);
			try {
				long diff = format.parse(currentTime).getTime() - format.parse(time).getTime();
				long hour = diff%nd/nh;//计算差多少小时
				long min = diff%nd%nh/nm;//计算差多少分钟
				long sec = diff%nd%nh%nm/ns;//计算差多少秒
				t = ("已用时：" + hour+"小时" + min +"分钟"+sec+"秒");
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

			return t;
		}
		else
			return t;
	}

	private class RemindTask extends TimerTask {
		public void run() {
			timePanel.setText(getTime());
		}
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
		numberOne.setText(String.valueOf(n1.getNumberOne()));
		numberOne.setBounds(400, 200, 20, 20);
		//numberOne.setFont(new Font("黑体", Font.BOLD, 5));
		mainFrame.add(numberOne);


		flag = n1.getFlag();
		symbol.removeAll();
		symbol.repaint();
		if(flag % 2 == 0) {
			//偶数代表加法
			symbol.setText("+");
		}
		if(flag % 2 == 1) {
			//奇数代表减法
			symbol.setText("-");
		}
		symbol.setBounds(350, 220, 20, 20);
		mainFrame.add(symbol);

		numberTwo.removeAll();
		numberTwo.repaint();
		numberTwo.setText(String.valueOf(n1.getNumberTwo()));
		numberTwo.setBounds(400, 220, 20, 20);		
		mainFrame.add(numberTwo);

		mainFrame.getContentPane().setVisible(true);
		mainFrame.setVisible(true);
		return n1;
	}
	public  void checkAnswer(int n1, int n2) {
		if(flag % 2 == 0) {
			if(answerStringToInt == n1 + n2) {
				resultString.setBounds(370, 280, 220, 20);
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
				resultString.setBounds(370, 280, 220, 20);
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
				resultString.setBounds(370, 280, 220, 20);
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
				resultString.setBounds(370, 280, 220, 20);
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

