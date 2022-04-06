package pkg9.boxpuzzle;
import java.io.*;
import java.lang.*;
import java.awt.Graphics;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.String;
import javax.swing.*;

public class BoxPuzzle extends JFrame implements ActionListener, KeyListener{

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class MyButton extends Button{
        
        private MyButton(String string, Color black) {
        }
        class MouseCalcButtonAdapter
        {
            public void mouseEntered(MouseEvent me)
            {
            }
            public void mouseExited(MouseEvent me)
            {   
            }
        }
        public void mouseEntered(MouseEvent me)
        {
        }
        public void mouseExited(MouseEvent me)
        {            
        }
    }

    private MyButton[] button;
    private JLabel l1,l2,l3,l4;
    private JTextField tf1,tf2;
    private String[] B1={"7","8","4","3","6","1","2","5","","Start","Restart","Finish"};
    private String[] B2={"1","2","3","4","5","6","7","8",""};
    private int click_count;
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints gbc1=new GridBagConstraints();
    JPanel pan1,pan2;
    String str1="";
    
    BoxPuzzle()
    {
        super("9-Box Puzzle");
        l1=new JLabel("Puzzle");
        l1.setFont(new Font("Times Roman", Font.BOLD,20));
        l1.setForeground(Color.blue);
        l2=new JLabel("Name of the Player");
        l2.setFont(new Font("Times Roman", Font.BOLD,15));
        l2.setForeground(Color.blue);
        l3=new JLabel("Number of clicks");
        l3.setFont(new Font("Times Roman", Font.BOLD,15));
        l3.setForeground(Color.blue);
        l4= new JLabel();
        button=new MyButton[12];
        for(int i=0;i<12;i++)
        {
            button[i]=new MyButton(B1[i],Color.black);
            button[i].addActionListener(this);
        }
        tf1=new JTextField(20);
        tf2=new JTextField(20);
        tf1.setFont(new Font("Times Roman",Font.BOLD,12));
        tf2.setFont(new Font("Times Roman",Font.BOLD,12));
        tf1.setText("");
        tf2.setText("");
        tf1.addKeyListener(this);
        tf2.addKeyListener(this);
        click_count=0;
        setSize(500,500);
        setVisible(true);
        displayPanel();
    }
    public void actionPerformed(ActionEvent ae)
    {
        int index=8,i;
        String str,temp,count;
        boolean check;
        for(i=0;i<9;i++)
        {
            if(button[i].getLabel()=="")
                index=i;
        }
        if(ae.getSource()==button[9])               
        {
            for(int j=0;j<=8;j++)
                button[j].setEnabled(true);
            button[9].setEnabled(false);
        }
        if(ae.getSource()==button[10])
        {
            for(i=0;i<9;i++)
            {
                button[i].setEnabled(true);
                button[i].setLabel(B1[i]);
            }
            click_count=0;
            tf2.setText("0");
        }
        if((ae.getSource()!=button[9])||(ae.getSource()!=button[10]))
        {
            check=checkStatus();
            if(check==false)
            {
                if(ae.getSource()==button[0])
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==1||index==3)
                    {
                        str=button[0].getLabel();
                        button[0].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[1])
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==0||index==4||index==2)
                    {
                        str=button[1].getLabel();
                        button[1].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[2])
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==1||index==5)
                    {
                        str=button[2].getLabel();
                        button[2].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[3])
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==0||index==4||index==6)
                    {
                        str=button[3].getLabel();
                        button[3].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[4])
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==1||index==3||index==5||index==7)
                    {
                        str=button[4].getLabel();
                        button[4].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[5])
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==2||index==4||index==8)
                    {
                        str=button[5].getLabel();
                        button[5].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[6])
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==3||index==7)
                    {
                        str=button[6].getLabel();
                        button[6].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[7])
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==6||index==4||index==8)
                    {
                        str=button[7].getLabel();
                        button[7].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[8])           //exit button
                {
                    count=Integer.toString(countClicks());
                    tf2.setText(count);
                    if(index==5||index==7)
                    {
                        str=button[8].getLabel();
                        button[8].setLabel("");
                        button[index].setLabel(str);
                    }
                }
                if(ae.getSource()==button[10])            //restart button
                {
                    for(i=0;i<9;i++)
                    {
                        button[i].setEnabled(true);
                        button[i].setLabel(B1[i]);
                    }
                    click_count=0;
                    tf2.setText("0");
                }
                if(ae.getSource()==button[11])         //finish button   
                {
                    for(i=0;i<8;i++)
                    {
                        button[i].setLabel(B1[i]);
                    }
                    click_count=0;
                    tf2.setText("0");
                    button[11].setEnabled(false);
                    button[10].setEnabled(false);
                }
            }
            else
            {
                String st=str1+",you have won the game.";
                for(int j=0;j<=8;j++)
                    button[j].setEnabled(false);
                JOptionPane.showMessageDialog(null,st);
            }
        }
    }
    public void displayPanel()
    {
        JPanel pa4=new JPanel();
        pan1=new JPanel();          //main panel
        pan1.setLayout(grid);
        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.ipadx=0;              //width
        gbc1.ipady=0;              //height
        gbc1.gridwidth=1;
        gbc1.gridheight=1;
        gbc1.gridx=0;
        gbc1.gridy=0;
        grid.setConstraints(l1,gbc1);
        pan1.add(l1);
        
        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.ipadx=5;              //width
        gbc1.ipady=5;              //height
        gbc1.gridwidth=1;
        gbc1.gridheight=1;
        gbc1.gridx=1;
        gbc1.gridy=0;
        grid.setConstraints(button[9],gbc1);
        pan1.add(button[9]);
        
        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.ipadx=0;              //width
        gbc1.ipady=0;              //height
        gbc1.gridwidth=1;
        gbc1.gridheight=2;
        gbc1.gridx=0;
        gbc1.gridy=2;
        grid.setConstraints(l2,gbc1);
        pan1.add(l2);
        
        grid.setConstraints(tf1,gbc1);
        pan1.add(tf1);
        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.ipadx=0;              //width
        gbc1.ipady=0;              //height
        gbc1.gridwidth=1;
        gbc1.gridheight=2;
        gbc1.gridx=0;
        gbc1.gridy=4;
        pa4.setLayout(new GridLayout(3,3,5,5));
        for(int i=0;i<9;i++)
        {
            pa4.add(button[i]);
            button[i].setEnabled(false);
        }
        grid.setConstraints(pa4,gbc1);
        pan1.add(pa4);
        
        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.ipadx=0;              //width
        gbc1.ipady=0;              //height
        gbc1.gridwidth=1;
        gbc1.gridheight=1;
        gbc1.gridx=0;
        gbc1.gridy=6;
        grid.setConstraints(l3,gbc1);
        pan1.add(l3);
        gbc1.ipadx=0;              //width
        gbc1.ipady=0;              //height
        
        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.gridwidth=1;
        gbc1.gridheight=1;
        gbc1.gridx=1;
        gbc1.gridy=6;
        grid.setConstraints(tf1,gbc1);
        pan1.add(tf1);
        gbc1.ipadx=5;              //width
        gbc1.ipady=5;              //height
                
        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.gridwidth=1;
        gbc1.gridheight=1;
        gbc1.gridx=0;
        gbc1.gridy=7;
        grid.setConstraints(button[10],gbc1);
        pan1.add(button[10]);
        gbc1.ipadx=5;              //width
        gbc1.ipady=5;              //height

        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.gridwidth=1;
        gbc1.gridheight=1;
        gbc1.gridx=1;
        gbc1.gridy=7;
        grid.setConstraints(button[11],gbc1);
        pan1.add(button[11]);
        gbc1.ipadx=0;              //width
        gbc1.ipady=0;              //height

        gbc1.weightx=100;
        gbc1.weighty=100;
        gbc1.gridwidth=1;
        gbc1.gridheight=1;
        gbc1.gridx=0;
        gbc1.gridy=8;
        grid.setConstraints(l4,gbc1);
        pan1.add(l4);
        gbc1.ipadx=5;              //width
        gbc1.ipady=5;              //height
        getContentPane().add(pan1);
    }
    public int countClicks()
    {
        return (++click_count);
    }
    public boolean checkStatus()       //to check if the game is finished or not
    {
        int i;
        if((button[0].getLabel()=="1")&&(button[1].getLabel()=="2")&&(button[2].getLabel()=="3")&&(button[3].getLabel()=="4")&&(button[4].getLabel()=="5")&&(button[5].getLabel()=="6")&&(button[6].getLabel()=="7")&&(button[7].getLabel()=="8")&&(button[8].getLabel()==""))
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BoxPuzzle obj =new BoxPuzzle();
    }
    
}
