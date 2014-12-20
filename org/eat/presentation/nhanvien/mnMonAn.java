package org.eat.presentation.nhanvien;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;
import org.eat.collection.*;
import org.eat.database.*;
import org.eat.model.*;
import javax.swing.event.*;

public class mnMonAn extends JInternalFrame implements ActionListener, ListSelectionListener {
	public mnMonAn(String title) {
		super(title, true, true,true,true);
		setSize(200, 200);
		doShow();
	}
	public void doShow() {
		dblma = new LoaiMonAnDatabase();
		dbma = new MonAnDatabase();
		setSize(800, 550);
		addControl("Thông tin món ăn");		
	}
	public void addControl(String title) {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel(title);
		Font ftTitle = new Font("arial", Font.BOLD, 32);
		lblTitle.setFont(ftTitle);
		lblTitle.setForeground(Color.BLUE);
		pnNorth.add(lblTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		JPanel pnListCate = new JPanel();
		pnListCate.setLayout(new BoxLayout(pnListCate, BoxLayout.Y_AXIS ));
		JPanel pnListProduct = new JPanel();
		JSplitPane slitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnListCate, pnListProduct);
		pnBorder.add(slitPane, BorderLayout.CENTER);
		lstCateModel = new DefaultListModel();
		LoaiMonAnCollection dslma = new LoaiMonAnCollection(dblma.getAllLoaiMonAn());
		for (int i = 0; i < dslma.size(); i++) {
			// lstCateModel.addElement(
			//		dslma.getLoaiMonAn(i).getMaLoaiMonAn()
			//		+ "." + dslma.getLoaiMonAn(i).getTenLoai());
			lstCateModel.addElement(dslma.getLoaiMonAn(i));
		}
		lstCate = new JList(lstCateModel);
		//lstCate.addListSelectionListener(this);
		TitledBorder cateBorder = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Danh muc san pham");
		lstCate.setBorder(cateBorder);
		pnListCate.setPreferredSize(new Dimension(300, 0));
		pnListCate.add(lstCate, BorderLayout.NORTH);
		
		// List Loai
		JPanel pnListCateSouth = new JPanel();
		btnCateNew = new JButton("New");
		btnCateNew.addActionListener(this);
		pnListCateSouth.add(btnCateNew);
		btnCateUpdate =new JButton("Update");
		btnCateUpdate.addActionListener(this);
		pnListCateSouth.add(btnCateUpdate);
		btnCateRemove =new JButton("Remove");
		btnCateRemove.addActionListener(this);
		pnListCateSouth.add(btnCateRemove);
		pnListCate.add(pnListCateSouth,BorderLayout.SOUTH);
		
		// mon an
		pnListProduct.setLayout(new BorderLayout());
		JPanel pnProductTitle=new JPanel();
		JLabel lblProductTitle=new JLabel(title);
		pnProductTitle.add(lblProductTitle);
		pnListProduct.add(pnProductTitle, BorderLayout.NORTH);
		JPanel pnProductTable=new JPanel();
		pnProductTable.setLayout(new BorderLayout());
		pnListProduct.add(pnProductTable,BorderLayout.CENTER);
		dtmHoaDon =new DefaultTableModel();
		dtmHoaDon.addColumn("Mã món ăn");
		dtmHoaDon.addColumn("Tên món ăn");
		dtmHoaDon.addColumn("Hình ảnh");
		dtmHoaDon.addColumn("Loại");
		dtmHoaDon.addColumn("Mô tả");
		dtmHoaDon.addColumn("Giá");
		tblProduct=new JTable(dtmHoaDon);
		loadTable();
		JScrollPane sctblproduct=new JScrollPane(tblProduct );
		sorter = new TableRowSorter<>(tblProduct.getModel());
		tblProduct.setRowSorter(sorter);
		pnProductTable.add(sctblproduct,BorderLayout.CENTER);
		JPanel pnProductDetail=new JPanel();
		pnListProduct.add(pnProductDetail,BorderLayout.SOUTH);
		pnProductDetail.setLayout(new BoxLayout(pnProductDetail, BoxLayout.Y_AXIS ));
		
		// Chi tiet mon an
		JPanel pnCateList=new JPanel();
		JLabel lblCateId=new JLabel("Loại món ăn :");
		cboCateList=new JComboBox();
		loadCombobox();
		pnCateList.add(lblCateId);
		pnCateList.add(cboCateList);
		pnProductDetail.add(pnCateList);
		JPanel pnProductId=new JPanel();
		JLabel lblProId=new JLabel("Mã món ăn:");
		txtMaMonAn=new JTextField(20);
		pnProductId.add(lblProId);
		pnProductId.add(txtMaMonAn);
		pnProductDetail.add(pnProductId);
		JPanel pnProductName=new JPanel();
		JLabel lblProName=new JLabel("Tên món ăn:");
		txtTenMonAn=new JTextField(20);
		pnProductName.add(lblProName);
		pnProductName.add(txtTenMonAn);
		pnProductDetail.add(pnProductName);
		JPanel pnProductQuantity=new JPanel();
		JLabel lblQuantity=new JLabel("Giá :");
		txtGia=new JTextField(20);
		pnProductQuantity.add(lblQuantity);
		pnProductQuantity.add(txtGia);
		pnProductDetail.add(pnProductQuantity);
		JPanel pnProductDescription=new JPanel();
		JLabel lblDescription=new JLabel("Mô tả :");
		txtMoTa=new JTextArea(4, 20);
		JScrollPane scare=new JScrollPane(txtMoTa);
		pnProductDescription.add(lblDescription);
		pnProductDescription.add(scare);
		pnProductDetail.add(pnProductDescription);
		JPanel pnButton=new JPanel();
		btnNew=new JButton("New");
		btnSave=new JButton("Save");
		btnRemove=new JButton("Remove");
		pnButton.add(btnNew);
		pnButton.add(btnSave);
		pnButton.add(btnRemove);
		pnProductDetail.add(pnButton);
		cboCateList.setPreferredSize(txtMaMonAn.getPreferredSize());
		lblCateId.setPreferredSize(lblProName.getPreferredSize());
		lblDescription.setPreferredSize(lblProName.getPreferredSize());
		lblQuantity.setPreferredSize(lblProName.getPreferredSize());
		//lblUnitPrice.setPreferredSize(lblProName.getPreferredSize());
		lblProId.setPreferredSize(lblProName.getPreferredSize());
		Container con=getContentPane();
		con.add(pnBorder);
		btnCateNew.addActionListener(this);
		btnNew.addActionListener(this);
		btnSave.addActionListener(this);
		btnRemove.addActionListener(this);
		//cboCateList.addActionListener(this);
		
		// Load data
		//loadLoaiMonAn();
		lstCate.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (lstCate.getSelectedIndex() != -1) {
						LoaiMonAn l = (LoaiMonAn) lstCate.getSelectedValue();
						lmaSelected = l;
						cboCateList.setSelectedItem(lmaSelected);
						//sorter.setRowFilter(RowFilter.regexFilter(l.getMaLoaiMonAn()));
						//RowFilter.numberFilter(ComparisonType.EQUAL, 1);
					}
				}
			}
		});
		tblProduct.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}			
			@Override
			public void mouseEntered(MouseEvent arg0) {}			
			@Override
			public void mouseClicked(MouseEvent e) {
				/*if (tblProduct.getSelectedRow() != -1) {
					int row = tblProduct.getSelectedRow();
					MonAn m = new MonAn(tblProduct.getValueAt(row, 0).toString()
							, tblProduct.getValueAt(row, 1).toString()
							, tblProduct.getValueAt(row, 2).toString()
							, tblProduct.getValueAt(row, 3).toString()
							, tblProduct.getValueAt(row, 4).toString()
							, Double.parseDouble(tblProduct.getValueAt(row, 5).toString())							
							);
					maSelected = m;
					setMonAnValue(m);
				}*/
			}
		});
	}
	public void loadTable() {
		colma = new MonAnCollection(dbma.getAllMonAn());
		collma = new LoaiMonAnCollection(dblma.getAllLoaiMonAn());
		for (int i = 0; i < dtmHoaDon.getRowCount(); i++) {
			dtmHoaDon.setDataVector(null, header);
		}
		for (int i = 0; i < colma.size(); i++) {
			MonAn m = colma.getMonAn(i);
			LoaiMonAn l = collma.getLoaiMonAnID(m.getLoai());
			dtmHoaDon.addRow(new Object[] {
					m.getMaMonAn(), m.getTenMonAn(),m.getHinhAnh(), l.getTenLoai() ,m.getMoTa(),m.getGia()
			});
		}
	}
	public void loadCombobox() {
		LoaiMonAnCollection col = new LoaiMonAnCollection(dblma.getAllLoaiMonAn());
			for (int i = 0; i < col.size(); i++) {
				cboCateList.addItem(col.getLoaiMonAn(i));
			}
		
	}
	public void loadLoaiMonAn() {
		lstCateModel = new DefaultListModel();
		LoaiMonAnCollection dslma = new LoaiMonAnCollection(dblma.getAllLoaiMonAn());
		for (int i = 0; i < dslma.size(); i++) {
			lstCateModel.addElement(dslma.getLoaiMonAn(i).toString());
		}
	}
	
	public void setMonAnValue(MonAn m) {
		LoaiMonAnCollection col = new LoaiMonAnCollection(dblma.getAllLoaiMonAn());
		LoaiMonAn l = col.getLoaiMonAnID(m.getLoai());
		if (l != null) {
		cboCateList.setSelectedItem(l);
		}
		txtMaMonAn.setText(m.getMaMonAn());
		txtTenMonAn.setText(m.getTenMonAn());
		txtGia.setText(m.getGia() + "");
		txtMoTa.setText(m.getMoTa());
	}
	public void ClearMonAnValue() {
		txtMaMonAn.setText("");
		txtTenMonAn.setText("");
		txtGia.setText("");
		txtMoTa.setText("");
	}
	public MonAn getMonAn(boolean b) {
		MonAn m = new  MonAn();
		if (b) {
		m.setMaMonAn(txtMaMonAn.getText());
		m.setMoTa(txtMoTa.getText());
		}
		else {
			if (maSelected != null) {
				m.setMaMonAn(maSelected.getMaMonAn());
			}
		}
		m.setTenMonAn(txtTenMonAn.getText());
		m.setLoai(((LoaiMonAn)cboCateList.getSelectedItem()).getMaLoaiMonAn());
		m.setGia(Double.parseDouble(txtGia.getText()));
		return m;
	}
	public static ArrayList listData;
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCateNew)) {
			
		} else if (e.getSource().equals(btnNew)) {
			ClearMonAnValue();
			them = true;
		} else if (e.getSource().equals(btnSave)) {
			if (them) {
				MonAn m = getMonAn(them);
				int i = dbma.InsertMonAn(m);
				loadTable();
				ClearMonAnValue();
			} else {
				MonAn m = getMonAn(them);
				int i = dbma.UpdateMonAn(m);
				//JOptionPane.showMessageDialog(null, i+ "");
				loadTable();
				ClearMonAnValue();
			}
			them = false;
		} else if (e.getSource().equals(btnRemove)) {
			if (maSelected != null) {
				int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa món ăn: " + maSelected.getMaMonAn(),"Thông báo !", JOptionPane.YES_NO_OPTION);
				if (option == 0) {
					dbma.DeleteMonAn(maSelected);
					loadTable();
				}
				//ClearMonAnValue();
			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn món ăn");
			}
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {}
	private static boolean them = false;
	private String[] header = new String[] {"Mã món ăn","Tên món ăn","Hình ảnh","Loại", "Mô tả", "Giá"};
	private static final long serialVersionUID = 1L;
	private static JList lstCate;
	private static DefaultListModel lstCateModel;
	private JTable tblProduct;
	private DefaultTableModel dtmHoaDon;
	private JButton btnCateRemove, btnCateNew, btnCateUpdate, btnNew, btnSave, btnRemove;
	private JTextField txtMaMonAn, txtTenMonAn, txtGia, txtName;
	private JTextArea txtMoTa;
	private static JComboBox cboCateList;
	private static LoaiMonAnDatabase dblma;
	private static MonAnDatabase dbma;
	private static LoaiMonAnCollection collma;
	private static MonAnCollection colma;
	private static String maLoai = "";
	private static TableRowSorter<TableModel> sorter;
	private static LoaiMonAn lmaSelected;
	private static MonAn maSelected;
}
