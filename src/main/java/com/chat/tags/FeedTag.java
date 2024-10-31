package com.chat.tags;


import java.io.IOException;
import java.util.List;

import com.chat.jsonDTO.FeedEntry;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class FeedTag extends SimpleTagSupport {
    private List<FeedEntry> feedEntries;

    // Setter for the list of feed entries
    public void setFeedEntries(List<FeedEntry> feedEntries) {
        this.feedEntries = feedEntries;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (feedEntries != null) {
            for (FeedEntry entry : feedEntries) {
                out.write("<div class='feed-entry'>");
                out.write("<h3>" + entry.getTitle() + "</h3>");
                out.write("<p>" + entry.getDescription() + "</p>");
                out.write("<small>Posted on: " + entry.getDate() + "</small>");
                out.write("</div>");
            }
        } else {
            out.write("<p>No feed entries available.</p>");
        }
    }
}
