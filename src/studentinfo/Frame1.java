package studentinfo;
import java.lang.*;
import java.lang.Object.*;
import java.sql.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * <p>Title: StudentINFO</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author ��һ��
 * @version 1.0
 */


public class Frame1 extends JFrame
{
  JPanel contentPane;
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JTextField jTextField1 = new JTextField();
  JTextField jTextField2 = new JTextField();
  JTextField jTextField3 = new JTextField();
  JTextField jTextField4 = new JTextField();

  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JButton jButton4 = new JButton();

  String stu_info[] = {"ѧ��","����","����ѧԺ","�����༶"};    // ��ά������
  Connection connection = null; // ����Connection�ӿڶ���connection
  ResultSet rSet = null; // �������ݿ��ѯ�Ľ����
  Statement statement = null; // �����ѯ���ݿ��Statement����
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenu1 = new JMenu();
  JMenu jMenuhelp = new JMenu();
  JMenuItem jMenuabout = new JMenuItem();
  JMenuItem jMenuexit = new JMenuItem();
  JTextPane jTextPane1 = new JTextPane();
  JLabel jLabel5 = new JLabel();
  JTextField jTextField5 = new JTextField();
  JButton jButton5 = new JButton();
  int ��ѯ��¼;


  //Construct the frame
  public Frame1()
  {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception
  {
    contentPane = (JPanel) this.getContentPane();
    jLabel1.setFont(new java.awt.Font("Dialog", 0, 15));
    jLabel1.setForeground(Color.black);
    jLabel1.setDebugGraphicsOptions(0);
    jLabel1.setToolTipText("");
    jLabel1.setVerifyInputWhenFocusTarget(true);
    jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel1.setIconTextGap(4);
    jLabel1.setText("ѧ��");
    jLabel1.setBounds(new Rectangle(47, 98, 47, 23));
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 341));
    this.setState(Frame.NORMAL);
    this.setTitle("ѧ��������Ϣ��");
    jLabel2.setFont(new java.awt.Font("Dialog", 0, 15));
    jLabel2.setToolTipText("");
    jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel2.setText("����");
    jLabel2.setBounds(new Rectangle(40, 137, 56, 25));
    jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
    jLabel3.setToolTipText("");
    jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel3.setText("����ѧԺ");
    jLabel3.setBounds(new Rectangle(34, 173, 63, 27));
    jLabel4.setFont(new java.awt.Font("Dialog", 0, 15));
    jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel4.setText("�����༶");
    jLabel4.setBounds(new Rectangle(28, 215, 71, 29));
    jTextField1.setText("");
    jTextField1.setBounds(new Rectangle(106, 95, 95, 27));
    jTextField2.setText("");
    jTextField2.setBounds(new Rectangle(107, 136, 93, 28));
    jTextField3.setText("");
    jTextField3.setBounds(new Rectangle(108, 174, 91, 25));
    jTextField4.setText("");
    jTextField4.setBounds(new Rectangle(108, 212, 91, 26));


    jButton1.setBounds(new Rectangle(250, 95, 73, 31));
    jButton1.setFont(new java.awt.Font("Dialog", 0, 15));
    jButton1.setToolTipText("");
    jButton1.setText("�޸�");
    jButton1.addActionListener(new Frame1_jButton1_actionAdapter(this));
    jButton2.setBounds(new Rectangle(250, 146, 74, 34));
    jButton2.setFont(new java.awt.Font("Dialog", 0, 15));
    jButton2.setToolTipText("");
    jButton2.setVerifyInputWhenFocusTarget(true);
    jButton2.setText("���");
    jButton2.addActionListener(new Frame1_jButton2_actionAdapter(this));
    jButton3.setBounds(new Rectangle(213, 250, 75, 28));
    jButton3.setFont(new java.awt.Font("Monospaced", 1, 15));
    jButton3.setToolTipText("");
    jButton3.setText("ɾ��");
    jButton3.addActionListener(new Frame1_jButton3_actionAdapter(this));
    jButton4.setBounds(new Rectangle(253, 201, 73, 36));
    jButton4.setFont(new java.awt.Font("Dialog", 0, 15));
    jButton4.setToolTipText("");
    jButton4.setText("ȡ��");
    jButton4.addActionListener(new Frame1_jButton4_actionAdapter(this));

