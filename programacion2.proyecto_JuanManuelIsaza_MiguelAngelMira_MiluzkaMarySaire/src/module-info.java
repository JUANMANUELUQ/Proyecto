module Proyecto {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;
	requires junit;
	
	exports co.uniquindio.proyecto.application to javafx.graphics;
	opens co.uniquindio.proyecto.application to javafx.fxml;
	exports co.uniquindio.proyecto.controllers to javafx.fxml;
	opens co.uniquindio.proyecto.controllers to javafx.fxml;
}