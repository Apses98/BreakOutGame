import javax.swing.DefaultListModel;

public class Lista {
	private DefaultListModel dlm;
	public Lista()
	{
		dlm = new DefaultListModel();
	}
	public void add(Object anElement)
	{
		dlm.addElement(anElement);
	}
	public DefaultListModel getList()
	{
		return dlm;
	}

}
