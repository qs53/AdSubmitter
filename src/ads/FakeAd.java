package ads;

public class FakeAd extends AffiliateProgram {

    private static String[] titles = new String[]{"title1", "title2", "title3", "title4", "title5", "title6", "title7", "title8", "title9", "title10"};
    static int index = 0;

    public FakeAd(String title, String description, String url, String youtubeVideo, String imagePath) {
        super(title, description, url, youtubeVideo, imagePath);
    }

    public static FakeAd getInstance() {
        String url = "https://bit.ly/38VwKT5";
        return new FakeAd(titles[index++],
                "Internet Millionaire shows you how to quit your job fast and work from home! Make a lot more monese i Guarantee!\nSo what are you waiting for? Visit our website here: " + url + "\n", "url", null, "C:\\Users\\ASUS\\Downloads\\money_online\\Millionare_society\\millionare.jpg");
    }
}