    jMenu1.setActionCommand("�ļ�");
    jMenu1.setText("�ļ�");
    jMenuhelp.setAction(null);
    jMenuhelp.setActionCommand("����");
    jMenuhelp.setText("����");
    jMenuabout.setPreferredSize(new Dimension(55, 21));
    jMenuabout.setToolTipText("");
    jMenuabout.setActionCommand("����");
    jMenuabout.setSelected(false);
    jMenuabout.setText("����");
    jMenuexit.setActionCommand("�˳�");
    jMenuexit.setText("�˳�");
    jTextPane1.setBackground(SystemColor.control);
    jTextPane1.setFont(new java.awt.Font("Dialog", 0, 14));
    jTextPane1.setBorder(BorderFactory.createLoweredBevelBorder());
    jTextPane1.setEditable(false);
    jTextPane1.setText("");
    jTextPane1.setBounds(new Rectangle(40, 1, 316, 86));
    jLabel5.setFont(new java.awt.Font("Monospaced", 1, 15));
    jLabel5.setOpaque(true);
    jLabel5.setPreferredSize(new Dimension(94, 22));
    jLabel5.setRequestFocusEnabled(false);
    jLabel5.setToolTipText("");
    jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel5.setHorizontalTextPosition(SwingConstants.TRAILING);
    jLabel5.setIconTextGap(4);
    jLabel5.setText("������ѧ�ţ� ");
    jLabel5.setVerticalAlignment(SwingConstants.CENTER);
    jLabel5.setVerticalTextPosition(SwingConstants.CENTER);
    jLabel5.setBounds(new Rectangle(5, 245, 109, 38));
    jTextField5.setFont(new java.awt.Font("Dialog", 0, 15));
    jTextField5.setCaretPosition(0);
    jTextField5.setText("");
    jTextField5.setColumns(0);
    jTextField5.setBounds(new Rectangle(107, 251, 94, 28));
    jButton5.setBounds(new Rectangle(315, 249, 75, 30));
    jButton5.setFont(new java.awt.Font("Monospaced", 1, 15));
    jButton5.setToolTipText("");
    jButton5.setText("��ѯ");
    jButton5.addActionListener(new Frame1_jButton5_actionAdapter(this));
    contentPane.add(jTextPane1, null);
    contentPane.add(jTextField5, null);
    contentPane.add(jButton5, null);
    contentPane.add(jButton3, null);
    contentPane.add(jTextField4, null);
    contentPane.add(jTextField3, null);
    contentPane.add(jTextField2, null);
    contentPane.add(jTextField1, null);
    contentPane.add(jLabel4, null);
    contentPane.add(jLabel5, null);
    contentPane.add(jLabel3, null);
    contentPane.add(jLabel2, null);
    contentPane.add(jLabel1, null);
    contentPane.add(jButton4, null);
    contentPane.add(jButton2, null);
    contentPane.add(jButton1, null);
    jMenuBar1.add(jMenu1);
    jMenu1.addSeparator();
    jMenu1.add(jMenuexit);
    jMenuBar1.add(jMenuhelp);
    jMenuhelp.add(jMenuabout);
    this.setJMenuBar(jMenuBar1);
  }


  //File | Exit action performed
 public void jMenuexit_ActionPerformed(ActionEvent e)
 {
   System.exit(0);
 }

 //Help | About action performed
 public void jMenuabout_ActionPerformed(ActionEvent e)
 {
   Frame1_AboutBox dlg = new Frame1_AboutBox(this);
   Dimension dlgSize = dlg.getPreferredSize();
   Dimension frmSize = getSize();
   Point loc = getLocation();
   dlg.setLocation( 132 + loc.x,
                    122 + loc.y);
   dlg.setModal(true);
   dlg.pack();
   dlg.show();
 }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e)
  {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING)
    {
      System.exit(0);
    }
  }

  class Frame1_jMenuabout_ActionAdapter implements ActionListener
  {
    Frame1 adaptee;

    Frame1_jMenuabout_ActionAdapter(Frame1 adaptee)
    {
      this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e)
    {
      adaptee.jMenuabout_ActionPerformed(e);
    }
  }


    void jButton1_actionPerformed(ActionEvent e)                    // �����޸İ�ť��ActionEvent
    {
      try
      {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");               // ʵ����JDBC-ODBC�ŵ�����
        connection = DriverManager.getConnection("jdbc:odbc:student","sa","123456");  // �������ݿ�
        // ����Statement�ӿڶ���
        statement = connection.createStatement();
        if (jTextField1.getText().length() == 0)
        {
          jTextPane1.setText("�����޸ģ���������ѧ�ţ�");
        }
        else {
          if (jTextField2.getText().length() != 0)
            statement.executeUpdate("update stu_info set ����='" +
                                    jTextField2.getText() + "' where ѧ��='" +
                                    jTextField1.getText() + "'"); // ����stu_info����ѧ����صļ�¼
          if (jTextField3.getText().length() != 0)
            statement.executeUpdate("update stu_info set ����ѧԺ='" +
                                    jTextField3.getText() + "' where ѧ��='" +
                                    jTextField1.getText() + "'"); // ����stu_info����ѧ����صļ�¼
          if (jTextField4.getText().length() != 0)
            statement.executeUpdate("update stu_info set �����༶='" +
                                    jTextField4.getText() + "' where ѧ��='" +
                                    jTextField1.getText() + "'"); // ����stu_info��������ѧ�ŵļ�¼
          if (jTextField2.getText().length() == 0 &
              jTextField3.getText().length() == 0 &
              jTextField4.getText().length() == 0) {
            jTextPane1.setText("�޸Ĳ��ɹ�,���������룡");
          }
          else {
            jTextPane1.setText("��¼�޸ĳɹ�!");
          }
        }
        // �����Ϣ��
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
      }
      catch(SQLException ex)                                    // ��׽�쳣
      {
        jTextPane1.setText(ex.getMessage());
        System.out.println("\nERROR:----- SQLException -----\n");
        while (ex != null)
        {
          System.out.println("Message:   " + ex.getMessage());
          System.out.println("SQLState:  " + ex.getSQLState());
          System.out.println("ErrorCode: " + ex.getErrorCode());
          ex = ex.getNextException();
        }
      }
      catch(Exception ex )
      {
        ex.printStackTrace();
      }
      finally
      {
        try
        {
          if(statement != null)
          {
            statement.close();                                // �ر�Statement�ӿ�ʵ��
          }
          if(connection != null)
          {
            connection.close();                               // �ر�Connection�ӿ�ʵ��
          }
        }
        catch (SQLException ex)
        {
          System.out.println("\nERROR:----- SQLException -----\n");
          System.out.println("Message:   " + ex.getMessage( ));
          System.out.println("SQLState:  " + ex.getSQLState());
          System.out.println("ErrorCode: " + ex.getErrorCode());
        }
      }
    }


    void jButton2_actionPerformed(ActionEvent e)                  // ������Ӱ�ťActionEvent
    {
      try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // ʵ����JDBC-ODBC�ŵ�����
        connection = DriverManager.getConnection("jdbc:odbc:student", "sa",
                                                 "123456"); // �������ݿ�
        // ����Statement�ӿڶ���
        statement = connection.createStatement();
        String sql1 = "insert  into stu_info  values ('" + jTextField1.getText() +
            "','" + jTextField2.getText() + "','" + jTextField3.getText() + "','" +
            jTextField4.getText() + "')";
        if (jTextField1.getText().length() == 0) {
          jTextPane1.setText("�����޸ģ���������ѧ�ţ�");
          // �����Ϣ��
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField3.setText("");
          jTextField4.setText("");
        }
        else {
          statement.executeUpdate(sql1); // stu_info������Ӽ�¼
          jTextPane1.setText("��¼��ӳɹ�!");
          // �����Ϣ��
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField3.setText("");
          jTextField4.setText("");
        }
      }
      catch (SQLException ex) { // ��׽�쳣
        jTextPane1.setText(ex.getMessage());
        System.out.println("\nERROR:----- SQLException -----\n");
        while (ex != null) {
          System.out.println("Message:   " + ex.getMessage());
          System.out.println("SQLState:  " + ex.getSQLState());
          System.out.println("ErrorCode: " + ex.getErrorCode());
          ex = ex.getNextException();
        }
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
      finally {
        try {
          if (statement != null) {
            statement.close(); // �ر�Statement�ӿ�ʵ��
          }
          if (connection != null) {
            connection.close(); // �ر�Connection�ӿ�ʵ��
          }
        }
        catch (SQLException ex) {
          System.out.println("\nERROR:----- SQLException -----\n");
          System.out.println("Message:   " + ex.getMessage());
          System.out.println("SQLState:  " + ex.getSQLState());
          System.out.println("ErrorCode: " + ex.getErrorCode());
        }
      }
    }

   void  jButton3_actionPerformed(ActionEvent e)                  // ����ɾ����ť��ActionEvent
   {
      try
      {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");           // ʵ����JDBC-ODBC�ŵ�����
        connection = DriverManager.getConnection("jdbc:odbc:student","sa","123456");  // �������ݿ�
        // ����Statement�ӿڶ���
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rSet = statement.executeQuery("select ѧ�� from stu_info ");
        if (rSet.next()==false)                        // �ж����ݿ����Ƿ���Ҫɾ���ļ�¼����û������ʾ��ʾ��
        {
          jTextField5.setText("");
          jTextPane1.setText("���ݿ���û����Ҫɾ����ѧ��!");
        }
        else
        {
          String sql2="delete from stu_info where ѧ��='"+jTextField5.getText()+"'";
          statement.executeUpdate(sql2);             // ɾ��stu_info���ж�Ӧѧ�ŵ����ݼ�¼
          // �����Ϣ��
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField3.setText("");
          jTextField4.setText("");
          jTextField5.setText("");
          jTextPane1.setText("��¼�ѳɹ�ɾ��!");
        }
      }
      catch(SQLException ex)                      // ��׽�쳣
      {
         System.out.println("\nERROR:----- SQLException -----\n");
        while (ex != null)
        {
           System.out.println("Message:   " + ex.getMessage());
           System.out.println("SQLState:  " + ex.getSQLState());
           System.out.println("ErrorCode: " + ex.getErrorCode());
           ex = ex.getNextException();
        }
      }
      catch(Exception ex )
      {
        ex.printStackTrace();
      }
      finally
      {
        try
        {
          if(statement != null)
          {
            statement.close();                                // �ر�Statement�ӿ�ʵ��
          }
          if(connection != null)
          {
            connection.close();                               // �ر�Connection�ӿ�ʵ��
          }
        }
        catch (SQLException ex)
        {
          System.out.println("\nERROR:----- SQLException -----\n");
          System.out.println("Message:   " + ex.getMessage( ));
          System.out.println("SQLState:  " + ex.getSQLState());
          System.out.println("ErrorCode: " + ex.getErrorCode());
        }
      }
    }
    void jButton4_actionPerformed(ActionEvent e)
    {
      jTextField1.setText("");
      jTextField2.setText("");
      jTextField3.setText("");
      jTextField4.setText("");
      jTextField5.setText("");
      jTextPane1.setText("");
    }

    void jButton5_actionPerformed(ActionEvent e)             // �����ѯ��ť��ActionEvent
    {
      try
      {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  // ʵ����JDBC-ODBC�ŵ�����
        connection = DriverManager.getConnection("jdbc:odbc:student","sa","123456");  // �������ݿ�
        // ����Statement�ӿڶ���
        statement = connection.createStatement();
        rSet = statement.executeQuery("select * from stu_info ");
        String sno;
        sno = rSet.getString(1);
        if (rSet.next()==false)                  // �ж����ݿ����Ƿ���Ҫ��ѯ�ļ�¼����û������ʾ��ʾ��
        {
          jTextField5.setText("");
          jTextPane1.setText("���ݿ���û������ѯ��ѧ��!");
        }
        else{
          if (sno.equals(jTextField5.getText())) {
              jTextField5.setText("");
              jTextPane1.setText("��ѯ��Ϣ����:"); //��ʾ����
              jTextField1.setText(rSet.getString(1));
              jTextField2.setText(rSet.getString(2));
              jTextField3.setText(rSet.getString(3));
              jTextField4.setText(rSet.getString(4));
            }
            else
            {
              jTextField5.setText("");
              jTextPane1.setText("���ݿ���û������ѯ��ѧ��!");
            }
        }
      }

      catch(SQLException ex)                      // ��׽�쳣
      {
        System.out.println("\nERROR:----- SQLException -----\n");
        while (ex != null)
        {
          System.out.println("Message:   " + ex.getMessage());
          System.out.println("SQLState:  " + ex.getSQLState());
          System.out.println("ErrorCode: " + ex.getErrorCode());
          ex = ex.getNextException();
        }
      }
      catch(Exception ex )
      {
        ex.printStackTrace();
      }
      finally
      {
        try
        {
          if(statement != null)
          {
            statement.close();                                // �ر�Statement�ӿ�ʵ��
          }
          if(connection != null)
          {
            connection.close();                               // �ر�Connection�ӿ�ʵ��
          }
        }
      catch (SQLException ex)
      {
        System.out.println("\nERROR:----- SQLException -----\n");
        System.out.println("Message:   " + ex.getMessage( ));
        System.out.println("SQLState:  " + ex.getSQLState());
        System.out.println("ErrorCode: " + ex.getErrorCode());
      }
    }
  }
}
class Frame1_jButton4_actionAdapter implements java.awt.event.ActionListener {
  Frame1 adaptee;

  Frame1_jButton4_actionAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton4_actionPerformed(e);
  }
}

class Frame1_jButton2_actionAdapter implements java.awt.event.ActionListener {
  Frame1 adaptee;

  Frame1_jButton2_actionAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}
class Frame1_jButton1_actionAdapter implements java.awt.event.ActionListener {
  Frame1 adaptee;

  Frame1_jButton1_actionAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}
class Frame1_jButton3_actionAdapter implements java.awt.event.ActionListener {
  Frame1 adaptee;

  Frame1_jButton3_actionAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class Frame1_jButton5_actionAdapter implements java.awt.event.ActionListener {
  Frame1 adaptee;

  Frame1_jButton5_actionAdapter(Frame1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton5_actionPerformed(e);
  }
}







