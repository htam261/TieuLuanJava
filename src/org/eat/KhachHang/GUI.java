package org.eat.KhachHang;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.lang.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.eat.collection.ChiTietDatMonCollection;
import org.eat.database.*;
import org.eat.model.ChiTietDatMon;
import org.eat.model.DatMonAn;
import org.eat.model.HoaDon;
import org.eat.model.LoaiMonAn;
import org.eat.model.MonAn;

public class GUI extends JFrame implements ActionListener{
	private JLabel lb1,lb2,lb3,lb4,lb5;
	private JPanel jpanMain,jpan2,jpan1;
	private JButton btntimkiem,btndatmon,btnthemmon;
	private JTable tblmonan,tbldatmon;
	private JComboBox cbxloai,cbxgia;
	private JTextField txttenMA,txtenMAdat,txtsoluong;
	private DefaultTableModel model;
	private String makh,maHD="",maDMA="";
	private double tong;
	ArrayList<ChiTietDatMon> ct=new ArrayList<>();

	public GUI(String id){
		this.makh=id;
		setLayout(new GridLayout(2,1));
		setSize(750,500);
		setVisible(true);
		setTitle("GUI Tim kiếm món ăn");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawGUI();
		loadcbx();
		MonAnDatabase ma=new MonAnDatabase();
		ArrayList<MonAn> list=ma.getAllMonAn();
		LoaiMonAnDatabase loai=new LoaiMonAnDatabase();
		loadDanhsachmonan(list,loai);
//		loadDanhsachdatmon(null);
	}
	public void loadcbx(){
		LoaiMonAnDatabase loai=new LoaiMonAnDatabase();
		ArrayList<LoaiMonAn> clsloai=loai.getAllLoaiMonAn();
		for(LoaiMonAn monan : clsloai)
        {	
            cbxloai.addItem(monan.getTenLoai());
        }
	}
	public void loadDanhsachmonan(ArrayList<MonAn> list,LoaiMonAnDatabase loai){
		model = new DefaultTableModel();
        //Set Column Title
        Vector column = new Vector();
        column.add("Mã Món");
        column.add("Tên Món");
        column.add("Loại Món");
        column.add("Mô Tả");
        column.add("Giá");
        model.setColumnIdentifiers(column);
//        MonAnDatabase ma=new MonAnDatabase();
//        ArrayList<MonAn> list=ma.getAllMonAn();
//        LoaiMonAnDatabase loai=new LoaiMonAnDatabase();
          for (int i = 0; i < list.size(); i++) {
             MonAn cls = (MonAn) list.get(i);
             Vector row = new Vector();
             row.add(cls.getMaMonAn());
             row.add(cls.getTenMonAn());
             row.add(loai.getTenloai(cls.getLoai()));
             row.add(cls.getMoTa());
             row.add(cls.getGia());
             model.addRow(row);
         }

        tblmonan.setModel(model);
	}
	public void loadDanhsachdatmon(ArrayList<ChiTietDatMon> list){
		model = new DefaultTableModel();
        //Set Column Title
        Vector column = new Vector();
        column.add("Mã Món");
        column.add("Tên Món");
        column.add("Số lượng");
        column.add("Giá");
        model.setColumnIdentifiers(column);
          for (int i = 0; i < list.size(); i++) {
             ChiTietDatMon cls = (ChiTietDatMon) list.get(i);
             Vector row = new Vector();
             row.add(cls.getMamon());
             row.add(cls.getTenmon());
             row.add(cls.getSoluong());
             row.add(cls.getGia());
             model.addRow(row);
         }

        tbldatmon.setModel(model);
	}
	public void drawGUI(){
		jpan1=new JPanel();
		jpan1.setBorder(new TitledBorder("Thông tin tìm kiếm"));
		jpan1.setPreferredSize(new Dimension(700, 200));
		getContentPane().add(jpan1);
		
		lb1=new JLabel("Loại món ăn :");
		jpan1.add(lb1);	
		cbxloai=new JComboBox();
		jpan1.add(cbxloai);

		
		lb2=new JLabel("Tên món ăn :");
		jpan1.add(lb2);
		txttenMA=new JTextField(15);
		jpan1.add(txttenMA);
		
		lb3=new JLabel("Giá :");
		jpan1.add(lb3);
		String gias[]={"Dưới 50 ngàn","Từ 50 - 100 ngàn","Trên 100 ngàn"};
		cbxgia=new JComboBox(gias);
		jpan1.add(cbxgia);
		
		btntimkiem=new JButton("Tìm kiếm");
		jpan1.add(btntimkiem);
		btntimkiem.addActionListener(this);
		
		tblmonan=new JTable();
		tblmonan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					DefaultTableModel model=(DefaultTableModel)tblmonan.getModel();
					Object obj= model.getValueAt(tblmonan.getSelectedRow(), 1);
					String a=String.valueOf(obj);
					
					Object obj2= model.getValueAt(tblmonan.getSelectedRow(), 0);
					String a2=String.valueOf(obj2);
					
					txtenMAdat.setText(a);
					JOptionPane.showMessageDialog(rootPane, a2);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		JScrollPane croll=new JScrollPane(tblmonan);
		jpan1.add(croll);
		
		jpan2=new JPanel(new FlowLayout());
		jpan2.setBorder(new TitledBorder("Đặt món"));
		jpan2.setPreferredSize(new Dimension(700, 200));
		getContentPane().add(jpan2,BorderLayout.CENTER);
		
		lb4=new JLabel("Tên món ăn :");
		jpan2.add(lb4);
		txtenMAdat=new JTextField(15);
		txtenMAdat.setEditable(false);
		jpan2.add(txtenMAdat);
		
		lb5=new JLabel("Số lượng :");
		jpan2.add(lb5);
		txtsoluong=new JTextField(15);
		jpan2.add(txtsoluong);
		
		btndatmon=new JButton("Đặt món");
		jpan2.add(btndatmon);
		btndatmon.addActionListener(this);
		
		btnthemmon=new JButton("Thêm món");
		btnthemmon.setEnabled(false);
		jpan2.add(btnthemmon);
		btnthemmon.addActionListener(this);
		
		tbldatmon=new JTable();
		JScrollPane croll2=new JScrollPane(tbldatmon);
		jpan2.add(croll2);
		
	}
//	public static void main(String[] args) {
//		GUI g=new GUI();
//		g.setLayout(new GridLayout(2,1));
//		g.setSize(620, 400);
//		g.pack();
//		g.setVisible(true);
//		g.setTitle("GUI Tim kiếm món ăn");
//		g.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btntimkiem){
			MonAnDatabase ma=new MonAnDatabase();
			LoaiMonAnDatabase loai=new LoaiMonAnDatabase();
			int a=cbxloai.getSelectedIndex();
			LoaiMonAn lma=loai.getMaloai(a);
			String maloai=lma.getMaLoaiMonAn();
			String tenmonan=txttenMA.getText();
			int gia=cbxgia.getSelectedIndex();
			ArrayList<MonAn> list;
			list=ma.getSearch(maloai,tenmonan,gia);
			this.loadDanhsachmonan(list, loai);
		}
		if(e.getSource() == btndatmon){
			Object obj1= model.getValueAt(tblmonan.getSelectedRow(), 0);
	        String mamon=String.valueOf(obj1);
//	        Object obj2= model.getValueAt(tblmonan.getSelectedRow(), 1);
//			String tenmon=String.valueOf(obj2);
//			Object obj3= model.getValueAt(tblmonan.getSelectedRow(), 2);
//			String loaim=String.valueOf(obj3);
//			Object obj4= model.getValueAt(tblmonan.getSelectedRow(), 3);
//			String mota=String.valueOf(obj4);
//			Object obj5= model.getValueAt(tblmonan.getSelectedRow(), 4);
//			String gia=String.valueOf(obj5);
//			double gia2=Double.parseDouble(gia);
			
			
	        HoaDonDatabase hddt=new HoaDonDatabase();
	        DatMonAnDatabase da=new DatMonAnDatabase();
	        MonAnDatabase madt=new MonAnDatabase();
//	        LoaiMonAnDatabase loai=new LoaiMonAnDatabase();
	        ChiTietDatMonCollection c=new ChiTietDatMonCollection();
	        
	        if(maHD.equalsIgnoreCase("")){
		        int key=(int)(Math.round(Math.random()*1000));
		        maHD="HD"+key;
		        maDMA="DA"+key;
	        }
//	        JOptionPane.showMessageDialog(rootPane, maHD);
//	        String makh="1";
	        GregorianCalendar cal=new GregorianCalendar();
			Date d=new Date(cal.getTimeInMillis());
	        boolean dathanhtoan=false;
//	        JOptionPane.showMessageDialog(rootPane, d);
	        HoaDon hd=new HoaDon(maHD, "", makh, d, dathanhtoan, 0);
	        ArrayList<MonAn> ma=madt.getMonAn(mamon);
	        ChiTietDatMon ctdm;
	        if(hddt.InsertHoaDon(hd) > 0){
				DatMonAn dma=new DatMonAn(maDMA, hd.getMaHoaDon(), mamon, Integer.parseInt(txtsoluong.getText()), d);
				if(da.InsertDatMonAn(dma) > 0){
			        JOptionPane.showMessageDialog(rootPane, "Đặt thành công");
			        ctdm=new ChiTietDatMon(mamon,ma.get(0).getMaMonAn(),Integer.parseInt(txtsoluong.getText()) , ma.get(0).getGia());
//			        ct=c.addChiTietMonAn(ctdm);
			        tong=Integer.parseInt(txtsoluong.getText())*ma.get(0).getGia();
			        ct.add(ctdm);
			        this.loadDanhsachdatmon(ct);
//			        JOptionPane.showMessageDialog(rootPane, ct + "\n"+tong+"/"+mamon);
				}else
					JOptionPane.showMessageDialog(rootPane, "Đặt thất bại");
			}
//	        btndatmon.setEnabled(false);
//	        btnthemmon.setEnabled(true);
	        JOptionPane.showMessageDialog(rootPane, maHD);
		}
		if(e.getSource() == btnthemmon){
			String obj1= (String)model.getValueAt(tblmonan.getSelectedRow(), 1);
//	        String mamon=String.valueOf(obj1);
	        
	        HoaDonDatabase hddt=new HoaDonDatabase();
	        JOptionPane.showMessageDialog(rootPane, obj1);
		}
	}

}
