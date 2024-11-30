package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import main.Stock;
import main.ClientEmail;
import main.ClientPhone;
import main.ClientText;

public class StockAlertTest {
    
    @Test
    public void PhoneTest() {
        Stock META = new Stock("Meta", "META", 100, new ClientPhone(null));
        
        assertEquals(META.changePrice(-100), "");
        assertFalse(META.changePrice((-100)).equals("\"Alerting Action: attempting to call client \"Meta(META) has changed it's price to $-100.0\""));
        
        assertEquals(META.changePrice(202.02), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $202.02\"");
        
        ArrayList<String> alertsList = (ArrayList<String>) META.getAlerts();
        
        assertEquals(alertsList.get(0), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $202.02\"");
        
        assertEquals(META.changePrice(201.57), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $201.57\"");
        
        alertsList = (ArrayList<String>) META.getAlerts();
        
        assertEquals(alertsList.get(0), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(1), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $201.57\"");
    }

    @Test
    public void EmailTest() {
        Stock META = new Stock("Meta", "META", 100, new ClientEmail(null));
        
        assertEquals(META.changePrice(-100), "");
        assertFalse(META.changePrice((-100)).equals("\"Alerting Action: attempting to email client \"Meta(META) has changed it's price to $-100.0\""));
        
        assertEquals(META.changePrice(202.02), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $202.02\"");
        
        ArrayList<String> alertsList = (ArrayList<String>) META.getAlerts();
        
        assertEquals(alertsList.get(0), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $202.02\"");
        
        assertEquals(META.changePrice(201.57), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $201.57\"");
        
        alertsList = (ArrayList<String>) META.getAlerts();
        
        assertEquals(alertsList.get(0), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(1), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $201.57\"");    
    }

    @Test
    public void TextTest() {
        Stock META = new Stock("Meta", "META", 100, new ClientText(null));
        
        assertEquals(META.changePrice(-100), "");
        assertFalse(META.changePrice((-100)).equals("\"Alerting Action: attempting to text client \"Meta(META) has changed it's price to $-100.0\""));
        
        assertEquals(META.changePrice(202.02), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $202.02\"");
        ArrayList<String> alertsList = (ArrayList<String>) META.getAlerts();

        assertEquals(alertsList.get(0), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $202.02\"");
        
        assertEquals(META.changePrice(201.57), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $201.57\"");
        
        alertsList = (ArrayList<String>) META.getAlerts();

        assertEquals(alertsList.get(0), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(1), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $201.57\"");
    }

    @Test
    public void PhoneEmailTest() {
        Stock META = new Stock("Meta", "META", 100, new ClientPhone(new ClientEmail(null)));
        
        assertEquals(META.changePrice(-100), "");
        assertFalse(META.changePrice((-100)).equals("\"Alerting Action: attempting to email client \"Meta(META) has changed it's price to $-100.0\""));
        
        assertEquals(META.changePrice(202.02), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $202.02\"");
        
        ArrayList<String> alertsList = (ArrayList<String>) META.getAlerts();

        assertEquals(alertsList.get(0), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(1), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $202.02\"");
        
        assertEquals(META.changePrice(201.57), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $201.57\"");
        
        alertsList = (ArrayList<String>) META.getAlerts();

        assertEquals(alertsList.get(0), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(1), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(2), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $201.57\"");
        assertEquals(alertsList.get(3), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $201.57\"");
    }

    @Test
    public void TextPhoneEmailTest() {
        Stock META = new Stock("Meta", "META", 100, new ClientText(new ClientPhone(new ClientEmail(null))));
        
        assertEquals(META.changePrice(-100), "");
        assertFalse(META.changePrice((-100)).equals("\"Alerting Action: attempting to text client \"Meta(META) has changed it's price to $-100.0\""));
        
        assertEquals(META.changePrice(202.02), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $202.02\"");
        
        ArrayList<String> alertsList = (ArrayList<String>) META.getAlerts();

        assertEquals(alertsList.get(0), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(1), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(2), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $202.02\"");
        
        assertEquals(META.changePrice(201.57), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $201.57\"");
        
        alertsList = (ArrayList<String>) META.getAlerts();

        assertEquals(alertsList.get(0), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(1), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(2), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $202.02\"");
        assertEquals(alertsList.get(3), "Alerting Action: attempting to email client \"Meta(META) has changed it's price to $201.57\"");
        assertEquals(alertsList.get(4), "Alerting Action: attempting to call client \"Meta(META) has changed it's price to $201.57\"");
        assertEquals(alertsList.get(5), "Alerting Action: attempting to text client \"Meta(META) has changed it's price to $201.57\"");
    }

    @Test
    public void AlertsUnaffected() {
        Stock META = new Stock("Meta", "META", 100, new ClientText(new ClientPhone(new ClientEmail(null))));
        
        assertEquals(META.changePrice(-100), "");
        assertFalse(META.changePrice((-100)).equals("\"Alerting Action: attempting to text client \"Meta(META) has changed it's price to $-100.0\""));
        
        ArrayList<String> alertList = META.getAlerts();
        assertEquals(alertList.size(), 0); // no alerts added/created
    }
}
