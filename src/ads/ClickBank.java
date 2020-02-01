package ads;

public class ClickBank extends AffiliateProgram {

    private static String[] titles = new String[]{"Your First ClickBank Check Is Waiting for You To Go And Get It!", "Your First ClickBank Check Is Waiting for You!",
            "Your First ClickBank Check Is Waiting for You To Go And Get It", "Your First ClickBank Check Is Waiting for You", "Learn to make money online with ClickBank University!",
            "Learn to make money online with ClickBank University", "Learn to make money online!", "Learn to make money online", "Secrets to earning money online!", "Secrets to earning money online"};
    static int index = 0;

    public ClickBank(String title, String description, String url, String youtubeVideo, String imagePath, String keywords) {
        super(title, description, url, youtubeVideo, imagePath, keywords);
    }

    public static ClickBank getInstance() {
        String url = "https://bit.ly/317Q3Wi";
            return new ClickBank(titles[index++],
                "Join the BRAND NEW Fully Upgraded ClickBank University 2.0. ClickBank University 2.0 delivers the latest up to date strategies, methods and tactics for you build your ClickBank business rapidly. \n" +
                        "We've made it possible for you to follow in the Exact Footsteps of PROVEN 7 and 8-Figure ClickBank Winners. \n" +
                        "You'll get Complete Access to TWO Separate Training Tracks: ClickBank Product Publishing & ClickBank Affiliate Mastery. PLUS, you'll Get Even More Bonuses to Guarantee Your Success. \n" +
                        "We've been told it's: \"The BEST ClickBank-oriented training on the Internet\".\n" +
                        "However, if you're not absolutely thrilled with the training for whatever reason, you can request a refund, as ClickBank University 2.0 offers a 30-day Money-Back Guarantee! \nSo what are you waiting for? Visit our website here: " + url + "\n" +
                        "NOTE: A percentage of your purchase will be donated to Pencils Of Promise. Pencils of Promise is a for-purpose organization that works across the globe to build schools and create programs around the goal of education for all.\n", url,
                    null, "C:\\Users\\ASUS\\Downloads\\money_online\\CB_university\\commoney.jpg",
                    "work from home, work from home jobs, make money online, money online, jobs online, online jobs, work at home jobs, digital marketing, affiliate marketing, internet marketing, make money at home, digital marketing course, affiliate marketing training, digital marketing training, affiliate marketing course, how to sell ebooks, sell ebooks online");
    }
}
// Keywords additional
//

