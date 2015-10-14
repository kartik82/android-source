package io.bloc.android.blocly.api;

import java.util.ArrayList;
import java.util.List;

import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.api.model.RssItem;
import io.bloc.android.blocly.api.network.GetFeedsNetworkRequest;

/**
 * Created by Kartik on 05-Oct-15.
 */

public class DataSource {

    private List<RssFeed> feeds;
    private List<RssItem> items;
    private List<GetFeedsNetworkRequest.FeedResponse> feedResponses;

    public DataSource(){
        feeds = new ArrayList<RssFeed>();
        items = new ArrayList<RssItem>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                feedResponses = new GetFeedsNetworkRequest("http://feeds.feedburner.com/androidcentral?format=xml").performRequest();
                createFakeData();
            }
        }).start();

    }

    public List<RssFeed> getFeeds() {
        return feeds;
    }

    public List<RssItem> getItems() {
        return items;
    }

    void createFakeData() {

        for (int i = 0; i < feedResponses.size(); i++) {
            feeds.add(new RssFeed(feedResponses.get(i).channelTitle, feedResponses.get(i).channelDescription,
                    feedResponses.get(i).channelURL, feedResponses.get(i).channelFeedURL));

            for (int j = 0; j < feedResponses.get(i).channelItems.size(); j++) {
                items.add(new RssItem(feedResponses.get(i).channelItems.get(j).itemGUID,
                        feedResponses.get(i).channelItems.get(j).itemTitle,
                        feedResponses.get(i).channelItems.get(j).itemDescription,
                        feedResponses.get(i).channelItems.get(j).itemURL,
                        feedResponses.get(i).channelItems.get(j).itemEnclosureURL,
                        0,
                        System.currentTimeMillis(),
                        false,
                        false,
                        false));
            }

        }

    }

}
