import java.util.Random;
import java.util.Scanner;

public class randomPassword {
    public static void main(String[] args) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&/();:";
        String cadenaFinal = "";

        Random azar = new Random();
        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Ingresa la cantidad de caracteres que desee para la contraseña?");
        int largoCadena = entrada.nextInt();

        if (largoCadena < 15) {
            System.out.println("Se recomienda que la contraseña tenga 15 o mas digitos\n");
        }

        char[] text = new char[largoCadena];

        for(int i = 0; i < largoCadena; i++) {
            text[i] = caracteres.charAt(azar.nextInt(caracteres.length()));
        }

        for(int i = 0; i < text.length; i++) {
            cadenaFinal += text[i];
        }

        System.out.println("Tu contraseña es : " + cadenaFinal);
    }
}
