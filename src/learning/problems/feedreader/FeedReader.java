package learning.problems.feedreader;

/**
 * Created by edmundas on 10/02/2015.
 */

//import com.sun.syndication.feed.synd.SyndFeed;
//import com.sun.syndication.io.SyndFeedInput;
//import com.sun.syndication.io.XmlReader;

import java.net.URL;

public class FeedReader {

    public static void main(String[] args) {
        boolean ok = false;
        if (args.length==1) {
            try {
                URL feedUrl = new URL(args[0]);

//                SyndFeedInput input = new SyndFeedInput();
//                SyndFeed feed = input.build(new XmlReader(feedUrl));
//
//                System.out.println(feed);

                ok = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("ERROR: "+ex.getMessage());
            }
        }

        if (!ok) {
            System.out.println();
            System.out.println("FeedReader reads and prints any RSS/Atom feed type.");
            System.out.println("The first parameter must be the URL of the feed to read.");
            System.out.println();
        }
    }

}