import javax.swing.*; 
import java.awt.event.*;

import java.util.Random;

class random{


			int generate(){
			Random ran = new Random();
			int num=0;

			int i=0;

			while(i<10)
			{

			num = (ran.nextInt(100000)%10);
			int num1 = (ran.nextInt(100000)%10);
			int num2 = (ran.nextInt(100000)%10);
			int num3 = (ran.nextInt(100000)%10);

					if(num3!=num && num2!=num && num1!= num && num3!=num1 && num3!=num2 && num2!=num1){
					 num = num3*1000+num1*100+num2*10+num;
					i = i+2;
					}
			}
			return num;
			}
			
}






public class fontend extends JFrame  
{
  JLabel  l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16,l17, l18, l19 ;
  JTextField  t1, t2, t3, t4, t5, t6, t7 ,actual_no;
  JButton  b1, b2, b3, b4, b5, b6 ,b7 ,b8 ,b9 ,b10 ,b11,b12,b13 ; 

  fontend()
  {
	super("JAVA PROJECT") ;
	
    setLayout(null) ;
    setSize(700,700);
    setVisible(true);
	
	
	//ITS ALL FRONT END
	
    l1 = new JLabel("CAN YOU BREAK THE 4-DIGIT CODE?") ;
    l1.setBounds(20,30,300,30) ;
	add(l1); 
	
	
	l2 = new JLabel("YOUR ENTRY") ;
    l2.setBounds(20,70,100,30) ;
	add(l2); 
		
	l3 = new JLabel("IN POSITION") ;
    l3.setBounds(170,70,100,30) ;
	add(l3); 
	
	l4 = new JLabel("OUT OF POSITION") ;
    l4.setBounds(270,70,100,30) ;
	add(l4); 
	
	
	t1 = new JTextField() ;
    t1.setBounds(20,130,100,30) ;
    add(t1); 
		
		
	t2 = new JTextField() ;
    t2.setBounds(170,130,100,30) ;
    add(t2); 
	
	
	t3 = new JTextField() ;
    t3.setBounds(270,130,100,30) ;
    add(t3);

	actual_no= new JTextField() ;
    actual_no.setBounds(470,330,100,30) ;
    add(actual_no);

	b1 = new JButton("1");
	b1.setBounds(20,330,50,50) ;
	add(b1);
	b2 = new JButton("2");
	b2.setBounds(70,330,50,50) ;
	add(b2);
	b3 = new JButton("3");
	b3.setBounds(120,330,50,50) ;
	add(b3);
	b4 = new JButton("4");
	b4.setBounds(20,380,50,50) ;
	add(b4);	
	b5 = new JButton("5");
	b5.setBounds(70,380,50,50) ;
	add(b5);	
	b6 = new JButton("6");
	b6.setBounds(120,380,50,50) ;
	add(b6);
	b7 = new JButton("7");
	b7.setBounds(20,430,50,50) ;
	add(b7);
	b8 = new JButton("8");
	b8.setBounds(70,430,50,50) ;
	add(b8);
	b9 = new JButton("9");
	b9.setBounds(120,430,50,50) ;
	add(b9);
	b10 = new JButton("0");
	b10.setBounds(20,480,150,50) ;
	add(b10);
	
		b11 = new JButton("CHECK ENTRY");
	b11.setBounds(170,330,130,66) ;
	add(b11);
		b12 = new JButton("CLEAR ENTRY");
	b12.setBounds(170,396,130,66) ;
	add(b12);
		b13 = new JButton("NEW GAME");
	b13.setBounds(170,462,130,66) ;
	add(b13);
	
	

	//ACTION LISTENER 
	
	  b13.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
         random r = new random();
		 int no =r.generate();
		 String b = String.format("%04d",no);
		 actual_no.setText(b);
				   t1.setText(""); 
			t2.setText(""); 
			t3.setText("");
		 }  
    });
	
	
	
	//dial pad

	
		int[] dailed=new int[11];
		int[] predicted =new int[2];
		for(int x=0;x<10;x++)
		{
		dailed[x]=0;
		}
	predicted[0]=0;		

