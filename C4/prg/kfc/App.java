package C4.prg.kfc;

/*
* Představme si, že programujeme informační systém pro fast foodový řetězec (např. KFC, McDonald’s apod.).

* Program by měl obsahovat třídu reprezentující „fastfood“. Fastfood má následující vlastnosti (atributy):
!! ⦁    Název fastfoodu – např. McDonald’s nebo KFC
!! ⦁    Počet naskladněných kuřat – každý fastfood na začátku bude mít 0 kuřat

*  Dále bude umět následující schopnosti (metody):
!! ⦁    Naskladnit nová kuřata
!! ⦁    Prodat kuřata (Kuřata půjde prodat pouze pokud fastfood bude mít dostatek kuřat na skladě.)

*   Napište aplikaci, která bude prodávat kuřata (dokud uživatel neukončí vstup), v případě, že kuřata nemá na skladě
*  (nebo ideálně dříve),  si kuřata naskladní a poté uživateli prodá.
* Metodu ukončení vstupu nechám na Vás, vhodné možnosti jsou vypnutí vstupu (Ctrl+D) nebo napsání hlášky, která program ukončí.

* Zamyslete se, kde dává smysl jaké metody volat a tedy jakou budou mít viditelnost. 
*/
public class App {
    protected static final DeliveryService provider = new DeliveryService();
    protected static final Customer customer = new Customer();

    public static void main(String[] args) {
        //TODO
    }
}
