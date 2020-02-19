package iva.com.beispiele;

public enum Status {
START(1,10), STOP(2,20);

private final int go;
private final int goo;

Status(int go, int goo){
	this.go = go;
	this.goo = goo;
}
public int getGo(){
	return this.go;
}
public int getGoo() {
	return goo;
}
}
