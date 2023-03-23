///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: HuaiYuan Jing
// Campus ID: 9084099523
// WiscEmail: hjing7@wisc.edu
////////////////////////////////////////////////////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HolidayPrizeIterator implements Iterator
{
	private String[] names;
	private int id;
	public HolidayPrizeIterator(String[] names) throws NoSuchElementException
	{
		if (names == null)
			throw new NoSuchElementException();
		this.names = new String[names.length];
		for (int i = 0; i < names.length; ++i)
			this.names[i] = names[i];
		this.id = 0;
	}
	
	@Override
	public boolean hasNext()
	{
		return this.id < this.names.length;
	}
	
	@Override
	public Object next()
	{
		String ans = this.names[id] + " is our next exclusive holiday prize";
		id++;
		return ans;
	}
}
