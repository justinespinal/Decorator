package main;
public class Main {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Email!\n");
        Stock NVDA = new Stock("Nividia", "NVDA", 320, new ClientEmail(null));
        NVDA.changePrice(312.30);
    
        System.out.println("\nEmail and Phone alert!\n");
        NVDA = new Stock("Nividia", "NVDA", 320, new ClientEmail(new ClientPhone(null)));
        NVDA.changePrice(320.57);
    
        System.out.println("\nEmail, Phone and Text alert!\n");
        NVDA = new Stock("Nividia", "NVDA", 320, new ClientEmail(new ClientPhone(new ClientText(null))));
        NVDA.changePrice(354.78);
    
      }
}
