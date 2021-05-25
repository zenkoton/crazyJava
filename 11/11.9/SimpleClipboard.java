
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
/**
 * Description:
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 5.0
 */
public class SimpleClipboard
{
	private Frame f = new Frame("�򵥵ļ��������");
	// ��ȡϵͳ������
	private Clipboard clipboard = Toolkit
		.getDefaultToolkit().getSystemClipboard();
	// �����Ǵ������ؼ�����Ĵ���
	// Clipboard clipboard = new Clipboard("cb");   // ��
	// ���ڸ����ı����ı���
	private TextArea jtaCopyTo = new TextArea(5,20);
	// ����ճ���ı����ı���
	private TextArea jtaPaste = new TextArea(5,20);
	private Button btCopy = new Button("����"); // ���ư�ť
	private Button btPaste = new Button("ճ��"); // ճ����ť
	public void init()
	{
		var p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		btCopy.addActionListener(event ->
		{
			// ��һ�������ı�������ַ�����װ��StringSelection����
			var contents = new StringSelection(jtaCopyTo.getText());
			// ��StringSelection������������
			clipboard.setContents(contents, null);
		});
		btPaste.addActionListener(event ->
		{
			// ����������а���stringFlavor����
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
			{
				try
				{
					// ȡ����������stringFlavor����
					var content = (String) clipboard.getData(DataFlavor.stringFlavor);
					jtaPaste.append(content);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		// ����һ��ˮƽ���е�Box����
		var box = new Box(BoxLayout.X_AXIS);
		// �����������ı������Box������
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		// ����ť����Panel��Box�������ӵ�Frame������
		f.add(p,BorderLayout.SOUTH);
		f.add(box,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleClipboard().init();
	}
}