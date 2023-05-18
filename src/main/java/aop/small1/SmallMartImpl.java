package aop.small1;

public class SmallMartImpl implements SmallMart{

	@Override
	public void getProduct(String name) throws Exception {
		System.out.println(String.format("impl.getProduct(%s)", name));
		if(name.equals("stop")) {
			throw new Exception("my exception");
		}
	}
	
}
