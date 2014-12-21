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
import org.eat.presentation.login;

public class GUI extends JFrame implements ActionListener{
	private JLabel lb1,lb2,lb3,lb4,lb5,lb6;
	private JPanel jpan2,jpan1;
	private JButton btntimkiem,btndatmon,btnthanhtoan;
	private JTable tblmonan,tbldatmon;
	private JComboBox cbxloai,cbxgia;
	private JTextField txttenMA,txtenMAdat,txtsoluong,txttongtien;
	private DefaultTableModel model;
	private String makh,maHD="",maDMA="",maMA="",tenMA="",maMAdb="";
	private double tong=0,giaMA;
	private int soluong=0;
	private Date d;
	ArrayList<ChiTietDatMon> ct=new ArrayList<ChiTietDatMon>();

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
		String gias[]={"Dưới 50 ngàn","Từ 50 - 100 ngàn","Trên 100 ngàn","Tất cả giá"};
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
					maMA= model.getValueAt(tblmonan.getSelectedRow(), 0).toString();
					tenMA=model.getValueAt(tblmonan.getSelectedRow(), 1).toString();
					giaMA=Double.parseDouble(model.getValueAt(tblmonan.getSelectedRow(), 4).toString());
					
					txtenMAdat.setText(tenMA);
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
		jpan2.setPreferredSize(new Dimension(700, 400));
		getContentPane().add(jpan2,BorderLayout.CENTER);
		
		lb4=new JLabel("Tên món ăn :");
		jpan2.add(lb4);
		txtenMAdat=new JTextField(20);
		txtenMAdat.setEditable(false);
		jpan2.add(txtenMAdat);
		
		lb5=new JLabel("   Số lượng :");
		jpan2.add(lb5);
		txtsoluong=new JTextField(18);
		jpan2.add(txtsoluong);
		
		btndatmon=new JButton("   Đặt món   ");
		jpan2.add(btndatmon);
		btndatmon.addActionListener(this);
		
		lb6=new JLabel("Tổng tiền :  ");
		jpan2.add(lb6);
		txttongtien=new JTextField(15);
		txttongtien.setEditable(false);
		jpan2.add(txttongtien);
		
		btnthanhtoan=new JButton("Thanh toán");
		jpan2.add(btnthanhtoan);
		btnthanhtoan.addActionListener(this);
		
		tbldatmon=new JTable();
		JScrollPane croll2=new JScrollPane(tbldatmon);
		jpan2.add(croll2);
		
	}
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
	        HoaDonDatabase hddt=new HoaDonDatabase();
	        DatMonAnDatabase da=new DatMonAnDatabase();
	        if(txtsoluong.getText().equalsIgnoreCase("")){
	        	JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số lượng");
	        	txtsoluong.requestFocus();
	        }else{
	        	soluong=Integer.parseInt(txtsoluong.getText());
		        int key=(int)(Math.round(Math.random()*1000));
		        if(maHD.equalsIgnoreCase("")){
			        maHD="HD"+key;
			        
			        GregorianCalendar cal=new GregorianCalendar();
					d=new Date(cal.getTimeInMillis());
			        boolean dathanhtoan=false;
			        HoaDon hd=new HoaDon(maHD, "", makh, d, dathanhtoan, 0);
			        hddt.InsertHoaDon(hd);
	//		        JOptionPane.showMessageDialog(rootPane, "HD :"+hd);
			        
			        maDMA="DA"+key;
			        DatMonAn dma=new DatMonAn(maDMA, maHD, maMA, soluong, d);
			        if(da.InsertDatMonAn(dma) > 0){
						maMAdb=dma.getMaMonAn();
					    JOptionPane.showMessageDialog(rootPane, "Đặt thành công");
					    ChiTietDatMon ctdm=new ChiTietDatMon(maMA,tenMA,dma.getSoLuong() , giaMA);
					    tong+=Integer.parseInt(txtsoluong.getText())*giaMA;
					    ct.add(ctdm);
					    this.loadDanhsachdatmon(ct);
		//			    JOptionPane.showMessageDialog(rootPane, "DMA :"+dma + "\n"+tong);
					    txttongtien.setText(tong+"");
					}else
						JOptionPane.showMessageDialog(rootPane, "Đặt thất bại");
		        }else{
		        	DatMonAn dma=new DatMonAn(maDMA, maHD, maMA,Integer.parseInt(txtsoluong.getText()), d);
		        	boolean f=true;
			        ArrayList<DatMonAn> m=da.getMaMonAn(maHD);
			        for(int i=0;i<m.size();i++){
			        	String ma=m.get(i).getMaMonAn();
			        	if(maMA.equalsIgnoreCase(ma)){
			        		soluong+=m.get(i).getSoLuong();
			        		da.updateSoLuong(m.get(i).getMaMonAn(), soluong);
			        		f=false;
			        		JOptionPane.showMessageDialog(rootPane, "Cập nhật");
			        	}
			        }
		        		
				        if(f){
		        		maDMA="DA"+key++;
						da.InsertDatMonAn(dma);
						JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
				        }
//							maMAdb=dma.getMaMonAn();
//							JOptionPane.showMessageDialog(rootPane, "chen moi");
//						    JOptionPane.showMessageDialog(rootPane, "Đặt thành công");
						    ChiTietDatMon ctdm=new ChiTietDatMon(maMA,tenMA,soluong , giaMA);
						    tong+=Integer.parseInt(txtsoluong.getText())*giaMA;
						    
						    for(int ii=0;ii<ct.size();ii++){
					        	String maa=ct.get(ii).getMamon();
					        	if(maMA.equalsIgnoreCase(maa)){
					        		ct.get(ii).setSoluong(soluong);
					        		ct.remove(ii);
					        	}
					        }
						    ct.add(ctdm);
						    this.loadDanhsachdatmon(ct);
			//			    JOptionPane.showMessageDialog(rootPane, "DMA :"+dma + "\n"+tong);
						    txttongtien.setText(tong+"");
		        	}
	        	}
	        }
//		}
		if(e.getSource() == btnthanhtoan){
			HoaDonDatabase hddt=new HoaDonDatabase();
			HoaDon hd=new HoaDon(maHD, "", makh, d, true, tong);
			hddt.UpdateHoaDon(hd);
//			JOptionPane.showMessageDialog(rootPane, "U HD"+hd);
	        JOptionPane.showMessageDialog(rootPane, "Số tiền quý khách cần thanh toán là "+tong + "VND");
	        this.setVisible(false);
	        login l=new login();
	        l.main(null);
		}
	}

}
