package Test.bank7.java;

/**
 * @author sunjiacheng
 * @create 2019-10-18-14:30
 */
public class OverDraftException extends Exception
{
    static final long serialVersionUID = -338751699312948L;

    private double deficit;

    public double getDeficit() {
        return deficit;
    }

    public OverDraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }
}
