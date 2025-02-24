import java.util.Random;
import java.util.Scanner;

public class SimuladorDeVueloInterplanetario {

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
    static String[] naves = {
        "Nave Explorer: Capacidad para 5 personas, velocidad máxima 20,000 km/h",
        "Nave Voyager: Capacidad para 8 personas, velocidad máxima 25,000 km/h",
        "Nave Pioneer: Capacidad para 10 personas, velocidad máxima 22,000 km/h"
    };
    

    // Definir constantes para códigos de color+
    static final String GREEN = "\033[32m"; // Verde para barra de progreso11
    static final String YELLOW = "\033[33m"; // Amarillo para barra de progreso
    static final String BLUE = "\033[34m"; // Azul para subtitulos
    static final String ORANGE = "\033[38;5;208m"; // Naranja en las recomendaciones
    static final String BOLD = "\033[1m"; // Negrita en subtitulos
    static final String RESET = "\033[0m"; // Resetea el color
    static final String BRIGHT_BLUE = "\033[94m"; // Azul brillante Titulos
    static final String BRIGHT_GREEN = "\033[92m"; // Verde brillante Soluciones
    static final String UNDERLINE = "\033[4m"; // Subrayado en titulos
    static final String RED = "\033[32m"; // Rojo para barra de progreso

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
    
        System.out.println(BOLD + BRIGHT_BLUE + UNDERLINE + "\n\tMenú de Naves Espaciales Disponibles" + RESET + "\n");
        for (int i = 0; i < naves.length; i++) {
            System.out.println(BOLD + BRIGHT_BLUE + (i + 1) + "). " + RESET + naves[i]);
        }
    
        System.out.print(BOLD + "Elige el número de tu nave espacial: " + RESET);
        var seleccion = sc.nextInt();
    
