import java.util.Random;
import java.util.Scanner;

class Customer {
    Scanner sc = new Scanner(System.in);
    String username, password, confirm_pass, ID, passport_no, email;
    String mobile;
    boolean isLogin;
    boolean isPackage;
    String destination;
    String hotel;
    int days;
    int nights;
    double price;
    int no_people;
    boolean is_paid;
    boolean lucky;

    void set() {
        System.out.println("Enter User Name : ");
        username = sc.nextLine();
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Password  : ");
            password = sc.nextLine();

            System.out.println("Confirm Your Password : ");
            confirm_pass = sc.nextLine();
            if (password.equals(confirm_pass)) {
                System.out.println("Password Is set ! ");
                flag = false;

            } else {
                System.out.println("Please Re enter the password ");
            }
        }


        System.out.println("Enter The ID You Want To Upload : ");
        ID = sc.nextLine();

        System.out.println("Enter The Passport Number : ");
        passport_no = sc.nextLine();

        System.out.println("Enter The Email ID  : ");
        email = sc.nextLine();

        boolean flagm = true;
        while (flagm) {
            System.out.println("Enter Your Mobile Number : ");
            mobile = sc.nextLine();

            if (mobile.length() == 10) {
                if(mobile.startsWith("91")) {
                    flagm = false;
                }
            }
            if (flagm) {
                System.out.println("Enter The Valid Mobile No. : ");

            }
        }
        System.out.println("Registration Successful!");

    }

    void display() {
        System.out.println("  Username       : " + username);
        System.out.println("  Password       : " + password);
        System.out.println("  ID             : " + ID);
        System.out.println("  Passport Number: " + username);
        System.out.println("  Email          : " + email);
        System.out.println("  Mobile         : " + mobile);

    }


    void set_package(String destination, String hotel, int days, int nights, double price, int no_people) {
        this.destination = destination;
        this.hotel = hotel;
        this.days = days;
        this.nights = nights;
        this.price = price;
        this.no_people = no_people;
    }

    void display_package() {
        System.out.println("Destination : " + destination);
        System.out.println("Booked Hotel : " + hotel);
        System.out.println("days : " + days);
        System.out.println("nights : " + (days + 1));
        System.out.println("price : " + price);
        System.out.println("No of Persons : " + no_people);

    }


}


class Registration {
    int cust = 0;

    void register(Customer[] arr) {
        arr[cust++].set();

    }

}


class Login {
    int cus_num = 0;
    Scanner sc = new Scanner(System.in);
    Customer ob = new Customer();

    void login(Customer[] arr) {
        System.out.println("Enter Username : ");
        String u = sc.nextLine();
        System.out.println("Enter Password : ");
        String p = sc.nextLine();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (u.equals(arr[i].username) && (p.equals(arr[i].password))) {
                System.out.println("Login Successfull ! ");
                cus_num = i;
                arr[i].isLogin = true;

                flag = false;
                break;


            }


        }

        if (flag) {
            System.out.println("Invalid Username or Password Please Try Again! ");
        }

    }


}

class Destination {
    String dest_name;
    String dest_des;
    double dest_price;
    String[] hotels = new String[3];


    void set(String name, String descritption, double pri, String hotel1, String hotel2, String hotel3) {
        dest_name = name;
        dest_des = descritption;
        dest_price = pri;
        hotels[0] = hotel1;
        hotels[1] = hotel2;
        hotels[2] = hotel3;
    }

    void display(Destination[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Press " + (i + 1) + " for " + arr[i].dest_name);

        }

    }


    void display_destination(Destination[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("*******************************************************************************************************************************");
            System.out.println(i + 1 + " " + arr[i].dest_name + " :");
            System.out.println("      " + arr[i].dest_des);
            System.out.println("Price : " + arr[i].dest_price);

        }
    }


}


class tour {


