package main;

import java.util.ArrayList;

public class Stock {
    private String company;
    private String ticker;
    private double price;
    private Alert alertSystem;
    private ArrayList<String> alerts;
  
    public Stock(String company, String ticker, double price, Alert alertSystem) {
      this.company = company;
      this.ticker = ticker;
      this.price = price;
      this.alertSystem = alertSystem;
      this.alerts = new ArrayList<String>();
    }
  
    public String changePrice(double newPrice) {
      if (newPrice < 0) {
        return "";
      }
      this.price = newPrice;
      String message = company +
          "(" +
          ticker +
          ") has changed it's price to $" +
          price;
      return this.alertSystem.alert(message, alerts);
    }
  
    public double getPrice() {
      return this.price;
    }

    public ArrayList<String> getAlerts() {
        return new ArrayList<String>(this.alerts);
    }
  }
