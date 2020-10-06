package sv.org.rguevara.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DemoController {
	
	
	private String hola = "Hola Mundo";

	public String getHola() {
		return hola;
	}

	public void setHola(String hola) {
		this.hola = hola;
	}
	
	
}
