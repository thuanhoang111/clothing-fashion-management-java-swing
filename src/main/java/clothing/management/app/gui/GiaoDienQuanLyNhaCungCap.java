package clothing.management.app.gui;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoDienQuanLyNhaCungCap extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton btnBack;
    private JPanel pn1;
    private JPanel head;
    private JPanel pn2;
    private DefaultTableModel dtm;
    private JTable table;
    private JComboBox<String> cboFind;
    private JPanel pn3;
    private JPanel pn3BL;
    private JTextField txtFind;
    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnDelete;

    public GiaoDienQuanLyNhaCungCap() {
        this.setTitle("Giao Diện Quản Lý Nhà Cung Cấp");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//setUndecorated(true);
        createGUI();
    }

    private void createGUI() {
        JPanel header;


        //Phần North
        pn1 = new JPanel();
        head = new JPanel();
        head.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		head.setLayout(new FlowLayout(FlowLayout.LEFT));
        head.setPreferredSize(new Dimension(150, 50));
        btnBack = new JButton("Quay lại");
        btnBack.setFont(new Font("Arial", Font.BOLD, 20));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
					btnBackActionPerformed(evt);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        head.add(btnBack);
        header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER));
        header.setPreferredSize(new Dimension(1350, 90));
        JLabel lblHeader = new JLabel("Quản Lý Nhà Cung Cấp");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 70));
        header.add(lblHeader);
        pn1.add(header);
        pn1.add(head);
// code  table

        pn2 = new JPanel();
        pn2.setBorder(BorderFactory.createTitledBorder("Danh sách nhà cung cấp"));

//get table  fullScreen
        pn2.setLayout(new BoxLayout(pn2, BoxLayout.PAGE_AXIS));

        String[] cols = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số Điện Thoại"};
        dtm = new DefaultTableModel(cols, 0);
        table = new JTable(dtm);
        JScrollPane scroll = new JScrollPane(table);
//setsize for table
        scroll.setPreferredSize(new DimensionUIResource(1400, 600));
        pn2.add(scroll);

// code function
        pn3 = new JPanel();
        pn3.setPreferredSize(new Dimension(1500, 100));
        pn3.setBorder(BorderFactory.createTitledBorder("các chức năng"));
        pn3BL = new JPanel();
        pn3BL.setPreferredSize(new DimensionUIResource(1400, 50));
        pn3BL.setBorder(BorderFactory.createLoweredBevelBorder());
        cboFind = new JComboBox<String>();
        cboFind.setEditable(false);
        cboFind.addItem("Chọn tiêu chí tìm");
        cboFind.addItem("Tìm theo mã nhà cung cấp");
        cboFind.addItem("Tìm theo tên nhà cung cấp");
        cboFind.addItem("Tìm theo địa chỉ");
        txtFind = new JTextField(20);
        JLabel lbFind = new JLabel("Tìm Kiếm theo:");
        btnSearch = new JButton("Tim");
        btnUpdate = new JButton("Cập Nhật");
        btnDelete = new JButton("Xoá");
        pn3BL.add(txtFind);
        pn3BL.add(lbFind);
        pn3BL.add(cboFind);


        lbFind.setPreferredSize(new DimensionUIResource(100, 40));
        txtFind.setPreferredSize(new DimensionUIResource(100, 40));
        cboFind.setPreferredSize(new DimensionUIResource(150, 40));
        btnSearch.setPreferredSize(new DimensionUIResource(100, 40));
        btnUpdate.setPreferredSize(new DimensionUIResource(150, 40));
        btnDelete.setPreferredSize(new DimensionUIResource(100, 40));
        pn3BL.add(btnSearch);
        pn3BL.add(btnUpdate);
        pn3BL.add(btnDelete);

        pn3.add(pn3BL);

        this.add(pn1, BorderLayout.NORTH);
        this.add(pn2, BorderLayout.CENTER);
        this.add(pn3, BorderLayout.SOUTH);


    }

    private void btnBackActionPerformed(ActionEvent evt) throws InterruptedException {
        new GiaoDienDieuKhien().setVisible(true);
        setVisible(false);
    }
}

