package Assignment;

public class TestMkst {
	
	public static void main(String args[]) throws Exception{
		//testAdd();
		//testUpdate();
		//testDelete();
		//testGet();
		//testGetMeritList();
		testSearch();
	}

	public static void testSearch() throws Exception{
		MrkshtModel mm=new MrkshtModel();
		
		mm.search();
	}

	public static void testGetMeritList() throws Exception{
		 
		MrkshtModel md=new MrkshtModel();
		
		md.getMeritList();
		
	}

	public static void testGet() throws Exception {
		
		MarksheetBean bean=new MarksheetBean();
		
		bean.setId(12);
		
		MrkshtModel model=new MrkshtModel();
		
		model.get(bean);
	}

	public static void testDelete() throws Exception {
		
		MarksheetBean bean=new MarksheetBean();
		
		bean.setId(2);
		
		MrkshtModel model=new MrkshtModel();
		
		model.delete(bean);
	}

	public static void testUpdate() throws Exception {
		
		MarksheetBean bean=new MarksheetBean();
		
		bean.setPhy(40);
		
		bean.setChe(42);
		
		bean.setMath(47);
		
		bean.setId(14);
		
		MrkshtModel model=new MrkshtModel();
		
		model.update(bean);
	}

	public static void testAdd() throws Exception {
		
		MarksheetBean bean= new MarksheetBean();
		
		//bean.setId();
		
		bean.setRollNo("B23");
		
		bean.setFName("");
		
		bean.setLname("");
		
		bean.setPhy(76);
		
		bean.setChe(81);
		
		bean.setMath(78);
		
		MrkshtModel mm=new MrkshtModel();
		
		mm.add(bean);
	
	}
}
