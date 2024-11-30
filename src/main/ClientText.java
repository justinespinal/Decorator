package main;

import java.util.ArrayList;

public class ClientText extends Alert {

    public ClientText(Alert alert) {
      super(alert);
    }
  
    String alert(String message, ArrayList<String> alerts) {
      if (previousAlert != null)
        previousAlert.alert(message, alerts);
  
      String constructedMessage = "Alerting Action: attempting to text client \"" +
          message +
          "\"";
      System.out.println(constructedMessage);
      alerts.add(constructedMessage);
      return constructedMessage;
    }
  }
