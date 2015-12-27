package com.epam.mentoring.plugin;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Url Downloader Plugin implementation. Used for downloading pages from the internet. Prints result in console.
 *
 * @author vkrasovsky
 */
public class UrlDownloaderPlugin implements Plugin {
    private static final Logger LOGGER = LogManager.getLogger(UrlDownloaderPlugin.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void processInput(String input) {
        try {
            List<String> content = Resources.readLines(new URL(input), Charsets.UTF_8);
            LOGGER.info(MenuConstants.DELIMITER);
            LOGGER.info("Downloaded content: ");
            for (String line : content) {
                LOGGER.info(line);
            }
            LOGGER.info(MenuConstants.DELIMITER);
        } catch (MalformedURLException e) {
            LOGGER.debug("Incorrect url");
        } catch (IOException e) {
            LOGGER.debug("Cannot fetch url content");
        }
    }
}
