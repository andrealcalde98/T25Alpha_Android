package com.example.t25alpha;

public class Semanas {
        private int imagen;
        private String nombre;

        public Semanas(){

        }

        public Semanas(String nombre, int imagen) {
            this.nombre = nombre;
            this.imagen = imagen;

        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }


        public int getImagen() {
            return imagen;
        }

        public void setImagen(int imagen){
            this.imagen = imagen;
        }
    }