int [] count = new int[2];
count[0]=0;

b12.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
     
			
		   t1.setText(""); 
			t2.setText(""); 
			t3.setText(""); 		   
			count[0]=0;
			predicted[0]=0;
		
			for(int z =0 ;z<11 ; z++)
			{
			dailed[z]=0;
			}
			
		
	}  
    });

//checks entry
b11.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
	
	
			String no = actual_no.getText();
			int result = Integer.parseInt(no);

			
			int[] array=new int[4];
			int [] pre_array =new int [4];
			for(int z =0 ;z<4 ; z++)
			{
			array[z]=result%10;
			result=result/10;
			}
			
			for(int z =0 ;z<4 ; z++)
			{
			pre_array[z]=predicted[0]%10;
			predicted[0]=predicted[0]/10;
			}
			
			 int outt=0;
			for(int z=0 ; z<4 ;z++)
			{
				for(int a=3; a<4 ; a++)
				{
					if(a!=z)
					{
							if(pre_array[z]==array[a])
							{outt++;}
					}
				}			
			}
			 int inn=0;
				for(int a=0; a<4 ; a++)
				{
				if(pre_array[a]==array[a])
				{inn++;}
				}
			
			
			
            String in = String.format("%d",inn);
			String out = String.format("%d",outt);
			t2.setText(in);
			t3.setText(out);
			
	}  
    });
	
	
	
	b10.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
		if(dailed[0]==0 &&count[0]<=3)
			{
			count[0]=count[0]+1;
			dailed[0]=1;
			
			predicted[0]=predicted[0]*10+0;
			
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
	}  
    });
	b9.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
          	if(dailed[1]==0 &&count[0]<=3)
			{
			count[0]=count[0]+1;
			dailed[1]=1;
			predicted[0]=predicted[0]*10+9;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		 
    }  
    });
	b8.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
           	if(dailed[2]==0 &&count[0]<=3)
			{
				count[0]=count[0]+1;
			dailed[2]=1;
			predicted[0]=predicted[0]*10+8;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		  
    }  
    });
	b7.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            	if(dailed[3]==0 &&count[0]<=3)
			{
				count[0]=count[0]+1;
			dailed[3]=1;
			predicted[0]=predicted[0]*10+7;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		
    }  
    });
	b6.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
        	if(dailed[4]==0 &&count[0]<=3)
			{
				count[0]=count[0]+1;
			dailed[4]=1;
			predicted[0]=predicted[0]*10+6;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		    }  
    });
	b5.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            	if(dailed[5]==0 &&count[0]<=3)
			{
				count[0]=count[0]+1;
			dailed[5]=1;
			predicted[0]=predicted[0]*10+5;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		    }  
    });
	b4.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
         	if(dailed[6]==0 &&count[0]<=3)
			{
				count[0]=count[0]+1;
			dailed[6]=1;
			predicted[0]=predicted[0]*10+4;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		  
    }  
    });
	b3.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
        	if(dailed[7]==0 && count[0]<=3)
			{
				count[0]=count[0]+1;
			dailed[7]=1;
			predicted[0]=predicted[0]*10+3;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		  
    }  
    });
	b2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            	if(dailed[8]==0 && count[0]<=3)
			{
				count[0]=count[0]+1;
			dailed[8]=1;
			predicted[0]=predicted[0]*10+2;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		  
    }  
    });
	b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
        	if(dailed[9]==0 && count[0]<=3)
			{
				count[0]=count[0]+1;
			dailed[9]=1;
			predicted[0]=predicted[0]*10+1;
			String pre = String.format("%d",predicted[0]);
			t1.setText(pre);
			}	
		    }  
    });
	

	
	
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
  } 
 

  public static void main(String[] args)
  {
		fontend frm = new fontend();
  }
}

