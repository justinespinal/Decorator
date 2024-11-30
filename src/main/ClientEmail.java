package main;

import java.util.ArrayList;

public class ClientEmail extends Alert {

    public ClientEmail(Alert alert) {
      super(alert);
    }
  
    String alert(String message, ArrayList<String> alerts) {
      if (previousAlert != null)
        previousAlert.alert(message, alerts);
  
      String constructedMessage = "Alerting Action: attempting to email client \"" +
          message +
          "\"";
      System.out.println(constructedMessage);
      alerts.add(constructedMessage);
      return constructedMessage;
    }
  }
