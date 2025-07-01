import java.util.*;


public class CurrencyConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome To My Currency Converter");
        System.out.println("Please enter the currency from which you want to convert:");
        System.out.println("1.Dollar\n2.Rupee\n3.Euro\n4.Yen");
        String Currency = sc.nextLine().toLowerCase();

        System.out.println("To which currency you want to convert " + Currency + "?");
        System.out.println("1.Dollar\n2.Rupee\n3.Euro\n4.Yen");
        String Currency1 = sc.nextLine().toLowerCase();

        System.out.println("How much amount you want to convert " + Currency + "?");
        float amount = sc.nextFloat();

        switch (Currency) {
            case "dollar":
            case "1":
                switch (Currency1) {
                    case "dollar":
                    case "1":
                        System.out.println(amount+"Dollar is Euqal to: " + amount + " " + "$");
                        break;
                    case "rupee":
                    case "2":
                        System.out.println(amount+"Dollar is Euqal to : " + (amount * 85.70) + " " + "₹");
                        break;
                    case "euro":
                    case "3":
                        System.out.println(amount+"Dollar is Euqal to: " + (amount * 0.85) + " " + "€");
                        break;
                    case "yen":
                    case "4":
                        System.out.println(amount+"Dollar is Euqal to: " + (amount * 144.21) + " " + "¥");
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                }
                break;
            case "rupee":
            case "2":
                switch (Currency1) {
                    case "dollar":
                    case "1":
                        System.out.println(amount +"Rupee is Equal to : " + (amount * 0.012) + " " + "$");
                        break;
                    case "rupee":
                    case "2":
                        System.out.println(amount +"Rupee is Equal to : " + amount + " " + "₹");
                        break;
                    case "euro":
                    case "3":
                        System.out.println(amount +"Rupee is Equal to : " + (amount * 0.0099) + " " + "€");
                        break;
                    case "yen":
                    case "4":
                        System.out.println(amount +"Rupee is Equal to : " + (amount * 1.68) + " " + "¥");
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                }
                break;
            case "euro":
            case "3":
                switch (Currency1) {
                    case "dollar":
                    case "1":
                        System.out.println(amount+"Euro is Equal to : " + (amount * 1.18) + " " + "$");
                        break;
                    case "rupee":
                    case "2":
                        System.out.println(amount+"Euro is Equal to : " + (amount * 100.90) + " " + "₹");
                        break;
                    case "euro":
                    case "3":
                        System.out.println(amount+"Euro is Equal to : " + amount + " " + "€");
                        break;
                    case "yen":
                    case "4":
                        System.out.println(amount+"Euro is Equal to : " + (amount * 169.68) + " " + "¥");
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                }
                break;
            case "yen":
            case "4":
                switch (Currency1) {
                    case "dollar":
                    case "1":
                        System.out.println(amount+"Yen is Equal to: " + (amount * 0.0069) + " " + "$");
                        break;
                    case "rupee":
                    case "2":
                        System.out.println(amount+"Yen is Equal to: " + (amount * 0.59) + " " + "₹");
                        break;
                    case "euro":
                    case "3":
                        System.out.println(amount+"Yen is Equal to: " + (amount * 0.0059) + " " + "€");
                        break;
                    case "yen":
                    case "4":
                        System.out.println(amount+"Yen is Equal to: " + amount + " " + "¥");
                        break;
                    default:
                        System.out.println("Invalid target currency.");
                }
                break;
            default:
                System.out.println("Invalid input currency.");
        }

    }
}
