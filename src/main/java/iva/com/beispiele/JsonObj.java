package iva.com.beispiele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JsonObj {
 private int inhalt;
 private String fehler;
 private List<String> lis = new ArrayList<String>();
 private String[] arr = new String[2];
 private Map<String, String> map = new HashMap<String, String>();
 
 public JsonObj(int inhalt, String fehler){
	 this.inhalt = inhalt;
	 this.fehler = fehler;
			 lis.add("Fehler");
			 lis.add(fehler);
			 arr[0]="iva";
			 map.put("Fehler", fehler);
			 map.put("Fehler1", fehler);
 }
public Map<String, String> getMap() {
	return map;
}
public List<String> getLis() {
	return lis;
}
public int getInhalt() {
	return inhalt;
}
public void setInhalt(int inhalt) {
	this.inhalt = inhalt;
}
public String getFehler() {
	return fehler;
}
public void setFehler(String fehler) {
	this.fehler = fehler;
}
 
	
}
