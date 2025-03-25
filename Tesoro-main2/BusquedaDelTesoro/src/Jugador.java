import javax.swing.*;

public class Jugador {

 int posicionTablero = 1;
 String nombre;
 ImageIcon icon;
 boolean turnoActivo;

 public Jugador(int posicionTablero,String nombre, ImageIcon icon, boolean turnoActivo){
     this.posicionTablero=posicionTablero;
     this.nombre= nombre;
     this.icon =icon;
     this.turnoActivo=turnoActivo;

 }

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public ImageIcon getIcon() {
  return icon;
 }

 public void setIcon(ImageIcon icon) {
  this.icon = icon;
 }

 public boolean isTurnoActivo() {
  return turnoActivo;
 }

 public void setTurnoActivo(boolean turnoActivo) {
  this.turnoActivo = turnoActivo;
 }

 public int getPosicionTablero() {
  return posicionTablero;
 }

 public void setPosicionTablero(int posicionTablero) {
  this.posicionTablero = posicionTablero;
 }

 private void mecanismoAvance(){

 }
 

}
