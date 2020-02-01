package ads;

public class MinuteAffiliate extends AffiliateProgram {

    private static String[] titles = new String[]{"Make money online! Start earning commissions in as little as 12 minutes!", "Make money online! Start earning commissions in 12 minutes!",
            "Start earning commissions in as little as 12 minutes!", "Start earning commissions in 12 minutes!", "Make money online in 12 minutes!", "Earn commissions in as little as 12 minutes!",
            "Earn commissions in 12 minutes!", "Make money in as little as 12 minutes!", "Make money in 12 minutes!", "Make money with the \"12 minute Affiliate\" system!"};
    static int index = 0;
    static String imagePathLinux = "/home/qusai/Documents/Videos/money_online/12minute_affiliate/makemoney.jpg";
    static String imagePathWindows = "";

    public MinuteAffiliate(String title, String description, String url, String youtubeVideo, String imagePath, String keywords) {
        super(title, description, url, youtubeVideo, imagePath, keywords);
    }

    public static MinuteAffiliate getInstance() {
        String url = "https://bit.ly/314jEA8";
        return new MinuteAffiliate(titles[index++],
                "Whether you're an experienced affiliate marketer, or you're brand new to making money online, the 12 Minute Affiliate System is the SOLUTION you've been looking for. " +
                        "\nFINALLY - Someone has made making money online as easy as everyone else has promised you it would be. \n" +
                        "12 Minute Affiliate is a revolutionary new system that simplifies the process of making online commissions with affiliate marketing. It is 100% newbie-friendly. \nMost other systems claim to be easy and \"non-techie\"... but they're not. 12 Minute Affiliate really IS! \n" +
                        "Disclaimer: This is not a Get-Rich-Quick scheme. This is \"Get Everything Up and Running QUICK\".\n" +
                        "If for any reason this guide did not meet your expectations, we offer a 60-Day, Ironclad Money Back Guarantee. \nSo what are you waiting for? Visit our website here: " + url + "\n", url, null, imagePathLinux,
                "work from home, work from home jobs, make money online, money online, jobs online, online jobs, work at home jobs, digital marketing, affiliate marketing, internet marketing, make money at home, digital marketing course, affiliate marketing training, digital marketing training, affiliate marketing course");
    }

}