    public static void main(String args[]) {

        boolean spin;
        int Spin_input;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
// Customer object of array 
        Customer[] arr = new Customer[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Customer();
        }
        Login log = new Login();
        Registration reg = new Registration();
//Destination Object Of array

        Destination international[] = new Destination[4];
        Destination domestic[] = new Destination[4];
        Destination obp = new Destination();

        for (int i = 0; i < international.length; i++) {
            international[i] = new Destination();
            domestic[i] = new Destination();
        }
        international[0].set("Paris, France", "Known as the \"City of Love,\" Paris is a captivating blend of art, history, and romance. The iconic Eiffel Tower, Louvre Museum, and charming Montmartre neighborhood are just a few of its enchanting attractions. Indulge in delectable French cuisine and explore the Seine River's scenic beauty.", 50000, " Ritz Paris: A legendary 5-star hotel offering opulent luxury in the heart of the city.", " Hotel Plaza Athenee: Known for its lavish décor and Michelin-starred Alain Ducasse restaurant.", " Le Bristol Paris: A palace hotel with beautiful gardens and impeccable service.");
        international[1].set("Kyoto, Japan", "Steeped in tradition, Kyoto is a mesmerizing blend of ancient temples, serene gardens, and traditional tea houses. Explore the historic Gion district, witness a geisha performance, and immerse yourself in the beauty of cherry blossoms during spring.", 60000, " Hoshinoya Kyoto: A stunning ryokan-style resort on the banks of the Oi River.", " The Ritz-Carlton Kyoto: Combining modern luxury with traditional Japanese design.", " Hyatt Regency Kyoto: Located in the Higashiyama Shichijo district, offering elegance and comfort.");
        international[2].set("Santorini, Greece", " Santorini is a picturesque island in the Aegean Sea, famous for its white-washed buildings with blue-domed roofs and breathtaking sunsets. Explore the ancient ruins of Akrotiri, relax on unique black sand beaches, and savor delicious Greek cuisine.", 75000, " Canaves Oia Hotel: Perched on the edge of the caldera, providing stunning views.", " Katikies Hotel: A boutique hotel offering traditional Cycladic architecture.", " Mystique, a Luxury Collection Hotel: A cliffside retreat with luxurious amenities.");
        international[3].set("New York City, USA", " The \"Big Apple\" is a vibrant metropolis with iconic landmarks like Times Square, Central Park, and the Statue of Liberty. Enjoy world-class Broadway shows, explore diverse neighborhoods, and savor the culinary delights in this city that never sleeps.", 65000, " The Plaza Hotel: An iconic landmark offering timeless luxury on Fifth Avenue.", " The St. Regis New York: A prestigious hotel with a rich history and exceptional service.", " The NoMad Hotel: Known for its stylish design and a Michelin-starred restaurant by Daniel Humm.");
        domestic[0].set("Agra, Uttar Pradesh", " Agra is home to the iconic Taj Mahal, a symbol of eternal love. Explore the Agra Fort, visit Fatehpur Sikri, and marvel at the intricate architecture of the Taj Mahal.", 15000, " The Oberoi Amarvilas: A luxury hotel with uninterrupted views of the Taj Mahal.", " ITC Mughal, A Luxury Collection Hotel: Surrounded by 35 acres of gardens, offering a Mughal-inspired experience.", " Trident, Agra: Located close to the Taj Mahal, providing modern comforts.");
        domestic[1].set("Leh-Ladakh, Jammu and Kashmir", " Leh-Ladakh is a high-altitude desert region known for its stunning landscapes, monasteries, and adventure activities. Explore Pangong Lake, visit Thiksey Monastery, and experience the unique culture of the region.", 30000, " The Grand Dragon Ladakh: A centrally heated hotel with traditional Ladakhi architecture.", " Hotel Shambhala: Offering comfortable accommodations with panoramic mountain views.", "Ladakh Sarai: A boutique hotel with eco-friendly practices, providing a peaceful stay.");
        domestic[2].set("Varanasi, Uttar Pradesh", " Varanasi, situated on the banks of the Ganges River, is one of the world's oldest cities. Experience spiritual ceremonies along the ghats, visit Kashi Vishwanath Temple, and explore narrow winding streets.", 20000, " Brijrama Palace: A heritage hotel overlooking the Ganges with exquisite architecture.", " Taj Ganges, Varanasi: Set amidst 40 acres of lush gardens, providing a serene atmosphere.", " Hotel Ganges View: Offering budget-friendly accommodation with views of the river");
        domestic[3].set("Shimla, Himachal Pradesh", " Shimla, the capital of Himachal Pradesh, is a charming hill station with colonial architecture, scenic landscapes, and pleasant weather. Take a stroll on the Mall Road, visit the Ridge, and enjoy panoramic views from Jakhoo Hill.", 25000, " Wildflower Hall, Shimla: An Oberoi Resort: A luxury retreat surrounded by pine and cedar forests.", " Clarkes Hotel: A heritage hotel with Victorian architecture and modern amenities.", " The Oberoi Cecil, Shimla: Offering a blend of colonial charm and contemporary luxury.");


        while (flag) {
            System.out.println("************************************************** Welcome To Our Tourism System**************************************************  ");
            System.out.println("                                             Press 0 For Lucky Spin. ");
            System.out.println("                                             Press 1 For Login. ");
            System.out.println("                                             Press 2 For Registration. ");
            System.out.println("                                             Press 3 To View Destination.  ");
            System.out.println("                                             Press 4 To View Hotels Information. ");
            System.out.println("                                             Press 5 To Select Our Packages.  ");
            System.out.println("                                             Press 6 To Make Your Own Package. ");
            System.out.println("                                             Press 7 To View Booking History.  ");
            System.out.println("                                             Press 8 To View Your Personal Details. ");
            System.out.println("                                             Press 9 To Update Your Personal Details.  ");
            System.out.println("                                             Press 10 To Exit. ");
            System.out.println("***********************************************************************************************************************************  ");

            int menu = sc.nextInt();


            switch (menu) {
                case 0:
                    //for Lucky spin
                    if (arr[log.cus_num].isLogin && arr[log.cus_num].isPackage) {

                        if (arr[log.cus_num].lucky) {
                            System.out.println("You Have Only One Chance TO participate In lucky Draw!");
                        } else {

                            Random sp = new Random();
                            System.out.println("Welcome to the Lucky Spin \nPress 1.You get 1 chances here for only 500Rs. \nPress 2.You get 2 chances for only 800Rs. (The maximum one from both atttempts will be considered!!)");
                            int lucky = sc.nextInt();
                            int first = 0, second = 0;

                            switch (lucky) {
                                case 1:
                                    first = sp.nextInt(1, 30);
                                    System.out.println("Congratulations! You Have Won " + first + " % discount on you final expance!");
                                    arr[log.cus_num].price = arr[log.cus_num].price + 500 - ((arr[log.cus_num].price * first) / 100);
                                    System.out.println("Your Final Expance Is : " + arr[log.cus_num].price);
                                    arr[log.cus_num].lucky = true;
                                    break;

                                case 2:
                                    first = sp.nextInt(1, 30);
                                    System.out.println("Congratulations! You Have Won " + first + " % discount on you final expance!");
                                    arr[log.cus_num].price = arr[log.cus_num].price + 500 - ((arr[log.cus_num].price * first) / 100);
                                    System.out.println("Your Final Expance Is : " + arr[log.cus_num].price);
                                    arr[log.cus_num].lucky = true;

                                    second = sp.nextInt(1, 30);
                                    if (second > first) {
                                        System.out.println("Congratulations! You Have Won" + second + " % discount on you final expance!");
                                        arr[log.cus_num].price = arr[log.cus_num].price + 800 - ((arr[log.cus_num].price * second) / 100);
                                        System.out.println("Your Final Expance Is : " + arr[log.cus_num].price);
                                        arr[log.cus_num].lucky = true;
                                    } else {
                                        System.out.println("Your Winning Remain Same As First Spin!");
                                        arr[log.cus_num].price = arr[log.cus_num].price + 800 - ((arr[log.cus_num].price * first) / 100);
                                        System.out.println("Your Final Expance Is : " + arr[log.cus_num].price);
                                        arr[log.cus_num].lucky = true;
                                    }
                            }
                        }


                    } else {
                        System.out.println("Please Login and Book a package!");
                    }

                    break;
                case 1:
                    //for login
                    log.login(arr);
                    break;

                case 2:
                    //for signup
                    reg.register(arr);

                    break;
                case 3:
                    // switch case for destination preview
                    System.out.println("Press 1 for view International Destinations : ");
                    System.out.println("Press 2 for view domestic Destinations :      ");
                    int nd = sc.nextInt();
                    Destination obd = new Destination();

                    switch (nd) {

                        case 1:


                            obd.display_destination(international);

                            break;

                        case 2:


                            obd.display_destination(domestic);

                            break;
                        default:
                            System.out.println("Enter valid input! ");
                            break;
                    }

                    break;
                case 4:
                    System.out.println("Press 1 To see International Hotels : ");
                    System.out.println("Press 2 To see Domestic Hotels :      ");
                    int nh = sc.nextInt();
                    if (nh == 1) {
                        for (int i = 0; i < international.length; i++) {
                            System.out.println();
                            System.out.println(i + 1 + " " + international[i].dest_name + ":");
                            System.out.println();
                            System.out.println();
                            for (String e : international[i].hotels) {
                                System.out.println(e);
                                System.out.println();

                            }


                        }
                    } else if (nh == 2) {
                        for (int i = 0; i < domestic.length; i++) {
                            System.out.println();
                            System.out.println(i + 1 + " " + domestic[i].dest_name + ":");
                            System.out.println();
                            System.out.println();
                            for (String e : domestic[i].hotels) {
                                System.out.println(e);
                                System.out.println();

                            }


                        }
                    }


                    break;
                case 5:
                    if (arr[log.cus_num].isLogin) {
                        System.out.println("Select Your Destination! ");
                        System.out.println();
                        System.out.println("Press 1 for  International Destinations : ");
                        System.out.println("Press 2 for  domestic Destinations :      ");
                        System.out.println();
                        int np = sc.nextInt();


                        switch (np) {

                            case 1:
                                obp.display(international);
                                int in = sc.nextInt();


                                System.out.println("Select The Package Type : ");
                                System.out.println();
                                System.out.println();
                                System.out.println("Press 1 for Platinum Package : ");
                                System.out.println();
                                System.out.println("--> 7 Days and 8 nights ");
                                System.out.println("--> 5 Star Hotel For Staying ");
                                System.out.println("--> Free Assistant Of Touris Guide ");
                                System.out.println("Price : " + international[in - 1].dest_price * 7 + "(For Per Person )");
                                System.out.println();
                                System.out.println();
                                System.out.println("Press 2 for gold Package : ");
                                System.out.println();
                                System.out.println("--> 5 Days and 6 nights ");
                                System.out.println("--> 4 Star Hotel For Staying ");
                                System.out.println("--> Free Assistant Of Touris Guide ");
                                System.out.println("Price : " + international[in - 1].dest_price * 5 + ("(For Per Person )"));
                                System.out.println();
                                System.out.println();
                                System.out.println("Press 3 for Silver Package : ");
                                System.out.println();
                                System.out.println("--> 3 Days and 4 nights ");
                                System.out.println("--> 3 Star Hotel For Staying ");
                                System.out.println("--> Get Tourist Guide at Discounted Price");
                                System.out.println("Price : " + international[in - 1].dest_price * 3 + "(For Per Person)");
                                int pi = sc.nextInt();
                                System.out.println("Enter The Number Of Persons For Your Tour! ");
                                int no_p = sc.nextInt();


                                switch (pi) {
                                    case 1 ->
                                            arr[log.cus_num].set_package(international[in - 1].dest_name, international[in - 1].hotels[0], 7, 8, international[in - 1].dest_price * 7 * no_p, no_p);
                                    case 2 ->
                                            arr[log.cus_num].set_package(international[in - 1].dest_name, international[in - 1].hotels[1], 5, 6, international[in - 1].dest_price * 5 * no_p, no_p);
                                    case 3 ->
                                            arr[log.cus_num].set_package(international[in - 1].dest_name, international[in - 1].hotels[1], 3, 4, international[in - 1].dest_price * 3 * no_p, no_p);
                                }


                                arr[log.cus_num].price = arr[log.cus_num].price + (arr[log.cus_num].price * 0.18);
                                System.out.println(" Your Final Expance is " + arr[log.cus_num].price + " (18% GST Applied)");
                                System.out.println();
                                System.out.println(" Make Your Payment To confirm Your Trip ! , Enter Confirm!");
                                sc.nextLine();
                                String conf = sc.nextLine();
                                if (conf.equalsIgnoreCase("confirm")) {

                                    arr[log.cus_num].isPackage = true;
                                    System.out.println();
                                    System.out.println("Congratulations ! Your Package Is booked ! ");
                                    System.out.println("Have a Great Journey!");
                                    System.out.println("Check Your Booking History For Information About Your Package");
                                    System.out.println();

                                }


                                break;

                            case 2:
                                obp.display(domestic);
                                int dm = sc.nextInt();
                                //switch case for slecting packages


                                System.out.println("Select The Package Type : ");
                                System.out.println();
                                System.out.println();
                                System.out.println("Press 1 for Platinum Package : ");
                                System.out.println();

                                System.out.println("--> 7 Days and 8 nights ");
                                System.out.println("--> 5 Star Hotel For Staying ");
                                System.out.println("--> Free Assistant Of Touris Guide ");
                                System.out.println("Price : " + domestic[dm - 1].dest_price * 7 + "(For Per Person)");
                                System.out.println();
                                System.out.println();
                                System.out.println("Press 2 for gold Package : ");
                                System.out.println();
                                System.out.println("--> 5 Days and 6 nights ");
                                System.out.println("--> 4 Star Hotel For Staying ");
                                System.out.println("--> Free Assistant Of Touris Guide ");
                                System.out.println("Price : " + domestic[dm - 1].dest_price * 5 + "(For Per Person)");
                                System.out.println();
                                System.out.println();
                                System.out.println("Press 3 for Silver Package : ");
                                System.out.println();
                                System.out.println("--> 3 Days and 4 nights ");
                                System.out.println("--> 3 Star Hotel For Staying ");
                                System.out.println("--> Get Tourist Guide at Discounted Price");
                                System.out.println("Price : " + domestic[dm - 1].dest_price * 3 + "(For Per Person)");
                                int pd = sc.nextInt();

                                System.out.println("Enter The Number Of People For Your Tour ");
                                int no_pe = sc.nextInt();
                                switch (pd) {
                                    case 1 ->
                                            arr[log.cus_num].set_package(domestic[dm - 1].dest_name, domestic[dm - 1].hotels[0], 7, 8, domestic[dm - 1].dest_price * 7 * no_pe, no_pe);
                                    case 2 ->
                                            arr[log.cus_num].set_package(domestic[dm - 1].dest_name, domestic[dm - 1].hotels[1], 5, 6, domestic[dm - 1].dest_price * 5 * no_pe, no_pe);
                                    case 3 ->
                                            arr[log.cus_num].set_package(domestic[dm - 1].dest_name, domestic[dm - 1].hotels[1], 3, 4, domestic[dm - 1].dest_price * 4 * no_pe, no_pe);
                                }


                                arr[log.cus_num].price = arr[log.cus_num].price + (arr[log.cus_num].price * 0.18);
                                System.out.println(" Your Final Expance is " + arr[log.cus_num].price + " (18% GST Applied)");
                                System.out.println(" Make Your Payment To confirm Your Trip ! , Enter Confirm!");
                                sc.nextLine();
                                String confi = sc.nextLine();
                                if (confi.equalsIgnoreCase("confirm")) {

                                    arr[log.cus_num].isPackage = true;
                                    System.out.println("Congratulations ! Your Package Is booked ! ");
                                    System.out.println("Have a Great Journey!");
                                    System.out.println("Check Your Booking History For Information About Your Package");

                                }

                                break;
                            default:
                                System.out.println("Enter valid input! ");
                                break;
                        }

                    } else {
                        System.out.println("Please Login First!");
                    }


                    break;
                case 6:
                    if (arr[log.cus_num].isLogin) {

                        System.out.println("Which Type Of tour Do You Want ? Domestic Or International ");
                        sc.nextLine();
                        String t = sc.nextLine();
                        if (t.equalsIgnoreCase("international")) {
                            System.out.println("Select Your Destination ");
                            obp.display(international);
                            int dest = sc.nextInt();
                            arr[log.cus_num].destination = international[dest - 1].dest_name;

                            System.out.println("Enter The Number Of Persons For Tour ");

                            arr[log.cus_num].no_people = sc.nextInt();

                            System.out.println("Enter The Days For Your Tour ");
                            arr[log.cus_num].days = sc.nextInt();

                            System.out.println("Select The Hotel For Staying For Your Destination ");
                            for (int i = 0; i < international[dest - 1].hotels.length; i++) {
                                System.out.println("Press " + (i + 1) + "  for " + international[dest - 1].hotels[i]);
                                System.out.println();

                            }
                            int h = sc.nextInt();
                            arr[log.cus_num].hotel = international[dest - 1].hotels[h - 1];

                            arr[log.cus_num].price = international[dest - 1].dest_price * arr[log.cus_num].days * arr[log.cus_num].no_people;
                            System.out.println("Do You Want Tourist Guide With You ? Yes or No ");
                            System.out.println("(With The Additional Cost Of 5000)");
                            sc.nextLine();
                            String ans = sc.nextLine();
                            if (ans.equalsIgnoreCase("yes")) {
                                arr[log.cus_num].price += 5000;
                            }

                            arr[log.cus_num].price = arr[log.cus_num].price + (arr[log.cus_num].price * 0.18);
                            System.out.println(" Your Final Expance is " + arr[log.cus_num].price + " (18% GST Applied)");
                            System.out.println();


                            System.out.println(" Make Your Payment To confirm Your Trip ! , Enter Confirm!");
                            String confi = sc.nextLine();
                            if (confi.equalsIgnoreCase("confirm")) {

                                System.out.println(
                                        "Thank you for choosing our Tourism Management System for your travel needs. We appreciate your trust in our services and look forward to enhancing your travel experience");

                                System.out.println("Please View Your Booking History For Booking Information ");

                                arr[log.cus_num].isPackage = true;

                            }


                        } else if (t.equalsIgnoreCase("domestic")) {

                            System.out.println("Select Your Destination ");
                            obp.display(domestic);
                            int dest = sc.nextInt();
                            arr[log.cus_num].destination = domestic[dest - 1].dest_name;

                            System.out.println("Enter The Number Of Persons For Tour ");

                            arr[log.cus_num].no_people = sc.nextInt();

                            System.out.println("Enter The Days For Your Tour ");
                            arr[log.cus_num].days = sc.nextInt();

                            System.out.println("Select The Hotel For Staying For Your Destination ");
                            for (int i = 0; i < domestic[dest - 1].hotels.length; i++) {
                                System.out.println("Press " + (i + 1) + "  for " + domestic[dest - 1].hotels[i]);
                                System.out.println();

                            }
                            int h = sc.nextInt();
                            arr[log.cus_num].hotel = domestic[dest - 1].hotels[h - 1];

                            arr[log.cus_num].price = domestic[dest - 1].dest_price * arr[log.cus_num].days * arr[log.cus_num].no_people;
                            System.out.println("Do You Want Tourist Guide With You ? Yes or No ");
                            System.out.println("(With The Additional Cost Of 5000)");
                            sc.nextLine();
                            String ans = sc.nextLine();
                            if (ans.equalsIgnoreCase("yes")) {
                                arr[log.cus_num].price += 5000;
                            }

                            System.out.println("The Total Expance For Your Trip Is : " + arr[log.cus_num].price);


                            System.out.println(" Make Your Payment To confirm Your Trip ! , Enter Confirm!");
                            String confi = sc.nextLine();
                            if (confi.equalsIgnoreCase("confirm")) {

                                System.out.println(
                                        "Thank you for choosing our Tourism Management System for your travel needs. We appreciate your trust in our services and look forward to enhancing your travel experience");

                                System.out.println("Please View Your Booking History For Booking Information ");

                                arr[log.cus_num].isPackage = true;

                            }


                        } else {
                            System.out.println("Invalid Input! ");
                        }


                    } else {
                        System.out.println("Please Login First!");
                    }
                    break;
                case 7:
                    if (arr[log.cus_num].isPackage) {
                        arr[log.cus_num].display_package();
                    } else {
                        System.out.println("No Packages Is booked! ");
                    }

                    break;
                case 8:
                    if (arr[log.cus_num].isLogin) {
                        arr[log.cus_num].display();

                    } else {
                        System.out.println("Please Login First");
                    }


                    break;

                case 9:
                    if (arr[log.cus_num].isLogin) {
                        System.out.println("What Do you Want to update ? ");
                        System.out.println();
                        System.out.println("Press 1 To Update Username ");
                        System.out.println("Press 2 To Update Password ");
                        System.out.println("Press 3 To Update Email ");
                        System.out.println("Press 4 To Update Mobile ");

                        int u = sc.nextInt();
                        sc.nextLine();
                        System.out.println();
                        switch (u) {
                            case 1:
                                System.out.println("Enter Your New Username ");
                                arr[log.cus_num].username = sc.nextLine();
                                System.out.println("Username Is Updated!");
                                break;

                            case 2:
                                String pass, pass_c;
                                do {

                                    System.out.println("Enter Your New Password ");
                                    pass = sc.nextLine();
                                    System.out.println("Confirm Your New Password ");
                                    pass_c = sc.nextLine();
                                    if (!pass.equals(pass_c)) {
                                        System.out.println("Enter Your Password Again!");
                                    }

                                } while (!pass.equals(pass_c));
                                arr[log.cus_num].password = pass;
                                System.out.println("Password is Updated!");


                                break;
                            case 3:
                                System.out.println("Enter Your Email ");
                                arr[log.cus_num].email = sc.nextLine();
                                System.out.println("Email is Updated");
                                break;
                            case 4:
                                String m;
                                do {
                                    System.out.println("Enter Your New Mobile ");
                                    m = sc.nextLine();
                                    if (m.length() != 10) {
                                        System.out.println("Enter Valid Mobile No : ");
                                    }
                                }
                                while (m.length() != 10);
                                arr[log.cus_num].mobile = m;
                                System.out.println("Mobile is Updated!");
                                break;


                        }
                    } else {
                        System.out.println("Please Login First ! ");
                    }
                    break;


                case 10:
                    flag = false;
                    break;

                default:
                    break;


            }


        }

    }


}
