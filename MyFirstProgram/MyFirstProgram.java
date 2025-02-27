import java.time.LocalTime; // Mengimpor kelas LocalTime untuk mendapatkan waktu saat ini
import java.util.Random; // Mengimpor kelas Random untuk menghasilkan angka acak
import java.util.Scanner; // Mengimpor kelas Scanner untuk menerima input dari pengguna
import java.io.*;

public class MyFirstProgram {
    public static void main(String[] args) throws Exception {
        // Menginisialisasi warna untuk output di terminal
        String yellow = "\u001B[33m"; // Warna kuning
        String green = "\u001B[32m"; // Warna hijau
        String blue = "\u001B[34m"; // Warna biru
        String reset = "\u001B[0m"; // Reset warna ke default terminal

        // Mendapatkan waktu saat ini
        LocalTime current = LocalTime.now();
        int currentHour = current.getHour(); // Mengekstrak jam dalam format 24 jam

        // Array pesan greeting berdasarkan waktu
        String[] morning = {"Good morning! Hope you have an amazing day ahead!",
            "Rise and shine! It's a beautiful new day!",
            "Wakey wakey! Time to make today great!",
            "Top of the morning to you! Wishing you a fantastic day!",
            "A fresh morning, a fresh start! Let's make the most of it!",
            "Good morning! Don't forget to smile and spread positivity!",
            "The sun is shining, the birds are singing—it's time to shine too!",
            "Morning, champ! Time to go out there and be awesome!",
            "A new day, a new chance to be better than yesterday! Good morning!",
            "May your coffee be strong and your Monday be short!" };
        
        String[] afternoon = {"Good afternoon! Hope you're having a fantastic day!",
            "Hey there! Don't forget to take a break and enjoy your afternoon!",
            "The sun is high, and so should be your energy! Keep shining!",
            "Good afternoon! Stay positive and make the rest of your day great!",
            "A beautiful afternoon is a reminder that the day isn't over yet, keep going!",
            "Hope your afternoon is as bright and wonderful as your smile!",
            "Keep pushing forward! The day is halfway done, and you got this!",
            "Good afternoon! Keep up the hard work and finish the day strong!",
            "Take a deep breath, relax for a moment, and enjoy the afternoon vibes!",
            "Wishing you a joyful and productive afternoon! Stay awesome!" };
        
        String[] evening = {"Good evening! Hope you had a wonderful day!",
            "Evening is the time to relax and unwind. Enjoy it!",
            "Good evening! Take a deep breath and appreciate the night sky!",
            "The day is ending, but your potential is limitless! Have a great evening!",
            "A peaceful evening to you! May your night be filled with rest and happiness!",
            "Good evening! Time to slow down and enjoy the little moments.",
            "Hope you had a productive day! Now, take time to relax.",
            "Evening is a reminder that you made it through the day. Well done!",
            "The stars are coming out to shine—just like you! Good evening!",
            "As the sun sets, let go of the stress and embrace the calm of the night!" };
        
        String[] night = {"Good night! Time to close your eyes and pretend to sleep for 8 hours.",
            "Hello, night owl! Time to shut down and recharge… unless you're planning an all-nighter?",
            "Good night! May your dreams be filled with adventures (or just a great nap)!",
            "Sweet dreams! Unless you're a gamer, then good luck on your night quest!",
            "It's time to power down for the night… or at least try! Good night!",
            "Good night! Reminder: If you dream of winning the lottery, don't forget to buy a ticket!",
            "Hello and good night! May your pillow be soft, your blanket be warm, and your alarm stay silent!",
            "Bedtime? Already? Feels like the day just started. Oh well—good night!",
            "Good night! If sleep was a game, you'd be a pro by now. Keep leveling up!",
            "Time to say goodbye to the real world and enter dreamland. Have a fun trip!" };

        // Membuat objek Random untuk memilih greeting secara acak
        Random random = new Random();
        int randomMorning = random.nextInt(morning.length);
        int randomAfternoon = random.nextInt(afternoon.length);
        int randomEvening = random.nextInt(evening.length);
        int randomNight = random.nextInt(night.length);

        // Menentukan greeting berdasarkan waktu saat ini
        String greet;
        if (currentHour >= 5 && currentHour < 12){
            greet = morning[randomMorning];
        } else if (currentHour >= 12 && currentHour < 18){
            greet = afternoon[randomAfternoon];
        } else if (currentHour >= 18 && currentHour < 22){
            greet = evening[randomEvening];
        } else {
            greet = night[randomNight];
        }

        // Menampilkan greeting ke layar
        System.out.println(green + greet + reset);
        
        // Meminta input nama pengguna
        System.out.println(yellow + "What's your name?" + reset);
        Scanner myObj = new Scanner(System.in);
        String userName = myObj.nextLine();
        System.out.println(green + "What's bonkin', " + yellow + userName + "!" + reset);
        myObj.close();

        // Array fun facts tentang Java
        String[] funFacts = {"Java is a case-sensitive language!",
            "Java was originally called Oak before being renamed!",
            "The mascot of Java is called Duke!",
            "Java's creator, James Gosling, is known as the father of Java!",
            "Java follows the 'Write Once, Run Anywhere' principle!",
            "The first version of Java was released in 1995!",
            "Java is used in over 3 billion devices worldwide!",
            "Android apps are primarily written in Java!",
            "Java does not support multiple inheritance directly!",
            "Java has automatic garbage collection to manage memory!"};

        //File untuk menyimpan fun fact
        File file = new File("lastFunFact.txt");
        String lastFact = "";
        
        // Baca fun fact terakhir dari file (jika ada)
        if (file.exists()) {
            Scanner fileScanner = new Scanner(file);
            if (fileScanner.hasNextLine()) {
                lastFact = fileScanner.nextLine();
            }
            fileScanner.close();
        }

        //Pilih fun fact yang beda dari sebelumnya 
        String newFact;
        do {
            newFact = funFacts[random.nextInt(funFacts.length)];
        } while (newFact.equals(lastFact));

        //Display fun fact
        System.out.println(green + "This Time's Java Fun Fact is: " + blue + newFact + reset);

        //Save fact yang barusan ke file
        FileWriter writer = new FileWriter(file);
        writer.write(newFact);
        writer.close();
        // // Memilih fun fact secara acak
        // int randomIndex = random.nextInt(funFacts.length);
        // System.out.println(green + "This Time's Java Fun Fact is: " + blue + funFacts[randomIndex] + reset);
        
        // Menampilkan versi Java saat ini
        System.out.println(green + "current java ver: " + blue + System.getProperty("java.version") + reset);
    }
}
