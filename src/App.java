import java.util.Random;
import java.util.Scanner;

public class App {

    // Definir variables globales
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    static String[] planetas = { "Marte: Es un planeta frio y oscuro",
            "Jupiter: Es el planeta mas grande del sistema solar",
            "Neptuno: Es el planeta mas lejano del sistema solar",
            "mercurio: Mercurio es el planeta más pequeño del sistema solar con un diámetro de 4,879 km y es uno de los cinco planetas que es visible a simple vista. Después de la Tierra",
            "venus: Se caracteriza por ser un planta rocoso, sin satélites ni anillos y con una atmósfera muy densa compuesta en mayor proporción de dióxido de carbono",
            "saturno: Saturno es el sexto planeta desde el Sol, y el último de los planetas conocidos por las civilizaciones antiguas. Era conocido por los babilonios y el observador del Lejano Oriente",
            "urano:  Urano es un planeta gaseoso con una gran cantidad de metano en su superficie, lo que le confiere un tono azulado" }; // Nombre del planeta OPCIONAL: que tenga su descripción

      

    static double[] distancias = { 225.0, 588.0, 4500.0, 77.0, 41.0, 1.2000, 2.871 }; // Distancia en millones de kilometros

    // Definir constantes para códigos de color
    static final String GREEN = "\033[32m"; // Verde para barra de progreso
    static final String YELLOW = "\033[33m"; // Amarillo para barra de progreso
    static final String BLUE = "\033[34m"; // Azul para subtitulos
    static final String ORANGE = "\033[38;5;208m"; // Naranja en las recomendaciones
    static final String BOLD = "\033[1m"; // Negrita en subtitulos
    static final String RESET = "\033[0m"; // Resetea el color
    static final String BRIGHT_BLUE = "\033[94m"; // Azul brillante Titulos
    static final String BRIGHT_GREEN = "\033[92m"; // Verde brillante Soluciones
    static final String UNDERLINE = "\033[4m"; // Subrayado en titulos

    // Verificación de selección de nave y planeta
    static boolean isPlanetSelected = false; // Verifica si se ha seleccionado un planeta
    static boolean isShipSelected = false; // Verifica si se ha seleccionado una nave
    static int selectedShipIndex = -1; // Indice de nave seleccionada
    static int selectedPlanetIndex = -1; // Indice de planeta seleccionado

    public static void main(String[] args) {
        int opcion;

        do {
            showMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    seleccionarPlaneta();
                    break;
                case 2:
                    seleccionarNaveEspacial();
                    break;
                case 3:
                    calcularRecursos();
                    break;
                case 4:
                    iniciarViaje();
                    break;  
                case 5:
                    monitorearEstadoViaje();
                    break;                    
                case 6:
                    simularEventosinconvenientes();
                    break;
                case 7:
                    System.out.println("Saliendo del programa.......");
                   break;     
                                
                
                
                
                
                  
                default:
                    System.out.println("Opción no validad  !!!!!");
                    break;
            }
        } while (opcion !=7);
        sc.close();
    }

    public static void showMenu() {
        System.out.println(BRIGHT_BLUE + UNDERLINE + BOLD+"\n\t=== SIMULADOR DE VAIJES INTERPLANETARIO ===\n" + RESET);
        System.out.println(BLUE+BOLD + "1)." + RESET + " Planetas destino");
        System.out.println(BLUE+BOLD + "2)." + RESET + " Naves disponible");
        System.out.println(BLUE+BOLD + "3)." + RESET + " Calcular recursos");
        System.out.println(BLUE+BOLD + "4)." + RESET + " Iniciar Viaje");
        System.out.println(BLUE+BOLD + "5)." + RESET + " Monitorear el estado del Viaje");
        System.out.println(BLUE+BOLD + "6)." + RESET + " Simular eventos o inconvenientes");
        System.out.println(BLUE+BOLD + "7)." + RESET + " Salir");
        System.out.print(BOLD + "Selecciones una opción: " + RESET);
      
      
    }

    // Selección de planeta
    public static void seleccionarPlaneta() {
        System.out.println(BOLD+BRIGHT_BLUE+UNDERLINE+"\n\tMenú Planetas y sus distancias desde la Tierra "+RESET+"\n");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println(BOLD+BRIGHT_BLUE+(i + 1) + "). " +RESET+ planetas[i] +BLUE+BOLD+ " - Distancia: " + distancias[i] + " millones de km."+RESET);
        }
        System.out.print(BOLD+"Elige el número de tu planeta destino: "+RESET);
        var seleccion = sc.nextInt();

        if (seleccion >= 1 && seleccion <= planetas.length) {
            selectedPlanetIndex = seleccion - 1;
            System.out.println(BRIGHT_GREEN+"\nHas seleccionado " + planetas[selectedPlanetIndex] + "."+RESET);
            isPlanetSelected = true;
        } else {
            System.err.println(ORANGE+"Selección no válida. Por favor, intenta de nuevo."+RESET);
        }

    }

    // Selección de nave espacial
    public static void seleccionarNaveEspacial() {
        if (!isPlanetSelected) {
            System.err.println(ORANGE + "Primero debes seleccionar un planeta destino." + RESET);
            return;
        }

    }

    public static void gestionarRecursos(double distancia) {
        // Supongamos que la nave consume 0.1 unidades de combustible por km y 0.05 unidades de oxígeno por km
        double combustibleNecesario = distancia * 0.55;
        double oxigenoNecesario = distancia * 0.05;
        
        System.out.println("Combustible necesario: " + combustibleNecesario + " unidades");
        System.out.println("Oxígeno necesario: " + oxigenoNecesario + " unidades");
        
        // Permitir al usuario ajustar recursos (se podría implementar una lógica adicional aquí)
    }
        public static void simularEventosinconvenientes() {
            // Generar eventos aleatorios (por ejemplo, utilizando la clase Random)
            System.out.println("Simulación de eventos aleatorios en progreso...");
            // Lógica de eventos aleatorios aquí
        }
       public static void calcularRecursos() {
    
       }
        public static void monitorearEstadoViaje() {
            // Monitorear el progreso del viaje
            System.out.println("Monitoreando el estado del viaje...");
            // Lógica de monitoreo aquí
        }
        
        public static void iniciarViaje() {
    
        }

   

   

   

}