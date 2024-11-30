package main;

import java.util.ArrayList;

public abstract class Alert {

    protected Alert previousAlert;
  
    Alert(Alert alert) {
      this.previousAlert = alert;
    }
  
    abstract String alert(String message, ArrayList<String> alerts);
  }