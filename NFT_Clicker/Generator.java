
/**
 * Write a description of class Generator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Generator
{
    // instance variables - replace the example below with your own
    private String name;
    private long startCost;
    private long genIncome;
    private int amount;
    private double increaseRate;
    private long visibleAmount;
    private boolean visibility;

    /**
     * Constructor for objects of class Generator
     */
    public Generator(String name, long startCost, long genIncome, int amount, double increaseRate, long visibleAmount, boolean visibility)
    {
        // initialise instance variables
        this.name = name;
        this.startCost = startCost;
        this.genIncome = genIncome;
        this.amount = amount;
        this.increaseRate = increaseRate;
        this.visibleAmount = visibleAmount;
        this.visibility = visibility;
    }

    public String getName()
    {
        return this.name;
    }
    
    public long getStartCost()
    {
        return this.startCost;
    }
    
    public long getGenIncome()
    {
        return genIncome;
    }

    public void setGenIncome(long income)
    {
        genIncome = income;
    }
    
    public int getAmount()
    {
        return this.amount;
    }
    
    public double getIncreaseRate()
    {
        return this.increaseRate;
    }
    
    public long getVisibleAmount()
    {
        return this.visibleAmount;
    }
    
    public boolean visibility()
    {
        return this.visibility;
    }
    
    public void toggleVisibility()
    {
        this.visibility = !this.visibility;
    }
    
    public void buyGenerator()
    {
        this.amount++;
    }
    
    public void buyGenerator(int num)
    {
        this.amount += num;
    }
    
    //Return the current price of the generator
    public long getPrice()
    {
        // startCost ^ (amount / increaseRate  + 1)
        return (long) Math.pow(this.startCost, (1 + this.amount / this.increaseRate));
    }
}