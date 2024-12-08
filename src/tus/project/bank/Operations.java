package tus.project.bank;

// Use of interface
// use of default, static, private methods in interface
public interface Operations {
    boolean deposit(int amount);
    boolean withdraw(int amount);

    // Default method
    default void showAccountType(){
        System.out.println("I am a default account type");
    }

    // Static method
    static void showOperationsAvailabe(){
        System.out.println("I can deposit or withdraw in an account");
    }

    private void calculateCompoundInterest(float ROI, float principal){
        // Convert annual rate to a fraction
        double rate = ROI / 100;
        int timesCompounded = 2; // Semi Annually
        int timeInYears = 5;

        // Compound interest formula: A = P(1 + R/n)^(nt)
        double amt = principal * Math.pow(1 + (rate / timesCompounded), timesCompounded * timeInYears);

        // Calculate compound interest
        double compoundInterest = amt - principal;
        System.out.println("Compound interest is: " + compoundInterest);
    }
}
