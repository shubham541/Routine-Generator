
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author kunal
 */
public class Ui implements ActionListener {
    public static void main(String[] args) {
        
        
/*******************code for splash********************/
        Splash s=new Splash();
        s.setVisible(true);
        Thread t=Thread.currentThread();
        try{
            t.sleep(100);
        }catch(InterruptedException e){};
        s.dispose();
/*****************************************************/

        new Ui();
    }
    
    JFrame f1;
    JLabel welcome;
    String filepath="res/bgClock.jpg";
    
    public Ui()
    {
        
        ImageIcon iconFrame = new ImageIcon(getClass().getResource("res/iconApp.png"));
        f1= new JFrame();
        f1.setIconImage(iconFrame.getImage());
        
        createMenuBar(f1);
        
        welcome = new JLabel();
        
        ImageIcon bgWelcome = new ImageIcon(getClass().getResource(filepath));
        //ImageIcon bgWelcome1 = new ImageIcon(getClass().getResource("res/bgjarvis.jpg"));
        welcome.setIcon(bgWelcome);
        f1.add(welcome);
        
        
        f1.setVisible(true);
        f1.setLocation(150, 50);
        f1.pack();
        f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
/*****************************************************************/
    
    Output displayOutput;        //object to show output time table
    
    
    //function for menu item
    JMenuItem newItem,exitItem,secItem,roomItem,instructorItem,aboutItem,changeScreenItem;
    
    public void actionPerformed(ActionEvent ev)
    {
        String cmdText = ev.getActionCommand();
        if(cmdText.equals("New"))
        {
            //FileHandler.newFile();
            f1.dispose();
            new Input();
        }
        else if(cmdText.equals("Exit"))
        {
            System.exit(0);
        }
        else if(cmdText.equals("Section"))
        {
            //code to display
            displayOutput= new Output();
            
        }
        else if(cmdText.equals("Room"))
        {
            //code to dispaly
            displayOutput= new Output();
        }
        else if(cmdText.equals("Instructor"))
        {
            //code to display
            displayOutput= new Output();
        }
        else if(cmdText.equals("About"))
        {
        UIManager um=new UIManager();
        um.put("OptionPane.background",Color.BLACK);
        um.put("Panel.background",Color.BLACK);
        um.put("OptionPane.messageForeground", Color.GREEN);
        um.put("Button.background", Color.WHITE);

        JOptionPane.showMessageDialog(Ui.this.f1,"<html><big>Personal use only</big>"
                +"<br> Made by :<br>Kumar Atul<br> Kumar Shubham<br> Hritik Kumar<br> Kunal Kumar</html>","Help",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(cmdText.equals("Change Screen"))
        {
            //code to display
            changeScreenItem.addActionListener(
        a->
        {
            JFileChooser fc=new JFileChooser();    
            int i=fc.showOpenDialog(f1);    
            if(i==JFileChooser.APPROVE_OPTION){    
                File f=fc.getSelectedFile();    
                filepath=f.getPath();
                ImageIcon icon = new ImageIcon(filepath);
                welcome.setIcon(icon);
                
                f1.validate();
                //add your code to move ahead
                
            }
            
        }
        );
            
        }
        
    }
    
    
    
/*****************************************************************/
    JMenuItem createMenuItem(String s,JMenu toMenu,ActionListener al)
    {
        JMenuItem temp=new JMenuItem(s);
        temp.addActionListener(al);
        toMenu.add(temp);
        return temp;
    }
    
    
    JMenu createMenu(String s,JMenuBar toMenuBar)  //function to add menu
    {
        JMenu temp= new JMenu(s);
        toMenuBar.add(temp);
        return temp;
    }
    
    void createMenuBar(JFrame f1)
    {
        JMenuBar mb = new JMenuBar();
        mb.setBackground(new Color(24,24,24));
        mb.setOpaque(true);
        f1.setJMenuBar(mb);
        // adding Menu to MenuBar
        
        JMenu fileMenu = createMenu("File",mb);
        fileMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fileMenu.setForeground(Color.WHITE);
        fileMenu.setFont(new Font("monospace", 0, 20));
        fileMenu.setBackground(Color.WHITE);
        
        JMenu viewMenu = createMenu("View",mb);
        viewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewMenu.setForeground(Color.WHITE);
        viewMenu.setFont(new Font("monospace", 0, 20));
        
        JMenu settingMenu = createMenu("Setting",mb);
        settingMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settingMenu.setForeground(Color.WHITE);
        settingMenu.setFont(new Font("monospace", 0, 20));
        
        JMenu helpMenu = createMenu("Help",mb);
        helpMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        helpMenu.setForeground(Color.WHITE);
        helpMenu.setFont(new Font("monospace", 0, 20));
        
        // Now time to add subMenu
        
        newItem=createMenuItem("New",fileMenu,this);
        newItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newItem.setBackground(Color.BLACK);
        newItem.setForeground(Color.WHITE);
        
        fileMenu.addSeparator();
        
        exitItem=createMenuItem("Exit",fileMenu,this);
        exitItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitItem.setBackground(Color.BLACK);
        exitItem.setForeground(Color.WHITE);
        
        secItem=createMenuItem("Section",viewMenu,this);
        secItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        secItem.setBackground(Color.BLACK);
        secItem.setForeground(Color.WHITE);
        
        viewMenu.addSeparator();

        
        roomItem=createMenuItem("Room",viewMenu,this);
        roomItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        roomItem.setBackground(Color.BLACK);
        roomItem.setForeground(Color.WHITE);
        
        viewMenu.addSeparator();
        
        instructorItem=createMenuItem("Instructor",viewMenu,this);
        instructorItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        instructorItem.setBackground(Color.BLACK);
        instructorItem.setForeground(Color.WHITE);
        
        changeScreenItem=createMenuItem("Change Screen",settingMenu,this);
        changeScreenItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changeScreenItem.setBackground(Color.BLACK);
        changeScreenItem.setForeground(Color.WHITE);
        
        aboutItem=createMenuItem("About",helpMenu,this);
        aboutItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        aboutItem.setBackground(Color.BLACK);
        aboutItem.setForeground(Color.WHITE);
        
    }
    
    
}

class Input
{
    JFrame inputFrame,prevFrame;
    JButton back,generate;
    JButton tSB,cB,iB,rB,sB;
    Ui uiRef = new Ui();
    JLabel inputScreen;
    

    public Input() {
        
        
        
        prevFrame=new JFrame();
        prevFrame=uiRef.f1;
        inputFrame = new JFrame();
        inputFrame.setVisible(true);
        inputFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        inputFrame.setSize(400, 200);
        inputFrame.setResizable(false);
        inputFrame.setLocation(400, 200);
        
        //initialise each button
        tSB = new JButton("Open");
        tSB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cB = new JButton("Open");
        cB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        iB = new JButton("Open");
        iB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rB = new JButton("Open");
        rB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sB = new JButton("Open");
        sB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
      
       //add button to frame
        JPanel gui = new JPanel(new BorderLayout());
        JPanel gridButton = new JPanel(new GridLayout(0,2,2,2));
        gridButton.add(new JLabel("Upload Time Slot File"));
        gridButton.add(tSB);
        gridButton.add(new JLabel("Upload Courses File"));
        gridButton.add(cB);
        gridButton.add(new JLabel("Upload Instructor Detail File"));
        gridButton.add(iB);
        gridButton.add(new JLabel("Upload Section File"));
        gridButton.add(sB);
        gridButton.add(new JLabel("Upload Room File"));
        gridButton.add(rB);
        
        JPanel gridConstrain = new JPanel(new BorderLayout());
        gridConstrain.add(gridButton, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        back = new JButton("Back");
        buttonPanel.add(back);
        /***********************code for back *******************/
         back.addActionListener(ae->
        {
            inputFrame.dispose();
            prevFrame.setVisible(true);

            
        });
        /*******************************************************/
        generate = new JButton("Generate");
        buttonPanel.add(generate);
        /**********************code for generate Button***************/
         generate.addActionListener(ae->
        {
            //write code for output

            
        });
         
        /******************************************************/
        
        
        
        gridConstrain.add(buttonPanel,BorderLayout.SOUTH);

        gui.add(gridConstrain, BorderLayout.CENTER);

        gui.setPreferredSize(new Dimension(250,150));
        
        inputFrame.add(gui);
        
/**************************code to add action for file choose*************/
        
        tSB.addActionListener(
        atSB->
        {
            JFileChooser fc=new JFileChooser();    
            int i=fc.showOpenDialog(inputFrame);    
            if(i==JFileChooser.APPROVE_OPTION){    
                //File f=fc.getSelectedFile();    
                //String filepath=f.getPath(); 
                
                //add your code to move ahead
                
                
                
                tSB.setBackground(Color.red);
            }
        }
        );
        
        cB.addActionListener(
        acB->
        {
            JFileChooser fc=new JFileChooser();    
            int i=fc.showOpenDialog(inputFrame);    
            if(i==JFileChooser.APPROVE_OPTION){    
                //File f=fc.getSelectedFile();    
                //String filepath=f.getPath(); 
                
                //add your code to move ahead
                
                
                cB.setBackground(Color.red);
            }
        }
        );
        
        iB.addActionListener(
        aiB->
        {
            JFileChooser fc=new JFileChooser();    
            int i=fc.showOpenDialog(inputFrame);    
            if(i==JFileChooser.APPROVE_OPTION){    
                //File f=fc.getSelectedFile();    
                //String filepath=f.getPath();  
                
                
                //add your code to move ahead
                
                iB.setBackground(Color.red);
            }
        }
        );
        
        rB.addActionListener(
        arB->
        {
            JFileChooser fc=new JFileChooser();    
            int i=fc.showOpenDialog(inputFrame);    
            if(i==JFileChooser.APPROVE_OPTION){    
                //File f=fc.getSelectedFile();    
                //String filepath=f.getPath();
                
                //add your code to move ahead
                
                
                
                
                rB.setBackground(Color.red);
            }
        }
        );
        
        sB.addActionListener(
        asB->
        {
            JFileChooser fc=new JFileChooser();    
            int i=fc.showOpenDialog(inputFrame);    
            if(i==JFileChooser.APPROVE_OPTION){    
                //File f=fc.getSelectedFile();    
                //String filepath=f.getPath();  
                
                //add your code to move ahead
                
                
                sB.setBackground(Color.red);
            }
        }
        );
        
/**************************************************************/
        
    }
    
}


class Output
{
    JFrame outputFrame;
    JTable timeTable;
    DefaultTableModel model;

    JButton export;
    int rbCount=0;
    ButtonGroup rbgroup;
    String [] list={"WONG","APM","DB","DRS","SNS"}; //array to store data from clicked menu type
    
    String routine[][]={{"Day","1st","2nd","3rd","4th","5th","6th","7th"}, {"Tuesday","Microprocessor","Economics","Math","Microprocessor","Algorithm lab(c1)/c++ lab(c2)"
    ,"Algorithm lab(c1)/c++ lab(c2)","Algorithm lab(c1)/c++ lab(c2)"},{"Wednesday","","","","","","",""},
    {"Thursday","","","","","","",""},
    {"Friday","","","","","","",""},
    {"Saturday","","","","","","",""}};    
    String title[]={"Day","1st","2nd","3rd","4th","5th","6th","7th"}; 
    String defaultTitle [][] = new String[1][title.length];
    
    int noOfRadio;
    
    int e;
    
        
    
    public Output()
    {
        for(int i=0;i<8;i++)
        {
            defaultTitle[0][i]=title[i];
        }
        
        outputFrame = new JFrame();
        timeTable=new JTable(routine, title);
        model = new DefaultTableModel();

        outputFrame.setVisible(true);
        outputFrame.setSize(800, 600);
        outputFrame.setLayout(new BorderLayout());
        outputFrame.add(timeTable, BorderLayout.CENTER);
        
        JPanel bottom= new JPanel();
        bottom.setBackground(Color.BLACK);
        bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        export = new JButton("Export");
        export.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        export.setBackground(Color.YELLOW);
        export.setForeground(Color.BLUE);
        bottom.add(export);
        outputFrame.add(bottom,BorderLayout.SOUTH);
        
        JPanel upperp= new JPanel();
        upperp.setLayout(new FlowLayout(FlowLayout.CENTER));
        upperp.setBackground(Color.BLACK);
        JLabel upper = new JLabel("TIME TABLE");
        upper.setForeground(Color.WHITE);
        upper.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        upperp.add(upper);
        outputFrame.add(upperp,BorderLayout.NORTH);
        
/*************************** code for creating dynamic radio button for instructor *******************************/

        
        noOfRadio=list.length;
        JRadioButton []jrb=new JRadioButton[noOfRadio];
        rbgroup=new ButtonGroup();
        
        
        for(rbCount=0;rbCount<noOfRadio;rbCount++)
        {
            jrb[rbCount]=new JRadioButton(list[rbCount]);
            jrb[rbCount].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
        }
        for(int i=0;i<noOfRadio;i++)
        {
            rbgroup.add(jrb[i]);
        }
        JPanel gridRadio = new JPanel(new GridLayout(0,1,2,2));
        for(int i=0;i<noOfRadio;i++){
           
            gridRadio.add(jrb[i]);
        }
        
        
        // code for fumction of radio button
       
       
       /*ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JRadioButton) {
                  if("Kunal".equals(((JRadioButton)e.getSource()).getText()))
                  { 
                      String []localRow=new String[title.length];
                      for(int i=0;i<title.length;i++)
                      {
                          localRow[i]=routine[1][i];
                      }
                      model.addRow(localRow);
                      timeTable.setModel(model);
                  }
                }
            }
       };
       for(e=0;e<5;e++)
       {
           jrb[e].addActionListener(listener);
       }*/
        
     
        
        
/*********************************************************************************************/

/**************************************** code for export ***************************************************/
        
        
           
           

/*********************************************************************************************/


        
        JPanel gridConstrain = new JPanel(new BorderLayout());
        gridConstrain.add(gridRadio, BorderLayout.NORTH);
        outputFrame.add(gridConstrain,BorderLayout.WEST);

        
        
        
        
        
        
        
    }
    
    
}


class Splash extends JFrame {
 
    private JLabel imglabel;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;
    //Ui forPath=new Ui();
    String st,st1="";
 
    public Splash() {
        
        super("Splash");
        
        
        
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setResizable(false);
        ImageIcon iconFrame = new ImageIcon(getClass().getResource("res/iconApp.png"));
        setIconImage(iconFrame.getImage());
        
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        img = new ImageIcon(getClass().getResource("/res/loading.gif"));
        imglabel = new JLabel(img);
        add(imglabel);
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.LIGHT_GRAY);
        imglabel.setBounds(0, 0, 600, 400);
        //add(pbar);
        pbar.setPreferredSize(new Dimension(310, 30));
        pbar.setBounds(0, 290, 404, 20);
 
        Thread t = new Thread() {
 
            public void run() {
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    try {
                        sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        
        t.start();
        
        
        
    }
}



