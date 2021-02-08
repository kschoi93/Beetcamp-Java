
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbAll.CustomPlanDAO;
import dbAll.CustomPlanVO;

public class CustomPlan extends JPanel{
	Font fnt = new Font("굴림체",Font.BOLD,24);
		String columName[] = {"항공편","출발지","도착지","출발시간","도착시간","상태"};
	DefaultTableModel model = new DefaultTableModel(columName,0);
	JTable tbl = new JTable(model);
	JScrollPane sp = new JScrollPane(tbl);
		
	JLabel dateLbl = new JLabel("___월___일 항공 일정");
	public CustomPlan() {
		setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.BOTH;
		
		g.gridwidth = 1;
		g.gridheight = 1;
		g.gridx = 0;
		g.gridy = 0;
		dateLbl.setHorizontalAlignment(JLabel.CENTER);
		dateLbl.setFont(fnt);
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM월 dd일 항공일정");
		String date = format.format(today);
		dateLbl.setText(date);
		add(dateLbl,g);
		
		g.gridwidth= 1;
		g.gridheight= 1;
		g.gridx = 0;
		g.gridy = 1;
		tbl.getParent().setBackground(Color.white);
		add(sp,g);
		
		setBackground(Color.white);
		setSize(1000,800);
		setVisible(true);
		getCustomPlanPrint();
	}
	
	public void getCustomPlanPrint() {
		CustomPlanDAO dao = new CustomPlanDAO();
		List<CustomPlanVO> lst = dao.getCustomRecord();
		model.setRowCount(0);
		for(int i=0;i<lst.size();i++) {
			CustomPlanVO vo = lst.get(i);
			Object[] data = {vo.getFlightNo(),vo.getDep(),vo.getDes(),vo.getDepTime(),vo.getDesTime(),vo.getFlight_state()};
			model.addRow(data);
		}	
	}
	
	
	
}
