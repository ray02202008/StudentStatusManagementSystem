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
 * @author 杨一宁
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

  String stu_info[] = {"学号","姓名","所属学院","所属班级"};    // 二维表列名
  Connection connection = null; // 声明Connection接口对象connection
  ResultSet rSet = null; // 定义数据库查询的结果集
  Statement statement = null; // 定义查询数据库的Statement对象
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenu1 = new JMenu();
  JMenu jMenuhelp = new JMenu();
  JMenuItem jMenuabout = new JMenuItem();
  JMenuItem jMenuexit = new JMenuItem();
  JTextPane jTextPane1 = new JTextPane();
  JLabel jLabel5 = new JLabel();
  JTextField jTextField5 = new JTextField();
  JButton jButton5 = new JButton();
  int 查询记录;


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
    jLabel1.setText("学号");
    jLabel1.setBounds(new Rectangle(47, 98, 47, 23));
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 341));
    this.setState(Frame.NORMAL);
    this.setTitle("学生基本信息表");
    jLabel2.setFont(new java.awt.Font("Dialog", 0, 15));
    jLabel2.setToolTipText("");
    jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel2.setText("姓名");
    jLabel2.setBounds(new Rectangle(40, 137, 56, 25));
    jLabel3.setFont(new java.awt.Font("Dialog", 0, 15));
    jLabel3.setToolTipText("");
    jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel3.setText("所属学院");
    jLabel3.setBounds(new Rectangle(34, 173, 63, 27));
    jLabel4.setFont(new java.awt.Font("Dialog", 0, 15));
    jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
    jLabel4.setText("所属班级");
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
    jButton1.setText("修改");
    jButton1.addActionListener(new Frame1_jButton1_actionAdapter(this));
    jButton2.setBounds(new Rectangle(250, 146, 74, 34));
    jButton2.setFont(new java.awt.Font("Dialog", 0, 15));
    jButton2.setToolTipText("");
    jButton2.setVerifyInputWhenFocusTarget(true);
    jButton2.setText("添加");
    jButton2.addActionListener(new Frame1_jButton2_actionAdapter(this));
    jButton3.setBounds(new Rectangle(213, 250, 75, 28));
    jButton3.setFont(new java.awt.Font("Monospaced", 1, 15));
    jButton3.setToolTipText("");
    jButton3.setText("删除");
    jButton3.addActionListener(new Frame1_jButton3_actionAdapter(this));
    jButton4.setBounds(new Rectangle(253, 201, 73, 36));
    jButton4.setFont(new java.awt.Font("Dialog", 0, 15));
    jButton4.setToolTipText("");
    jButton4.setText("取消");
    jButton4.addActionListener(new Frame1_jButton4_actionAdapter(this));

    jMenu1.setActionCommand("文件");
    jMenu1.setText("文件");
    jMenuhelp.setAction(null);
    jMenuhelp.setActionCommand("帮助");
    jMenuhelp.setText("帮助");
    jMenuabout.setPreferredSize(new Dimension(55, 21));
    jMenuabout.setToolTipText("");
    jMenuabout.setActionCommand("关于");
    jMenuabout.setSelected(false);
    jMenuabout.setText("关于");
    jMenuexit.setActionCommand("退出");
    jMenuexit.setText("退出");
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
    jLabel5.setText("请输入学号： ");
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
    jButton5.setText("查询");
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


    void jButton1_actionPerformed(ActionEvent e)                    // 处理修改按钮的ActionEvent
    {
      try
      {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");               // 实例化JDBC-ODBC桥的驱动
        connection = DriverManager.getConnection("jdbc:odbc:student","sa","123456");  // 连接数据库
        // 创建Statement接口对象
        statement = connection.createStatement();
        if (jTextField1.getText().length() == 0)
        {
          jTextPane1.setText("不能修改，请先输入学号！");
        }
        else {
          if (jTextField2.getText().length() != 0)
            statement.executeUpdate("update stu_info set 姓名='" +
                                    jTextField2.getText() + "' where 学号='" +
                                    jTextField1.getText() + "'"); // 更新stu_info表中学号相关的记录
          if (jTextField3.getText().length() != 0)
            statement.executeUpdate("update stu_info set 所属学院='" +
                                    jTextField3.getText() + "' where 学号='" +
                                    jTextField1.getText() + "'"); // 更新stu_info表中学号相关的记录
          if (jTextField4.getText().length() != 0)
            statement.executeUpdate("update stu_info set 所属班级='" +
                                    jTextField4.getText() + "' where 学号='" +
                                    jTextField1.getText() + "'"); // 更新stu_info表中输入学号的记录
          if (jTextField2.getText().length() == 0 &
              jTextField3.getText().length() == 0 &
              jTextField4.getText().length() == 0) {
            jTextPane1.setText("修改不成功,请重新输入！");
          }
          else {
            jTextPane1.setText("记录修改成功!");
          }
        }
        // 清空信息框
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
      }
      catch(SQLException ex)                                    // 捕捉异常
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
            statement.close();                                // 关闭Statement接口实例
          }
          if(connection != null)
          {
            connection.close();                               // 关闭Connection接口实例
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


    void jButton2_actionPerformed(ActionEvent e)                  // 处理添加按钮ActionEvent
    {
      try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // 实例化JDBC-ODBC桥的驱动
        connection = DriverManager.getConnection("jdbc:odbc:student", "sa",
                                                 "123456"); // 连接数据库
        // 创建Statement接口对象
        statement = connection.createStatement();
        String sql1 = "insert  into stu_info  values ('" + jTextField1.getText() +
            "','" + jTextField2.getText() + "','" + jTextField3.getText() + "','" +
            jTextField4.getText() + "')";
        if (jTextField1.getText().length() == 0) {
          jTextPane1.setText("不能修改，请先输入学号！");
          // 清空信息框
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField3.setText("");
          jTextField4.setText("");
        }
        else {
          statement.executeUpdate(sql1); // stu_info表中添加记录
          jTextPane1.setText("记录添加成功!");
          // 清空信息框
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField3.setText("");
          jTextField4.setText("");
        }
      }
      catch (SQLException ex) { // 捕捉异常
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
            statement.close(); // 关闭Statement接口实例
          }
          if (connection != null) {
            connection.close(); // 关闭Connection接口实例
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

   void  jButton3_actionPerformed(ActionEvent e)                  // 处理删除按钮的ActionEvent
   {
      try
      {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");           // 实例化JDBC-ODBC桥的驱动
        connection = DriverManager.getConnection("jdbc:odbc:student","sa","123456");  // 连接数据库
        // 创建Statement接口对象
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rSet = statement.executeQuery("select 学号 from stu_info ");
        if (rSet.next()==false)                        // 判断数据库中是否有要删除的记录，如没有则显示提示框
        {
          jTextField5.setText("");
          jTextPane1.setText("数据库中没有您要删除的学号!");
        }
        else
        {
          String sql2="delete from stu_info where 学号='"+jTextField5.getText()+"'";
          statement.executeUpdate(sql2);             // 删除stu_info表中对应学号的数据记录
          // 清空信息框
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField3.setText("");
          jTextField4.setText("");
          jTextField5.setText("");
          jTextPane1.setText("记录已成功删除!");
        }
      }
      catch(SQLException ex)                      // 捕捉异常
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
            statement.close();                                // 关闭Statement接口实例
          }
          if(connection != null)
          {
            connection.close();                               // 关闭Connection接口实例
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

    void jButton5_actionPerformed(ActionEvent e)             // 处理查询按钮的ActionEvent
    {
      try
      {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  // 实例化JDBC-ODBC桥的驱动
        connection = DriverManager.getConnection("jdbc:odbc:student","sa","123456");  // 连接数据库
        // 创建Statement接口对象
        statement = connection.createStatement();
        rSet = statement.executeQuery("select * from stu_info ");
        String sno;
        sno = rSet.getString(1);
        if (rSet.next()==false)                  // 判断数据库中是否有要查询的记录，如没有则显示提示框
        {
          jTextField5.setText("");
          jTextPane1.setText("数据库中没有您查询的学号!");
        }
        else{
          if (sno.equals(jTextField5.getText())) {
              jTextField5.setText("");
              jTextPane1.setText("查询信息如下:"); //显示数据
              jTextField1.setText(rSet.getString(1));
              jTextField2.setText(rSet.getString(2));
              jTextField3.setText(rSet.getString(3));
              jTextField4.setText(rSet.getString(4));
            }
            else
            {
              jTextField5.setText("");
              jTextPane1.setText("数据库中没有您查询的学号!");
            }
        }
      }

      catch(SQLException ex)                      // 捕捉异常
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
            statement.close();                                // 关闭Statement接口实例
          }
          if(connection != null)
          {
            connection.close();                               // 关闭Connection接口实例
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







