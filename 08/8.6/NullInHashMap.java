
import java.util.*;
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
public class NullInHashMap
{
	public static void main(String[] args)
	{
		var hm = new HashMap();
		// ��ͼ������keyΪnull��key-value�Է���HashMap��
		hm.put(null, null);
		hm.put(null, null);    // ��
		// ��һ��valueΪnull��key-value�Է���HashMap��
		hm.put("a", null);    // ��
		// ���Map����
		System.out.println(hm);
	}
}