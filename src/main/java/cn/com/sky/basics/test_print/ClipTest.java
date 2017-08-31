package cn.com.sky.basics.test_print;

import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClipTest {

	protected JTable table;

	public static void main(String[] args) {
		new ClipTest();
	}

	public ClipTest() {
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{ "ts", "etry", null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null },
						{ null, null, null, null, null, null, null, null, null,
								null } }, new String[] { "厂商编号", "厂商名称",
						"应付款金额", "预付款金额", "实际欠款", "联系人", "联系电话", "邮政编码",
						"通信地址", "入档日期" }) {

			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		table.setSize(table.getPreferredSize());
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new MyPrintable());
		try {
			job.print();
		} catch (PrinterException pe) {
		}
		;
		System.exit(0);
	}

	class MyPrintable implements Printable {

		public int print(Graphics g, PageFormat pf, int index) {
			int positionX = (int) (pf.getImageableX());
			int positionY = (int) (pf.getImageableY());
			int width = (int) (pf.getImageableWidth());
			g.clipRect(positionX, positionY, width, 500);
			g.translate(positionX, positionY);
			int pixelIndex = index * 500;
			if (pixelIndex < table.getHeight()) {
				g.translate(0, -pixelIndex);
				table.paint(g);
				return Printable.PAGE_EXISTS;
			}
			return Printable.NO_SUCH_PAGE;
		}

	}

}