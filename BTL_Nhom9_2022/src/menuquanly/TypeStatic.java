package menuquanly;

import java.io.Serializable;

public class TypeStatic implements Serializable{
		private String type;
	    private int sumTotal;

	    public TypeStatic(String type, int sumTotal)
	    {
	        this.type = type;
	        this.sumTotal = sumTotal;
	    }

	    @Override
	    public String toString()
	    {
	        return String.format("%-12s %-5d", type, sumTotal);
	    }

	    public String getType()
	    {
	        return type;
	    }

	    public int getSumTotal()
	    {
	        return sumTotal;
	    }
}
