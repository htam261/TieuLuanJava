package org.eat.presentation.nhanvien;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;
import org.eat.collection.*;
import org.eat.database.*;
import org.eat.model.*;

import javax.swing.event.*;

public class mnHoaDon extends JInternalFrame implements ActionListener, ListSelectionListener {
	public mnHoaDon(String title, String id) {
		super(title, true, true, true, true);
		this.id = id;
		setSize(200, 200);
		doShow();
	}
	public void doShow() {
		dblma = new LoaiMonAnDatabase();
		dbma = new MonAnDatabase();
		dbhd = new HoaDonDatabase();
		dbdma = new DatMonAnDatabase();
		setSize(800, 550);
		addControl("Thông tin hóa đơn");		
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
		JPanel pnHoaDon = new JPanel();
		pnHoaDon.setLayout(new BoxLayout(pnHoaDon, BoxLayout.Y_AXIS ));
		JPanel pnDSHoaDon = new JPanel();
		JSplitPane slitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnHoaDon, pnDSHoaDon);
		pnBorder.add(slitPane, BorderLayout.CENTER);
		lstHoaDonModel = new DefaultListModel();
		loadHoaDon();
		
		TitledBorder cateBorder = new TitledBorder(BorderFactory.createLineBorder(Color.red),"Danh muc san pham");
		lstHoaDon.setBorder(cateBorder);
		pnHoaDon.setPreferredSize(new Dimension(300, 0));
		pnHoaDon.add(lstHoaDon, BorderLayout.NORTH);
		
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
		pnHoaDon.add(pnListCateSouth,BorderLayout.SOUTH);
		
		// mon an
		pnDSHoaDon.setLayout(new BorderLayout());
		JPanel pnProductTitle=new JPanel();
		JLabel lblProductTitle=new JLabel(title);
		pnProductTitle.add(lblProductTitle);
		pnDSHoaDon.add(pnProductTitle, BorderLayout.NORTH);
		JPanel pnProductTable=new JPanel();
		pnProductTable.setLayout(new BorderLayout());
		pnDSHoaDon.add(pnProductTable,BorderLayout.CENTER);
		dtmDatMonAn =new DefaultTableModel();
		dtmDatMonAn.addColumn("Mã hóa đơn");
		dtmDatMonAn.addColumn("Mã món ăn");
		dtmDatMonAn.addColumn("Tên món ăn");
		dtmDatMonAn.addColumn("Số lượng");
		dtmDatMonAn.addColumn("Loại");
		dtmDatMonAn.addColumn("Giá");
		dtmDatMonAn.addColumn("Mô tả");
		tblDatMonAn=new JTable(dtmDatMonAn);
		loadTable();
		JScrollPane sctblproduct=new JScrollPane(tblDatMonAn );
		sorter = new TableRowSorter<>(tblDatMonAn.getModel());
		tblDatMonAn.setRowSorter(sorter);
		pnProductTable.add(sctblproduct,BorderLayout.CENTER);
		JPanel pnProductDetail=new JPanel();
		pnDSHoaDon.add(pnProductDetail,BorderLayout.SOUTH);
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
		//JPanel pnProductUnitPrice=new JPanel();
		//JLabel lblUnitPrice=new JLabel("Hình ảnh:");
		//txtTenMonAn=new JTextField(20);
		//pnProductUnitPrice.add(lblUnitPrice);
		//pnProductUnitPrice.add(txtTenMonAn);
		//pnProductDetail.add(pnProductUnitPrice);
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
		lstHoaDon.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (lstHoaDon.getSelectedIndex() != -1) {
						HoaDon h = (HoaDon) lstHoaDon.getSelectedValue();
						hdSelected = h;
						//cboCateList.setSelectedItem(lmaSelected);
						sorter.setRowFilter(RowFilter.regexFilter(h.getMaHoaDon()));
					}
				}
			}
		});
		tblDatMonAn.addMouseListener(new MouseListener() {
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
				/*if (tblDatMonAn.getSelectedRow() != -1) {
					int row = tblDatMonAn.getSelectedRow();
					MonAn m = new MonAn(tblDatMonAn.getValueAt(row, 0).toString()
							, tblDatMonAn.getValueAt(row, 1).toString()
							, tblDatMonAn.getValueAt(row, 2).toString()
							, tblDatMonAn.getValueAt(row, 3).toString()
							, tblDatMonAn.getValueAt(row, 4).toString()
							, Double.parseDouble(tblDatMonAn.getValueAt(row, 5).toString())							
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
		coldma = new DatMonAnCollection(dbdma.getAllDatMonAn());
		for (int i = 0; i < dtmDatMonAn.getRowCount(); i++) {
			dtmDatMonAn.setDataVector(null, header);
		}
		if (hdSelected == null) {
			for (int i = 0; i < coldma.size(); i++) {
				DatMonAn d = coldma.getDatMonAn(i);
				MonAn m = colma.getMonAnID(d.getMaMonAn());
				LoaiMonAn l = collma.getLoaiMonAnID(m.getLoai());
				dtmDatMonAn.addRow(new Object[] {
						d.getMaHoaDon(), m.getMaMonAn(), m.getTenMonAn(), d.getSoLuong(), l.getTenLoai(), m.getGia(), m.getMoTa()
				});
			}
		} else {
			DatMonAnCollection cold = new DatMonAnCollection(coldma.getAllDatMonAn_MaHoaDon(hdSelected.getMaHoaDon()));
			for (int i = 0; i < cold.size(); i++) {
				DatMonAn d = cold.getDatMonAn(i);
				MonAn m = colma.getMonAnID(d.getMaMonAn());
				LoaiMonAn l = collma.getLoaiMonAnID(m.getLoai());
				dtmDatMonAn.addRow(new Object[] {
						d.getMaHoaDon(), m.getMaMonAn(), m.getTenMonAn(), d.getSoLuong(), l.getTenLoai(), m.getGia(), m.getMoTa()
				});
			}
		}
	}
	public void loadCombobox() {
		LoaiMonAnCollection col = new LoaiMonAnCollection(dblma.getAllLoaiMonAn());
			for (int i = 0; i < col.size(); i++) {
				cboCateList.addItem(col.getLoaiMonAn(i));
			}
		
	}
	public void loadHoaDon() {
		lstHoaDonModel = new DefaultListModel();
		HoaDonCollection dshd = new HoaDonCollection(dbhd.getAllHoaDon());
		if (dshd.size() != 0) {
		for (int i = 0; i < dshd.size(); i++) {
			lstHoaDonModel.addElement(dshd.getHoaDon(i).toString());
		}
		lstHoaDon = new JList(lstHoaDonModel);
		} else {
			JOptionPane.showMessageDialog(null, "not null");
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
			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn món ăn");
			}
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {}
	private static boolean them = false;
	private String[] header = new String[] {"Mã hóa đơn","Mã món ăn","Tên món ăn","Số lượng","Loại", "Giá", "Mô tả"};
	private static final long serialVersionUID = 1L;
	private static JList lstHoaDon;
	private static DefaultListModel lstHoaDonModel;
	private JTable tblDatMonAn;
	private DefaultTableModel dtmDatMonAn;
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
	private static String id;
	private static DatMonAnDatabase dbdma;
	private static DatMonAnCollection coldma;
	private static HoaDonDatabase dbhd;
	private static HoaDonCollection colhd;
	private static HoaDon hdSelected;
}
