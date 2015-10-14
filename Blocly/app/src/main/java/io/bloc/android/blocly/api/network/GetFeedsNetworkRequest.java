package io.bloc.android.blocly.api.network;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by Kartik on 14-Oct-15.
 */
public class GetFeedsNetworkRequest extends NetworkRequest {

    String [] feedUrls;

    public GetFeedsNetworkRequest(String... feedUrls) {
        this.feedUrls = feedUrls;
    }

    @Override
    public Object performRequest() {
        for (String feedUrlString : feedUrls) {
            InputStream inputStream = openStream(feedUrlString);
            if (inputStream == null) {
                return null;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = bufferedReader.readLine();

                int itemCounter = 0;

                while (line != null) {
                    Log.v(getClass().getSimpleName(), "Line: " + line);

                    try {
                        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                        factory.setNamespaceAware(true);
                        XmlPullParser xpp = factory.newPullParser();
                        xpp.setInput(new StringReader(line));

                        boolean insideItem = false;

                        int eventType = xpp.getEventType();

                        while (eventType != XmlPullParser.END_DOCUMENT) {
                            if (eventType == XmlPullParser.START_TAG) {

                                if (xpp.getName().equalsIgnoreCase("item")) {
                                    insideItem = true;
                                    itemCounter++;
                                } else if (xpp.getName().equalsIgnoreCase("title")) {
                                    if (insideItem)
                                        Log.i(getClass().getSimpleName(),xpp.nextText());
                                } else if (xpp.getName().equalsIgnoreCase("link")) {
                                    if (insideItem)
                                        Log.i(getClass().getSimpleName(),xpp.nextText());
                                }
                            } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                                insideItem = false;
                            }

                            eventType = xpp.next();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    line = bufferedReader.readLine();

                }
                bufferedReader.close();

                Log.v(getClass().getSimpleName(), "Item Counter: " + itemCounter);

            } catch (IOException e) {
                e.printStackTrace();
                setErrorCode(ERROR_IO);
                return null;
            }
        }
        return null;
    }
}
