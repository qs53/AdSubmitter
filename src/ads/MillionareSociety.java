package ads;

public class MillionareSociety extends AffiliateProgram {

    private static String[] titles = new String[]{"Work from home and earn a passive income online!", "Quit your job and earn a passive income online!",
            "Work from home and earn a passive income online", "Quit your job and earn a passive income online", "Want to work from home full time? Click here!",
            "Want to work from home full time? Click HERE!", "Want to work from home full time? Click here", "Want to work from home full time? CLICK HERE",
            "Want to work from home full time? CLICK HERE!", "Want to work from home full time? CLICK HERE!!"};
    static int index = 0;

    public MillionareSociety(String title, String description, String url, String youtubeVideo, String imagePath) {
        super(title, description, url, youtubeVideo, imagePath);
    }

    public static ClickBank getInstance() {
        String url = "https://bit.ly/38VwKT5";
        return new ClickBank(titles[index++],
                "Internet Millionaire shows you how to quit your job fast and work from home! Make a lot more money with just a click of the button! \n" +
                        "This 15 minute system will show you how to make passive income online upto $200,000 or more! What's better? Your purchase is is covered by a 100% Money-Back Guarantee!\nSo what are you waiting for? Visit our website here: " + url + "\n", url
                , null, "C:\\Users\\ASUS\\Downloads\\money_online\\Millionare_society\\millionare.jpg");
    }
}