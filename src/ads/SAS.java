package ads;

public class SAS extends AffiliateProgram {
    
    private static String[] titles = new String[]{"EARN A 6-FIGURE SIDE-INCOME ONLINE!",
            "NEW MONEY MAKING SYSTEM",
            "Genius Way to Make Money Online (on the Side) Today!",
            "Follow This \"Beginner Friendly\" 3-Step Formula Webinar",
            "STOP: Even You Can Make $$$ every day – Chance of a Lifetime!", "Earn a 6-Figure Side-Income Online", "Genius Way to Make Money Online (on the Side) Today",
            "NEW MONEY MAKING SYSTEM!", "STOP: Even You Can Make $$ every day – Chance of a Lifetime!", "Follow This \"Beginner Friendly\" 3-Step Formula Webinar!"};
    static int index = 0;
    static String imagePathLinux = "/home/qusai/Documents/Videos/money_online/Super_Affiliate_System_Crestani/images.jpg";
    static String imagePathWindows = "C:\\Users\\ASUS\\Downloads\\money_online\\Super_Affiliate_System_Crestani\\images.jpg";

    public SAS(String title, String description, String url, String youtubeVideo, String imagePath, String keywords) {
        super(title, description, url, youtubeVideo, imagePath, keywords);
    }

    public static SAS getInstance() {
        String url = "https://bit.ly/2u2SygD";
        return new SAS(titles[index],
                "The Super Affiliate System is a complete affiliate marketing training system that shows people how to create massively profitable affiliate campaigns. \n" +
                        "Created by John Crestani, an internationally popular expert in the field of affiliate marketing. He'll show an enormous amount of proof on the training that HE and his STUDENTS are doing that pretty effortlessly. \n" +
                        "So, make sure you register now to claim your spot on this special training. Signup for the free training HERE: https://bit.ly/2u2SygD\n" +
                        "If for any reason this course does not meet your expectations, Super Affiliate System offers a full refund of the course. \nSo what are you waiting for? Visit our website here: " + url + "\n", url, "https://youtu.be/XhkaB5OcT0E", imagePathLinux,
                "work from home, work from home jobs, make money online, money online, jobs online, online jobs, work at home jobs, digital marketing, affiliate marketing, internet marketing, make money at home, digital marketing course, affiliate marketing training, digital marketing training, affiliate marketing course");
    }
}
