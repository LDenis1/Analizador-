/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasintactico;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Yoly
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Examen/src/pruebasintactico/Lexer.flex";
        String ruta2 = "C:/Examen/src/pruebasintactico/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax","C:/Examen/src/pruebasintactico/Sintax.cup"};
        generarLexer(ruta1, ruta2);
        generarSintactico(rutaS);
    }
 
    public static void generarSintactico(String[] rutaS) throws IOException, Exception{
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Examen/src/pruebasintactico/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Examen/src/pruebasintactico/sym.java"), 
                Paths.get("C:/Examen/src/pruebasintactico/sym.java")
        );
        Path rutaSin = Paths.get("C:/Examen/src/pruebasintactico/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Examen/src/pruebasintactico/Sintax.java"), 
                Paths.get("C:/Examen/src/pruebasintactico/Sintax.java")
        );
    }
   
    public static void generarLexer(String ruta1, String ruta2) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
    }
}