        if (seleccion >= 1 && seleccion <= naves.length) {
            selectedShipIndex = seleccion - 1;
            System.out.println(BRIGHT_GREEN + "\nHas seleccionado " + naves[selectedShipIndex] + "." + RESET);
            isShipSelected = true;
        } else {
            System.err.println(ORANGE + "Selección no válida. Por favor, intenta de nuevo." + RESET);
        }
                               
    }

    public static void valcularrRecursos(double distancia) {
        // Supongamos que la nave consume 1.55 unidades de combustible por km y 0.15 unidades de oxígeno por km
        double combustibleNecesario = distancia * 1.55;
        double oxigenoNecesario = distancia * 0.15;
        
        System.out.println("Combustible necesario: " + combustibleNecesario + " unidades");
        System.out.println("Oxígeno necesario: " + oxigenoNecesario + " unidades");
        
       
    }
        
        
        
        
        
    public static void simularEventosinconvenientes() {
        if (!isPlanetSelected) {
            System.err.println(ORANGE + "Primero debes seleccionar un planeta destino." + RESET);
            return;
        }
        if (!isShipSelected) {
            System.err.println(ORANGE + "Primero debes seleccionar una nave espacial." + RESET);
            return;
        }
    
        System.out.println(BRIGHT_GREEN + "\nSimulación de eventos aleatorios en progreso..." + RESET);
    
        String[] eventos = {
            "Tormenta de meteoritos: La nave ha sufrido daños menores.",
            "Agujero negro cercano: La trayectoria ha sido ligeramente desviada.",
            "Se detecta una anomalía gravitacional: Velocidad reducida temporalmente.",
            "Falla en los sistemas de soporte vital: Los sistemas se están reiniciando.",
            "Encuentro con una nave alienígena: Intercambio de saludos amistosos."
        };
    
        // Generar un evento aleatorio
        int eventoIndex = r.nextInt(eventos.length);
    
        // Mostrar el evento aleatorio generado
        System.out.println(YELLOW + eventos[eventoIndex] + RESET);
    
        // Lógica adicional según el evento (puedes ajustar según necesites)
        switch (eventoIndex) {
            case 0: // Tormenta de meteoritos
                System.out.println(RED + "Reparando daños menores..." + RESET);
                break;
            case 1: // Agujero negro cercano
                System.out.println(BRIGHT_BLUE + "Recalculando trayectoria..." + RESET);
                break;
            case 2: // Anomalía gravitacional
                System.out.println(BRIGHT_BLUE + "Velocidad reducida temporalmente." + RESET);
                break;
            case 3: // Falla en los sistemas de soporte vital
                System.out.println(RED + "Reiniciando sistemas de soporte vital..." + RESET);
                break;
            case 4: // Encuentro con una nave alienígena
                System.out.println(BRIGHT_GREEN + "Intercambio de saludos completado." + RESET);
                break;
        }
    }
    
       public static void calcularRecursos() {
    if (!isPlanetSelected) {
        System.err.println(ORANGE + "Primero debes seleccionar un planeta destino." + RESET);
        return;
    }
    if (!isShipSelected) {
        System.err.println(ORANGE + "Primero debes seleccionar una nave espacial." + RESET);
        return;
    }

    double distancia = distancias[selectedPlanetIndex];
    double combustibleNecesario = distancia * 1.55; // Suponemos que la nave consume 1.55 unidades de combustible por km
    double oxigenoNecesario = distancia * 0.15; // Suponemos que la nave consume 0.15 unidades de oxígeno por km

    System.out.println(BRIGHT_BLUE + "\nRecursos necesarios para el viaje a " + planetas[selectedPlanetIndex] + ":" + RESET);
    System.out.println(BRIGHT_GREEN + "Combustible necesario: " + combustibleNecesario + " unidades" + RESET);
    System.out.println(BRIGHT_GREEN + "Oxígeno necesario: " + oxigenoNecesario + " unidades" + RESET);

    // Permitir al usuario ajustar recursos (puedes implementar lógica adicional aquí si es necesario)
}

     
       public static void monitorearEstadoViaje() {
        if (!isPlanetSelected) {
            System.err.println(ORANGE + "Primero debes seleccionar un planeta destino." + RESET);
            return;
        }
        if (!isShipSelected) {
            System.err.println(ORANGE + "Primero debes seleccionar una nave espacial." + RESET);
            return;
        }
    
        System.out.println(BRIGHT_GREEN + "Monitoreando el estado del viaje hacia " + planetas[selectedPlanetIndex] + "..." + RESET);
    
        double distanciaTotal = distancias[selectedPlanetIndex];
        double distanciaRecorrida = 0;
        double velocidad = 100; // Suponiendo una velocidad constante de 100 millones de km por ciclo
        double combustible = distanciaTotal * 1.55;
        double oxigeno = distanciaTotal * 0.15;
    
        while (distanciaRecorrida < distanciaTotal) {
            distanciaRecorrida += velocidad;
    
            if (distanciaRecorrida > distanciaTotal) {
                distanciaRecorrida = distanciaTotal;
            }
    
            combustible -= velocidad * 1.55;
            oxigeno -= velocidad * 0.15;
    
            System.out.println(BRIGHT_BLUE + "Progreso del viaje: " + RESET + (distanciaRecorrida / distanciaTotal * 100) + "%");
            System.out.println(BRIGHT_BLUE + "Combustible restante: " + RESET + combustible + " unidades");
            System.out.println(BRIGHT_BLUE + "Oxígeno restante: " + RESET + oxigeno + " unidades");
            
            try {
                Thread.sleep(1000); // Pausa de 1 segundo para simular el tiempo de viaje
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        System.out.println(BRIGHT_GREEN + "\n¡El viaje ha sido completado! Has llegado a " + planetas[selectedPlanetIndex] + "." + RESET);
    }
  
       
       
       
        
        
        public static void iniciarViaje() {
            if (!isPlanetSelected) {
                System.err.println(ORANGE + "Primero debes seleccionar un planeta destino." + RESET);
                return;
            }
            
            if (!isShipSelected) {
                System.err.println(ORANGE + "Primero debes seleccionar una nave espacial." + RESET);
                return;
            }
     System.out.println(BRIGHT_GREEN + "Iniciando el viaje hacia " + planetas[selectedPlanetIndex] + "..." + RESET);
            
            // Simular el progreso del viaje
            for (int i = 0; i <= 100; i += 10) {
                try {
                    Thread.sleep(500); // Pausa de medio segundo para simular progreso
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i < 50) {

                    System.out.print(GREEN + "=" + RESET);
                } else if (i < 80) {
                    System.out.print(YELLOW + "=" + RESET);
                } else {
                    System.out.print(RED + "=" + RESET);
                }
            }
            System.out.println(BRIGHT_GREEN + "\n¡Has llegado a " + planetas[selectedPlanetIndex] + "!" + RESET);
        }
        
    
        }
