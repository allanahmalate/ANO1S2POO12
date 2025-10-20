import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;

public class FormattingDemo {

    public static void main(String[] args) {
        // --- Input Values ---
        double valueToFormat = 5891.3456;
        double percentageValue = 0.385;
        double valueToRound = 15.67;
        
        System.out.println("--- Java Math Operations ---");

        // 1. Math.round()
        //Rounds a float or double to the nearest integer (returns long or int).
        // Rounds the double 15.67 to the nearest integer (16), returned as a long.
        long rounded = Math.round(valueToRound);
        System.out.println("1. Math.round(" + valueToRound + ") is: " + rounded); 

        // 2. Math.random()
        //Returns a pseudo-random double greater than or equal to $0.0$ and less than $1.0$.
        //To get a random integer in a range (e.g., $1$ to $100$): (int)(Math.random() * range) + min
        // Generates a random integer between 1 and 50 (inclusive).
        int randomInt = (int) (Math.random() * 50) + 1;
        System.out.println("2. Math.random() (1-50 range) result: " + randomInt);

        System.out.println("\n--- Number Formatting ---");
        
        // 3. NumberFormat (for Dollars)
        //Used for locale-specific currency formatting, typically with getCurrencyInstance()
        // Uses the US locale to display currency with the '$' symbol.
        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedDollars = dollarFormat.format(valueToFormat);
        System.out.println("3. Dollar Format: " + formattedDollars); 

        // 4. NumberFormat (for Percentage)
        //Used for locale-specific percentage formatting, typically with getPercentInstance().
        // Displays the value as a percentage.
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        String formattedPercent = percentFormat.format(percentageValue);
        System.out.println("4. Percentage Format: " + formattedPercent); 

        // 5. DecimalFormat (for Meticais)
        //Provides flexible custom formatting using a pattern (e.g., for Mozambican Metical, MZN).
        // Uses a custom pattern to ensure two decimal places and adds the " MT" suffix.
        DecimalFormat meticalFormat = new DecimalFormat("###,###,###.00 MT");
        String formattedMeticais = meticalFormat.format(valueToFormat);
        System.out.println("5. Metical Format (MZN): " + formattedMeticais); 
    }
}
